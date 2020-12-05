package com.llx.crm.workbench.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Title: IndexController
 * Description:
 *
 * @author LanLinxiang
 * @version V1.0
 * @email linxianglan@aliyun.com
 * @date 2020-12-01
 */
@Controller
@RequestMapping("/workbench")
public class IndexController {




    /**
     * Description:工作台首页面展示
     * @return
     * @date 2020/12/1 0:30
     */
    @RequestMapping("/toindex.do")
    public String toWorkbenchIndex(){
        return "/workbench/index";
    }

    /**
     * Description:首页面内容区展示
     * @return
     * @date 2020/12/3 21:53
     */
    @RequestMapping("/main/toindex.do")
    public String toMainIndex(){
        return "/workbench/main/index";
    }
}
