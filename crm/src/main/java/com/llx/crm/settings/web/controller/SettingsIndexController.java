package com.llx.crm.settings.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Title: IndexController
 * Description:
 *
 * @author LanLinxiang
 * @version V1.0
 * @email linxianglan@aliyun.com
 * @date 2020-12-03
 */

@Controller
@RequestMapping("/settings")
public class SettingsIndexController {

    /**
     * Description:跳转到系统设置页面
     * @return
     * @date 2020/12/3 22:04
     */
    @RequestMapping("/toIndex.do")
    public String toIdenx(){
        return "/settings/index";
    }




}
