package com.xjt.service.impl;

import com.xjt.business.DictfreightcorpBusinessSer;
import com.xjt.dao.master.DictfreightcorpDao;
import com.xjt.dao.other.DictfreightcorpSqlDao;
import com.xjt.dto.BaseResDto;
import com.xjt.entity.Dictfreightcorp;
import com.xjt.enums.ResultCode;
import com.xjt.service.DictfreightcorpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class DictfreightcorpServiceImpl implements DictfreightcorpService {
    @Resource
    private DictfreightcorpDao dictfreightcorpDao;
    @Resource
    private DictfreightcorpSqlDao dictfreightcorpSqlDao;
    @Resource
    private DictfreightcorpBusinessSer businessSer;

    private Logger logger = LoggerFactory.getLogger(DictfreightcorpServiceImpl.class);

    /**
     * 批量添加公司
     * @param dictfreightcorps
     * @param db
     * @return
     */
    @Override
    public BaseResDto insertBatch(List<Dictfreightcorp> dictfreightcorps, Integer db) {
        BaseResDto baseResDto = new BaseResDto();
        if(dictfreightcorps==null||dictfreightcorps.size()==0){
            baseResDto.setResultMessage("添加数据为空");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            businessSer.insertBatch(dictfreightcorps,db);
        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("批量添加数据异常");
            logger.error("批量添加数据异常",e);

        }
        return baseResDto;
    }

    /**
     * 批量删除数据
     * @param dictfreightcorps
     * @param db
     * @return
     */
    @Override
    public BaseResDto deleteBatch(List<Dictfreightcorp> dictfreightcorps, Integer db) {
        BaseResDto baseResDto = new BaseResDto();
        if(dictfreightcorps==null||dictfreightcorps.size()==0){
            baseResDto.setResultMessage("添加数据为空");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            businessSer.deleteBatch(dictfreightcorps,db);
        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("批量删除数据异常");
            logger.error("批量删除数据异常",e);

        }
        return baseResDto;
    }

    /**
     * 查看数据
     * @param dictfreightcorp
     * @return
     */
    @Override
    public BaseResDto queryAllCorp(Dictfreightcorp dictfreightcorp) {
        BaseResDto baseResDto = new BaseResDto();
        Integer db = dictfreightcorp.getDb();
        try{
            List<Dictfreightcorp> dictfreightcorps = new ArrayList<>();
            if(db==1){
                dictfreightcorps = dictfreightcorpDao.queryAllCorps(dictfreightcorp);
            }else{
                dictfreightcorps = dictfreightcorpSqlDao.queryAllCorps(dictfreightcorp);
            }
            if(dictfreightcorps.size()==0){
                baseResDto.setResultMessage("no data");
                baseResDto.setResultCode(ResultCode.RESULT_CODE_NODATA.getCode());
                return baseResDto;
            }
            baseResDto.setData(dictfreightcorps);

        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("查看数据异常");
            logger.error("查看数据异常",e);
        }
        return baseResDto;
    }
}
