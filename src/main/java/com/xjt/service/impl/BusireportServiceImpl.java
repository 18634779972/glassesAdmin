package com.xjt.service.impl;

import com.xjt.business.BusireportBusinessService;
import com.xjt.business.ManureportBusinessService;
import com.xjt.dao.master.BusireportDao;
import com.xjt.dao.master.ManureportDao;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.BusireportReqDto;
import com.xjt.entity.Busireport;
import com.xjt.entity.Manureport;
import com.xjt.enums.ResultCode;
import com.xjt.service.BusireportService;
import com.xjt.utils.DateUtil;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class BusireportServiceImpl implements BusireportService {

    private Logger logger = LoggerFactory.getLogger(BusireportServiceImpl.class);
    @Resource
    private BusireportBusinessService businessService;
    @Resource
    private ManureportBusinessService manureportBusinessService;
    @Resource
    private BusireportDao busireportDao;
    @Resource
    private ManureportDao manureportDao;

    /**
     * 添加经营企业许可信息
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto insertBusireport(BusireportReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        Integer reportType = reqDto.getReportType();
        if(reportType==null||(reportType!=1&&reportType!=2)){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("reportType is error");
            return baseResDto;
        }
        if(!checkParams(reqDto,baseResDto)){
            return  baseResDto;
        }
        try{
            String key = STRUtils.createUUID();
            String issuDate = reqDto.getIssuedateStr();//发证日期
            Date issu = DateUtil.getDate(issuDate);
            String expriDate = reqDto.getExpirydateStr();//有效日期
            Date expri = DateUtil.getDate(expriDate);
            if(reportType==1){
                Busireport busireport = new Busireport();
                BeanUtils.copyProperties(reqDto,baseResDto);
                busireport.setBrid(key);
                busireport.setIssuedate(issu);
                busireport.setExpirydate(expri);
                businessService.insertBusireport(busireport);
            }else{
                Manureport manureport = new Manureport();
                BeanUtils.copyProperties(reqDto,manureport);
                manureport.setMrid(key);
                manureport.setIssuedate(issu);
                manureport.setExpirydate(expri);
                manureportBusinessService.insertManureport(manureport);
            }

        }catch (Exception e){
            baseResDto.setResultMessage("添加经营企业许可信息异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("添加经营企业许可信息异常",e);
        }

        return baseResDto;
    }

    /**
     * 根据许可证编号，企业名称，法人 查看许可证信息
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto queryBusInfo(BusireportReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        Integer reportType = reqDto.getReportType();
        if(reportType==null||(reportType!=1&&reportType!=2)){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("reportType is error");
            return baseResDto;
        }
        if(STRUtils.isEmpty(reqDto.getLegal())&&STRUtils.isEmpty(reqDto.getPermitno())&&STRUtils.isEmpty(reqDto.getEnterprisename())){
            baseResDto.setResultMessage("需要查询参数");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            if(reportType==1){
                Busireport busireport = new Busireport();
                BeanUtils.copyProperties(reqDto,busireport);
                Busireport busireport1 =busireportDao.queryBusiInfo(busireport);
                baseResDto.setData(busireport1);
            }else{
                Manureport manureport = new Manureport();
                BeanUtils.copyProperties(reqDto,manureport);
                Manureport manureport1 = manureportDao.queryManureInfo(manureport);
                baseResDto.setData(manureport1);
            }

        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("查看企业经营许可证信息异常");
            logger.error("查看企业经营许可证信息异常",e);
        }
        return baseResDto;
    }

    /**
     * 更新企业经营许可证信息
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto updateBusInfo(BusireportReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        Integer reportType = reqDto.getReportType();
        if(reportType==null||(reportType!=1&&reportType!=2)){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("reportType is error");
            return baseResDto;
        }
        String brid = reqDto.getBrid();
        if(STRUtils.isEmpty(brid)){
            baseResDto.setResultMessage("主键 id is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{

            String issuDate = reqDto.getIssuedateStr();//发证日期
            if(DateUtil.checkDateForm(issuDate)){
                reqDto.setIssuedate(DateUtil.getDate(issuDate));
            }
            String expriDate = reqDto.getExpirydateStr();//有效日期
            if(DateUtil.checkDateForm(expriDate)){
                reqDto.setExpirydate(DateUtil.getDate(expriDate));
            }
            if(reportType==1){
                Busireport busireport = new Busireport();
                BeanUtils.copyProperties(reqDto,busireport);
                businessService.updateBusireport(busireport);
            }else{
                Manureport manureport = new Manureport();
                BeanUtils.copyProperties(reqDto,manureport);
                manureportBusinessService.updateManureport(manureport);
            }
            }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("更新企业经营许可证信息异常");
            logger.error("更新企业经营许可证信息异常",e);
        }
        return baseResDto;
    }

    /**
     * 参数校验
     * @param reqDto
     * @param resDto
     * @return
     */
    private boolean checkParams(BusireportReqDto reqDto,BaseResDto resDto){
        boolean flag = true;
        if(STRUtils.isEmpty(reqDto.getPermitno())){
            resDto.setResultMessage("许可证 permitno is null");
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            flag = false;
        }
        if(STRUtils.isEmpty(reqDto.getEnterprisename())){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("企业名称 enterprisename is null");
            flag = false;
        }
        if(STRUtils.isEmpty(reqDto.getLegal())){
            resDto.setResultMessage("企业法人 legal is null");
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            flag = false;
        }
        if(STRUtils.isEmpty(reqDto.getKeyman())){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("企业负责人 keyman is null");
            flag = false;
        }
        if(STRUtils.isEmpty(reqDto.getIssuedepartment())){
            resDto.setResultMessage("发证部门 issuedepartment is null");
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            flag = false;
        }
        if(!DateUtil.checkDateForm(reqDto.getIssuedateStr())){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("发证日期格式错误 ：YYYY-MM-DD");
            flag = false;
        }
        if(!DateUtil.checkDateForm(reqDto.getExpirydateStr())){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("有效日期格式错误 ：YYYY-MM-DD");
            flag = false;
        }
//        if(!DateUtil.checkDateForm(reqDto.getDocdateStr())){
//            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
//            resDto.setResultMessage("到期日期格式错误 ：YYYY-MM-DD");
//            flag = false;
//        }

        return  flag;
    }
}
