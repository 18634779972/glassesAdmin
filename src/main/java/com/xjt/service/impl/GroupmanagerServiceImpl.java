package com.xjt.service.impl;

import com.xjt.business.GroupmanagerBusinessService;
import com.xjt.dao.master.GroupmanagerDao;
import com.xjt.dao.master.MastergroupDao;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.GroupmanagerReqDto;
import com.xjt.entity.Groupmanager;
import com.xjt.enums.ResultCode;
import com.xjt.service.GroupmanagerService;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GroupmanagerServiceImpl implements GroupmanagerService {

    @Resource
    private GroupmanagerBusinessService businessService;
    @Resource
    private GroupmanagerDao groupmanagerDao;
    @Resource
    private MastergroupDao mastergroupDao;

    private Logger logger = LoggerFactory.getLogger(GroupmanagerServiceImpl.class);

    /**
     * 添加管理组
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto insertGroupManager(GroupmanagerReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String groupName = reqDto.getGroupName();
        String  masterId = reqDto.getMasterId();

        if(STRUtils.isEmpty(groupName)||STRUtils.isEmpty(masterId)){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("参数数据不全");
            return baseResDto;
        }
        try{
            businessService.insertGroupManager(reqDto);
        }catch (Exception e){
            baseResDto.setResultMessage("It has an exception to insert groupManager");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("添加管理组异常",e);
        }
        return baseResDto;
    }

    /**
     * 删除管理组 包括管理组的成员有效信息 管理组的权限信息
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto deleteGroupManager(GroupmanagerReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String groupId = reqDto.getGroupId();
        if(groupId==null){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("groupId is null");
            return baseResDto;
        }
        try{
            int num = mastergroupDao.isHaveMaster(groupId);
            if(num>0){
                baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
                baseResDto.setResultMessage("该组内还有成员，不允许删除");
                return baseResDto;
            }
            businessService.deleteGroupManager(reqDto);
        }catch (Exception e){
            baseResDto.setResultMessage("It has an exception to delete the group");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("删除管理组及组里成员异常",e);
        }
        return baseResDto;
    }

    /**
     * 查看管理组列表
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto queryGroupList(GroupmanagerReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        try{
            List<Groupmanager> groupmanagers = groupmanagerDao.queryGroupList(reqDto);
            if(groupmanagers==null||groupmanagers.size()==0){
                baseResDto.setResultCode(ResultCode.RESULT_CODE_NODATA.getCode());
                baseResDto.setResultMessage("no data");
                return baseResDto;
            }
            baseResDto.setData(groupmanagers);

        }catch (Exception e){
            baseResDto.setResultMessage("It has an exception to query groupList");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("查看管理组列表异常",e);
        }
        return baseResDto;
    }
}
