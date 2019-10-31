package com.xjt.dto;

import java.util.Date;

public class ManureportReqDto {
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
    private String issuedateStr;

    /**
     * 有效期限
     */
    private Date expirydate;
    private String expirydateStr;

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
    private String reportdateStr;

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
    private String docdateStr;

    /**
     * 更新时间
     */
    private Date updatetimestamp;

    public String getMrid() {
        return mrid;
    }

    public void setMrid(String mrid) {
        this.mrid = mrid;
    }

    public String getPermitno() {
        return permitno;
    }

    public void setPermitno(String permitno) {
        this.permitno = permitno;
    }

    public String getEnterprisename() {
        return enterprisename;
    }

    public void setEnterprisename(String enterprisename) {
        this.enterprisename = enterprisename;
    }

    public String getLegal() {
        return legal;
    }

    public void setLegal(String legal) {
        this.legal = legal;
    }

    public String getKeyman() {
        return keyman;
    }

    public void setKeyman(String keyman) {
        this.keyman = keyman;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getFactorysite() {
        return factorysite;
    }

    public void setFactorysite(String factorysite) {
        this.factorysite = factorysite;
    }

    public String getBusiscope() {
        return busiscope;
    }

    public void setBusiscope(String busiscope) {
        this.busiscope = busiscope;
    }

    public String getIssuedepartment() {
        return issuedepartment;
    }

    public void setIssuedepartment(String issuedepartment) {
        this.issuedepartment = issuedepartment;
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
        this.reportno = reportno;
    }

    public String getReportdepartment() {
        return reportdepartment;
    }

    public void setReportdepartment(String reportdepartment) {
        this.reportdepartment = reportdepartment;
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
        this.supplyNo = supplyNo;
    }

    public String getFieldEx1() {
        return fieldEx1;
    }

    public void setFieldEx1(String fieldEx1) {
        this.fieldEx1 = fieldEx1;
    }

    public String getFieldEx2() {
        return fieldEx2;
    }

    public void setFieldEx2(String fieldEx2) {
        this.fieldEx2 = fieldEx2;
    }

    public String getFieldEx3() {
        return fieldEx3;
    }

    public void setFieldEx3(String fieldEx3) {
        this.fieldEx3 = fieldEx3;
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

    public String getIssuedateStr() {
        return issuedateStr;
    }

    public void setIssuedateStr(String issuedateStr) {
        this.issuedateStr = issuedateStr;
    }

    public String getExpirydateStr() {
        return expirydateStr;
    }

    public void setExpirydateStr(String expirydateStr) {
        this.expirydateStr = expirydateStr;
    }

    public String getReportdateStr() {
        return reportdateStr;
    }

    public void setReportdateStr(String reportdateStr) {
        this.reportdateStr = reportdateStr;
    }

    public String getDocdateStr() {
        return docdateStr;
    }

    public void setDocdateStr(String docdateStr) {
        this.docdateStr = docdateStr;
    }
}
