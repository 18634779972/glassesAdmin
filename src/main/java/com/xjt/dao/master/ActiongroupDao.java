package com.xjt.dao.master;

import com.xjt.dto.ActiongroupReqDto;
import com.xjt.entity.Actiongroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ActiongroupDao {
    int deleteByPrimaryKey(Long id);

    int insert(Actiongroup record);

    int insertSelective(Actiongroup record);

    Actiongroup selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Actiongroup record);

    int updateByPrimaryKey(Actiongroup record);

    /**
     * 为组批量添加权限
     * @return
     */
    int insertActionForGroupBatch(@Param("actiongroups") List<Actiongroup> actiongroups);

    /**
     * 删除组内对应的权限
     * @param reqDto
     * @return
     */
    int deleteActionFromGroup(ActiongroupReqDto reqDto);

}