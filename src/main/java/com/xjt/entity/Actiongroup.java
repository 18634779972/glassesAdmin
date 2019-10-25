package com.xjt.entity;

import java.util.Date;

/**
 * 权限关联表
 * 
 * @author wcyong
 * 
 * @date 2019-10-24
 */
public class Actiongroup {
    /**
     * 主键id
     */
    private String id;

    /**
     * 动作Id(与action表关联)
     */
    private String action;

    /**
     * 动作所属组id(关联到mastergroup表)
     */
    private String groupId;

    /**
     * 创建者id
     */
    private String masterId;

    /**
     * 创建者名称
     */
    private String masterName;

    /**
     * 创建时间
     */
    private Date createdate;

    /**
     * 是否有效 0 否 1 是
     */
    private Long deleteFlag;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName == null ? null : masterName.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Long getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Long deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}