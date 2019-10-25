package com.xjt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xjt.business.ChannelBusinessService;
import com.xjt.dao.master.ChannelDao;
import com.xjt.dto.BaseReqDto;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.ChannelReqDto;
import com.xjt.entity.Channel;
import com.xjt.enums.ResultCode;
import com.xjt.service.ChannelService;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ChannelServiceImpl implements ChannelService {

    @Resource
    private ChannelBusinessService businessService;
    @Resource
    private ChannelDao channelDao;

    private Logger logger = LoggerFactory.getLogger(ChannelServiceImpl.class);

    /**
     * 添加渠道
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto insertChannel(ChannelReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String channelName = reqDto.getChannel();
        String masterId = reqDto.getMasterId();
        String createId = reqDto.getCreateId();
        if(STRUtils.isEmpty(channelName)||STRUtils.isEmpty(masterId)){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("channel or masterId is null");
            return baseResDto;
        }
        if(createId==null){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("createId is null");
            return baseResDto;
        }
        try{
            Channel channel = new Channel();
            BeanUtils.copyProperties(reqDto,channel);
            channel.setId(STRUtils.createUUID());
            channel.setDeleteFlag(1L);
            channel.setCreatedate(new Date());
            businessService.insertChannel(channel);
        }catch (Exception e){
            baseResDto.setResultMessage("添加渠道异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("添加渠道异常",e);
        }
        return baseResDto;
    }

    /**
     * 更新渠道有效值
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto updateDeleteFlag(ChannelReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String id = reqDto.getId();
        Long deleteFlag = reqDto.getDeleteFlag();
        if(STRUtils.isEmpty(id)){
            baseResDto.setResultMessage("id is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        if(deleteFlag==null){
            baseResDto.setResultMessage("deleteFlag is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            Channel channel = new Channel();
            BeanUtils.copyProperties(reqDto,channel);
            businessService.updateDeleteFlag(channel);

        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("更新渠道有效值异常");
            logger.error("更新渠道有效值异常",e);
        }
        return baseResDto;
    }

    /**
     * 更新渠道信息
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto updateChannelInfo(ChannelReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String id = reqDto.getId();
        if(STRUtils.isEmpty(id)){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("id is null");
            return baseResDto;
        }
        try{
            Channel channel = new Channel();
            BeanUtils.copyProperties(reqDto,channel);
            channel.setUpdatedate(new Date());
            businessService.updateChannelInfo(channel);
        }catch (Exception e){
            baseResDto.setResultMessage("更新渠道信息异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("更新渠道信息异常",e);
        }
        return baseResDto;
    }

    /**
     * 查看渠道列表 如果有分页参数 就分页查看
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto queryChannelList(ChannelReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        try{
            Integer pageNo = reqDto.getPageNo();
            Integer pageSize = reqDto.getPageSize();
            List<Channel> channels = channelDao.selectChannelList();
            if(pageNo!=null&&pageSize!=null){
                PageHelper.startPage(pageNo,pageSize);
                PageInfo<Channel> pageInfo = new PageInfo<>(channels);
                baseResDto.setData(pageInfo);
                return baseResDto;
            }
                baseResDto.setData(channels);
        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("查看渠道列表异常");
            logger.error("查看渠道列表异常",e);
        }

        return null;
    }

    /**
     * 查看单条渠道信息
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto queryChannelInfo(ChannelReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String id = reqDto.getId();
        if(STRUtils.isEmpty(id)){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("id is null");
            return baseResDto;
        }
        try{
            Channel channel = channelDao.selectByPrimaryKey(id);
            baseResDto.setData(channel);
        }catch (Exception e){
            baseResDto.setResultMessage("查看渠道详细信息异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("查看渠道详细信息异常",e);
        }
        return baseResDto;
    }
}
