package com.llx.crm.settings.web.controller;

import com.llx.crm.exception.LoginException;
import com.llx.crm.settings.domain.User;
import com.llx.crm.settings.service.UserService;
import com.llx.crm.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
/**
 * Description:flag 十天免登錄的標記，如果勾選了十天免登錄，在cookie中存入
 * @return
 * @date 2020/12/1 0:03
 */
    @RequestMapping("/login.do")
    public String login(String loginAct, String loginPwd, HttpServletRequest request,String flag
                        ,HttpServletResponse response) throws LoginException {
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
        //  十天免登錄的標記
        if("a".equals(flag)){
            //存入密碼 賬號
            Cookie loginActCookie = new Cookie("loginAct",loginAct);
            Cookie loginPwdCookie = new Cookie("loginPwd",md5);
            //計算過期時間
            int max_CookAge = 60*60*24*10;
            loginActCookie.setMaxAge(max_CookAge);
            loginPwdCookie.setMaxAge(max_CookAge);
            //設置Cookie 路徑
            loginActCookie.setPath("/");
            loginPwdCookie.setPath("/");
            //存入到瀏覽器中
            response.addCookie(loginActCookie);
            response.addCookie(loginPwdCookie);

        }

        //转到系统内的主页
        return "/workbench/index";
    }

    /**
     * 程序入口
     *
     * Description:处理十天免登录,在該方法中進行免登錄的操作
     *
     * @return login
     * @date 2020/11/30 23:20
     */

    @RequestMapping("/toLogin.do")
    public String toLogin(HttpServletResponse response,HttpServletRequest request) throws LoginException {
        String loginPwd = null;
        String loginAct = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length >0){
            //對比賬號是否已被記錄
            for (Cookie cookie:cookies
            ) {
                String name = cookie.getName();
                if("loginAct".equals(name)){
                    loginAct = cookie.getValue();
                    continue;
                }
                if("loginPwd".equals(name)){
                    loginPwd = cookie.getValue();
                }
            }
            if(loginAct != null && loginPwd != null){
                if(loginAct.length() >0 && loginPwd.length() > 0){

                    User user = userService.login(loginAct,loginPwd, request.getRemoteAddr());
                    if(null != user){

                        request.getSession().setAttribute("user",user);
                        //重定向到首頁面
                        return "redirect:/workbench/toindex.do";
                    }else {
                        return "login";
                    }
                }
            }

        }


        return "/login";
    }


}
