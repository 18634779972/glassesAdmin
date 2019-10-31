package com.xjt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.regexp.internal.RE;
import com.xjt.business.WarehouseBusinessService;
import com.xjt.dao.master.WarehouseDao;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.WarehouseReqDto;
import com.xjt.entity.Warehouse;
import com.xjt.enums.ResultCode;
import com.xjt.service.WarehouseService;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.print.DocFlavor;
import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Resource
    private WarehouseBusinessService businessService;
    @Resource
    private WarehouseDao warehouseDao;

    private Logger logger = LoggerFactory.getLogger(WarehouseServiceImpl.class);

    /**
     * 增加仓库
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto insertWareHouse(WarehouseReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(!checkParams(reqDto,baseResDto)){
            return baseResDto;
        }

        try{
            Warehouse warehouse = new Warehouse();
            BeanUtils.copyProperties(reqDto,warehouse);
            warehouse.setWarehouseNo(STRUtils.createUUID());
            businessService.insertWarehouse(warehouse);

        }catch (Exception e){
            baseResDto.setResultMessage("增加仓库异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("增加仓库异常",e);
        }

        return baseResDto;
    }

    /**
     * 查看仓库列表
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto queryWarehouseList(WarehouseReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        try{

            Integer pageNo = reqDto.getPageNo();
            Integer pageSize = reqDto.getPageSize();
            if(pageNo!=null&&pageSize!=null){
                PageHelper.startPage(pageNo,pageSize);
                List<Warehouse> warehouses = warehouseDao.queryWarehouseList();
                PageInfo<Warehouse> pageInfo = new PageInfo<>(warehouses);
                baseResDto.setData(pageInfo);
            }else{
                List<Warehouse> warehouses = warehouseDao.queryWarehouseList();
                baseResDto.setData(warehouses);
            }

        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("查看仓库列表异常");
            logger.error("查看仓库列表异常",e);
        }
        return baseResDto;
    }

    /**
     * 查看仓库详情
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto queryHouseInfo(WarehouseReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String wareNo = reqDto.getWarehouseNo();
        if(STRUtils.isEmpty(wareNo)){
            baseResDto.setResultMessage("warehouseNo is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            Warehouse warehouse = warehouseDao.selectByPrimaryKey(wareNo);
            baseResDto.setData(warehouse);
        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("查看仓库详情异常");
            logger.error("查看仓库详情异常",e);
        }
        return baseResDto;
    }

    private boolean checkParams(WarehouseReqDto reqDto,BaseResDto resDto){
        boolean flag = true;
        if(STRUtils.isEmpty(reqDto.getWarehouseNa())){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("仓库名称不能为空");
            flag = false;
        }
        if(STRUtils.isEmpty(reqDto.getAddress())){
            resDto.setResultMessage("仓库地址不能为空");
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            flag = false;
        }
        if(STRUtils.isEmpty(reqDto.getZipcode())){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("仓库电话不能为空");
            flag = false;
        }
        if(STRUtils.isEmpty(reqDto.getKeyman())){
            resDto.setResultMessage("仓库负责人不能为空");
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            flag = false;
        }
        if(reqDto.getTag()==null){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("tag is null");
            flag = false;
        }
        return flag;
    }
}
