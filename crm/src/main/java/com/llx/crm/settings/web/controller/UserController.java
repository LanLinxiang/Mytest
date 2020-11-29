package com.llx.crm.settings.web.controller;

import com.llx.crm.exception.LoginException;
import com.llx.crm.settings.domain.User;
import com.llx.crm.settings.service.UserService;
import com.llx.crm.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Title: UserController
 * Description:
 *
 * @author LanLinxiang
 * @version V1.0
 * @email linxianglan@aliyun.com
 * @date 2020-11-29
 */
@Controller
@RequestMapping("/settings/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    public String login(String loginAct, String loginPwd, HttpServletRequest request) throws LoginException {
        //登录操作
        //获取当前IP地址后期进行比对
        String ipAddr = request.getRemoteAddr();
        //对密码进行MD5加密
        String md5 = MD5Util.getMD5(loginPwd);
        User user = userService.login(loginAct,md5,ipAddr);

        if(null != user){
            //查看是否已经登录，将user存入session中
            request.getSession().setAttribute("user",user);
        }

        //转到系统内的主页
        return "/workbench/index";
    }
}
