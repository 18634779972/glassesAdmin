package com.xjt.entity;

import java.math.BigDecimal;

/**
 * 货品条码表
 * 
 * @author wcyong
 * 
 * @date 2019-10-29
 */
public class Goodsbarcode {
    /**
     * 自动ID
     */
    private Integer id;

    /**
     * 货品编号
     */
    private String goodsno;

    /**
     * 颜色、膜层
     */
    private String colordd;

    /**
     * 曲光度
     */
    private BigDecimal dioptre;

    /**
     * 散光度
     */
    private BigDecimal astigmia;

    /**
     * 条码
     */
    private String barcode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsno() {
        return goodsno;
    }

    public void setGoodsno(String goodsno) {
        this.goodsno = goodsno == null ? null : goodsno.trim();
    }

    public String getColordd() {
        return colordd;
    }

    public void setColordd(String colordd) {
        this.colordd = colordd == null ? null : colordd.trim();
    }

    public BigDecimal getDioptre() {
        return dioptre;
    }

    public void setDioptre(BigDecimal dioptre) {
        this.dioptre = dioptre;
    }

    public BigDecimal getAstigmia() {
        return astigmia;
    }

    public void setAstigmia(BigDecimal astigmia) {
        this.astigmia = astigmia;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }
}