package com.xjt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.regexp.internal.RE;
import com.xjt.business.SupplyBusinessService;
import com.xjt.dao.master.SupplyDao;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.SupplyReqDto;
import com.xjt.entity.Supply;
import com.xjt.enums.ResultCode;
import com.xjt.service.SupplyService;
import com.xjt.utils.DateUtil;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SupplyServiceImpl implements SupplyService {

    private Logger logger = LoggerFactory.getLogger(SupplyServiceImpl.class);
    @Resource
    private SupplyBusinessService businessService;
    @Resource
    private SupplyDao supplyDao;

    /**
     * 添加供货商
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto insertSupply(SupplyReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        //参数校验
        if(!checkParams(reqDto,baseResDto)){
            return  baseResDto;
        }
        try{
            Supply supply = new Supply();
            BeanUtils.copyProperties(reqDto,supply);
            supply.setSupplyNo(STRUtils.createUUID());
            supply.setRegisterdate(DateUtil.getDate(reqDto.getRegisterDateStr()));
            supply.setExpirydate(DateUtil.getDate(reqDto.getExpriDateStr()));
            businessService.insertSupply(supply);

        }catch (Exception e){
            baseResDto.setResultMessage("It has an exception to insert supply");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("添加供货商异常",e);

        }
        return baseResDto;
    }

    /**
     * 查看供货商列表 可以分页查看
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto querySupplyList(SupplyReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        try{

            Integer pageNo = reqDto.getPageNo();
            Integer pageSize = reqDto.getPageSize();
            if(pageNo!=null&&pageSize!=null){
                PageHelper.startPage(pageNo,pageSize);
                List<Supply> supplies = supplyDao.querySupplyDataList();
                PageInfo<Supply> pageInfo = new PageInfo<>(supplies);
                baseResDto.setData(pageInfo);

            }else{
                List<Supply> supplies = supplyDao.querySupplyDataList();
                baseResDto.setData(supplies);
            }

            }catch (Exception e){
            baseResDto.setResultMessage("查看供货商列表异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("查看供货商列表异常",e);
        }
        return baseResDto;
    }

    /**
     * 查看供货商详情
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto querySupplyInfo(SupplyReqDto reqDto) {
        BaseResDto resDto = new BaseResDto();
        String supplyNo = reqDto.getSupplyNo();
        if(STRUtils.isEmpty(supplyNo)){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("supplyNo is null");
            return resDto;
        }
        try{
            Supply supply = supplyDao.selectByPrimaryKey(supplyNo);
            resDto.setData(supply);

        }catch (Exception e){
            resDto.setResultMessage("查看供货商详情异常");
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("查看供货商详情异常",e);
        }
        return resDto;
    }

    /**
     * 参数校验
     * @param reqDto
     * @param resDto
     * @return
     */
    public boolean checkParams(SupplyReqDto reqDto,BaseResDto resDto){
        boolean flag = true;
        if(STRUtils.isEmpty(reqDto.getSupplyNa())){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("供应商名称不能为空");
            flag = false;
        }
        if(STRUtils.isEmpty(reqDto.getRegisternumber())){
            resDto.setResultMessage("营业执照编号不能为空");
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            flag = false;
        }
        if(STRUtils.isEmpty(reqDto.getKeyman())){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("负责人不能为空");
            flag = false;
        }
        if(DateUtil.checkDateForm(reqDto.getRegisterDateStr())){
            resDto.setResultMessage("注册时间格式不正确");
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            flag = false;
        }
        if(DateUtil.checkDateForm(reqDto.getExpriDateStr())){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("到期时间格式不正确");
            flag = false;
        }
        return flag;
    }
}
