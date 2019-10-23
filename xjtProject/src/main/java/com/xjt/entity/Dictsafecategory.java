package com.xjt.entity;

/**
 * 安全类别
 * 
 * @author wcyong
 * 
 * @date 2019-10-17
 */
public class Dictsafecategory {
    /**
     * 安全类别
     */
    private String safecategory;

    public String getSafecategory() {
        return safecategory;
    }

    public void setSafecategory(String safecategory) {
        this.safecategory = safecategory == null ? null : safecategory.trim();
    }
}