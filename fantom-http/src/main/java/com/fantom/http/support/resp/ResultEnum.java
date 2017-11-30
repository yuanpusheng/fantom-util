package com.fantom.http.support.resp;

/**
 * @author tufatao
 * @version V 0.1
 * @describe {}
 * @time 2017/11/29 17:18.
 */
public enum ResultEnum {
    UNKNOWN_FAIL("1", "未知错误"),
    BAD_REQUEST("400", "请求格式错误"),
    AUTH_FAIL("401", "非法请求"),
    SERVER_ERROR("500", "服务器异常"),
    SERVER_BUSY("503", "服务器繁忙, 请稍候再试");
    private String code;
    private String message;

    ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
