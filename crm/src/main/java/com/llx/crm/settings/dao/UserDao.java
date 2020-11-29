package com.llx.crm.settings.dao;

import com.llx.crm.settings.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * Title: UserDao
 * Description:
 *
 * @author LanLinxiang
 * @version V1.0
 * @email linxianglan@aliyun.com
 * @date 2020-11-29
 */
public interface UserDao {
    //登录用户名密码验证
    User login(@Param("loginAct") String loginAct,
               @Param("loginPwd") String md5);
}
