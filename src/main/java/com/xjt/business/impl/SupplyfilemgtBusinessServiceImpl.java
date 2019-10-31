package com.xjt.business.impl;

import com.xjt.business.SupplyfilemgtBusinessService;
import com.xjt.dao.master.SupplyfilemgtDao;
import com.xjt.entity.Supplyfilemgt;

import com.xjt.utils.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Service
public class SupplyfilemgtBusinessServiceImpl implements SupplyfilemgtBusinessService {

    @Resource
    private SupplyfilemgtDao supplyfilemgtDao;

    /**
     * 上传文件 添加文件信息 入库失败 删除已上传文件
     * @param supplyfilemgt
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertFileInfo(Supplyfilemgt supplyfilemgt) {
        int num = supplyfilemgtDao.insert(supplyfilemgt);
        if(num !=1){
            FileUtil.deleteFile(supplyfilemgt.getFilepath());
            throw new RuntimeException("添加上传文件信息异常");
        }

    }
}
