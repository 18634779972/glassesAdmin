package com.xjt.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 渠道信息表
 * 
 * @author wcyong
 * 
 * @date 2019-10-28
 */
public class Customer {
    /**
     * 渠道编号
     */
    private String customerId;

    /**
     * 渠道简称
     */
    private String abbrev;

    /**
     * 渠道名称
     */
    private String customerNa;

    /**
     * 开业时间
     */
    private Date practisedate;

    /**
     * 停业时间
     */
    private Date shutoutdate;

    /**
     * 法人
     */
    private String fictitiousperson;

    /**
     * 社会信用代码(税号)
     */
    private String taxnumber;

    /**
     * 联系人
     */
    private String keyman;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 邮箱 
     */
    private String email;

    /**
     * 传真
     */
    private String fax;

    /**
     * 电话
     */
    private String tel1;

    /**
     * 电话
     */
    private String tel2;

    /**
     * 组
     */
    private String cgroup;

    /**
     * 公司ID
     */
    private String companyId;

    /**
     * 机构组织ID
     */
    private String organizationid;

    /**
     * 国
     */
    private String country;

    /**
     * 区
     */
    private String region;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 地址
     */
    private String address;

    /**
     * 邮编
     */
    private String zipcode;

    /**
     * 经营方式(1自营2加盟3代理4批发)
     */
    private String mathod;

    /**
     * 经营模式
     */
    private String dealinpattern;

    /**
     * 评级
     */
    private Short clevel;

    /**
     * 渠道类别
     */
    private String sort;

    /**
     * 业务员
     */
    private String saleman;

    private String propertylevel;

    /**
     * 销售目标
     */
    private BigDecimal saletarget;

    /**
     * 经营费用
     */
    private BigDecimal fee;

    /**
     * 营业面积
     */
    private BigDecimal carea;

    /**
     * 保证金
     */
    private BigDecimal deposit;

    /**
     * 备注
     */
    private String remark;

    /**
     * 信用额度
     */
    private Long credit;

    /**
     * 上级渠道
     */
    private String parentchannelid;

    /**
     * 应收归集户口
     */
    private String accountcustomerId;

    /**
     * 应收户口
     */
    private Boolean accountcustomerflag;

    /**
     * 零售价类型
     */
    private String dppricetype;

    /**
     * 结算价类型
     */
    private String balancepricetype;

    /**
     * 结算价是否从货品档案取
     */
    private Boolean balancepricegetfromgoods;

    /**
     * 折扣
     */
    private BigDecimal fdiscount;

    /**
     * 商场扣点
     */
    private BigDecimal marketplacediscount;

    /**
     * 换货率
     */
    private BigDecimal qiexchangerate;

    /**
     * 换货周期
     */
    private Integer qiexchangecyc;

    private BigDecimal exchangerate;

    private Integer exchangecyc;

    private BigDecimal exchangefirst;

    /**
     * VIP卡顺序(0先卡后促销1先促销后卡)
     */
    private Integer spromobeforevip;

    /**
     * 配货周期天数
     */
    private Integer sortcycdays;

    private BigDecimal nospromoscale;

    /**
     * 暂无
     */
    private String vipusegroup;

    /**
     * 暂无
     */
    private String stockquerygroup;

    /**
     * 暂无
     */
    private String businessmangroup;

    /**
     * 是否停用
     */
    private Boolean shutout;

    /**
     * 建立日期
     */
    private Date inputDate;

    /**
     * 更新日期
     */
    private Date updatetimestamp;

    /**
     * 允许负库存
     */
    private Boolean allowminusstock;

    /**
     * 暂无
     */
    private String shopsId;

    /**
     * 暂无
     */
    private String item;

    /**
     * 暂无
     */
    private Boolean flag;

    /**
     * 暂无
     */
    private String warehouseNo;

    /**
     * 暂无
     */
    private Integer calulate;

    /**
     * 暂无
     */
    private String formulaid;

    /**
     * 暂无
     */
    private Boolean overcrdt;

    /**
     * 暂无
     */
    private Boolean ischeckbalancemode;

    /**
     * 暂无
     */
    private Boolean printpossmallbill;

    /**
     * 暂无
     */
    private String repofficeId;

    /**
     * 暂无
     */
    private Boolean isautobuildbill;

    /**
     * 暂无
     */
    private Boolean companypriceflag;

    /**
     * 暂无
     */
    private String accountcompanyId;

    /**
     * 暂无
     */
    private Boolean isemporium;

