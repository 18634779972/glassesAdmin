package com.xjt.service.impl;

import com.xjt.business.SupplyfilemgtBusinessService;
import com.xjt.dto.BaseResDto;
import com.xjt.entity.Supplyfilemgt;
import com.xjt.enums.ResultCode;
import com.xjt.service.SupplyfilemgtService;
import com.xjt.utils.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class SupplyfilemgtServiceImpl implements SupplyfilemgtService {

    private Logger logger = LoggerFactory.getLogger(SupplyfilemgtServiceImpl.class);
    @Resource
    private SupplyfilemgtBusinessService businessService;

    /**
     * 上传文件 DB记录文件信息
     * @param file
     * @param fileSavePath
     * @return
     */

    @Override
    public BaseResDto insertFileInfo(MultipartFile file, String fileSavePath) {
        BaseResDto baseResDto = new BaseResDto();
        try{
            boolean flag = FileUtil.uploadFile(file,fileSavePath);

            if(flag){
                logger.info("文件上传成功");
                String fileName = file.getOriginalFilename();
                String filePath = fileSavePath+"/" + fileName;
                Supplyfilemgt supplyfilemgt = new Supplyfilemgt();
                supplyfilemgt.setFilename(fileName);
                supplyfilemgt.setFilepath(filePath);
                int index = filePath.lastIndexOf(".");
                String fileType = filePath.substring(index+1);
                supplyfilemgt.setFiletype(fileType);
                supplyfilemgt.setUploaddate(new Date());
                businessService.insertFileInfo(supplyfilemgt);
            }else{
                baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
                baseResDto.setResultMessage("文件上传异常");
            }

        }catch (Exception e){
            baseResDto.setResultMessage("上传文件 添加文件信息异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("上传文件 添加文件信息异常",e);
        }
        return baseResDto;
    }
}
