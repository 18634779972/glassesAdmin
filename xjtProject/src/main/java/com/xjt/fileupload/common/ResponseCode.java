package com.xjt.fileupload.common;

/**
 * @Author 刘威
 * @Date 2018.04.23
 * @Description 响应消息指令
 */
public enum ResponseCode {

    //成功
    SUCCESS(0, "SUCCESS"),
    //失败
    ERROR(1, "ERROR"),
    //需要登录
    NEED_LOGIN(2, "NEED_LOGIN"),
    //FTP错误
    FTP_FAILED(3, "FTP_FAILED"),
    //参数错误
    ILLEGAL_ARGUMENT(4, "ILLEGAL_ARGUMENT"),
    //Excel数据错误
    EXCEL_DATA_ERROR(5, "EXCEL_DATA_ERROR");

    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
