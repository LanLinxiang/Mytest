package com.llx.crm.settings.dao;

import com.llx.crm.settings.domain.DicType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Title: DictionaryTypeDao
 * Description:
 *
 * @author LanLinxiang
 * @version V1.0
 * @email linxianglan@aliyun.com
 * @date 2020-12-05
 */

public interface DictionaryTypeDao {
    List<DicType> findAll();


    int checkCode(String code);
}
