package com.xjt.service.impl;

import com.xjt.business.DictbrandBusinessService;
import com.xjt.dao.master.DictbrandDao;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.DictbrandReqDto;
import com.xjt.entity.Dictbrand;
import com.xjt.enums.ResultCode;
import com.xjt.service.DictbrandService;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DictbrandServiceImpl implements DictbrandService {

    @Resource
    private DictbrandBusinessService businessService;
    @Resource
    private DictbrandDao dictbrandDao;
    private Logger logger = LoggerFactory.getLogger(DictbrandServiceImpl.class);

    /**
     * 添加品牌
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto addBrand(DictbrandReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String brandName = reqDto.getBrandName();
        if(STRUtils.isEmpty(brandName)){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("brandName is null");
            return baseResDto;
        }
        try{
            Dictbrand dictbrand = new Dictbrand();
            BeanUtils.copyProperties(reqDto,dictbrand);
            businessService.addBrand(dictbrand);

        }catch (Exception e){
            baseResDto.setResultMessage("添加品牌异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("添加品牌异常",e);

        }
        return baseResDto;
    }

    /**
     * 更新品牌有效值
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto updateDeleteFlag(DictbrandReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String brandId = reqDto.getId();
        Long flag = reqDto.getDeleteFlag();
        if(STRUtils.isEmpty(brandId)){
            baseResDto.setResultMessage("id is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        if(flag==null){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("deleteFlag is null");
            return baseResDto;
        }
        try{
            Dictbrand dictbrand = new Dictbrand();
            BeanUtils.copyProperties(reqDto,dictbrand);
            businessService.updateDeleteFlag(dictbrand);

        }catch (Exception e){
            baseResDto.setResultMessage("更新品牌有效值异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("更新品牌有效值异常",e);
        }
        return baseResDto;
    }

    /**
     * 查看品牌列表
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto queryBrandList(DictbrandReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        try{
            List<Dictbrand> dictbrands = dictbrandDao.queryBrandList();
            if(dictbrands==null||dictbrands.size()==0){
                baseResDto.setResultMessage("no data");
                baseResDto.setResultCode(ResultCode.RESULT_CODE_NODATA.getCode());
                return baseResDto;
            }
            baseResDto.setData(dictbrands);

        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("查看品牌列表异常");
            logger.error("查看品牌列表异常",e);
        }
        return baseResDto;
    }

    /**
     * 查看品牌信息
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto queryBrandInfo(DictbrandReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String id = reqDto.getId();
        if(STRUtils.isEmpty(id)){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("id is null");
            return baseResDto;
        }
        try{
            Dictbrand dictbrand = dictbrandDao.selectByPrimaryKey(id);
            baseResDto.setData(dictbrand);

        }catch (Exception e){
            baseResDto.setResultMessage("查看品牌信息异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("查看品牌信息异常",e);
        }
        return baseResDto;
    }
}
