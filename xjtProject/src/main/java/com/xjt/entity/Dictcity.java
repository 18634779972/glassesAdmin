package com.xjt.entity;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-10-17
 */
public class Dictcity {
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }
}