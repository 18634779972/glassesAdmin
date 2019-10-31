package com.xjt.dao.master;

import com.xjt.entity.Supply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SupplyDao {
    int deleteByPrimaryKey(String supplyNo);

    /**
     * 增加供货商
     * @param record
     * @return
     */
    int insert(Supply record);

    int insertSelective(Supply record);

    Supply selectByPrimaryKey(String supplyNo);

    int updateByPrimaryKeySelective(Supply record);

    int updateByPrimaryKey(Supply record);

    /**
     * 根据id查看供货商列表
     * @param ids
     * @return
     */
    List<Supply> querySupplyList(@Param("ids") List<String> ids);

    /**
     * 查看供货商列表
     */
    List<Supply> querySupplyDataList();

}