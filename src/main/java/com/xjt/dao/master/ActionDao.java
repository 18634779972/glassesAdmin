package com.xjt.dao.master;

import com.xjt.entity.Action;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.method.P;

import java.util.List;

@Mapper
public interface ActionDao {
    int deleteByPrimaryKey(@Param("actionid") String actionid);

    int insert(Action record);

    int insertSelective(Action record);

    Action selectByPrimaryKey(@Param("actionid")String actionid);

    int updateByPrimaryKeySelective(Action record);

    int updateByPrimaryKey(Action record);

    /**
     * 查看组内对应的权限
     * @param groupId
     * @return
     */
    List<Action> queryActionByGroupId(@Param("groupId")String groupId);

    /**
     * 更改单个权限有效值
     * @param action
     * @return
     */
    int updateDeleteFlag(Action action);

    /**
     * 查看分栏下的权限
     */
    List<Action> queryActionsByCloumn(@Param("cloumnId") String cloumnId);
}