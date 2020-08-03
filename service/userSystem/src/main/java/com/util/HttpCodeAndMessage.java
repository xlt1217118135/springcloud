package com.util;

/**
 * Created by lenovo
 * Date 2020/7/31 16:16
 */
public enum HttpCodeAndMessage {

    OK(0, "调用成功"),
    MISS_PARAM(1000, "参数缺失");

    private final int code;
    private final String message;

    HttpCodeAndMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }

}
