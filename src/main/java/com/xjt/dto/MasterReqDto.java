package com.xjt.dto;

import java.util.Date;

public class MasterReqDto extends BaseReqDto {
    /**
     * 主键id
     */
    private String id;

    /**
     * 管理员名称
     */
    private String name;

    /**
     * 管理员密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String trueName;

    /**
     * 性别(0是男，1是女)
     */
    private Long sex;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 所属部门
     */
    private String dept;

    /**
     * 职务
     */
    private String position;

    /**
     * 职务说明
     */
    private String positionDesc;

    /**
     * 办公室电话
     */
    private Long officePhone;

    /**
     * 手机
     */
    private Long mobile;

    /**
     * 家庭电话
     */
    private Long homePhone;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 创建者id
     */
    private String masterId;

    /**
     * 创建者名称
     */
    private String masterName;

    /**
     * 修改时间
     */
    private Date createdate;

    /**
     * 是否有效 0 否 1 有
     */
    private Long deleteFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName == null ? null : trueName.trim();
    }

    public Long getSex() {
        return sex;
    }

    public void setSex(Long sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept == null ? null : dept.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getPositionDesc() {
        return positionDesc;
    }

    public void setPositionDesc(String positionDesc) {
        this.positionDesc = positionDesc == null ? null : positionDesc.trim();
    }

    public Long getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(Long officePhone) {
        this.officePhone = officePhone;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public Long getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(Long homePhone) {
        this.homePhone = homePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
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
