package com.llx.crm.utils;

import java.util.HashMap;
import java.util.Map;
/**
 * 公共返回值
 *      返回MAP集合 将该集合转为JESON
 * */
public class HandleFlag {

    /*public static Map<String,Object> handleFlag(boolean flag){

        Map<String,Object> map = new HashMap<>();
        map.put("success",flag);
        return map;

    }*/

    public static Map<String,Object> successTrue(){

        Map<String,Object> map = new HashMap<>();
        map.put("success",true);
        return map;

    }

    public static Map<String,Object> successObj(String key,Object obj){

        Map<String,Object> map = new HashMap<>();
        map.put("success",true);
        map.put(key,obj);
        return map;

    }


}
