package com.xjt.business.impl;

import com.xjt.business.CommonBusinessService;
import com.xjt.dao.master.CommonDao;
import com.xjt.dao.other.CommonSqlDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CommonBusinessServiceImpl implements CommonBusinessService {
    @Resource
    private CommonDao commonDao;
    @Resource
    private CommonSqlDao commonSqlDao;
    private Logger logger = LoggerFactory.getLogger(CommonBusinessServiceImpl.class);

    /**
     * 批量添加数据
     * @param tableName
     * @param values
     * @param db
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertBatch(String tableName, List<String> values,Integer db) {
        int num =0;
        if(db==1){
            num = commonDao.insertBatch(tableName,values);
            if(num != values.size()){
                throw new RuntimeException("批量添加数据异常"); }
        }else{
            num = commonSqlDao.insertBatch(tableName,values);
            if(num != 1){
                throw new RuntimeException("批量添加数据异常"); }
        }


        logger.info("添加纪录"+num);


    }

    /**
     * 批量删除数据
     * @param tableName
     * @param colName
     * @param values
     * @param db
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteBatch(String tableName, String colName, List<String> values,Integer db) {
        int num =0;
        if(db==1){
            num = commonDao.deleteBatch(tableName,colName,values);
        }else{
            num = commonSqlDao.deleteBatch(tableName,colName,values);
        }
        if(values!=null&&num != values.size()){
            throw new RuntimeException("批量删除数据异常");

        }
    }
}
