package com.xjt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@ApiModel
public class GoodsReqDto extends BaseReqDto {

    /**
     * 货品ID(生成GUID)
     */
    @ApiModelProperty("货品ID")
    private String goodsid;

    /**
     * 货品编号
     */
    @ApiModelProperty("货品编号")
    private String goodsno;

    /**
     * 厂家编号
     */
    @ApiModelProperty("厂家编号")
    private String goodsmanuno;

    /**
     * 左右眼（0不分1左2右）
     */
    @ApiModelProperty("左右眼（0不分1左2右）")
    private String ctype;

    /**
     * 积分值
     */
    @ApiModelProperty("积分值")
    private Integer integral;

    /**
     * ADD值
     */
    @ApiModelProperty("ADD值")
    private Integer addvalue;

    /**
     * 税率
     */
    @ApiModelProperty("税率")
    private String taxrate;

    /**
     * 建档人
     */
    @ApiModelProperty("建档人")
    private String inputman;

    /**
     * 建档日期
     */
    @ApiModelProperty("建档日期")
    private String inputdate;

    /**
     * 更新时间戳
     */
    @ApiModelProperty("更新时间戳")
    private Date updatetimestamp;

    /**
     * 停用
     */
    @ApiModelProperty("停用")
    private Integer shutout;

    /**
     * 是否效期管理  0 否，1 是
     */
    @ApiModelProperty("是否效期管理  0 否，1 是")
    private Integer isvalidity;

    /**
     * 效期天数
     */
    @ApiModelProperty("效期天数")
    private Integer effectivedays;

    /**
     * 是否批次管理  0 否，1 是
     */
    @ApiModelProperty("是否批次管理  0 否，1 是")
    private Integer isbatch;

    /**
     * 是否附加商品  0 否，1 是
     */
    @ApiModelProperty("是否附加商品  0 否，1 是")
    private Integer isattach;

    /**
     * 是否虚拟商品 0 否，1 是
     */
    @ApiModelProperty("是否虚拟商品 0 否，1 是")
    private Integer isvirtual;

    /**
     * 货品名称
     */
    @ApiModelProperty("货品名称")
    private String goodsname;

    /**
     * 品牌
     */
    @ApiModelProperty("品牌")
    private String brand;

    /**
     * 系列名
     */
    @ApiModelProperty("系列名")
    private String crange;

    /**
     * 年份表
     */
    @ApiModelProperty("年份表")
    private String cyear;

    /**
     * 季节表
     */
    @ApiModelProperty("季节表")
    private String season;

    /**
     * 属性
     */
    @ApiModelProperty("属性")
    private String property;

    /**
     * 单位
     */
    @ApiModelProperty("单位")
    private String unit;

    /**
     * 分类编号(guid)
     */
    @ApiModelProperty("分类编号")
    private String categoryid;

    /**
     * 分类编号(Guid)
     */
    @ApiModelProperty("分类编号")
    private String categoryid2;

    /**
     * 款型
     */
    @ApiModelProperty("款型")
    private String pattem;

    /**
     * 执行标准
     */
    @ApiModelProperty("执行标准")
    private String executestandard;

    /**
     * 安全类别
     */
    @ApiModelProperty("安全类别")
    private String safecategory;

    /**
     * 产地
     */
    @ApiModelProperty("产地")
    private String producingarea;

    /**
     * 色散系数
     */
    @ApiModelProperty("色散系数")
    private String abbenumber;

    /**
     * 折射率
     */
    @ApiModelProperty("折射率")
    private BigDecimal refractiveindex;

    /**
     * 供应商
     */
    @ApiModelProperty("供应商")
    private String supplyNo;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String cmemo;

    /**
     * 备用1
     */

    private String field1;

    /**
     * 备用2
     */

    private String field2;

    /**
     * 备用3
     */
    private String field3;

