package com.xjt.dao.master;

import com.xjt.dto.GoodsReqDto;
import com.xjt.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsDao {
    int deleteByPrimaryKey(String goodsid);

    /**
     * 增加货品
     * @param record
     * @return
     */
    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(String goodsid);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    /**
     * 查看货品列表信息
     * @return
     */
    List<Goods> queryGoodsList(GoodsReqDto reqDto);
}