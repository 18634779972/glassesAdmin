package com.xjt.entity;

import java.math.BigDecimal;

/**
 * 仓库信息表
 * 
 * @author wcyong
 * 
 * @date 2019-10-25
 */
public class Warehouse {
    /**
     * 仓库编号
     */
    private String warehouseNo;

    /**
     * 仓库名称
     */
    private String warehouseNa;

    /**
     * 地址
     */
    private String address;

    /**
     * 电话
     */
    private String tele;

    /**
     * 邮编
     */
    private String zipcode;

    /**
     * 负责人
     */
    private String keyman;

    /**
     * 是否虚拟仓库
     */
    private Boolean tag;

    /**
     * 邮件
     */
    private String eMail;

    /**
     * 区域
     */
    private String region;

    /**
     * 传真
     */
    private String fax;

    /**
     * 允许负库存
     */
    private Boolean allowminusstock;

    /**
     * 是否停用
     */
    private Boolean shutout;

    private String item;

    private BigDecimal discount;

    private BigDecimal qidiscount;

    private BigDecimal budiscount;

    private BigDecimal pudiscount;

    private BigDecimal maidiscount;

    private String repofficeId;

    /**
     * 上级渠道
     */
    private String channelid;

    /**
     * 仓库组
     */
    private String waregroup;

    /**
     * 应收归集户口
     */
    private String accountcustomerId;

    /**
     * 风险控制
     */
    private String insurance;

    private String warehouseprice;

    /**
     * 运费组
     */
    private String freightcorp;

    /**
     * 是否计算成本
     */
    private Boolean iscalccost;

    /**
     * 是否定制化
     */
    private Boolean iscustomize;

    /**
     * 供应商
     */
    private String supplyNo;

    /**
     * 机构编号（GUID）
     */
    private String id;

    /**
     * 公司编号
     */
    private String companyId;

    public String getWarehouseNo() {
        return warehouseNo;
    }

    public void setWarehouseNo(String warehouseNo) {
        this.warehouseNo = warehouseNo == null ? null : warehouseNo.trim();
    }

    public String getWarehouseNa() {
        return warehouseNa;
    }

    public void setWarehouseNa(String warehouseNa) {
        this.warehouseNa = warehouseNa == null ? null : warehouseNa.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele == null ? null : tele.trim();
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode == null ? null : zipcode.trim();
    }

    public String getKeyman() {
        return keyman;
    }

    public void setKeyman(String keyman) {
        this.keyman = keyman == null ? null : keyman.trim();
    }

    public Boolean getTag() {
        return tag;
    }

    public void setTag(Boolean tag) {
        this.tag = tag;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail == null ? null : eMail.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public Boolean getAllowminusstock() {
        return allowminusstock;
    }

    public void setAllowminusstock(Boolean allowminusstock) {
        this.allowminusstock = allowminusstock;
    }

    public Boolean getShutout() {
        return shutout;
    }

    public void setShutout(Boolean shutout) {
        this.shutout = shutout;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item == null ? null : item.trim();
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getQidiscount() {
        return qidiscount;
    }

    public void setQidiscount(BigDecimal qidiscount) {
        this.qidiscount = qidiscount;
    }

    public BigDecimal getBudiscount() {
        return budiscount;
    }

    public void setBudiscount(BigDecimal budiscount) {
        this.budiscount = budiscount;
    }

    public BigDecimal getPudiscount() {
        return pudiscount;
    }

    public void setPudiscount(BigDecimal pudiscount) {
        this.pudiscount = pudiscount;
    }

    public BigDecimal getMaidiscount() {
        return maidiscount;
    }

    public void setMaidiscount(BigDecimal maidiscount) {
        this.maidiscount = maidiscount;
    }

    public String getRepofficeId() {
        return repofficeId;
    }

    public void setRepofficeId(String repofficeId) {
        this.repofficeId = repofficeId == null ? null : repofficeId.trim();
    }

    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid == null ? null : channelid.trim();
    }

    public String getWaregroup() {
        return waregroup;
    }

    public void setWaregroup(String waregroup) {
        this.waregroup = waregroup == null ? null : waregroup.trim();
    }

    public String getAccountcustomerId() {
        return accountcustomerId;
    }

    public void setAccountcustomerId(String accountcustomerId) {
        this.accountcustomerId = accountcustomerId == null ? null : accountcustomerId.trim();
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance == null ? null : insurance.trim();
    }

    public String getWarehouseprice() {
        return warehouseprice;
    }

    public void setWarehouseprice(String warehouseprice) {
        this.warehouseprice = warehouseprice == null ? null : warehouseprice.trim();
    }

    public String getFreightcorp() {
        return freightcorp;
    }

    public void setFreightcorp(String freightcorp) {
        this.freightcorp = freightcorp == null ? null : freightcorp.trim();
    }

    public Boolean getIscalccost() {
        return iscalccost;
    }

    public void setIscalccost(Boolean iscalccost) {
        this.iscalccost = iscalccost;
    }

    public Boolean getIscustomize() {
        return iscustomize;
    }

    public void setIscustomize(Boolean iscustomize) {
        this.iscustomize = iscustomize;
    }

    public String getSupplyNo() {
        return supplyNo;
    }

    public void setSupplyNo(String supplyNo) {
        this.supplyNo = supplyNo == null ? null : supplyNo.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }
}