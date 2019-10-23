package com.xjt.service.impl;

import com.xjt.business.Dictcategory2BusinessService;
import com.xjt.dao.master.Dictcategory2Dao;
import com.xjt.dao.other.Dictcategory2SqlDao;
import com.xjt.dto.BaseResDto;
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
     * 批量添加分类
     * @param records
     * @param db
     * @return
     */
    @Override
    public BaseResDto insertBatch(List<Dictcategory2> records, Integer db) {
        BaseResDto baseResDto = new BaseResDto();
        if(records==null||records.size()==0){
            baseResDto.setResultMessage("添加数据为空");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
          businessService.insertBatch(records,db);
        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("批量添加二级分类异常");
            logger.error("批量添加二级分类异常",e);
        }
        return baseResDto;
    }

    /**
     * 批量删除分类
     * @param records
     * @param db
     * @return
     */
    @Override
    public BaseResDto deleteBatch(List<Dictcategory2> records, Integer db) {
        BaseResDto baseResDto = new BaseResDto();

        try{
            businessService.deleteBatch(records,db);
        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("批量删除二级分类异常");
            logger.error("批量删除二级分类异常",e);
        }
        return baseResDto;
    }

    /**
     * 根据分类名称查看二级分类 默认查看一级分类下的所有二级分类
     * @param dictcategory2
     * @return
     */
    @Override
    public BaseResDto queryAllCategory2(Dictcategory2 dictcategory2 ) {
        BaseResDto baseResDto = new BaseResDto();
        Integer db = dictcategory2.getDb();
        String parentCate = dictcategory2.getParentcategory();
        if(STRUtils.isEmpty(parentCate)){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("一级分类不能为空");
            return baseResDto;
        }
        try{
            List<Dictcategory2> dictcategory2s = new ArrayList<>();
            if(db==1){
                dictcategory2s = dictcategory2Dao.queryCategory2(dictcategory2);
            }else{
                dictcategory2s = dictcategory2SqlDao.queryCategory2(dictcategory2);
            }
            if(dictcategory2s.size()==0){
                baseResDto.setResultMessage(" no data");
                baseResDto.setResultCode(ResultCode.RESULT_CODE_NODATA.getCode());
                return baseResDto;
            }
            baseResDto.setData(dictcategory2s);

        }catch (Exception e){
            baseResDto.setResultMessage("查看二级分类异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("查看二级分类异常",e);
        }
        return baseResDto;
    }
}
