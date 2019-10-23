package com.xjt.business.impl;

import com.xjt.business.Dictcategory2BusinessService;
import com.xjt.dao.master.Dictcategory2Dao;
import com.xjt.dao.other.Dictcategory2SqlDao;
import com.xjt.entity.Dictcategory2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
public class Dictcategory2BusinessServiceImpl implements Dictcategory2BusinessService {

    @Resource
    private Dictcategory2Dao dictcategory2Dao;

    @Resource
    private Dictcategory2SqlDao dictcategory2SqlDao;


    /**
     * 批量添加二级分类
     * @param records
     * @param db
     */

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertBatch(List<Dictcategory2> records, Integer db) {
        int num = 0;
        if(db==1){
            num =dictcategory2Dao.insertBatch(records);
            if(num != records.size()){
                throw new RuntimeException("批量添加二级分类异常");
            }
        }else{
            num =dictcategory2SqlDao.insertBatch(records);
            if(num != 1){
                throw new RuntimeException("批量添加二级分类异常");
            }
        }

    }

    /**
     * 批量删除二级分类
     * @param records
     * @param db
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteBatch(List<Dictcategory2> records, Integer db) {

        int num =0;
        if(db==1){
           num = dictcategory2Dao.deleteBatch(records);
        }else{
            num = dictcategory2SqlDao.deleteBatch(records);
        }
        if(records!=null&&num != records.size()){
            throw new RuntimeException("批量删除二级分类异常");
        }
    }
}
