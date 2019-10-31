package com.xjt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class DatapermissionReqDto extends BaseReqDto {

    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    private String id;

    /**
     * 管理组id(关联groupmanager)
     */
    @ApiModelProperty("管理组id")
    private String groupmanagerId;

    /**
     * 品牌id(关联dictbrand)
     */
    @ApiModelProperty("品牌id")
    private String dictbrandId;

    /**
     * 仓库id(关联warehouse)
     */
    @ApiModelProperty("仓库id")
    private String warehouseId;

    /**
     * 渠道id(关联channel)
     */
    @ApiModelProperty("渠道id")
    private String customerId;

    /**
     * 供应商id(关联supply表)
     */
    @ApiModelProperty("供应商id")
    private String supplyId;

    /**
     * 价格(0是进货价,1是零售价,2是附加价,3是批发价,4是加盟价)
     */
    @ApiModelProperty("价格(0是进货价,1是零售价,2是附加价,3是批发价,4是加盟价)")
    private String priceRange;

    /**
     * 动态字段名
     * @return
     */
    private String colName;
    /**
     * 请求类别
     */

    private Integer requestType;
    /**
     * 用户id
     */
    private String masterId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getGroupmanagerId() {
        return groupmanagerId;
    }

    public void setGroupmanagerId(String groupmanagerId) {
        this.groupmanagerId = groupmanagerId == null ? null : groupmanagerId.trim();
    }

    public String getDictbrandId() {
        return dictbrandId;
    }

    public void setDictbrandId(String dictbrandId) {
        this.dictbrandId = dictbrandId == null ? null : dictbrandId.trim();
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId == null ? null : warehouseId.trim();
    }



    public String getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(String supplyId) {
        this.supplyId = supplyId == null ? null : supplyId.trim();
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange == null ? null : priceRange.trim();
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public Integer getRequestType() {
        return requestType;
    }

    public void setRequestType(Integer requestType) {
        this.requestType = requestType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }
}
