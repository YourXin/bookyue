package com.bookyue.util;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

@Component
public class CheckContent {
	

	@Resource
	private RedisTemplate<String, String> redisTemplate;

	/**
	 * 调用微信验证接口判断输入的文字内容是否合法
	 * @param str
	 * @return
	 */
	public boolean isSafe(String str) {
		if(MyStringUtil.isEmpty(str)) {
			return true;
		}
		StringBuffer url = new StringBuffer("https://api.weixin.qq.com/wxa/msg_sec_check");
		
		System.out.println(redisTemplate);
		
		String accessToken = redisTemplate.opsForValue().get("ACCESS_TOKEN");

		if (MyStringUtil.isEmpty(accessToken)) {
			// 获得token并保存
			Map<String, Object> map = AccessTokenUtil.getAccessToken();
			accessToken = (String) map.get("accessToken");

			if (!MyStringUtil.isEmpty(accessToken)) {
				// 保存到redis中,时间比获取到的时间少 20秒
				redisTemplate.opsForValue().set("ACCESS_TOKEN", accessToken, (Integer) map.get("expiresIn") - 20,
						TimeUnit.SECONDS);
			} else {
				throw new RuntimeException("获取accessToken异常");
			}
		}
		
		url.append("?access_token=").append(accessToken);

		JSONObject params = new JSONObject();
		params.put("content", str);

		String result = MyHttpRequestUtil.httpRequest(url.toString(), "POST", params.toJSONString());

		System.out.println(result);
		JSONObject resultJson = JSONObject.parseObject(result);
		// 0 内容正常
		// 87014 内容含有违法违规内容
		Integer errCode = resultJson.getInteger("errcode");
		// String errMsg = resultJson.getString("errMsg");
		if (errCode == 0) {
			return true;
		}
		return false;
	}

}
