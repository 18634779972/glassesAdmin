package com.xjt.service.impl;

import com.xjt.business.GoodsbarcodeBusinessService;
import com.xjt.dao.master.GoodsbarcodeDao;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.GoodsbarcodeReqDto;
import com.xjt.entity.Goodsbarcode;
import com.xjt.enums.ResultCode;
import com.xjt.service.GoodsbarcodeService;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GoodsbarcodeServiceImpl implements GoodsbarcodeService {

    private Logger logger = LoggerFactory.getLogger(GoodsbarcodeServiceImpl.class);
    @Resource
    private GoodsbarcodeBusinessService businessService;
    @Resource
    private GoodsbarcodeDao goodsbarcodeDao;

    /**
     * 添加货品膜层 屈光 散光 条码
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto insertGoodsbarcode(GoodsbarcodeReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        if(!checkParams(reqDto,baseResDto)){
            return baseResDto;
        }
        try{
            Goodsbarcode goodsbarcode = new Goodsbarcode();
            BeanUtils.copyProperties(reqDto,goodsbarcode);
           businessService.insertGoodsbarcode(goodsbarcode);

        }catch (Exception e){
            baseResDto.setResultMessage("添加货品屈光，散光，条码异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("添加货品屈光，散光，条码异常",e);
        }

        return baseResDto;
    }

    /**
     * 根据货品编号查看信息
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto queryGoodsbarcodeInfo(GoodsbarcodeReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String goodsNo = reqDto.getGoodsno();
        if(STRUtils.isEmpty(goodsNo)){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("goodsno is null");
            return baseResDto;
        }
        try{
            Goodsbarcode goodsbarcode = goodsbarcodeDao.selectByGoodsNo(goodsNo);
            baseResDto.setData(goodsbarcode);
        }catch (Exception e){
            baseResDto.setResultMessage("根据货品编号货品膜层屈光散光异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("根据货品编号货品膜层屈光散光异常",e);
        }
        return baseResDto;
    }

    /**
     * 参数校验
     * @param reqDto
     * @param resDto
     * @return
     */
    private boolean checkParams(GoodsbarcodeReqDto reqDto,BaseResDto resDto){
        boolean flag = true;
        if(STRUtils.isEmpty(reqDto.getGoodsno())){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("货品编号 goodsno is null");
            flag = false;
        }
        if(STRUtils.isEmpty(reqDto.getColordd())){
            resDto.setResultMessage("颜色膜层 colordd is null");
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            flag = false;
        }
        if(STRUtils.isEmpty(reqDto.getBarcode())){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("货品条码 barcode is null");
            flag = false;
        }
        if(reqDto.getAstigmia()==null){
            resDto.setResultMessage("散光度 astigmia is null");
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            flag = false;
        }
        return flag;
    }
}
