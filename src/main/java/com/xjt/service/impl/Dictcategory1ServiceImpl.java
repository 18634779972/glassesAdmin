package com.xjt.service.impl;

import com.xjt.business.Dictcategory1BusinessService;
import com.xjt.dao.master.Dictcategory1Dao;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.Dictcategory1ReqDto;
import com.xjt.entity.Dictcategory1;
import com.xjt.enums.ResultCode;
import com.xjt.service.Dictcategory1Service;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Dictcategory1ServiceImpl implements Dictcategory1Service {

    private Logger logger = LoggerFactory.getLogger(Dictcategory1ServiceImpl.class);
    @Resource
    private Dictcategory1BusinessService businessService;
    @Resource
    private Dictcategory1Dao dictcategory1Dao;

    /**
     * 添加一级分类信息
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto insertOneCategory(Dictcategory1ReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(!checkParams(reqDto,baseResDto)){
            return baseResDto;
        }
        try{
            Dictcategory1 dictcategory1 = new Dictcategory1();
            BeanUtils.copyProperties(reqDto,dictcategory1);
            dictcategory1.setCategoryid(STRUtils.createUUID());
            dictcategory1.setIsbatch(0);
            dictcategory1.setIsvalidity(0);
            dictcategory1.setSysdef(0);
            businessService.insertOneCategory(dictcategory1);

        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("添加一级分类信息异常");
            logger.error("添加一级分类信息异常",e);

        }
        return baseResDto;
    }

    /**
     * 查看一级分类信息列表
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto queryCateList(Dictcategory1ReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        try{
            List<Dictcategory1> list = dictcategory1Dao.queryCateList();
            if(list==null||list.size()==0){
                baseResDto.setResultCode(ResultCode.RESULT_CODE_NODATA.getCode());
                baseResDto.setResultMessage("no data");
                return baseResDto;
            }
            baseResDto.setData(list);

        }catch (Exception e){
            baseResDto.setResultMessage("查看一级分类信息异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("查看一级分类信息异常",e);
        }
        return baseResDto;
    }

    /**
     * 查看分类详情
     * @param categoryid
     * @return
     */
    @Override
    public BaseResDto queryOneCateInfo(String categoryid) {
        BaseResDto baseResDto = new BaseResDto();
        if(STRUtils.isEmpty(categoryid)){
            baseResDto.setResultMessage("categoryid is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;

        }
        try{
            Dictcategory1 dictcategory1 = dictcategory1Dao.selectByPrimaryKey(categoryid);
            baseResDto.setData(dictcategory1);

        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("查看分类详情异常");
            logger.error("查看分类详情异常",e);
        }
        return baseResDto;
    }


    private boolean checkParams(Dictcategory1ReqDto reqDto,BaseResDto resDto){
        boolean flag = true;
        if(STRUtils.isEmpty(reqDto.getCategory())){
            resDto.setResultMessage("分类名 category is null");
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            flag = false;
        }
        return flag;
    }
}
