package com.xjt.entity;

/**
 * 数据权限表
 * 
 * @author wcyong
 * 
 * @date 2019-10-25
 */
public class Datapermission {
    /**
     * 主键id
     */
    private String id;

    /**
     * 管理组id(关联groupmanager)
     */
    private String groupmanagerId;

    /**
     * 品牌id(关联dictbrand)
     */
    private String dictbrandId;

    /**
     * 仓库id(关联warehouse)
     */
    private String warehouseId;

    /**
     * 渠道id(关联channel)
     */
    private String customerId;

    /**
     * 供应商id(关联supply表)
     */
    private String supplyId;

    /**
     * 价格(0是进货价,1是零售价,2是附加价,3是批发价,4是加盟价)
     */
    private String priceRange;
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }
}