package com.xjt.dao.master;

import com.xjt.entity.Goodspicturemgt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodspicturemgtDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Goodspicturemgt record);

    int insertSelective(Goodspicturemgt record);

    Goodspicturemgt selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goodspicturemgt record);

    int updateByPrimaryKey(Goodspicturemgt record);

    /**
     * 批量添加货品图片信息
     */
    int insertGoodsPics(@Param("goodspicturemgts") List<Goodspicturemgt> goodspicturemgts);
    /**
     * 根据货品id查看货品文件信息
     */
    List<Goodspicturemgt> queryFilesInfo(@Param("goodsIds") List<String> goodsIds);

    List<Goodspicturemgt> queryByGoodId(@Param("goodsId") String goodsId);

}