package com.xjt.enums;

public enum ResultCode {

    RESULT_CODE_EXCEPTION(0), //发生异常的结果值
    RESULT_CODE_NODATA(2),//没有数据时的结果值
    RESULT_CODE_NORMAL(1);//数据存在时的结果值

    private Integer code;

    ResultCode(Integer code){
        this.code = code;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

