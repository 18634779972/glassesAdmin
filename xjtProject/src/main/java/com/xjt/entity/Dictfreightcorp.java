package com.xjt.entity;

import com.xjt.dto.BaseReqDto;

/**
 * 货运公司
 * 
 * @author wcyong
 * 
 * @date 2019-10-18
 */
public class Dictfreightcorp extends BaseReqDto {
    /**
     * 货运公司
     */
    private String freightcorp;

    /**
     * 联系人
     */
    private String linkman;

    /**
     * 联系电话
     */
    private String liketel;

    public String getFreightcorp() {
        return freightcorp;
    }

    public void setFreightcorp(String freightcorp) {
        this.freightcorp = freightcorp == null ? null : freightcorp.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getLiketel() {
        return liketel;
    }

    public void setLiketel(String liketel) {
        this.liketel = liketel == null ? null : liketel.trim();
    }
}