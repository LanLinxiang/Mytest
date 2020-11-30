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
     * Description:
     * @return
     * @date 2020/12/1 0:30
     */
    @RequestMapping("/toindex.do")
    public String toWorkbenchIndex(){
        return "/workbench/index";
    }
}
