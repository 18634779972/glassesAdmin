package com.xjt.entity;

import java.util.Date;

/**
 * 管理组表
 * 
 * @author wcyong
 * 
 * @date 2019-10-24
 */
public class Groupmanager {
    /**
     * 主键id
     */
    private String groupId;

    /**
     * 管理组名称
     */
    private String groupName;

    /**
     * 管理组信息
     */
    private String groupInfo;

    /**
     * 创建者id
     */
    private String masterId;

    /**
     * 创建者名称
     */
    private String masterName;

    /**
     * 组创建时间
     */
    private Date createdate;

    /**
     * 是否有效 0 否 1 是
     */
    private Long deleteFlag;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupInfo() {
        return groupInfo;
    }

    public void setGroupInfo(String groupInfo) {
        this.groupInfo = groupInfo == null ? null : groupInfo.trim();
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