package com.xjt.entity;

import java.util.Date;

/**
 * 供应商文档
 * 
 * @author wcyong
 * 
 * @date 2019-10-29
 */
public class Supplyfilemgt {
    private Integer id;

    /**
     * 文档名
     */
    private String filename;

    /**
     * 文件路径
     */
    private String filepath;

    /**
     * 图片路径
     */
    private String picturepath;

    /**
     * 上传日期
     */
    private Date uploaddate;

    /**
     * 生效日期
     */
    private Date effectivedate;

    /**
     * 失效日期
     */
    private Date expirationdate;

    /**
     * 文件类型
     */
    private String filetype;

    /**
     * 到期时间
     */
    private Date docdate;

    /**
     * 更新时间
     */
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
        this.filename = filename == null ? null : filename.trim();
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    public String getPicturepath() {
        return picturepath;
    }

    public void setPicturepath(String picturepath) {
        this.picturepath = picturepath == null ? null : picturepath.trim();
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
        this.filetype = filetype == null ? null : filetype.trim();
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