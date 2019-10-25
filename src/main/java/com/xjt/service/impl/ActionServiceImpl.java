package com.xjt.service.impl;

import com.xjt.business.ActionBusinessService;
import com.xjt.dao.master.ActionDao;
import com.xjt.dto.ActionReqDto;
import com.xjt.dto.BaseResDto;
import com.xjt.entity.Action;
import com.xjt.enums.ResultCode;
import com.xjt.service.ActionService;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class ActionServiceImpl implements ActionService {

    @Resource
    private ActionBusinessService businessService;
    @Resource
    private ActionDao actionDao;

    private Logger logger = LoggerFactory.getLogger(ActionServiceImpl.class);


    /**
     * 添加权限
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto insertAction(ActionReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String actionName = reqDto.getActionName();
        if(STRUtils.isEmpty(actionName)){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("actionName is null");
            return baseResDto;
        }
        try{
            Action action = new Action();
            BeanUtils.copyProperties(reqDto,action);
            action.setActionid(STRUtils.createUUID());
            action.setDeleteFlag(1L);
            businessService.insertAction(action);

        }catch (Exception e){
            baseResDto.setResultMessage("It has an exception to insertAction");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("添加权限异常",e);
        }
        return baseResDto;
    }

    /**
     * 删除单个权限
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto deleteAction(ActionReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String actionId = reqDto.getActionid();
        if(actionId==null){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("actionId is null");
            return baseResDto;
        }
        try{
            Action action = new Action();
            BeanUtils.copyProperties(reqDto,action);
            businessService.deleteAction(action);
        }catch (Exception e){
            baseResDto.setResultMessage("It has an exception to delete the action");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("删除单个权限异常",e);
        }
        return baseResDto;
    }

    /**
     * 更新权限信息
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto updateAction(ActionReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String actionId = reqDto.getActionid();
        if(actionId==null){
            baseResDto.setResultMessage("actionId is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            Action action = new Action();
            BeanUtils.copyProperties(reqDto,action);
            actionDao.updateByPrimaryKeySelective(action);
            }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("It has an exception to update the action");
            logger.error("更新权限异常",e);
        }
        return baseResDto;
    }

    /**
     * 查看分栏下的权限
     * @param cloumnId
     * @return
     */
    @Override
    public BaseResDto queryActionsByCloumn(String cloumnId) {
        BaseResDto baseResDto = new BaseResDto();
        if(STRUtils.isEmpty(cloumnId)){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("cloumnId is null");
            return baseResDto;
        }
        try{
            List<Action> actions = actionDao.queryActionsByCloumn(cloumnId);
            if(actions==null||actions.size()==0){
                baseResDto.setResultCode(ResultCode.RESULT_CODE_NODATA.getCode());
                baseResDto.setResultMessage("no data");
                return baseResDto;
            }
            baseResDto.setData(actions);

        }catch (Exception e){
            baseResDto.setResultMessage("查看分栏下的权限异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("查看分栏下的权限异常",e);
        }
        return baseResDto;
    }

}
