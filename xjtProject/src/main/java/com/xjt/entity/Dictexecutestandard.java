package com.xjt.entity;

import com.xjt.dto.BaseReqDto;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-10-18
 */
public class Dictexecutestandard extends BaseReqDto {
    private String executestandard;

    public String getExecutestandard() {
        return executestandard;
    }

    public void setExecutestandard(String executestandard) {
        this.executestandard = executestandard == null ? null : executestandard.trim();
    }
}