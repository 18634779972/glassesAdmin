package com.xjt.dao.master;

import com.xjt.entity.Warehouse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WarehouseDao {
    int deleteByPrimaryKey(String warehouseNo);

    /**
     * 增加仓库
     * @param record
     * @return
     */
    int insert(Warehouse record);

    int insertSelective(Warehouse record);

    /**
     * 查看仓库详细信息
     * @param warehouseNo
     * @return
     */
    Warehouse selectByPrimaryKey(String warehouseNo);

    /**
     * 更新仓库信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Warehouse record);

    int updateByPrimaryKey(Warehouse record);

    /**
     * 根据仓库id查看仓库信息
     * @param ids
     * @return
     */
    List<Warehouse> queryHouseList(@Param("ids") List<String> ids);

    /**
     * 查看仓库列表
     * @return
     */
    List<Warehouse> queryWarehouseList();

}