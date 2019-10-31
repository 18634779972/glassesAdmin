package com.xjt.entity;

import java.util.Date;

/**
 * 生产企业许可、备案
 * 
 * @author wcyong
 * 
 * @date 2019-10-28
 */
public class Manureport {
    /**
     * 生产企业许可、备案编号（GUID）
     */
    private String mrid;

    /**
     * 许可证编号
     */
    private String permitno;

    /**
     * 企业名称
     */
    private String enterprisename;

    /**
     * 法人
     */
    private String legal;

    /**
     * 负责人
     */
    private String keyman;

    /**
     * 住所
     */
    private String home;

    /**
     * 经营场所
     */
    private String factorysite;

    /**
     * 经营范围
     */
    private String busiscope;

    /**
     * 发证部门
     */
    private String issuedepartment;

    /**
     * 发证日期
     */
    private Date issuedate;

    /**
     * 有效期限
     */
    private Date expirydate;

    /**
     * 备案编号
     */
    private String reportno;

    /**
     * 备案部门
     */
    private String reportdepartment;

    /**
     * 备案日期
     */
    private Date reportdate;

    /**
     * 编号
     */
    private String supplyNo;

    /**
     * 扩展字段1
     */
    private String fieldEx1;

    /**
     * 扩展字段2
     */
    private String fieldEx2;

    /**
     * 扩展字段3
     */
    private String fieldEx3;

    /**
     * 到期时间
     */
    private Date docdate;

    /**
     * 更新时间
     */
    private Date updatetimestamp;

    public String getMrid() {
        return mrid;
    }

    public void setMrid(String mrid) {
        this.mrid = mrid == null ? null : mrid.trim();
    }

    public String getPermitno() {
        return permitno;
    }

    public void setPermitno(String permitno) {
        this.permitno = permitno == null ? null : permitno.trim();
    }

    public String getEnterprisename() {
        return enterprisename;
    }

    public void setEnterprisename(String enterprisename) {
        this.enterprisename = enterprisename == null ? null : enterprisename.trim();
    }

    public String getLegal() {
        return legal;
    }

    public void setLegal(String legal) {
        this.legal = legal == null ? null : legal.trim();
    }

    public String getKeyman() {
        return keyman;
    }

    public void setKeyman(String keyman) {
        this.keyman = keyman == null ? null : keyman.trim();
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home == null ? null : home.trim();
    }

    public String getFactorysite() {
        return factorysite;
    }

    public void setFactorysite(String factorysite) {
        this.factorysite = factorysite == null ? null : factorysite.trim();
    }

    public String getBusiscope() {
        return busiscope;
    }

    public void setBusiscope(String busiscope) {
        this.busiscope = busiscope == null ? null : busiscope.trim();
    }

    public String getIssuedepartment() {
        return issuedepartment;
    }

    public void setIssuedepartment(String issuedepartment) {
        this.issuedepartment = issuedepartment == null ? null : issuedepartment.trim();
    }

    public Date getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(Date issuedate) {
        this.issuedate = issuedate;
    }

    public Date getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(Date expirydate) {
        this.expirydate = expirydate;
    }

    public String getReportno() {
        return reportno;
    }

    public void setReportno(String reportno) {
        this.reportno = reportno == null ? null : reportno.trim();
    }

    public String getReportdepartment() {
        return reportdepartment;
    }

    public void setReportdepartment(String reportdepartment) {
        this.reportdepartment = reportdepartment == null ? null : reportdepartment.trim();
    }

    public Date getReportdate() {
        return reportdate;
    }

    public void setReportdate(Date reportdate) {
        this.reportdate = reportdate;
    }

    public String getSupplyNo() {
        return supplyNo;
    }

    public void setSupplyNo(String supplyNo) {
        this.supplyNo = supplyNo == null ? null : supplyNo.trim();
    }

    public String getFieldEx1() {
        return fieldEx1;
    }

    public void setFieldEx1(String fieldEx1) {
        this.fieldEx1 = fieldEx1 == null ? null : fieldEx1.trim();
    }

    public String getFieldEx2() {
        return fieldEx2;
    }

    public void setFieldEx2(String fieldEx2) {
        this.fieldEx2 = fieldEx2 == null ? null : fieldEx2.trim();
    }

    public String getFieldEx3() {
        return fieldEx3;
    }

    public void setFieldEx3(String fieldEx3) {
        this.fieldEx3 = fieldEx3 == null ? null : fieldEx3.trim();
    }

    public Date getDocdate() {
        return docdate;
    }

    public void setDocdate(Date docdate) {
        this.docdate = docdate;
    }

    public Date getUpdatetimestamp() {
        return updatetimestamp;
    }

    public void setUpdatetimestamp(Date updatetimestamp) {
        this.updatetimestamp = updatetimestamp;
    }
}