    /**
     * 备用4
     */
    private String field4;
    /**
     * 货品图片
     */
    @ApiModelProperty("货品图片")
    private List<MultipartFile> files;
    /**
     * 拥有的品牌权限
     */
    private List<String> brands;
    /**
     * 拥有的供货商权限
     */
    private List<String> supplys;

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsno() {
        return goodsno;
    }

    public void setGoodsno(String goodsno) {
        this.goodsno = goodsno;
    }

    public String getGoodsmanuno() {
        return goodsmanuno;
    }

    public void setGoodsmanuno(String goodsmanuno) {
        this.goodsmanuno = goodsmanuno;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getAddvalue() {
        return addvalue;
    }

    public void setAddvalue(Integer addvalue) {
        this.addvalue = addvalue;
    }

    public String getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(String taxrate) {
        this.taxrate = taxrate;
    }

    public String getInputman() {
        return inputman;
    }

    public void setInputman(String inputman) {
        this.inputman = inputman;
    }

    public String getInputdate() {
        return inputdate;
    }

    public void setInputdate(String inputdate) {
        this.inputdate = inputdate;
    }

    public Date getUpdatetimestamp() {
        return updatetimestamp;
    }

    public void setUpdatetimestamp(Date updatetimestamp) {
        this.updatetimestamp = updatetimestamp;
    }

    public Integer getShutout() {
        return shutout;
    }

    public void setShutout(Integer shutout) {
        this.shutout = shutout;
    }

    public Integer getIsvalidity() {
        return isvalidity;
    }

    public void setIsvalidity(Integer isvalidity) {
        this.isvalidity = isvalidity;
    }

    public Integer getEffectivedays() {
        return effectivedays;
    }

    public void setEffectivedays(Integer effectivedays) {
        this.effectivedays = effectivedays;
    }

    public Integer getIsbatch() {
        return isbatch;
    }

    public void setIsbatch(Integer isbatch) {
        this.isbatch = isbatch;
    }

    public Integer getIsattach() {
        return isattach;
    }

    public void setIsattach(Integer isattach) {
        this.isattach = isattach;
    }

    public Integer getIsvirtual() {
        return isvirtual;
    }

    public void setIsvirtual(Integer isvirtual) {
        this.isvirtual = isvirtual;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCrange() {
        return crange;
    }

    public void setCrange(String crange) {
        this.crange = crange;
    }

    public String getCyear() {
        return cyear;
    }

    public void setCyear(String cyear) {
        this.cyear = cyear;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryid2() {
        return categoryid2;
    }

    public void setCategoryid2(String categoryid2) {
        this.categoryid2 = categoryid2;
    }

    public String getPattem() {
        return pattem;
    }

    public void setPattem(String pattem) {
        this.pattem = pattem;
    }

    public String getExecutestandard() {
        return executestandard;
    }

    public void setExecutestandard(String executestandard) {
        this.executestandard = executestandard;
    }

    public String getSafecategory() {
        return safecategory;
    }

    public void setSafecategory(String safecategory) {
        this.safecategory = safecategory;
    }

    public String getProducingarea() {
        return producingarea;
    }

    public void setProducingarea(String producingarea) {
        this.producingarea = producingarea;
    }

    public String getAbbenumber() {
        return abbenumber;
    }

    public void setAbbenumber(String abbenumber) {
        this.abbenumber = abbenumber;
    }

    public BigDecimal getRefractiveindex() {
        return refractiveindex;
    }

    public void setRefractiveindex(BigDecimal refractiveindex) {
        this.refractiveindex = refractiveindex;
    }

    public String getSupplyNo() {
        return supplyNo;
    }

    public void setSupplyNo(String supplyNo) {
        this.supplyNo = supplyNo;
    }

    public String getCmemo() {
        return cmemo;
    }

    public void setCmemo(String cmemo) {
        this.cmemo = cmemo;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }

    public List<String> getBrands() {
        return brands;
    }

    public void setBrands(List<String> brands) {
        this.brands = brands;
    }

    public List<String> getSupplys() {
        return supplys;
    }

    public void setSupplys(List<String> supplys) {
        this.supplys = supplys;
    }
}
