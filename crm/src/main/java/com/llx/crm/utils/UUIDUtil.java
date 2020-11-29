package com.llx.crm.utils;

import java.util.UUID;

/**
 * UUID 生成随机36位字符串
 * 其中包含4个 -  如果将4个 - 去除就是32位
 *
 *
 * */
public class UUIDUtil {
	
	public static String getUUID(){
		
		return UUID.randomUUID().toString().replaceAll("-","");
		
	}
	
}
