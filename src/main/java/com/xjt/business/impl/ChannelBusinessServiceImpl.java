package com.xjt.business.impl;

import com.xjt.business.ChannelBusinessService;
import com.xjt.dao.master.ChannelDao;
import com.xjt.entity.Channel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class ChannelBusinessServiceImpl implements ChannelBusinessService {
    @Resource
    private ChannelDao channelDao;

    /**
     * 添加渠道
     * @param channel
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertChannel(Channel channel) {
        int num = channelDao.insert(channel);
        if(num !=1){
            throw new RuntimeException("添加渠道异常");
        }
    }

    /**
     * 更新渠道有效值
     * @param channel
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateDeleteFlag(Channel channel) {

        int num = channelDao.updateDeleteFlag(channel);
        if(num !=1){
            throw new RuntimeException("更新渠道有效值异常");
        }
    }

    /**
     * 更新渠道信息
     * @param channel
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateChannelInfo(Channel channel) {

        int num = channelDao.updateByPrimaryKeySelective(channel);
        if(num != 1){
            throw new RuntimeException("更新渠道信息异常");
        }
    }
}