    /**
     * 暂无
     */
    private Boolean notintegral;

    /**
     * 暂无
     */
    private Boolean notdiscount;

    /**
     * 暂无
     */
    private Boolean notsendmobilemsg;

    /**
     * 暂无
     */
    private Boolean tag;

    /**
     * 暂无
     */
    private String customergroup;

    /**
     * 暂无
     */
    private Boolean isquotamanage;

    /**
     * 暂无
     */
    private Boolean checkminusstockwhenposdaybalance;

    /**
     * 暂无
     */
    private Boolean isuseunitprice;

    /**
     * 暂无
     */
    private Boolean ismall;

    /**
     * 暂无
     */
    private Boolean multiselectrenotice;

    /**
     * 暂无
     */
    private Boolean multiselectshopapplyout;

    /**
     * 暂无
     */
    private BigDecimal usearea;

    /**
     * 暂无
     */
    private BigDecimal shoptoparea;

    /**
     * 暂无
     */
    private BigDecimal shopafterarea;

    /**
     * 暂无
     */
    private BigDecimal contractarea;

    /**
     * 暂无
     */
    private BigDecimal shoplocation1;

    /**
     * 暂无
     */
    private BigDecimal shoplocation2;

    /**
     * 暂无
     */
    private Integer standardstockqt;

    /**
     * 暂无
     */
    private BigDecimal standardarearate;

    /**
     * 暂无
     */
    private Date contractbegindate;

    /**
     * 暂无
     */
    private Date contractenddate;

    /**
     * 暂无
     */
    private BigDecimal securityamount;

    /**
     * 暂无
     */
    private String controlman;

    /**
     * 暂无
     */
    private String shopstaffing;

    /**
     * 暂无
     */
    private Integer billingcycle;

    /**
     * 暂无
     */
    private String division;

    /**
     * 暂无
     */
    private String divisionlevel;

    /**
     * 暂无
     */
    private String ownbrand;

    /**
     * 是否单独核算成本
     */
    private Boolean iscalccost;

    /**
     * 暂无
     */
    private String insurance;

    /**
     * 暂无
     */
    private String giftcardusegroup;

    /**
     * 暂无
     */
    private String linkman;

    /**
     * 暂无
     */
    private String vipstoredgroup;

