package com.xjt.service.impl;

import com.xjt.business.DictbankaccountsBusinessSer;
import com.xjt.dto.BaseReqDto;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.DictbankaccountsReqDto;
import com.xjt.entity.Dictbankaccounts;
import com.xjt.enums.ResultCode;
import com.xjt.service.DictbankaccountsService;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DictbankaccountsServiceImpl implements DictbankaccountsService {

    private Logger logger = LoggerFactory.getLogger(DictbankaccountsServiceImpl.class);
    @Resource
    private DictbankaccountsBusinessSer businessSer;

    /**
     * 增加开户行信息
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto insertBankInfo(DictbankaccountsReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(!checkParams(reqDto,baseResDto)){
            return baseResDto;
        }
        try{
            Dictbankaccounts dictbankaccounts = new Dictbankaccounts();
            BeanUtils.copyProperties(reqDto,dictbankaccounts);
            dictbankaccounts.setId(STRUtils.createUUID());
            businessSer.insertBankInfo(dictbankaccounts);

        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("添加开户行信息异常");
            logger.error("添加开户行信息异常",e);
        }
        return baseResDto;
    }
    private boolean checkParams(DictbankaccountsReqDto reqDto,BaseResDto resDto){
        boolean flag = true;
        if(STRUtils.isEmpty(reqDto.getBank())){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("开户行 bank is null");
            flag = false;
        }
        if(STRUtils.isEmpty(reqDto.getBankaddr())){
            resDto.setResultMessage("开户行地址 bankaddr is null");
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            flag = false;
        }
        if(STRUtils.isEmpty(reqDto.getAccountsname())){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("户名 accountsname is null");
            flag = false;
        }
        if(STRUtils.isEmpty(reqDto.getAccounts())){
            resDto.setResultMessage("行号 accounts is null");
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            flag = false;
        }
        return flag;
    }
}
