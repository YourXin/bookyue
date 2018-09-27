package com.bookyue.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class UserInfoUtil {

	public static String getWxOpenid(String jsCode) {
		System.out.println(jsCode);
		String requestUrl = "https://api.weixin.qq.com/sns/jscode2session?" + "appid=" + AppInfo.APPID + "&secret=" + AppInfo.SECRET
				+ "&" + "js_code=" + jsCode + "&grant_type=authorization_code";
		
		String responseData = MyHttpRequestUtil.httpRequest(requestUrl, "GET", null);
		
		System.out.println(responseData);
		JSONObject jsonObject = JSON.parseObject(responseData);
		return jsonObject.getString("openid");
	}
}
