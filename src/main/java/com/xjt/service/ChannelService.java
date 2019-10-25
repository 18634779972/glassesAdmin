package com.xjt.service;

import com.xjt.dto.BaseReqDto;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.ChannelReqDto;

public interface ChannelService {

    /**
     * 添加渠道
     * @param reqDto
     * @return
     */
    BaseResDto insertChannel(ChannelReqDto reqDto);

    /**
     * 更改渠道有效值
     * @param reqDto
     * @return
     */
    BaseResDto updateDeleteFlag(ChannelReqDto reqDto);

    /**
     * 更新渠道信息
     * @param reqDto
     * @return
     */
    BaseResDto updateChannelInfo(ChannelReqDto reqDto);

    /**
     * 查看渠道列表
     * @param reqDto
     * @return
     */
    BaseResDto queryChannelList(ChannelReqDto reqDto);

    /**
     * 查看渠道信息
     * @param reqDto
     * @return
     */
    BaseResDto queryChannelInfo(ChannelReqDto reqDto);
}
