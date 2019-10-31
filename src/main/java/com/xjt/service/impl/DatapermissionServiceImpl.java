package com.xjt.service.impl;

import com.xjt.business.DatapermissionBusinessService;
import com.xjt.dao.master.*;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.DatapermissionReqDto;
import com.xjt.entity.*;
import com.xjt.enums.ResultCode;
import com.xjt.service.DatapermissionService;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class DatapermissionServiceImpl implements DatapermissionService {

    @Resource
    private DatapermissionBusinessService businessService;
    @Resource
    private DatapermissionDao datapermissionDao;
    @Resource
    private DictbrandDao dictbrandDao;

    @Resource
    private CustomerDao customerDao;
    @Resource
    private SupplyDao supplyDao;
    @Resource
    private WarehouseDao warehouseDao;

    private Logger logger = LoggerFactory.getLogger(DatapermissionServiceImpl.class);

    /**
     * 管理组添加数据权限
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto addDataPermissionForGroup(DatapermissionReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String groupId = reqDto.getGroupmanagerId();
        if(STRUtils.isEmpty(groupId)){
            baseResDto.setResultMessage("groupmanagerId is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            Datapermission datapermission = new Datapermission();
            BeanUtils.copyProperties(reqDto,datapermission);
            businessService.addDataPermissionForGroup(datapermission);
        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("It has an exception to addDataPermissionForGroup ");
            logger.error("管理组添加数据权限异常",e);
        }
        return baseResDto;
    }

    /**
     * 更改管理组数据权限
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto updatePermissionForGroup(DatapermissionReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String groupId = reqDto.getGroupmanagerId();
        if(STRUtils.isEmpty(groupId)){
            baseResDto.setResultMessage("groupmanagerId is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            Datapermission datapermission = new Datapermission();
            BeanUtils.copyProperties(reqDto,datapermission);
            businessService.updatePermissionForGroup(datapermission);
        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("It has an exception to addDataPermissionForGroup ");
            logger.error("管理组添加数据权限异常",e);
        }
        return baseResDto;
    }

    /**
     * 查看管理组品牌权限
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto queryBrandPermission(DatapermissionReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(!checkParam(reqDto,baseResDto)){
            return baseResDto;
        }
        try{
            reqDto.setColName("dictbrand_id");
            String brands = datapermissionDao.queryDiffPermission(reqDto);
            if(STRUtils.isEmpty(brands)){
                baseResDto.setResultMessage("管理组没有对应的品牌");
                baseResDto.setResultCode(ResultCode.RESULT_CODE_NODATA.getCode());
                return baseResDto;
            }
            List<String> brandIds = Arrays.asList(brands.split(","));
            List<Dictbrand> dictbrands = dictbrandDao.queryBrandById(brandIds);

            baseResDto.setData(dictbrands);
        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("查看管理组品牌权限异常");
            logger.error("查看管理组品牌权限异常",e);
        }
        return baseResDto;
    }

    /**
     * 查看管理组渠道权限
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto queryCustomerPermission(DatapermissionReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(!checkParam(reqDto,baseResDto)){
            return baseResDto;
        }
        try{
            reqDto.setColName("customer_id");
            String brands = datapermissionDao.queryDiffPermission(reqDto);
            if(STRUtils.isEmpty(brands)){
                baseResDto.setResultMessage("管理组没有对应的渠道");
                baseResDto.setResultCode(ResultCode.RESULT_CODE_NODATA.getCode());
                return baseResDto;
            }
            List<String> customerIds = Arrays.asList(brands.split(","));
            List<Customer> customers = customerDao.queryCustomerByIds(customerIds);
            baseResDto.setData(customerIds);
        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("查看管理组渠道权限异常");
            logger.error("查看管理组渠道权限异常",e);
        }
        return baseResDto;
    }


    /**
     * 查看管理组仓库权限
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto queryWareHousePermission(DatapermissionReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(!checkParam(reqDto,baseResDto)){
            return baseResDto;
        }
        try{
            reqDto.setColName("warehouse_id");
            String house = datapermissionDao.queryDiffPermission(reqDto);
            if(STRUtils.isEmpty(house)){
                baseResDto.setResultMessage("没有对应的仓库");
                baseResDto.setResultCode(ResultCode.RESULT_CODE_NODATA.getCode());
                return baseResDto;
            }
            List<String> houseIds = Arrays.asList(house.split(","));
            List<Warehouse> warehouses = warehouseDao.queryHouseList(houseIds);
            baseResDto.setData(warehouses);
        }catch (Exception e){
            baseResDto.setResultMessage("查看管理组仓库权限异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("查看管理组仓库权限异常",e);
        }
        return baseResDto;
    }

    /**
     * 查看管理组供货商权限
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto querySupplyPermission(DatapermissionReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(!checkParam(reqDto,baseResDto)){
            return baseResDto;
        }
        try{
            reqDto.setColName("supply_id");
            String supply = datapermissionDao.queryDiffPermission(reqDto);
            if(STRUtils.isEmpty(supply)){
                baseResDto.setResultCode(ResultCode.RESULT_CODE_NODATA.getCode());
                baseResDto.setResultMessage("没有对应的供货商");
                return baseResDto;
            }
            List<String> supplyIds = Arrays.asList(supply.split(","));
            List<Supply> supplies = supplyDao.querySupplyList(supplyIds);
            baseResDto.setData(supplies);


        }catch (Exception e){
            baseResDto.setResultMessage("查看管理组供货商权限异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("查看管理组供货商权限异常",e);
        }
        return baseResDto;
    }

    /**
     * 参数校验
     * @param reqDto
     * @return
     */
    public boolean checkParam(DatapermissionReqDto reqDto,BaseResDto resDto){
        String groupId = reqDto.getGroupmanagerId();
        if(STRUtils.isEmpty(groupId)){
            resDto.setResultMessage("groupId is null");
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return false;
        }
        return true;
    }
}
