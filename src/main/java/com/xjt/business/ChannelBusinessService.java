package com.xjt.business;

import com.xjt.entity.Channel;

public interface ChannelBusinessService {

    void insertChannel(Channel channel);

    void updateDeleteFlag(Channel channel);

    void updateChannelInfo(Channel channel);
}
