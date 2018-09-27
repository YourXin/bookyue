package com.bookyue.mapper;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRedis {

	private static Logger logger = LoggerFactory.getLogger(UserRedis.class);
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	/**
	 * 通过sessionId来从Redis中获取用户id
	 * @param sessionId
	 * @return
	 */
	public Integer getUserId(String sessionId) {
		String userId = redisTemplate.opsForValue().get(sessionId);
		return userId == null ? null : Integer.valueOf(userId);
	}
	
	/**
	 * 保存sessionId和用户id
	 * @param sessionId
	 * @param userId
	 */
	public void setSessionID(String sessionId, Integer userId) {
		redisTemplate.opsForValue().set(sessionId, String.valueOf(userId), 60, TimeUnit.MINUTES);
	}
}
