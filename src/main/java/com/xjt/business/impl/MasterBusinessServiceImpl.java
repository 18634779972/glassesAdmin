package com.xjt.business.impl;

import com.xjt.business.MasterBusinessService;
import com.xjt.dao.master.MasterDao;
import com.xjt.dto.MasterReqDto;
import com.xjt.entity.Master;
import com.xjt.utils.GeneratePassword;
import com.xjt.utils.MD5Util;
import com.xjt.utils.STRUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class MasterBusinessServiceImpl implements MasterBusinessService {
    @Resource
    private MasterDao masterDao;

    /**
     * 事务 添加用户
     * @param reqDto
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertMaster(MasterReqDto reqDto) {
        Master master = new Master();
        BeanUtils.copyProperties(reqDto,master);
        String password = reqDto.getPassword();
        master.setId(STRUtils.createUUID());
        master.setPassword(MD5Util.stringTO_MD5(password));
        master.setCreatedate(new Date());
        master.setDeleteFlag(1L);
         int num = masterDao.insert(master);
         if(num !=1){
             throw new RuntimeException("添加用户发生异常");
         }
    }


}
