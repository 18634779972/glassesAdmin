package com.xjt.service.impl;

import com.xjt.business.GoodspicturemgtBusinessSer;
import com.xjt.dto.BaseResDto;
import com.xjt.entity.Goodspicturemgt;
import com.xjt.enums.ResultCode;
import com.xjt.service.GoodspicturemgtService;
import com.xjt.utils.FileUtil;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class GoodspicturemgtServiceImpl implements GoodspicturemgtService {

    @Resource
    private GoodspicturemgtBusinessSer businessSer;

    private Logger logger = LoggerFactory.getLogger(GoodspicturemgtServiceImpl.class);

    /**
     * 批量上传货品文件  信息存入数据库
     * @param files
     * @param savePath
     * @return
     */
    @Override
    public BaseResDto insertGoodsFileInfo(List<MultipartFile> files, String savePath,String goodsId) {
        BaseResDto baseResDto = new BaseResDto();
        if(files.isEmpty()){
            baseResDto.setResultMessage("文件不能为空");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            //上传图片
            int num = FileUtil.uploadFileBatch(files,savePath);
            if(num != files.size()){

                baseResDto.setResultMessage("文件上传失败");
                baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
                return baseResDto;
            }
            List<Goodspicturemgt> list = new ArrayList<>();
            Date nowDate = new Date();
            for(MultipartFile file:files){
                String fileName = file.getOriginalFilename();
                String filePath = savePath+"/"+fileName;
                Goodspicturemgt entity = new Goodspicturemgt();
                entity.setFilename(fileName);
                entity.setFilepath(filePath);
                entity.setGoodsid(goodsId);
                entity.setUploaddate(nowDate);
                list.add(entity);
            }
            businessSer.insertGoodsPics(list);

        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("上传货品文件信息异常");
            logger.error("上传货品文件信息异常",e);
        }
        return baseResDto;
    }
}
