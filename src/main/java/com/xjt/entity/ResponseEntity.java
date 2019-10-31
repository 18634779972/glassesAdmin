package com.xjt.entity;

public class ResponseEntity {

    private  String ReturnType;

    private String Message;

    public String getReturnType() {
        return ReturnType;
    }

    public void setReturnType(String returnType) {
        ReturnType = returnType;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
