package com.xjt.dto;

import com.xjt.enums.ResultCode;

import java.io.Serializable;

public class BaseResDto<T> implements Serializable {

    /**
     * serialVersionUID的
     */
    private static final long serialVersionUID = -6673395649748854442L;

    /**
     * 的
     * 请求唯一ID
     */
    private Long requestId;

    /**
     * 操作结果代码
     */
    private Integer resultCode = ResultCode.RESULT_CODE_NORMAL.getCode(); //默认1 成功

    /**
     * 操作消息
     */
    private String resultMessage = "success";

    private T data;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
