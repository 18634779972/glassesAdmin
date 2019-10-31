package com.xjt.business.impl;

import com.xjt.business.Dictcategory2BusinessService;
import com.xjt.dao.master.Dictcategory2Dao;
import com.xjt.dao.other.Dictcategory2SqlDao;
import com.xjt.dto.Dictcategory1ReqDto;
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
     * @param
     */

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertBatch(List<Dictcategory2> records) {
        int  num =dictcategory2Dao.insertCategory2(records);
            if(num != records.size()){
                throw new RuntimeException("批量添加二级分类异常");
            }


    }

    /**
     * 批量删除二级分类
     * @param reqDto
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteTwoCate(Dictcategory1ReqDto reqDto) {
        int num = dictcategory2Dao.deleteTwoCate(reqDto);
        if(num != reqDto.getTwoCateIds().size()){
            throw new RuntimeException("批量删除二级分类异常");
        }
    }


}
