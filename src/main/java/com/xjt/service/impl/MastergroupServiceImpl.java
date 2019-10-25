package com.xjt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xjt.business.MastergroupBusinessService;
import com.xjt.dao.master.MasterDao;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.MastergroupReqDto;
import com.xjt.entity.Master;
import com.xjt.entity.Mastergroup;
import com.xjt.enums.ResultCode;
import com.xjt.service.MastergroupService;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MastergroupServiceImpl implements MastergroupService {

    @Resource
    private MastergroupBusinessService businessService;
    @Resource
    private MasterDao masterDao;

    private Logger logger = LoggerFactory.getLogger(MastergroupServiceImpl.class);

    /**
     * 批量添加用户入组
     * @param reqDto
     * @return
     */

    @Override
    public BaseResDto insertMasterToGroupBatch(MastergroupReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        List<String> userIds = reqDto.getUserIds();
        String groupId = reqDto.getGroupId();
        String menderId = reqDto.getMenderId();
        if(userIds==null||userIds.size()==0){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("Select at least one userId");
            return baseResDto;
        }
        if(groupId==null||menderId==null){
            baseResDto.setResultMessage("groupId or menderId is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            List<Mastergroup> mastergroups = new ArrayList<>();
            Date nowDate = new Date();
            for(String userId :userIds){
                Mastergroup mastergroup = new Mastergroup();
                mastergroup.setId(STRUtils.createUUID());
                mastergroup.setMasterId(userId);
                mastergroup.setGroupId(groupId);
                mastergroup.setCreatedate(nowDate);
                mastergroup.setName(reqDto.getName());
                mastergroup.setMenderId(menderId);
                mastergroup.setMenderName(reqDto.getMenderName());
                mastergroup.setDeleteFlag(1L);
                mastergroups.add(mastergroup);
            }
            businessService.insertMasterToGroupBatch(mastergroups);

        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("It has an exception to insert masters to group");
            logger.error("批量添加用户入组异常");
        }
        return baseResDto;
    }

    /**
     * 批量更改组里用户有效值 deleteFlag userIds groupId
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto updateDeleteFlagBatch(MastergroupReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String groupId = reqDto.getGroupId();
        List<String> userIds = reqDto.getUserIds();
        if(groupId==null){
            baseResDto.setResultMessage("groupId is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        if(userIds==null||userIds.size()==0){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("Select at least one userId ");
            return baseResDto;
        }
        try{
            businessService.updateDeleteFlagBatch(reqDto);
        }catch (Exception e){
            baseResDto.setResultMessage("更改组里用户有效值异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("更改组里用户有效值异常",e);
        }
        return baseResDto;
    }

    /**
     * 分页查看组里用户信息
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto queryMasterInfoOfGroup(MastergroupReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String groupId = reqDto.getGroupId();
        if(groupId==null){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("groupId is null");
            return baseResDto;
        }
        try{
            Integer pageNo = reqDto.getPageNo();
            Integer pageSize = reqDto.getPageSize();
            //需要分页查看
            if(pageNo !=null&&pageSize!=null){
                PageHelper.startPage(pageNo,pageSize);
                List<Master> masters = masterDao.queryUserInfoFromGroup(groupId);
                PageInfo<Master> pageInfo = new PageInfo<>(masters);
                baseResDto.setData(pageInfo);
                return baseResDto;
            }
            //不需要分页查看
            List<Master> masters = masterDao.queryUserInfoFromGroup(groupId);
            baseResDto.setData(masters);

        }catch (Exception e){
            baseResDto.setResultMessage("It has an exception to query user info from group");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("查看组里用户信息异常");
        }
        return baseResDto;
    }
}
