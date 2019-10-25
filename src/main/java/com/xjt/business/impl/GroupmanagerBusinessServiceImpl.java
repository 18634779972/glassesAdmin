package com.xjt.business.impl;

import com.alibaba.fastjson.JSONObject;
import com.xjt.business.GroupmanagerBusinessService;
import com.xjt.dao.master.ActiongroupDao;
import com.xjt.dao.master.GroupmanagerDao;
import com.xjt.dao.master.MastergroupDao;
import com.xjt.dto.ActiongroupReqDto;
import com.xjt.dto.GroupmanagerReqDto;
import com.xjt.dto.MastergroupReqDto;
import com.xjt.entity.Groupmanager;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class GroupmanagerBusinessServiceImpl implements GroupmanagerBusinessService {

    @Resource
    private GroupmanagerDao groupmanagerDao;
    @Resource
    private MastergroupDao mastergroupDao;
    @Resource
    private ActiongroupDao actiongroupDao;

    private Logger logger = LoggerFactory.getLogger(GroupmanagerBusinessServiceImpl.class);

    /**
     * 添加管理组 事务
     * @param reqDto
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertGroupManager(GroupmanagerReqDto reqDto) {
        Groupmanager groupmanager = new Groupmanager();
        BeanUtils.copyProperties(reqDto,groupmanager);
        groupmanager.setCreatedate(new Date());
        groupmanager.setGroupId(STRUtils.createUUID());
        logger.info("对象信息"+JSONObject.toJSONString(groupmanager));
        int num = groupmanagerDao.insert(groupmanager);

        if(num != 1){
            throw new RuntimeException("添加管理组异常");
        }

    }

    /**
     * 删除管理组 包括组里成员 组对应的权限
     * @param reqDto
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteGroupManager(GroupmanagerReqDto reqDto) {
        String groupId = reqDto.getGroupId();
        Long deleteFlag = reqDto.getDeleteFlag();
        reqDto.setDeleteFlag(deleteFlag);
        //删除管理组
        int num = groupmanagerDao.updateDeleteFlag(reqDto);
        if(num != 1){
            throw new RuntimeException("删除管理组异常");
        }
       /* MastergroupReqDto reqDto1 = new MastergroupReqDto();
        reqDto1.setGroupId(groupId);
        reqDto1.setDeleteFlag(deleteFlag);
        mastergroupDao.updateDeleteFlagBatch(reqDto1);*/
        ActiongroupReqDto reqDto2 = new ActiongroupReqDto();
        reqDto2.setGroupId(groupId);
        reqDto2.setDeleteFlag(deleteFlag);
        actiongroupDao.deleteActionFromGroup(reqDto2);

    }
}
