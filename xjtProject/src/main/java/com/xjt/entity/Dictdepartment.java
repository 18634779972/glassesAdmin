package com.xjt.entity;

import com.xjt.dto.BaseReqDto;

/**
 * 部门
 * 
 * @author wcyong
 * 
 * @date 2019-10-18
 */
public class Dictdepartment extends BaseReqDto {
    /**
     * 部门
     */
    private String department;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }
}