package com.xjt.dao.master;

import com.xjt.entity.Manureport;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManureportDao {
    int deleteByPrimaryKey(String mrid);

    /**
     * 增加企业生产许可信息
     * @param record
     * @return
     */
    int insert(Manureport record);

    int insertSelective(Manureport record);

    Manureport selectByPrimaryKey(String mrid);

    int updateByPrimaryKeySelective(Manureport record);

    int updateByPrimaryKey(Manureport record);

    /**
     * 根据许可证编号 企业名称 法人 查看许可证信息
     * @param manureport
     * @return
     */
    Manureport queryManureInfo(Manureport manureport);
}