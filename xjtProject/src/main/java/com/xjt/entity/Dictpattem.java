package com.xjt.entity;

import com.xjt.dto.BaseReqDto;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-10-18
 */
public class Dictpattem extends BaseReqDto {
       private String pattem;

    public String getPattem() {
        return pattem;
    }

    public void setPattem(String pattem) {
        this.pattem = pattem == null ? null : pattem.trim();
    }
}