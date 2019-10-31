package com.xjt.business.impl;

import com.xjt.business.GoodspicturemgtBusinessSer;
import com.xjt.dao.master.GoodspicturemgtDao;
import com.xjt.entity.Goodspicturemgt;
import com.xjt.utils.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoodspicturemgtBusinessSerImpl implements GoodspicturemgtBusinessSer {

    @Resource
    private GoodspicturemgtDao dao;

    /**
     * 批量添加货品图片信息 添加失败 删除已上传的图片
     * @param goodspicturemgts
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertGoodsPics(List<Goodspicturemgt> goodspicturemgts) {
        int num = dao.insertGoodsPics(goodspicturemgts);
        if(num != goodspicturemgts.size()){
            List<String> paths = goodspicturemgts.stream().map(Goodspicturemgt::getFilepath).collect(Collectors.toList());
            for(String path:paths){
                FileUtil.deleteFile(path);
            }
            throw new RuntimeException("批量添加货品文件信息异常");
        }
    }
}
