package com.jaksmok.suonchantha.infrastructure.response;

public class ResponseStatus {

    private String message;

    private int code;

    public String getMessage() {
        return message == null ? "Success" : message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ResponseStatus() {

    }


    public ResponseStatus(String message, int code) {
        this.message = message;
        this.code = code;
    }

}
