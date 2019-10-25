package com.xjt.service.impl;

import com.xjt.business.ActiongroupBusinessService;
import com.xjt.dao.master.ActionDao;
import com.xjt.dto.ActiongroupReqDto;
import com.xjt.dto.BaseReqDto;
import com.xjt.dto.BaseResDto;
import com.xjt.entity.Action;
import com.xjt.entity.Actiongroup;
import com.xjt.enums.ResultCode;
import com.xjt.service.ActiongroupService;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ActiongroupServiceImpl implements ActiongroupService{

    private Logger logger = LoggerFactory.getLogger(ActiongroupServiceImpl.class);
    @Resource
    private ActiongroupBusinessService businessService;
    @Resource
    private ActionDao actionDao;

    /**
     * 为组批量添加权限
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto insertActionForGroupBatch(ActiongroupReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String groupId = reqDto.getGroupId();
        List<String> actionIds = reqDto.getActionIds();
        String masterId = reqDto.getMasterId();//创建者
        if(groupId==null||masterId==null){
            baseResDto.setResultMessage("groupId or masterId is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        if(actionIds==null||actionIds.size()==0){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("Select at least one actionId");
            return baseResDto;
        }
        try{
            List<Actiongroup> actiongroups = new ArrayList<>();
            Date nowDate = new Date();
            for(String antion:actionIds){
                Actiongroup actiongroup = new Actiongroup();
                actiongroup.setId(STRUtils.createUUID());
                actiongroup.setAction(antion);
                actiongroup.setCreatedate(nowDate);
                actiongroup.setDeleteFlag(1L);
                actiongroup.setGroupId(groupId);
                actiongroup.setMasterId(masterId);
                actiongroup.setMasterName(reqDto.getMasterName());
                actiongroups.add(actiongroup);
            }
            businessService.insertActionForGroupBatch(actiongroups);
        }catch (Exception e){
            baseResDto.setResultMessage("It has an exception to insert action ");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("为组添加权限异常",e);
        }
        return baseResDto;
    }

    /**
     * 查看组内对应的权限
     * @param groupId
     * @return
     */
    @Override
    public BaseResDto queryActionsByGroupId(String groupId) {
        BaseResDto baseResDto = new BaseResDto();
        if(groupId==null){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("groupId is null");
            return baseResDto;
        }
        try{
            List<Action> actions = actionDao.queryActionByGroupId(groupId);
            baseResDto.setData(actions);
        }catch (Exception e){
            baseResDto.setResultMessage("It has an exception to query actions by groupId");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("查看组内对应的权限异常",e);
        }
        return baseResDto;
    }

    /**
     * 删除组内对应的权限（批量）
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto deleteActionFromGroup(ActiongroupReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String groupId = reqDto.getGroupId();
        List<String> actionIds = reqDto.getActionIds();
        if(groupId==null){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("groupId is null");
            return baseResDto;
        }
        if(actionIds==null||actionIds.size()==0){
            baseResDto.setResultMessage("Select at least one actionId");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            businessService.deleteActionFromGroup(reqDto);
        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("It has an exception to delete action");
            logger.error("删除组内权限异常",e);
        }
        return baseResDto;
    }
}
