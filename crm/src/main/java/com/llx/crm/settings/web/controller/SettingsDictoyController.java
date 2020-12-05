package com.llx.crm.settings.web.controller;

import com.llx.crm.settings.domain.DicType;
import com.llx.crm.settings.service.DictionaryTypeServise;
import com.llx.crm.utils.HandleFlag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Title: SettingsDictoyController
 * Description:
 *
 * @author LanLinxiang
 * @version V1.0
 * @email linxianglan@aliyun.com
 * @date 2020-12-03
 */
@Controller
@RequestMapping("/settings/dictionary")
public class SettingsDictoyController {
    @Autowired
    private DictionaryTypeServise dictionaryTypeServise;




    /**
     * Description:数据字典表设置页面
     * @return
     * @date 2020/12/3 22:31
     */
    @RequestMapping("/toIndex.do")
    public String toIndex(){
        return "/settings/dictionary/index";
    }



/**
 * Description:字典类型
 * @return
 * @date 2020/12/5 23:03
 */
    @RequestMapping("/type/toIndex.do")
    public String typetoIndex(Model model){
        //查询后台数据
        List<DicType> dicTypeList =  dictionaryTypeServise.findAll();
        //将表数据封装到Model中
       model.addAttribute("dicTypeList",dicTypeList);
        return "/settings/dictionary/type/index";
    }




    /**
     * Description:字典值新建页面
     * @return
     * @date 2020/12/6 0:07
     */
    @RequestMapping("/type/toEdit.do")
    public ModelAndView typetoEdit(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/settings/dictionary/type/save");
        return mv;
    }

    /**
     * Description:字典值新建页面
     * @return
     * @date 2020/12/6 0:07
     */
    @RequestMapping("/type/tosave.do")
    public ModelAndView typetoSave(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/settings/dictionary/type/save");
        return mv;
    }
/**
 * Description:测试新增字段是否已重复
 * @return json
 * @date 2020/12/6 0:59
 */
    @RequestMapping("/type/checkCode.do")
    @ResponseBody
    public Map<String,Object> checkCode(String code){
        boolean flag = dictionaryTypeServise.checkCode(code);
        if(flag){
            return HandleFlag.successTrue();
        }else {
            return HandleFlag.erro("编码已重复");
        }

    }

//==========================================type================================

//=========================================value===============================


    /**
     * Description:字典值
     * @return
     * @date 2020/12/5 23:03
     */
    @RequestMapping("/value/toIndex.do")
    public String valuetoIndex(){
        return "/settings/dictionary/value/index";
    }




}
