package com.xjt.dao.master;

import com.xjt.dto.DatapermissionReqDto;
import com.xjt.entity.Datapermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DatapermissionDao {
    int deleteByPrimaryKey(String id);

    /**
     * 管理组添加数据权限
     * @param record
     * @return
     */
    int insert(Datapermission record);

    int insertSelective(Datapermission record);

    Datapermission selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Datapermission record);

    int updateByPrimaryKey(Datapermission record);

    /**
     * 根据不同字段名查看
     * @param reqDto
     * @return
     */
    String queryDiffPermission(DatapermissionReqDto reqDto);

    Datapermission queryMasterPermission(@Param("masterId") String masterId);


}