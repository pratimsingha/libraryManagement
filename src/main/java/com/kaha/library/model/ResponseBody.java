package com.kaha.library.model;

public class ResponseBody<T>{
    private String status;
    private String message;
    private T data;

    public ResponseBody() {
    }

    public ResponseBody(String status, String message, T value) {
        this.status = status;
        this.message = message;
        this.data = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
