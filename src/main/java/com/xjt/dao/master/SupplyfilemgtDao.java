package com.xjt.dao.master;

import com.xjt.entity.Supplyfilemgt;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SupplyfilemgtDao {
    int deleteByPrimaryKey(Integer id);

    /**
     * 上传文件存储文件相关信息
     * @param record
     * @return
     */
    int insert(Supplyfilemgt record);

    int insertSelective(Supplyfilemgt record);

    Supplyfilemgt selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Supplyfilemgt record);

    int updateByPrimaryKey(Supplyfilemgt record);
}