package com.xjt.dao.master;

import com.xjt.dto.MastergroupReqDto;
import com.xjt.entity.Master;
import com.xjt.entity.Mastergroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MastergroupDao {
    int deleteByPrimaryKey(Long id);

    int insert(Mastergroup record);

    int insertSelective(Mastergroup record);

    Mastergroup selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Mastergroup record);

    int updateByPrimaryKey(Mastergroup record);

    /**
     * 组里批量添加用户
     * @param mastergroups
     * @return
     */
    int insertMasterToGroupBatch(@Param("mastergroups") List<Mastergroup> mastergroups);

    /**
     * 批量更改组里成员有效值
     * @param reqDto
     * @return
     */
    int updateDeleteFlagBatch(MastergroupReqDto reqDto);

    /**
     * 判断组里是否还有成员
     * @param groupId
     * @return
     */
    int isHaveMaster(String groupId);



}