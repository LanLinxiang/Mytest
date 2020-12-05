package com.llx.crm.settings.service;

import com.llx.crm.settings.domain.DicType;

import java.util.List;

/**
 * Title: DictionaryTypeServise
 * Description:
 *
 * @author LanLinxiang
 * @version V1.0
 * @email linxianglan@aliyun.com
 * @date 2020-12-05
 */
public interface DictionaryTypeServise {


    List<DicType> findAll();

   boolean checkCode(String code);
}
