package com.xjt.service.impl;

import com.xjt.business.Dictcategory2BusinessService;
import com.xjt.dao.master.Dictcategory2Dao;
import com.xjt.dao.other.Dictcategory2SqlDao;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.Dictcategory1ReqDto;
import com.xjt.entity.Dictcategory2;
import com.xjt.enums.ResultCode;
import com.xjt.service.Dictcategory2Service;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class Dictcategory2ServiceImpl implements Dictcategory2Service {
    @Resource
    private Dictcategory2Dao dictcategory2Dao;
    @Resource
    private Dictcategory2SqlDao dictcategory2SqlDao;
    @Resource
    private Dictcategory2BusinessService businessService;
    Logger logger = LoggerFactory.getLogger(Dictcategory2ServiceImpl.class);

    /**
     * 一级分类下批量添加二级分类
     * @param
     * @param
     * @return
     */
    @Override
    public BaseResDto insertBatch(Dictcategory1ReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        List<String> cateNames = reqDto.getCategory2name();
        String parentCateId = reqDto.getCategoryid();
        if(cateNames==null||cateNames.size()==0){
            baseResDto.setResultMessage("添加数据为空");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        if(STRUtils.isEmpty(parentCateId)){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("一级分类id is null");
            return baseResDto;
        }
        try{
            List<Dictcategory2> list = new ArrayList<>();
            for(String name:cateNames){
                Dictcategory2 dictcategory2 = new Dictcategory2();
                dictcategory2.setParentcategory(parentCateId);
                dictcategory2.setCategory(name);
                dictcategory2.setCategoryid(STRUtils.createUUID());
                list.add(dictcategory2);
            }
            businessService.insertBatch(list);

        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("批量添加二级分类异常");
            logger.error("批量添加二级分类异常",e);
        }
        return baseResDto;
    }

    /**
     * 查看二级分类列表
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto queryTwoCateList(Dictcategory1ReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String parentCate = reqDto.getCategoryid();
        if(STRUtils.isEmpty(parentCate)){
            baseResDto.setResultMessage("categoryid is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            List<Dictcategory2> dictcategory2s = dictcategory2Dao.queryByParent(parentCate);
            if(dictcategory2s==null||dictcategory2s.size()==0){
                baseResDto.setResultMessage("no data");
                baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
                return baseResDto;
            }
            baseResDto.setData(dictcategory2s);

        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("查看二级分类列表异常");
            logger.error("查看二级分类列表异常",e);
        }
        return baseResDto;
    }

    /**
     * 删除一级分类下的二级分类
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto deleteTwoCate(Dictcategory1ReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        List<String> twoCates = reqDto.getTwoCateIds();
        if(twoCates==null||twoCates.size()==0){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("请选择要删除的二级分类");
            return baseResDto;
        }
        try{
            businessService.deleteTwoCate(reqDto);
            }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("删除二级分类异常");
            logger.error("删除二级分类异常",e);
        }
        return baseResDto;
    }


}
