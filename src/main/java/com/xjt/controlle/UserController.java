
package com.xjt.controlle;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;


/**
 * 定义用户相关网址映射的Controller
 */

@Controller
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/user")
    public String user(@AuthenticationPrincipal Principal principal, Model model){
        model.addAttribute("username", principal.getName());
        return "user/user";
    }
    @RequestMapping("/admin")
    public String admin(@AuthenticationPrincipal Principal principal, Model model){
        model.addAttribute("username", principal.getName());
        return "admin/admin";
    }

    @RequestMapping("/testSession")
    @ResponseBody
    public  void testSession(HttpServletRequest request){
        HttpSession session =request.getSession();
        session.setAttribute("userId","001");
        logger.info("用户信息存入session成功,请求路径"+request.getRequestURI());
    }

    @RequestMapping("/getSessionInfo")
    @ResponseBody
    public  String getSessionInfo(HttpServletRequest request){
        HttpSession session = request.getSession();
        Object o = session.getAttribute("userId");
        return JSONObject.toJSONString(o);
    }

}

