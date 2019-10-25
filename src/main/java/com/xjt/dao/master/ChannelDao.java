package com.xjt.dao.master;

import com.xjt.entity.Channel;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.method.P;

import java.util.List;

public interface ChannelDao {
    int deleteByPrimaryKey(String id);

    int insert(Channel record);

    int insertSelective(Channel record);

    Channel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKey(Channel record);

    List<Channel> queryChannelList(@Param("ids") List<String> ids);
}