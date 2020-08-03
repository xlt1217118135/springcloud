package com.util;

/**
 * Created by lenovo
 * Date 2020/7/31 16:04
 */
public class ResponseWrapper {

    private boolean status;//标识本次请求是失败还是成功

    private int code; //标识本次请求的返回吗，正确是0， 其他错误码详见错误码枚举类

    private String message; //请求返回错误信息

    private Object result;//请求返回结果

    public ResponseWrapper() {
    }

    public ResponseWrapper(boolean status, int code, String message, Object result) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResponseWrapper{" +
                "status=" + status +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }
}
