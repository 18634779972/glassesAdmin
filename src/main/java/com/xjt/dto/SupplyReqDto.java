package com.xjt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
@ApiModel
public class SupplyReqDto extends BaseReqDto {

    /**
     * 编号
     */
    @ApiModelProperty("编号")
    private String supplyNo;

    /**
     * 供应商简称
     */
    @ApiModelProperty("供应商简称")
    private String supplyAbv;

    /**
     * 供应商全称
     */
    @ApiModelProperty("供应商全称")
    private String supplyNa;

    /**
     * 营业执照编号
     */
    @ApiModelProperty("营业执照编号")
    private String registernumber;

    /**
     * 发证机关
     */
    @ApiModelProperty("发证机关")
    private String registerorg;

    /**
     * 经营范围
     */
    @ApiModelProperty("经营范围")
    private String businessarea;

    /**
     * 注册时间
     */

    private Date registerdate;
    @ApiModelProperty("注册时间 yyyy-MM-dd")
    private String registerDateStr;

    /**
     * 到期时间
     */
    private Date expirydate;
    @ApiModelProperty("到期时间 yyyy-MM-dd")
    private String expriDateStr;
    /**
     * 注册金额
     */
    @ApiModelProperty("注册金额")
    private BigDecimal registermomey;

    /**
     * 负责人
     */
    @ApiModelProperty("负责人")
    private String keyman;

    /**
     * 传真
     */
    @ApiModelProperty("传真")
    private String fax;

    /**
     * 电话1
     */
    @ApiModelProperty("电话1")
    private String tele1;

    /**
     * 电话2
     */
    @ApiModelProperty("电话2")
    private String tele2;

    /**
     * 注册地址
     */
    @ApiModelProperty("注册地址")
    private String registeraddress;

    /**
     * 地址
     */
    @ApiModelProperty("地址")
    private String address;

    /**
     * 区域
     */
    @ApiModelProperty("区域")
    private String region;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String eMail;

    /**
     * 邮政编码
     */
    @ApiModelProperty("邮政编码")
    private String zipcode;

    /**
     * 税率
     */
    @ApiModelProperty("税率")
    private BigDecimal taxrate;

    /**
     * 供应商类型（0 生产企业1 经营企业2皆有）
     */
    @ApiModelProperty("供应商类型（0 生产企业1 经营企业2皆有）")
    private Integer type;

    /**
     * 采购组
     */
    @ApiModelProperty("采购组")
    private String cgroup;

    /**
     * 性质
     */
    @ApiModelProperty("性质")
    private String xingzhi;

    /**
     * 省
     */
    @ApiModelProperty("省")
    private String province;

    /**
     * 市
     */
    @ApiModelProperty("市")
    private String city;

    /**
     * 类别
     */
    @ApiModelProperty("类别")
    private String sort;

    /**
     * 结算模式(经销、代销、联营)
     */
    @ApiModelProperty("结算模式(经销、代销、联营)")
    private String balancemode;

    /**
     * 网址
     */
    @ApiModelProperty("网址")
    private String webaddress;

    /**
     * 扣点模式(0吊牌价、1实买价)
     */
    @ApiModelProperty("扣点模式(0吊牌价、1实买价)")
    private Integer rebatecalculatetype;

    /**
     * 扣点数
     */
    @ApiModelProperty("扣点数")
    private BigDecimal rebate;

    /**
     * 虚拟供应商
     */
    @ApiModelProperty("虚拟供应商")
    private Boolean tag;

    /**
     * 是否停用
     */
    @ApiModelProperty("是否停用")
    private Boolean shutout;

    /**
     * 跟单人
     */
    @ApiModelProperty("跟单人")
    private String processuser;

    /**
     * 到期时间
     */
    @ApiModelProperty("到期时间")
    private Date docdate;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date updatetimestamp;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

    /**
     * 生产企业许可、备案编号（GUID）
     */
    @ApiModelProperty("生产企业许可、备案编号")
    private String mrid;

    /**
     * 经营企业许可、备案编号（自动生成）
     */
    @ApiModelProperty("经营企业许可、备案编号")
    private String brid;

    public String getSupplyNo() {
        return supplyNo;
    }

    public void setSupplyNo(String supplyNo) {
        this.supplyNo = supplyNo == null ? null : supplyNo.trim();
    }

