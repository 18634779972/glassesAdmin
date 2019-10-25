package com.xjt.dao.master;

import com.xjt.dto.GroupmanagerReqDto;
import com.xjt.entity.Groupmanager;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GroupmanagerDao {
    int deleteByPrimaryKey(Long groupId);

    /**
     * 创建管理组
     * @param record
     * @return
     */
    int insert(Groupmanager record);

    int insertSelective(Groupmanager record);

    Groupmanager selectByPrimaryKey(Long groupId);

    int updateByPrimaryKeySelective(Groupmanager record);

    int updateByPrimaryKey(Groupmanager record);

    /**
     * 更改管理组有效值
     */
    int  updateDeleteFlag(GroupmanagerReqDto reqDto);

    /**
     * 查看管理组列表
     * @param reqDto
     * @return
     */
    List<Groupmanager> queryGroupList(GroupmanagerReqDto reqDto);
}