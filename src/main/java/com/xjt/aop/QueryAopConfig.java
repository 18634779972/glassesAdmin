package com.xjt.aop;

import com.alibaba.fastjson.JSONObject;
import com.xjt.dao.master.DatapermissionDao;
import com.xjt.entity.Datapermission;
import com.xjt.utils.STRUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class QueryAopConfig {

    private Logger logger = LoggerFactory.getLogger(QueryAopConfig.class);
    @Resource
    private DatapermissionDao datapermissionDao;

    @Pointcut("@annotation(com.xjt.annotation.QueryList)")
    public void addAdvice(){

    }


    /**
     * 切点之前
     *
     * @param
     * @throws Throwable
     */
    @Around("addAdvice()")
    public Object before(ProceedingJoinPoint pjp) throws Throwable {

        logger.info("进去切面");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response =attributes.getResponse();
        String userId = request.getHeader("userId");
        logger.info("请求头信息"+userId);
        if(STRUtils.isEmpty(userId)){
            PrintWriter printWriter = response.getWriter();
            printWriter.write("没有请求头信息");
            return null ;
        }

        //查看用户具有的数据权限
        Datapermission datapermission = datapermissionDao.queryMasterPermission(userId);
        logger.info("数据权限"+JSONObject.toJSONString(datapermission));
        if(datapermission==null){
            PrintWriter printWriter = response.getWriter();
            printWriter.write("您没有权限查看数据");
            return null;

        }

        getDataPermission(datapermission,request.getSession());
        return pjp.proceed();
        }

    /**
     * 数据权限存储session
     * @param datapermission
     * @param session
     * @return
     */
    private HttpSession getDataPermission(Datapermission datapermission,HttpSession session){
        String brandStr = datapermission.getDictbrandId();//品牌权限
        logger.info("品牌权限"+brandStr);
        String customerStr = datapermission.getCustomerId();//渠道权限
        String supplyStr = datapermission.getSupplyId();//供货商权限
        String wareHouseStr = datapermission.getWarehouseId();//仓库权限
        if(!STRUtils.isEmpty(brandStr)){
            List<String> brandPers = Arrays.asList(brandStr.split(","));
            session.setAttribute("brandPers",brandPers);
            logger.info("存入品牌权限成功");
        }
        if(!STRUtils.isEmpty(customerStr)){
            List<String> customerPers = Arrays.asList(customerStr.split(","));
            session.setAttribute("customerPers",customerPers);
        }
        if(!STRUtils.isEmpty(supplyStr)){
            List<String> supplyPers = Arrays.asList(supplyStr.split(","));
            session.setAttribute("supplyPers",supplyPers);
        }
        if(!STRUtils.isEmpty(wareHouseStr)){
            List<String> wareHousePer = Arrays.asList(wareHouseStr.split(","));
            session.setAttribute("wareHousePer",wareHousePer);
        }
        return session;

    }


}
