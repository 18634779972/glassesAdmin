package com.xjt.business.impl;

import com.xjt.business.DatapermissionBusinessService;
import com.xjt.dao.master.DatapermissionDao;
import com.xjt.entity.Datapermission;
import com.xjt.utils.STRUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class DatapermissionBusinessServiceImpl implements DatapermissionBusinessService {

    @Resource
    private DatapermissionDao datapermissionDao;

    /**
     * 管理组添加数据权限
     * @param datapermission
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addDataPermissionForGroup(Datapermission datapermission) {
        datapermission.setId(STRUtils.createUUID());
        int num = datapermissionDao.insert(datapermission);
        if(num !=1){
            throw new RuntimeException("管理组添加数据权限异常");
        }
    }

    /**
     * 更改管理组数据权限
     * @param datapermission
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updatePermissionForGroup(Datapermission datapermission) {
        int num = datapermissionDao.updateByPrimaryKeySelective(datapermission);
        if(num != 1){
            throw new RuntimeException("更新管理组数据权限异常");
        }
    }
}
