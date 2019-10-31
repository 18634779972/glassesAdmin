package com.xjt.entity;

import java.util.Date;

/**
 * 货品图片表
 * 
 * @author wcyong
 * 
 * @date 2019-10-30
 */
public class Goodspicturemgt {
    /**
     * 货品图片ID
     */
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
     * 货品ID(生成GUID)
     */
    private String goodsid;

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

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid == null ? null : goodsid.trim();
    }
}