package com.xjt.dao.master;

import com.xjt.entity.Channel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.method.P;

import java.util.List;
@Mapper
public interface ChannelDao {
    int deleteByPrimaryKey(String id);

    /**
     * 增加渠道
     * @param record
     * @return
     */
    int insert(Channel record);

    int insertSelective(Channel record);

    Channel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKey(Channel record);

    /**
     * 根据渠道id查看渠道列表
     * @param ids
     * @return
     */
    List<Channel> queryChannelList(@Param("ids") List<String> ids);

    /**
     * 更新渠道有效值
     * @param channel
     * @return
     */
    int updateDeleteFlag(Channel channel);

    /**
     * 查看渠道列表
     * @return
     */
    List<Channel> selectChannelList();

}