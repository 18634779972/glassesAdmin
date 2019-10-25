package com.xjt.dao.master;

import com.xjt.entity.Master;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MasterDao {
    int deleteByPrimaryKey(String id);

    /**
     * 添加用户
     * @param record
     * @return
     */
    int insert(Master record);

    int insertSelective(Master record);

    Master selectByPrimaryKey(String id);

    /**
     * 有选择更新用户
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Master record);

    /**
     * 更新用户
     * @param record
     * @return
     */
    int updateByPrimaryKey(Master record);

    /**
     * 更改是否有效状态
     * @param master
     * @return
     */
    int updateDeleteFlag(Master master);

    /**
     * 查看用户列表
     * @return
     */
    List<Master> queryMasterList();

    /**
     * 查看组里的用户信息
     * @param groupId
     * @return
     */
    List<Master> queryUserInfoFromGroup(String groupId);
}