    /**
     * 经营企业许可、备案编号（自动生成）
     */
    private String brid;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev == null ? null : abbrev.trim();
    }

    public String getCustomerNa() {
        return customerNa;
    }

    public void setCustomerNa(String customerNa) {
        this.customerNa = customerNa == null ? null : customerNa.trim();
    }

    public Date getPractisedate() {
        return practisedate;
    }

    public void setPractisedate(Date practisedate) {
        this.practisedate = practisedate;
    }

    public Date getShutoutdate() {
        return shutoutdate;
    }

    public void setShutoutdate(Date shutoutdate) {
        this.shutoutdate = shutoutdate;
    }

    public String getFictitiousperson() {
        return fictitiousperson;
    }

    public void setFictitiousperson(String fictitiousperson) {
        this.fictitiousperson = fictitiousperson == null ? null : fictitiousperson.trim();
    }

    public String getTaxnumber() {
        return taxnumber;
    }

    public void setTaxnumber(String taxnumber) {
        this.taxnumber = taxnumber == null ? null : taxnumber.trim();
    }

    public String getKeyman() {
        return keyman;
    }

    public void setKeyman(String keyman) {
        this.keyman = keyman == null ? null : keyman.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1 == null ? null : tel1.trim();
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2 == null ? null : tel2.trim();
    }

    public String getCgroup() {
        return cgroup;
    }

    public void setCgroup(String cgroup) {
        this.cgroup = cgroup == null ? null : cgroup.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getOrganizationid() {
        return organizationid;
    }

    public void setOrganizationid(String organizationid) {
        this.organizationid = organizationid == null ? null : organizationid.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode == null ? null : zipcode.trim();
    }

    public String getMathod() {
        return mathod;
    }

    public void setMathod(String mathod) {
        this.mathod = mathod == null ? null : mathod.trim();
    }

    public String getDealinpattern() {
        return dealinpattern;
    }

    public void setDealinpattern(String dealinpattern) {
        this.dealinpattern = dealinpattern == null ? null : dealinpattern.trim();
    }

    public Short getClevel() {
        return clevel;
    }

    public void setClevel(Short clevel) {
        this.clevel = clevel;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    public String getSaleman() {
        return saleman;
    }

    public void setSaleman(String saleman) {
        this.saleman = saleman == null ? null : saleman.trim();
    }

    public String getPropertylevel() {
        return propertylevel;
    }

    public void setPropertylevel(String propertylevel) {
        this.propertylevel = propertylevel == null ? null : propertylevel.trim();
    }

    public BigDecimal getSaletarget() {
        return saletarget;
    }

    public void setSaletarget(BigDecimal saletarget) {
        this.saletarget = saletarget;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getCarea() {
        return carea;
    }

    public void setCarea(BigDecimal carea) {
        this.carea = carea;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Long getCredit() {
        return credit;
    }

    public void setCredit(Long credit) {
        this.credit = credit;
    }

    public String getParentchannelid() {
        return parentchannelid;
    }

    public void setParentchannelid(String parentchannelid) {
        this.parentchannelid = parentchannelid == null ? null : parentchannelid.trim();
    }

    public String getAccountcustomerId() {
        return accountcustomerId;
    }

    public void setAccountcustomerId(String accountcustomerId) {
        this.accountcustomerId = accountcustomerId == null ? null : accountcustomerId.trim();
    }

    public Boolean getAccountcustomerflag() {
        return accountcustomerflag;
    }

    public void setAccountcustomerflag(Boolean accountcustomerflag) {
        this.accountcustomerflag = accountcustomerflag;
    }

    public String getDppricetype() {
        return dppricetype;
    }

    public void setDppricetype(String dppricetype) {
        this.dppricetype = dppricetype == null ? null : dppricetype.trim();
    }

    public String getBalancepricetype() {
        return balancepricetype;
    }

    public void setBalancepricetype(String balancepricetype) {
        this.balancepricetype = balancepricetype == null ? null : balancepricetype.trim();
    }

    public Boolean getBalancepricegetfromgoods() {
        return balancepricegetfromgoods;
    }

    public void setBalancepricegetfromgoods(Boolean balancepricegetfromgoods) {
        this.balancepricegetfromgoods = balancepricegetfromgoods;
    }

    public BigDecimal getFdiscount() {
        return fdiscount;
    }

    public void setFdiscount(BigDecimal fdiscount) {
        this.fdiscount = fdiscount;
    }

    public BigDecimal getMarketplacediscount() {
        return marketplacediscount;
    }

    public void setMarketplacediscount(BigDecimal marketplacediscount) {
        this.marketplacediscount = marketplacediscount;
    }

    public BigDecimal getQiexchangerate() {
        return qiexchangerate;
    }

    public void setQiexchangerate(BigDecimal qiexchangerate) {
        this.qiexchangerate = qiexchangerate;
    }

    public Integer getQiexchangecyc() {
        return qiexchangecyc;
    }

    public void setQiexchangecyc(Integer qiexchangecyc) {
        this.qiexchangecyc = qiexchangecyc;
    }

    public BigDecimal getExchangerate() {
        return exchangerate;
    }

    public void setExchangerate(BigDecimal exchangerate) {
        this.exchangerate = exchangerate;
    }

    public Integer getExchangecyc() {
        return exchangecyc;
    }

    public void setExchangecyc(Integer exchangecyc) {
        this.exchangecyc = exchangecyc;
    }

    public BigDecimal getExchangefirst() {
        return exchangefirst;
    }

    public void setExchangefirst(BigDecimal exchangefirst) {
        this.exchangefirst = exchangefirst;
    }

    public Integer getSpromobeforevip() {
        return spromobeforevip;
    }

    public void setSpromobeforevip(Integer spromobeforevip) {
        this.spromobeforevip = spromobeforevip;
    }

    public Integer getSortcycdays() {
        return sortcycdays;
    }

    public void setSortcycdays(Integer sortcycdays) {
        this.sortcycdays = sortcycdays;
    }

    public BigDecimal getNospromoscale() {
        return nospromoscale;
    }

    public void setNospromoscale(BigDecimal nospromoscale) {
        this.nospromoscale = nospromoscale;
    }

    public String getVipusegroup() {
        return vipusegroup;
    }

    public void setVipusegroup(String vipusegroup) {
        this.vipusegroup = vipusegroup == null ? null : vipusegroup.trim();
    }

    public String getStockquerygroup() {
        return stockquerygroup;
    }

    public void setStockquerygroup(String stockquerygroup) {
        this.stockquerygroup = stockquerygroup == null ? null : stockquerygroup.trim();
    }

    public String getBusinessmangroup() {
        return businessmangroup;
    }

    public void setBusinessmangroup(String businessmangroup) {
        this.businessmangroup = businessmangroup == null ? null : businessmangroup.trim();
    }

    public Boolean getShutout() {
        return shutout;
    }

    public void setShutout(Boolean shutout) {
        this.shutout = shutout;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public Date getUpdatetimestamp() {
        return updatetimestamp;
    }

    public void setUpdatetimestamp(Date updatetimestamp) {
        this.updatetimestamp = updatetimestamp;
    }

    public Boolean getAllowminusstock() {
        return allowminusstock;
    }

    public void setAllowminusstock(Boolean allowminusstock) {
        this.allowminusstock = allowminusstock;
    }

    public String getShopsId() {
        return shopsId;
    }

    public void setShopsId(String shopsId) {
        this.shopsId = shopsId == null ? null : shopsId.trim();
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item == null ? null : item.trim();
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getWarehouseNo() {
        return warehouseNo;
    }

    public void setWarehouseNo(String warehouseNo) {
        this.warehouseNo = warehouseNo == null ? null : warehouseNo.trim();
    }

    public Integer getCalulate() {
        return calulate;
    }

    public void setCalulate(Integer calulate) {
        this.calulate = calulate;
    }

    public String getFormulaid() {
        return formulaid;
    }

    public void setFormulaid(String formulaid) {
        this.formulaid = formulaid == null ? null : formulaid.trim();
    }

    public Boolean getOvercrdt() {
        return overcrdt;
    }

    public void setOvercrdt(Boolean overcrdt) {
        this.overcrdt = overcrdt;
    }

    public Boolean getIscheckbalancemode() {
        return ischeckbalancemode;
    }

    public void setIscheckbalancemode(Boolean ischeckbalancemode) {
        this.ischeckbalancemode = ischeckbalancemode;
    }

    public Boolean getPrintpossmallbill() {
        return printpossmallbill;
    }

    public void setPrintpossmallbill(Boolean printpossmallbill) {
        this.printpossmallbill = printpossmallbill;
    }

    public String getRepofficeId() {
        return repofficeId;
    }

    public void setRepofficeId(String repofficeId) {
        this.repofficeId = repofficeId == null ? null : repofficeId.trim();
    }

    public Boolean getIsautobuildbill() {
        return isautobuildbill;
    }

    public void setIsautobuildbill(Boolean isautobuildbill) {
        this.isautobuildbill = isautobuildbill;
    }

    public Boolean getCompanypriceflag() {
        return companypriceflag;
    }

    public void setCompanypriceflag(Boolean companypriceflag) {
        this.companypriceflag = companypriceflag;
    }

    public String getAccountcompanyId() {
        return accountcompanyId;
    }

    public void setAccountcompanyId(String accountcompanyId) {
        this.accountcompanyId = accountcompanyId == null ? null : accountcompanyId.trim();
    }

    public Boolean getIsemporium() {
        return isemporium;
    }

    public void setIsemporium(Boolean isemporium) {
        this.isemporium = isemporium;
    }

    public Boolean getNotintegral() {
        return notintegral;
    }

    public void setNotintegral(Boolean notintegral) {
        this.notintegral = notintegral;
    }

    public Boolean getNotdiscount() {
        return notdiscount;
    }

    public void setNotdiscount(Boolean notdiscount) {
        this.notdiscount = notdiscount;
    }

    public Boolean getNotsendmobilemsg() {
        return notsendmobilemsg;
    }

    public void setNotsendmobilemsg(Boolean notsendmobilemsg) {
        this.notsendmobilemsg = notsendmobilemsg;
    }

    public Boolean getTag() {
        return tag;
    }

    public void setTag(Boolean tag) {
        this.tag = tag;
    }

    public String getCustomergroup() {
        return customergroup;
    }

    public void setCustomergroup(String customergroup) {
        this.customergroup = customergroup == null ? null : customergroup.trim();
    }

    public Boolean getIsquotamanage() {
        return isquotamanage;
    }

    public void setIsquotamanage(Boolean isquotamanage) {
        this.isquotamanage = isquotamanage;
    }

    public Boolean getCheckminusstockwhenposdaybalance() {
        return checkminusstockwhenposdaybalance;
    }

    public void setCheckminusstockwhenposdaybalance(Boolean checkminusstockwhenposdaybalance) {
        this.checkminusstockwhenposdaybalance = checkminusstockwhenposdaybalance;
    }

    public Boolean getIsuseunitprice() {
        return isuseunitprice;
    }

    public void setIsuseunitprice(Boolean isuseunitprice) {
        this.isuseunitprice = isuseunitprice;
    }

    public Boolean getIsmall() {
        return ismall;
    }

    public void setIsmall(Boolean ismall) {
        this.ismall = ismall;
    }

    public Boolean getMultiselectrenotice() {
        return multiselectrenotice;
    }

    public void setMultiselectrenotice(Boolean multiselectrenotice) {
        this.multiselectrenotice = multiselectrenotice;
    }

    public Boolean getMultiselectshopapplyout() {
        return multiselectshopapplyout;
    }

    public void setMultiselectshopapplyout(Boolean multiselectshopapplyout) {
        this.multiselectshopapplyout = multiselectshopapplyout;
    }

    public BigDecimal getUsearea() {
        return usearea;
    }

    public void setUsearea(BigDecimal usearea) {
        this.usearea = usearea;
    }

    public BigDecimal getShoptoparea() {
        return shoptoparea;
    }

    public void setShoptoparea(BigDecimal shoptoparea) {
        this.shoptoparea = shoptoparea;
    }

    public BigDecimal getShopafterarea() {
        return shopafterarea;
    }

    public void setShopafterarea(BigDecimal shopafterarea) {
        this.shopafterarea = shopafterarea;
    }

    public BigDecimal getContractarea() {
        return contractarea;
    }

    public void setContractarea(BigDecimal contractarea) {
        this.contractarea = contractarea;
    }

    public BigDecimal getShoplocation1() {
        return shoplocation1;
    }

    public void setShoplocation1(BigDecimal shoplocation1) {
        this.shoplocation1 = shoplocation1;
    }

    public BigDecimal getShoplocation2() {
        return shoplocation2;
    }

    public void setShoplocation2(BigDecimal shoplocation2) {
        this.shoplocation2 = shoplocation2;
    }

    public Integer getStandardstockqt() {
        return standardstockqt;
    }

    public void setStandardstockqt(Integer standardstockqt) {
        this.standardstockqt = standardstockqt;
    }

    public BigDecimal getStandardarearate() {
        return standardarearate;
    }

    public void setStandardarearate(BigDecimal standardarearate) {
        this.standardarearate = standardarearate;
    }

    public Date getContractbegindate() {
        return contractbegindate;
    }

    public void setContractbegindate(Date contractbegindate) {
        this.contractbegindate = contractbegindate;
    }

    public Date getContractenddate() {
        return contractenddate;
    }

    public void setContractenddate(Date contractenddate) {
        this.contractenddate = contractenddate;
    }

    public BigDecimal getSecurityamount() {
        return securityamount;
    }

    public void setSecurityamount(BigDecimal securityamount) {
        this.securityamount = securityamount;
    }

    public String getControlman() {
        return controlman;
    }

    public void setControlman(String controlman) {
        this.controlman = controlman == null ? null : controlman.trim();
    }

    public String getShopstaffing() {
        return shopstaffing;
    }

    public void setShopstaffing(String shopstaffing) {
        this.shopstaffing = shopstaffing == null ? null : shopstaffing.trim();
    }

    public Integer getBillingcycle() {
        return billingcycle;
    }

    public void setBillingcycle(Integer billingcycle) {
        this.billingcycle = billingcycle;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division == null ? null : division.trim();
    }

    public String getDivisionlevel() {
        return divisionlevel;
    }

    public void setDivisionlevel(String divisionlevel) {
        this.divisionlevel = divisionlevel == null ? null : divisionlevel.trim();
    }

    public String getOwnbrand() {
        return ownbrand;
    }

    public void setOwnbrand(String ownbrand) {
        this.ownbrand = ownbrand == null ? null : ownbrand.trim();
    }

    public Boolean getIscalccost() {
        return iscalccost;
    }

    public void setIscalccost(Boolean iscalccost) {
        this.iscalccost = iscalccost;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance == null ? null : insurance.trim();
    }

    public String getGiftcardusegroup() {
        return giftcardusegroup;
    }

    public void setGiftcardusegroup(String giftcardusegroup) {
        this.giftcardusegroup = giftcardusegroup == null ? null : giftcardusegroup.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getVipstoredgroup() {
        return vipstoredgroup;
    }

    public void setVipstoredgroup(String vipstoredgroup) {
        this.vipstoredgroup = vipstoredgroup == null ? null : vipstoredgroup.trim();
    }

    public String getBrid() {
        return brid;
    }

    public void setBrid(String brid) {
        this.brid = brid == null ? null : brid.trim();
    }
}