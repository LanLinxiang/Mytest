package com.llx.crm.settings.service;

import com.llx.crm.exception.LoginException;
import com.llx.crm.settings.domain.User;

/**
 * Title: UserSerbice
 * Description:
 *
 * @author LanLinxiang
 * @version V1.0
 * @email linxianglan@aliyun.com
 * @date 2020-11-29
 */
public interface UserService {

    User login(String loginAct, String md5 ,String ipAddr) throws LoginException;
}
