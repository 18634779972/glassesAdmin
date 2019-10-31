package com.xjt.dao.master;

import com.xjt.entity.Busireport;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BusireportDao {
    int deleteByPrimaryKey(String brid);

    /**
     * 增加经营企业许可信息
     * @param record
     * @return
     */
    int insert(Busireport record);

    int insertSelective(Busireport record);

    Busireport selectByPrimaryKey(String brid);

    int updateByPrimaryKeySelective(Busireport record);

    int updateByPrimaryKey(Busireport record);

    /**
     * 根据许可证编号 企业名称 企业法人 查看企业经营许可证信息
     * @param busireport
     * @return
     */
    Busireport queryBusiInfo(Busireport busireport);

}