package com.xjt.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 张代浩
 * @ClassName: ContextHolderUtils
 * @Description: TODO(上下文工具类)
 * @date 2012-12-15 下午11:27:39
 */
public class ContextHolderUtils {

    /**
     * SpringMvc下获取request
     */
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * SpringMvc下获取session
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }
}