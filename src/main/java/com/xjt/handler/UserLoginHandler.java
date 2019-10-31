package com.xjt.handler;

import com.alibaba.fastjson.JSONObject;
import com.xjt.enums.ResultCode;
import com.xjt.utils.RedisUtil;
import com.xjt.utils.STRUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserLoginHandler extends HandlerInterceptorAdapter {

    @Autowired
    private RedisUtil redisUtil;

    @Value("${login.validity.time}")
    private Long loginValidityTime;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");
        Map<String,Object>  map = new HashMap<>();
        String userId = request.getHeader("userId");
       /* if(STRUtils.isEmpty(userId)){
            PrintWriter writer = response.getWriter();
            map.put("code",ResultCode.RESULT_CODE_EXCEPTION.getCode());
            map.put("message","没有请求头信息");
            writer.print(JSONObject.toJSONString(map));

            return false;
        }*/
        //根据用户id获取token 如果已失效 请求重新登录 否则 更新失效时间
        if(userId != null){
            String token =(String) redisUtil.get(userId);
            if(token==null){
                PrintWriter writer = response.getWriter();
                map.put("code",ResultCode.RESULT_CODE_EXCEPTION);
                map.put("message","已超时，请重新登录");
                writer.write(JSONObject.toJSONString(map));
                return false;
            }else{
                redisUtil.set(userId,token,loginValidityTime);
                return true;
            }
        }else{
            response.sendRedirect("/login");
            return false;
        }








    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
