package com.xjt.service.impl;

import com.xjt.business.ActioncolumnBusinessService;
import com.xjt.dao.master.ActioncolumnDao;
import com.xjt.dto.ActioncolumnReqDto;
import com.xjt.dto.BaseResDto;
import com.xjt.entity.Actioncolumn;
import com.xjt.enums.ResultCode;
import com.xjt.service.ActioncolumnService;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ActioncolumnServiceImpl implements ActioncolumnService {

    @Resource
    private ActioncolumnBusinessService businessService;
    @Resource
    private ActioncolumnDao actioncolumnDao;

    private Logger logger = LoggerFactory.getLogger(ActioncolumnServiceImpl.class);

    /**
     * 添加分栏
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto insertSubfield(ActioncolumnReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String name = reqDto.getActionColumnName();
        if(STRUtils.isEmpty(name)){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("添加分栏异常");
            return baseResDto;
        }
        try{
            Actioncolumn actioncolumn = new Actioncolumn();
            BeanUtils.copyProperties(reqDto,actioncolumn);
            actioncolumn.setActionColumnId(STRUtils.createUUID());
            businessService.insertSubfield(actioncolumn);
        }catch (Exception e){
            baseResDto.setResultMessage("It has an exception to insert the subfiled");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("添加分栏异常",e);
        }
        return baseResDto;
    }

    /**
     * 查看分栏列表
     * @return
     */
    @Override
    public BaseResDto queryColumnList() {
        BaseResDto baseResDto = new BaseResDto();
        try{
            List<Actioncolumn> actioncolumns =actioncolumnDao.queryActioncolumnList();
            if(actioncolumns==null||actioncolumns.size()==0){
                baseResDto.setResultMessage("no data");
                baseResDto.setResultCode(ResultCode.RESULT_CODE_NODATA.getCode());
                return baseResDto;
            }
            baseResDto.setData(actioncolumns);
        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("It has an exception to select the list");
            logger.error("查看分栏列表异常",e);
        }
        return baseResDto;
    }


}
