package com.xjt.business.impl;

import com.xjt.business.DictfreightcorpBusinessSer;
import com.xjt.dao.master.DictfreightcorpDao;
import com.xjt.dao.other.DictfreightcorpSqlDao;
import com.xjt.entity.Dictfreightcorp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DictfreightcorpBusinessSerImpl implements DictfreightcorpBusinessSer {

    @Resource
    private DictfreightcorpDao dictfreightcorpDao;

    @Resource
    private DictfreightcorpSqlDao dictfreightcorpSqlDao;




    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertBatch(List<Dictfreightcorp> dictfreightcorps, Integer db) {
        int num = 0;
        if(db==1){
            num = dictfreightcorpDao.insertBatch(dictfreightcorps);
            if(num != dictfreightcorps.size()){
                throw new RuntimeException("批量添加公司异常");
            }
        }else{
            num = dictfreightcorpSqlDao.insertBatch(dictfreightcorps);
            if(num != 1){
                throw new RuntimeException("批量添加公司异常");
            }
        }

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteBatch(List<Dictfreightcorp> dictfreightcorps, Integer db) {
        int num =0;
        if(db==1){
            num = dictfreightcorpDao.deleteBatch(dictfreightcorps);
        }else{
            num = dictfreightcorpSqlDao.deleteBatch(dictfreightcorps);
        }
        if(dictfreightcorps!=null&&num != dictfreightcorps.size()){
            throw new RuntimeException("批量删除公司异常");
        }
    }
}
