package com.xjt.entity;

import com.xjt.dto.BaseReqDto;

/**
 * 货运方式
 * 
 * @author wcyong
 * 
 * @date 2019-10-17
 */
public class Dictfreightmode extends BaseReqDto {
    /**
     * 货运方式
     */
    private String freightmode;

    public String getFreightmode() {
        return freightmode;
    }

    public void setFreightmode(String freightmode) {
        this.freightmode = freightmode == null ? null : freightmode.trim();
    }
}