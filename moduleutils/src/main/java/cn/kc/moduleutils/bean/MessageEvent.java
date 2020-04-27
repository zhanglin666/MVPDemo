package cn.kc.moduleutils.bean;

/**
 * 作者： Abel .
 * 日期：2019/8/8
 * 说明：
 */
public class MessageEvent {
    private String message;
    public MessageEvent(String message){
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
