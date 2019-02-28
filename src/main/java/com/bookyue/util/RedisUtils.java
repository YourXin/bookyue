package com.bookyue.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtils {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	// @Autowired
	// private StringRedisTemplate strRedis;

	public void set(String key, String value) {
		redisTemplate.opsForValue().set(key, value);

	}

	public void set(String key, String value, long offset) {
		redisTemplate.opsForValue().set(key, value, offset);
	}

	public String get(String key) {
		return redisTemplate.opsForValue().get(key);
	}

}
