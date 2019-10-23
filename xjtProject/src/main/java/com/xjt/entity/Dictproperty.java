package com.xjt.entity;

/**
 * 属性表
 * 
 * @author wcyong
 * 
 * @date 2019-10-17
 */
public class Dictproperty {
    /**
     * 属性表
     */
    private String property;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property == null ? null : property.trim();
    }
}