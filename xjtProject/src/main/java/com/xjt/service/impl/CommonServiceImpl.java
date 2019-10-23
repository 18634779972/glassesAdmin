package com.xjt.service.impl;

import com.xjt.business.CommonBusinessService;
import com.xjt.dao.master.CommonDao;
import com.xjt.dao.other.CommonSqlDao;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.CommonReqDto;
import com.xjt.entity.CommonData;
import com.xjt.enums.ResultCode;
import com.xjt.service.CommonService;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommonServiceImpl implements CommonService {

    @Resource
    private CommonBusinessService businessService;
    @Resource
    private CommonDao commonDao;
    @Resource
    private CommonSqlDao commonSqlDao;

    private Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);

    /**
     * 批量添加数据
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto insertDatasBatch(CommonReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String tableName = reqDto.getTableName();
        List<String> values = reqDto.getValues();
        Integer db = reqDto.getDb();
        if(STRUtils.isEmpty(tableName)||values==null||db==null){
            baseResDto.setResultMessage("参数错误");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            businessService.insertBatch(tableName,values,db);
            }catch (Exception e){
            baseResDto.setResultMessage("批量添加数据异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("批量添加数据异常",e);

        }
        return baseResDto;
    }

    /**
     * 批量删除数据
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto deleteDatasBatch(CommonReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String tableName = reqDto.getTableName();
        List<String> values = reqDto.getValues();
        Integer db = reqDto.getDb();
        String colName = reqDto.getColName();
        if(STRUtils.isEmpty(tableName)||STRUtils.isEmpty(colName)||values==null||db==null){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("参数错误");
            return baseResDto;
        }
        try{
            businessService.deleteBatch(tableName,colName,values,db);
        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("批量删除数据异常");
            logger.error("批量删除数据异常",e);
        }
        return baseResDto;
    }

    /**
     * 查看数据
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto queryAllData(CommonReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        Integer db = reqDto.getDb();
        if(db==null){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("参数错误");
            return baseResDto;
        }
        try{
            List<CommonData> commonDatas = new ArrayList<>();

            if(db==1){
                commonDatas = commonDao.queryAllDatas(reqDto);
            }else{
                commonDatas = commonSqlDao.queryAllDatas(reqDto);
            }
            if(commonDatas.size()==0){
                baseResDto.setResultCode(ResultCode.RESULT_CODE_NODATA.getCode());
                baseResDto.setResultMessage("no data");
                return baseResDto;
            }
            baseResDto.setData(commonDatas);
        }catch (Exception e){
            baseResDto.setResultMessage("查看数据异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("查看数据异常",e);
        }
        return baseResDto;
    }
}
