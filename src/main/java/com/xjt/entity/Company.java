package com.xjt.entity;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-10-28
 */
public class Company {
    /**
     * 公司编号
     */
    private String companyId;

    /**
     * 公司简称
     */
    private String companyAbv;

    /**
     * 全称
     */
    private String companyNa;

    /**
     * 地址
     */
    private String address;

    /**
     * 电话
     */
    private String tel;

    /**
     * 传真
     */
    private String fax;

    /**
     * 负责人
     */
    private String keyman;

    /**
     * 仓库
     */
    private String defaultwarehouse;

    /**
     * 机构编号（GUID）
     */
    private String id;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getCompanyAbv() {
        return companyAbv;
    }

    public void setCompanyAbv(String companyAbv) {
        this.companyAbv = companyAbv == null ? null : companyAbv.trim();
    }

    public String getCompanyNa() {
        return companyNa;
    }

    public void setCompanyNa(String companyNa) {
        this.companyNa = companyNa == null ? null : companyNa.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getKeyman() {
        return keyman;
    }

    public void setKeyman(String keyman) {
        this.keyman = keyman == null ? null : keyman.trim();
    }

    public String getDefaultwarehouse() {
        return defaultwarehouse;
    }

    public void setDefaultwarehouse(String defaultwarehouse) {
        this.defaultwarehouse = defaultwarehouse == null ? null : defaultwarehouse.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }
}