package com.llx.crm.settings.service;

import com.llx.crm.exception.LoginException;
import com.llx.crm.settings.dao.UserDao;
import com.llx.crm.settings.domain.User;
import com.llx.crm.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Title: UserServiceImpl
 * Description:
 *
 * @author LanLinxiang
 * @version V1.0
 * @email linxianglan@aliyun.com
 * @date 2020-11-29
 */

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

/**
 * Description:根据用户名或者密码进行查询
 * @return User
 * @date 2020/11/29 23:11
 */
    @Override
    public User login(String loginAct, String md5,String ipAddr) throws LoginException {
        User user =userDao.login(loginAct,md5);
        if (null == user){
            throw new LoginException("用户名及密码");
        }

    //判断账号是否失效，失效时间如果为空，代表永久有效
            String expireTime = user.getExpireTime();
            //如果失效时间不为空，对比时间判断是否失效
            if(null != expireTime){
            //比对数据库时间与当前时间 返回 -1 代表已失效
                if(expireTime.compareTo(DateTimeUtil.getSysTime()) < 0){
                    throw new LoginException("账号已失效");
                }
            }

    //判断账号的锁定状态 0为已锁定，1为未锁定
            String lockState = user.getLockState();
            if ("0".equals(lockState)){
                throw new LoginException("账号已被锁定");
            }

    //判断IP地址是否受限
            String allowIps = user.getAllowIps();
            if(null != allowIps){
                if(!allowIps.contains(ipAddr)){
                    throw new LoginException("账号ip已被锁定");
                }
                             /*//通过，对IP地址进行分割成一个数组
                             String[] ips = allowIps.split(",");
                             //遍历IP地址进行比对
                             for (String ip :ips
                              ) {
                             if(!allowIps.equals(ip)){
                                 throw new LoginException("账号ip已被锁定");
                                 }
                             }*/

            }

        return user;


    }
}
