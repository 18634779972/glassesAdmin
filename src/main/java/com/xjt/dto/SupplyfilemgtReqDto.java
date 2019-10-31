package com.xjt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel
public class SupplyfilemgtReqDto extends BaseReqDto {
    private Integer id;

    /**
     * 文档名
     */
    @ApiModelProperty("文档名")
    private String filename;

    /**
     * 文件路径
     */
    @ApiModelProperty("文件路径")
    private String filepath;

    /**
     * 图片路径
     */
    @ApiModelProperty("图片路径")
    private String picturepath;

    /**
     * 上传日期
     */
    @ApiModelProperty("上传日期")
    private Date uploaddate;

    /**
     * 生效日期
     */
    @ApiModelProperty("生效日期")
    private Date effectivedate;

    /**
     * 失效日期
     */
    @ApiModelProperty("失效日期")
    private Date expirationdate;

    /**
     * 文件类型
     */
    @ApiModelProperty("文件类型")
    private String filetype;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getPicturepath() {
        return picturepath;
    }

    public void setPicturepath(String picturepath) {
        this.picturepath = picturepath;
    }

    public Date getUploaddate() {
        return uploaddate;
    }

    public void setUploaddate(Date uploaddate) {
        this.uploaddate = uploaddate;
    }

    public Date getEffectivedate() {
        return effectivedate;
    }

    public void setEffectivedate(Date effectivedate) {
        this.effectivedate = effectivedate;
    }

    public Date getExpirationdate() {
        return expirationdate;
    }

    public void setExpirationdate(Date expirationdate) {
        this.expirationdate = expirationdate;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
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
}
