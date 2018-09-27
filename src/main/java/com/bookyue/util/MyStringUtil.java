package com.bookyue.util;

public class MyStringUtil {
	
	
	/**
	 * 判断字符串是否为空
	 * 
	 * <p>为null或者""空字符串都返回true</p>
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}

}
