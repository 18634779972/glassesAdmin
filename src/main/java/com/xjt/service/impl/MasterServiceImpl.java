package com.xjt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xjt.business.MasterBusinessService;
import com.xjt.dao.master.MasterDao;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.MasterReqDto;
import com.xjt.entity.Master;
import com.xjt.enums.ResultCode;
import com.xjt.service.MasterService;
import com.xjt.utils.GeneratePassword;
import com.xjt.utils.MD5Util;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MasterServiceImpl implements MasterService {

    private Logger logger = LoggerFactory.getLogger(MasterServiceImpl.class);
    @Resource
    private MasterBusinessService businessService;

    @Resource
    private MasterDao masterDao;

    /**
     * 添加用户
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto insertMaster(MasterReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String name = reqDto.getName();
        String password = reqDto.getPassword();
        String dept = reqDto.getDept();
        if(STRUtils.isEmpty(name)||STRUtils.isEmpty(password)||STRUtils.isEmpty(dept)){
            baseResDto.setResultMessage("部分参数为空");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            String birth = reqDto.getBirth();
            if(!STRUtils.isEmpty(birth)){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date birthday = sdf.parse(birth);
                reqDto.setBirthday(birthday);
            }
            businessService.insertMaster(reqDto);
        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("添加用户发生异常");
            logger.error("添加用户发生异常",e);

        }
        return baseResDto;
    }

    /**
     *   更改deleteFlag 状态值
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto deleteMaster(MasterReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String id = reqDto.getId();
        if(STRUtils.isEmpty(id)){
            baseResDto.setResultMessage(" id is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            Master master = new Master();
            master.setId(id);
            master.setDeleteFlag(reqDto.getDeleteFlag());
            int num =masterDao.updateDeleteFlag(master);
            if(num != 1){
                baseResDto.setResultMessage("It has an exception to delete the master");
                baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            }
        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage(" It has an exception to delete the master");
            logger.error("删除用户异常",e);
        }

        return baseResDto;
    }

    /**
     * 更改用户信息
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto updateMaster(MasterReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String id = reqDto.getId();
        if(STRUtils.isEmpty(id)){
            baseResDto.setResultMessage(" id is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            Master master = new Master();
            BeanUtils.copyProperties(reqDto,master);
            int num =masterDao.updateByPrimaryKeySelective(master);
            if(num != 1){
                baseResDto.setResultMessage("It has an exception to update the master");
                baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            }
        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage(" It has an exception to update the master");
            logger.error("更新用户异常",e);
        }
        return baseResDto;
    }

    /**
     * 分页查看用户信息
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto queryMasterList(MasterReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        Integer pageNo = reqDto.getPageNo();
        Integer pageSize = reqDto.getPageSize();
        if(pageNo==null||pageSize==null){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("pageNo or pageSize is null");
            return baseResDto;
        }
        try{
            PageHelper.startPage(pageNo,pageSize);
            List<Master> masters = masterDao.queryMasterList();
            PageInfo<Master> pageInfo = new PageInfo<>(masters);

            baseResDto.setData(pageInfo);
        }catch (Exception e){
            baseResDto.setResultMessage("It has an exception to query master");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("分页查看用户信息异常",e);
        }

        return baseResDto;
    }

    /**
     * 根据id查看用户详细信息
     * @param id
     * @return
     */
    @Override
    public BaseResDto queryMasterInfo(String id) {
        BaseResDto baseResDto = new BaseResDto();
        if(id==null){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("id is null");
            return baseResDto;
        }
        try{
            Master master = masterDao.selectByPrimaryKey(id);
            baseResDto.setData(master);

        }catch (Exception e){
            baseResDto.setResultMessage("It has an exception to query the master");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("根据id查看用户信息异常",e);
        }
        return baseResDto;
    }

    /**
     * 处理用户登录
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto userLoginResolve(MasterReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String userName = reqDto.getName();
        String password = reqDto.getPassword();
        if(STRUtils.isEmpty(userName)){
            baseResDto.setResultMessage("用户名不能为空");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        if(STRUtils.isEmpty(password)){
            baseResDto.setResultMessage("密码不能为空");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{

            Master master = masterDao.selectByNP(userName, MD5Util.stringTO_MD5(password));
            if(master==null){
                baseResDto.setResultMessage("用户名或密码错误");
                baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
                logger.info("用户名或密码错误");
                return baseResDto;
            }
            baseResDto.setData(master);
        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("用户登录异常");
            logger.error("用户登录异常");
        }
        return baseResDto;
    }
}
