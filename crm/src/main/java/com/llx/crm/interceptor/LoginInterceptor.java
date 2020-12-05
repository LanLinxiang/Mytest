package com.llx.crm.interceptor;

import com.llx.crm.exception.InterceptorException;
import com.llx.crm.exception.LoginException;
import com.llx.crm.settings.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    //控制器方法访问之前执行 返回true 代表放行  返回F 代表拦截
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //用户登录后允许访问后面的页面
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if(null == user){
            //throw new LoginException("用户未登录");
            throw new InterceptorException();
            //return false;
        }
        return true;
    }
    //控制器方法访问之后执行
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }
    //页面加载完成后执行
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
