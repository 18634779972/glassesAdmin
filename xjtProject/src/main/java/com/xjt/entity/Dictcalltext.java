package com.xjt.entity;

import com.xjt.dto.BaseReqDto;

/**
 * 回访项目
 * 
 * @author wcyong
 * 
 * @date 2019-10-17
 */
public class Dictcalltext extends BaseReqDto {
    /**
     * 回访项目
     */
    private String calltext;

    public String getCalltext() {
        return calltext;
    }

    public void setCalltext(String calltext) {
        this.calltext = calltext == null ? null : calltext.trim();
    }
}