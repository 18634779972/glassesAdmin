package com.xjt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

@ApiModel
public class GoodsbarcodeReqDto extends BaseReqDto {

    /**
     * 自动ID
     */
    @ApiModelProperty("自动ID")
    private Integer id;

    /**
     * 货品编号
     */
    @ApiModelProperty("货品编号")
    private String goodsno;

    /**
     * 颜色、膜层
     */
    @ApiModelProperty("颜色、膜层")
    private String colordd;

    /**
     * 曲光度
     */
    @ApiModelProperty("曲光度")
    private BigDecimal dioptre;

    /**
     * 散光度
     */
    @ApiModelProperty("散光度")
    private BigDecimal astigmia;

    /**
     * 条码
     */
    @ApiModelProperty("条码")
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
        this.goodsno = goodsno;
    }

    public String getColordd() {
        return colordd;
    }

    public void setColordd(String colordd) {
        this.colordd = colordd;
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
        this.barcode = barcode;
    }
}