    public String getSupplyAbv() {
        return supplyAbv;
    }

    public void setSupplyAbv(String supplyAbv) {
        this.supplyAbv = supplyAbv == null ? null : supplyAbv.trim();
    }

    public String getSupplyNa() {
        return supplyNa;
    }

    public void setSupplyNa(String supplyNa) {
        this.supplyNa = supplyNa == null ? null : supplyNa.trim();
    }

    public String getRegisternumber() {
        return registernumber;
    }

    public void setRegisternumber(String registernumber) {
        this.registernumber = registernumber == null ? null : registernumber.trim();
    }

    public String getRegisterorg() {
        return registerorg;
    }

    public void setRegisterorg(String registerorg) {
        this.registerorg = registerorg == null ? null : registerorg.trim();
    }

    public String getBusinessarea() {
        return businessarea;
    }

    public void setBusinessarea(String businessarea) {
        this.businessarea = businessarea == null ? null : businessarea.trim();
    }

    public Date getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(Date registerdate) {
        this.registerdate = registerdate;
    }

    public Date getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(Date expirydate) {
        this.expirydate = expirydate;
    }

    public BigDecimal getRegistermomey() {
        return registermomey;
    }

    public void setRegistermomey(BigDecimal registermomey) {
        this.registermomey = registermomey;
    }

    public String getKeyman() {
        return keyman;
    }

    public void setKeyman(String keyman) {
        this.keyman = keyman == null ? null : keyman.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getTele1() {
        return tele1;
    }

    public void setTele1(String tele1) {
        this.tele1 = tele1 == null ? null : tele1.trim();
    }

    public String getTele2() {
        return tele2;
    }

    public void setTele2(String tele2) {
        this.tele2 = tele2 == null ? null : tele2.trim();
    }

    public String getRegisteraddress() {
        return registeraddress;
    }

    public void setRegisteraddress(String registeraddress) {
        this.registeraddress = registeraddress == null ? null : registeraddress.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail == null ? null : eMail.trim();
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode == null ? null : zipcode.trim();
    }

    public BigDecimal getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(BigDecimal taxrate) {
        this.taxrate = taxrate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCgroup() {
        return cgroup;
    }

    public void setCgroup(String cgroup) {
        this.cgroup = cgroup == null ? null : cgroup.trim();
    }

    public String getXingzhi() {
        return xingzhi;
    }

    public void setXingzhi(String xingzhi) {
        this.xingzhi = xingzhi == null ? null : xingzhi.trim();
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

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    public String getBalancemode() {
        return balancemode;
    }

    public void setBalancemode(String balancemode) {
        this.balancemode = balancemode == null ? null : balancemode.trim();
    }

    public String getWebaddress() {
        return webaddress;
    }

    public void setWebaddress(String webaddress) {
        this.webaddress = webaddress == null ? null : webaddress.trim();
    }

    public Integer getRebatecalculatetype() {
        return rebatecalculatetype;
    }

    public void setRebatecalculatetype(Integer rebatecalculatetype) {
        this.rebatecalculatetype = rebatecalculatetype;
    }

    public BigDecimal getRebate() {
        return rebate;
    }

    public void setRebate(BigDecimal rebate) {
        this.rebate = rebate;
    }

    public Boolean getTag() {
        return tag;
    }

    public void setTag(Boolean tag) {
        this.tag = tag;
    }

    public Boolean getShutout() {
        return shutout;
    }

    public void setShutout(Boolean shutout) {
        this.shutout = shutout;
    }

    public String getProcessuser() {
        return processuser;
    }

    public void setProcessuser(String processuser) {
        this.processuser = processuser == null ? null : processuser.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getMrid() {
        return mrid;
    }

    public void setMrid(String mrid) {
        this.mrid = mrid == null ? null : mrid.trim();
    }

    public String getBrid() {
        return brid;
    }

    public void setBrid(String brid) {
        this.brid = brid == null ? null : brid.trim();
    }

    public String getRegisterDateStr() {
        return registerDateStr;
    }

    public void setRegisterDateStr(String registerDateStr) {
        this.registerDateStr = registerDateStr;
    }

    public String getExpriDateStr() {
        return expriDateStr;
    }

    public void setExpriDateStr(String expriDateStr) {
        this.expriDateStr = expriDateStr;
    }
}
