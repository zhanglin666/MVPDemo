package cn.kc.mvpdemo.utils;

import com.google.gson.*;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResponseConvert extends Converter.Factory{
    public static ResponseConvert create() {
        return new ResponseConvert();
    }

    /**
     * 转换的方法
     */
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new BodyConverter<>(type);
    }

    private class BodyConverter<T> implements Converter<ResponseBody, T> {
        private Gson gson;
        private Type type;

        public BodyConverter(Type type) {
            this.type = type;
            gson = new GsonBuilder()
                    .registerTypeHierarchyAdapter(List.class, new ListTypeAdapter())
                    .create();
        }

        @Override
        public T convert(ResponseBody value) throws IOException {
            String json = value.string();
            return gson.fromJson(json, type);
        }
    }

    /**
     * 空列表的转换
     */
    private static class ListTypeAdapter implements JsonDeserializer<List<?>> {
        @Override
        public List<?> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            if (json != null && json.isJsonArray()) {
                JsonArray array = json.getAsJsonArray();
                Type itemType = ((ParameterizedType) typeOfT).getActualTypeArguments()[0];
                List list = new ArrayList<>();
                for (int i = 0; i < array.size(); i++) {
                    JsonElement element = array.get(i);
                    Object item = context.deserialize(element, itemType);
                    list.add(item);
                }
                return list;
            } else {
                //和接口类型不符，返回空List
                return Collections.EMPTY_LIST;
            }
        }
    }
}
