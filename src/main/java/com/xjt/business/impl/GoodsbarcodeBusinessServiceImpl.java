package com.xjt.business.impl;

import com.xjt.business.GoodsbarcodeBusinessService;
import com.xjt.dao.master.GoodsbarcodeDao;
import com.xjt.entity.Goodsbarcode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class GoodsbarcodeBusinessServiceImpl implements GoodsbarcodeBusinessService {

    @Resource
    private GoodsbarcodeDao goodsbarcodeDao;

    /**
     * 添加货品信息
     * @param goodsbarcode
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertGoodsbarcode(Goodsbarcode goodsbarcode) {

        int num = goodsbarcodeDao.insert(goodsbarcode);
        if(num !=1){
            throw new RuntimeException("添加货品膜层,度数异常");
        }
    }
}
