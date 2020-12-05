package com.llx.crm.settings.service;

import com.llx.crm.settings.dao.DictionaryTypeDao;
import com.llx.crm.settings.domain.DicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Title: DictionaryTypeServiseImpl
 * Description:
 *
 * @author LanLinxiang
 * @version V1.0
 * @email linxianglan@aliyun.com
 * @date 2020-12-05
 */
@Service
public class DictionaryTypeServiseImpl implements DictionaryTypeServise {
    @Autowired
    private DictionaryTypeDao dictionaryTypeDao;

    @Override
    public List<DicType> findAll() {
        return dictionaryTypeDao.findAll();
    }

    @Override
    public boolean checkCode(String code) {

                int cont = dictionaryTypeDao.checkCode(code);
                if (0 <cont){
                    return false;
                }else {
                    return true;
                }
    }
}
