package com.xjt.entity;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-10-17
 */
public class Dictprovince {
    private String province;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }
}