package com.bookyue.util;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * 获取微信 的access_token
 * @author bigOrang
 *
 */
public class AccessTokenUtil {

	private static Logger logger = LoggerFactory.getLogger(AccessTokenUtil.class);

	/**
	 * 返回的key为
	 * <p>accessToken</p>
	 * <p>expiresIn</p>
	 * 两个参数
	 * @return
	 */
	public static Map<String, Object> getAccessToken() {
		// https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
		// https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx3de14ec4cdd7ef43&secret=cb6deaf3b78c4a0689d6a27e184bc38e
		StringBuffer url = new StringBuffer("https://api.weixin.qq.com/cgi-bin/token");
		String method = "GET";
		

		url.append("?grant_type=client_credential");
		
		url.append("&appid=").append(AppInfo.APPID);
		url.append("&secret=").append(AppInfo.SECRET);
		

		String result = MyHttpRequestUtil.httpRequest(url.toString(), method, null);

		logger.debug("result:" + result);
		System.out.println(result);

		JSONObject resultJson = JSONObject.parseObject(result);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("accessToken", resultJson.getString("access_token"));
		map.put("expiresIn", resultJson.getInteger("expires_in"));

		return map;
	}
}
