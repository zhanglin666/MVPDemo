package cn.kc.mvpdemo.utils

import java.util.concurrent.TimeUnit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import javax.security.auth.login.LoginException

class RetrofitUtils private constructor() {

    private val mRetrofit: Retrofit

    init {
        mRetrofit = createRetrofit()
    }

    /**
     * 初始化Retrofit
     */
    private fun createRetrofit() :Retrofit{
        val builder = OkHttpClient.Builder()
        // 设置超时
        builder.connectTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
        builder.readTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
        builder.writeTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
        builder.addInterceptor(LogInterceptor())
        val client = builder.build()
        return Retrofit.Builder()
                // 设置请求的域名
                .baseUrl(BASE_URL)
                .addConverterFactory(ResponseConvert.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
    }

    /**
     * 创建API
     */
    fun <T> getApiServier(reqServer: Class<T>): T {
        return mRetrofit.create(reqServer)
    }

    companion object {
        var BASE_URL: String = ""
        /**
         * 超时时间
         */
        val TIMEOUT = 20
        @Volatile
        private var mInstance: RetrofitUtils? = null

        fun setBaseUrl(baseUrl: String) {
            BASE_URL = baseUrl
        }

        val instance: RetrofitUtils
            get() {
                if (mInstance == null) {
                    synchronized(RetrofitUtils::class.java) {
                        if (mInstance == null) {
                            mInstance = RetrofitUtils()
                        }
                    }
                }
                return mInstance!!
            }
    }
}
