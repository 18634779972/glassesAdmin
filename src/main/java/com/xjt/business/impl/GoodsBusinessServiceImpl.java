package com.xjt.business.impl;

import com.xjt.business.GoodsBusinessService;
import com.xjt.dao.master.GoodsDao;
import com.xjt.dao.master.GoodspicturemgtDao;
import com.xjt.entity.Goods;
import com.xjt.entity.Goodspicturemgt;
import com.xjt.utils.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoodsBusinessServiceImpl implements GoodsBusinessService {


    @Resource
    private GoodsDao goodsDao;
    @Resource
    private GoodspicturemgtDao dao;

    /**
     * 增加货品信息
     * @param goods
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertGoods(Goods goods, List<Goodspicturemgt> goodspicturemgts) {
        int num = goodsDao.insert(goods);
        if(num !=1){
            throw new RuntimeException("增加货品信息异常");
        }
        if(goodspicturemgts!=null&&goodspicturemgts.size()>0){
            int num2 = dao.insertGoodsPics(goodspicturemgts);
            if(num2 != goodspicturemgts.size()){
                List<String> paths = goodspicturemgts.stream().map(Goodspicturemgt::getFilepath).collect(Collectors.toList());
                for(String path:paths){
                    FileUtil.deleteFile(path);
                }
                throw new RuntimeException("批量添加货品文件信息异常");
            }
        }


    }
}
