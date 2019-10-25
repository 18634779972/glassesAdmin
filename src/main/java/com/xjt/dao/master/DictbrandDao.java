package com.xjt.dao.master;

import com.xjt.entity.Dictbrand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface DictbrandDao {
    int deleteByPrimaryKey(String id);

    /**
     * 添加品牌
     * @param record
     * @return
     */
    int insert(Dictbrand record);

    int insertSelective(Dictbrand record);

    Dictbrand selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Dictbrand record);

    int updateByPrimaryKey(Dictbrand record);

    /**
     * 根据品牌id查看品牌信息
     * @param ids
     * @return
     */
    List<Dictbrand> queryBrandById(@Param("ids") List<String> ids);

    /**
     * 更新品牌有效值
     * @param dictbrand
     * @return
     */
    int updateDeleteFlag(Dictbrand dictbrand);

    /**
     * 查看品牌列表
     * @return
     */
    List<Dictbrand> queryBrandList();
}