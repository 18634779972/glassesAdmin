package com.xjt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xjt.business.CompanyBusinessService;
import com.xjt.dao.master.CompanyDao;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.CompanyReqDto;
import com.xjt.entity.Company;
import com.xjt.enums.ResultCode;
import com.xjt.service.CompanyService;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);

    @Resource
    private CompanyBusinessService businessService;
    @Resource
    private CompanyDao companyDao;

    /**
     * 增加公司
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto insertCompany(CompanyReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(!checkParams(reqDto,baseResDto)){
            return baseResDto;
        }
        try{
            Company company = new Company();
            BeanUtils.copyProperties(reqDto,company);
            company.setCompanyId(STRUtils.createUUID());
            businessService.insertCompany(company);

        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("添加公司异常");
            logger.error("添加公司异常",e);
        }

        return baseResDto;
    }

    /**
     * 查看公司列表 可分页查看
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto queryCompanyList(CompanyReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        try{

            Integer pageNo = reqDto.getPageNo();
            Integer pageSize = reqDto.getPageSize();
            if(pageNo!=null&&pageSize!=null){
                PageHelper.startPage(pageNo,pageSize);
                List<Company> companies = companyDao.queryCompanyList();
                PageInfo<Company> pageInfo = new PageInfo<>(companies);
                baseResDto.setData(pageInfo);
            }else{
                List<Company> companies = companyDao.queryCompanyList();
                baseResDto.setData(companies);
            }
        }catch (Exception e){
            baseResDto.setResultMessage("查看公司列表异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("查看公司列表异常",e);
        }
        return baseResDto;
    }

    /**
     * 查看公司详情
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto queryCompanyInfo(CompanyReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String companyNo = reqDto.getCompanyId();
        if(STRUtils.isEmpty(companyNo)){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("companyId is null");
            return baseResDto;
        }
        try{
            Company company = companyDao.selectByPrimaryKey(companyNo);
            baseResDto.setData(company);
        }catch (Exception e){
            baseResDto.setResultMessage("查看公司详情异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("查看公司详情异常",e);
        }
        return baseResDto;
    }

    /**
     * 参数校验
     * @param reqDto
     * @param resDto
     * @return
     */
    private boolean checkParams(CompanyReqDto reqDto,BaseResDto resDto){
        boolean flag = true;
        if(STRUtils.isEmpty(reqDto.getCompanyNa())){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("公司名称不能为空");
            flag = false;
        }
        if(STRUtils.isEmpty(reqDto.getKeyman())){
            resDto.setResultMessage("公司负责人不能为空");
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            flag = false;
        }
        if(STRUtils.isEmpty(reqDto.getAddress())){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("公司地址不能为空");
            flag = false;
        }
        if(STRUtils.isEmpty(reqDto.getTel())){
            resDto.setResultMessage("公司电话不能为空");
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            flag = false;
        }
        return flag;
    }
}
