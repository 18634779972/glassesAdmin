package com.xjt.entity;

import com.xjt.dto.BaseReqDto;

/**
 * 单位表
 * 
 * @author wcyong
 * 
 * @date 2019-10-18
 */
public class Dictunit extends BaseReqDto {
    /**
     * 单位
     */
    private String unit;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }
}