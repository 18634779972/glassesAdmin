package com.xjt.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xjt.business.GoodsBusinessService;
import com.xjt.dao.master.GoodsDao;
import com.xjt.dao.master.GoodspicturemgtDao;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.GoodsReqDto;
import com.xjt.entity.Goods;
import com.xjt.entity.Goodspicturemgt;
import com.xjt.enums.ResultCode;
import com.xjt.service.GoodsService;
import com.xjt.utils.FileUtil;
import com.xjt.utils.STRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GoodsServiceImpl implements GoodsService {

    private Logger logger = LoggerFactory.getLogger(GoodsServiceImpl.class);
    @Resource
    private GoodsBusinessService businessService;
    @Resource
    private GoodsDao goodsDao;
    @Resource
    private GoodspicturemgtDao goodspicturemgtDao;

    /**
     * 添加货品信息
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto insertGoods(GoodsReqDto reqDto,String savePath) {
        BaseResDto baseResDto = new BaseResDto();
        if(!checkParams(reqDto,baseResDto)){
            return baseResDto;
        }
        try{
            String goodsId = STRUtils.createUUID();
            List<MultipartFile> files = reqDto.getFiles();
            List<Goodspicturemgt> list = new ArrayList<>();
            Date nowDate = new Date();
            //上传图片
            List<Long> isEmpty = files.stream().map(MultipartFile::getSize).collect(Collectors.toList());
            Long length = 0L;
            for(Long l:isEmpty){
                length = length+l;
            }
            if(length!=0L){
                int num = FileUtil.uploadFileBatch(files,savePath);
                logger.info("上传文件"+length);
                if(num != files.size()){
                    baseResDto.setResultMessage("文件上传失败");
                    baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
                    return baseResDto;
                }
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
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String inputDateStr =  sdf.format(nowDate);
            Goods goods = new Goods();
            BeanUtils.copyProperties(reqDto,goods);
            goods.setGoodsid(goodsId);
            goods.setInputdate(inputDateStr);
            if(reqDto.getIsvalidity()==null){
                goods.setIsvalidity(0);
            }
            if(reqDto.getIsbatch()==null){
                goods.setIsbatch(0);
            }
            if(reqDto.getIsbatch()==null){
                goods.setIsbatch(0);
            }
            if(reqDto.getIsvirtual()==null){
                goods.setIsvirtual(0);
            }
            businessService.insertGoods(goods,list);

        }catch (Exception e){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("添加货品信息异常");
            logger.error("添加货品信息异常",e);
        }
        return baseResDto;
    }

    /**
     * 查看货品列表
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto queryGoodsList(GoodsReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        Integer pageNo = reqDto.getPageNo();
        Integer pageSize = reqDto.getPageSize();
        if(pageNo==null||pageSize==null||pageNo<1||pageSize<1){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("pageNo or pageSize is error");
            return baseResDto;
        }
        String twoCate =reqDto.getCategoryid2();
        if(STRUtils.isEmpty(twoCate)){
            baseResDto.setResultMessage("categoryid2 is null");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        try{
            PageHelper.startPage(pageNo,pageSize);
            List<Goods> goods = goodsDao.queryGoodsList(reqDto);
            PageInfo<Goods> pageInfo = new PageInfo<>(goods);
            //获取分页数据
            List<Goods> goodsList = pageInfo.getList();
            logger.info("分页后的数据"+JSONObject.toJSONString(goodsList));
            if(goodsList!=null&&goodsList.size()>0){
                List<String> goodsIds = goodsList.stream().map(Goods::getGoodsid).collect(Collectors.toList());
                List<Goodspicturemgt> goodspicturemgts = goodspicturemgtDao.queryFilesInfo(goodsIds);
                logger.info("货品图片"+JSONObject.toJSONString(goodspicturemgts));
                Map<String,List<Goodspicturemgt>> map = goodspicturemgts.stream().collect(Collectors.groupingBy(Goodspicturemgt::getGoodsid));
                for(Goods good:goodsList){
                    String goodsId = good.getGoodsid();
                    List<Goodspicturemgt> goodspicturemgtList = map.get(goodsId);
                    good.setList(goodspicturemgtList);
                }
                baseResDto.setData(pageInfo);
            }
        }catch (Exception e){
            baseResDto.setResultMessage("查看货品列表异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("查看货品列表异常",e);
        }
        return baseResDto;
    }

    /**
     * 查看货品详情
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto queryGoodsInfo(GoodsReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String goodsId = reqDto.getGoodsid();
        if(STRUtils.isEmpty(goodsId)){
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            baseResDto.setResultMessage("货品id is null");
            return baseResDto;
        }
        try{
            Goods goods = goodsDao.selectByPrimaryKey(goodsId);
            List<Goodspicturemgt> goodspicturemgts = goodspicturemgtDao.queryByGoodId(goodsId);
            goods.setList(goodspicturemgts);
            baseResDto.setData(goods);
        }catch (Exception e){
            baseResDto.setResultMessage("查看货品详情异常");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            logger.error("查看货品详情异常",e);
        }
        return baseResDto;
    }

    /**
     * 根据条件查看货品信息（品牌，供货商）
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto queryGoodsChoice(GoodsReqDto reqDto) {
        return null;
    }

    /**
     * 参数校验
     * @param reqDto
     * @param resDto
     * @return
     */
    private boolean checkParams(GoodsReqDto reqDto,BaseResDto resDto){
        boolean flag = true;
        if(STRUtils.isEmpty(reqDto.getGoodsname())){
            resDto.setResultMessage("货品名称 goodsname is null");
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            flag = false;
        }
        if(STRUtils.isEmpty(reqDto.getGoodsno())){
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            resDto.setResultMessage("货品编号 goodsno is null");
            flag = false;
        }
        if(STRUtils.isEmpty(reqDto.getGoodsmanuno())){
            resDto.setResultMessage("厂家编号 goodsmanuno is null");
            resDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            flag = false;
        }
        return  flag;
    }
}
