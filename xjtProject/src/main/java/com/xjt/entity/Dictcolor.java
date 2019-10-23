package com.xjt.entity;

/**
 * 颜色膜层表
 * 
 * @author wcyong
 * 
 * @date 2019-10-17
 */
public class Dictcolor {
    /**
     * 颜色、膜层
     */
    private String colordd;

    public String getColordd() {
        return colordd;
    }

    public void setColordd(String colordd) {
        this.colordd = colordd == null ? null : colordd.trim();
    }
}