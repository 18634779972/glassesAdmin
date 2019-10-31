package com.xjt.dao.master;

import com.xjt.entity.Goodsbarcode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GoodsbarcodeDao {
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加货品信息
     * @param record
     * @return
     */
    int insert(Goodsbarcode record);

    int insertSelective(Goodsbarcode record);

    Goodsbarcode selectByPrimaryKey(Integer id);

    Goodsbarcode selectByGoodsNo(@Param("goodsNo") String goodsNo);

    int updateByPrimaryKeySelective(Goodsbarcode record);

    int updateByPrimaryKey(Goodsbarcode record);
}