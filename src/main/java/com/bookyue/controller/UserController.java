package com.bookyue.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookyue.mapper.UserRedis;
import com.bookyue.model.BookPublish;
import com.bookyue.model.UserInfo;
import com.bookyue.service.BookPublishSerivce;
import com.bookyue.service.UserInfoService;
import com.bookyue.util.MyStringUtil;
import com.bookyue.util.UUIDUtil;
import com.bookyue.util.UserInfoUtil;
import com.bookyue.util.VertifyCodeUtil;
import com.github.pagehelper.util.StringUtil;

@RestController
@RequestMapping("/user")
public class UserController {

	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserInfoService userinfoSerivce;

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Autowired
	private UserRedis userRedis;

	private Map<String, Object> resultMap;

	/**
	 * 根据微信端获取到的传入的code来获取系统中的userId
	 * 如果是数据库中没有数据-新用户,即添加一个用户信息到数据库,并返回UserId
	 * 如果数据中有数据-老用户,直接查询出UserId并返回
	 * 
	 * @param code
	 * @return userId
	 */
	@GetMapping("/getUserId")
	public Map<String, Object> getUserIdByJsCode(String code, String userName, Byte userSex, String userAvatarUrl,
			HttpServletRequest request) {

		resultMap = new HashMap<String, Object>();
		// 从微信服务器得到wxopenId
		String wxOpenid = UserInfoUtil.getWxOpenid(code);

		UserInfo userInfo = new UserInfo();

		// 微信openId存在
		if (wxOpenid != null) {
			// 根据openId去查询出用户id,返回到服务器存入程序
			Integer userId = userinfoSerivce.getUserIdByWxopenid(wxOpenid);
			// 用户不存在
			if (userId == null) {
				// 新增用户
				userInfo.setUserWxopenid(wxOpenid);
				userInfo.setUserBonusPoints(0);
				userInfo.setUserAvatarUrl(userAvatarUrl);
				userInfo.setUserSex(userSex);
				userInfo.setUserName(userName);

				// 后期版本应该由前端进行传入----todo
				userInfo.setUserTypeId((byte) 1);
				// 添加新用户
				userinfoSerivce.addUserInfo(userInfo);

				// 得到返回的userId
				userId = userInfo.getUserId();

			}
			resultMap.put("success", true);
			resultMap.put("userId", userId);
		} else {
			// 没有得到微信openId
			resultMap.put("success", false);
		}
		return resultMap;
	}

	@GetMapping("/getSessionIdByJsCode")
	public Map<String, Object> getSessionIdByJsCode(String code, String userName, Byte userSex, String userAvatarUrl,
			HttpServletRequest request) {
		resultMap = new HashMap<String, Object>();
		// 从微信服务器得到wxopenId
		String wxOpenid = UserInfoUtil.getWxOpenid(code);
		if (wxOpenid != null) {
			// 根据openId去查询出用户id,返回到服务器存入程序
			Integer userId = userinfoSerivce.getUserIdByWxopenid(wxOpenid);

			// 用户不存在,第一次进入
			if (userId == null) {
				// 新增用户
				UserInfo userInfo = new UserInfo();
				// 微信openId存在
				userInfo.setUserWxopenid(wxOpenid);
				userInfo.setUserBonusPoints(0);
				userInfo.setUserAvatarUrl(userAvatarUrl);
				userInfo.setUserSex(userSex);
				userInfo.setUserName(userName);

				// 现在默认为学生-后期版本应该由前端进行传入----todo
				userInfo.setUserTypeId((byte) 1);
				// 添加新用户
				userinfoSerivce.addUserInfo(userInfo);

				// 得到返回的userId
				userId = userInfo.getUserId();
			}

			// 获取一个uuid作为userId的key保存至redis
			String sessionId = UUIDUtil.getUUIDStr();
			// 有效时间一天
			redisTemplate.opsForValue().set(sessionId, String.valueOf(userId), 1, TimeUnit.DAYS);

			resultMap.put("success", true);
			// resultMap.put("userId", userId);
			resultMap.put("sessionId", sessionId);
			resultMap.put("userId", userId);
		} else {
			// 没有得到微信openId
			resultMap.put("success", false);
		}
		return resultMap;
	}

	/**
	 * 更新用户信息
	 * 
	 * @param userInfo
	 * @return 
	 */
	@PutMapping("/update")
	public Map<String, Object> updateUserInfo(@RequestBody UserInfo userInfo,
			@RequestHeader("sessionId") String sessionId) {
		logger.debug(userInfo + "");
		resultMap = new HashMap<String, Object>();
		userInfo.setUserId(userRedis.getUserId(sessionId));
		logger.debug(sessionId + "");
		resultMap.put("success", userinfoSerivce.update(userInfo));
		return resultMap;
	}

	/**
	 * 用于返回发布者的信息-昵称、头像、性别
	 * @param userId
	 * @return
	 */
	@GetMapping("/get/{userId}")
	public Map<String, Object> getUserInfoByUserId(@PathVariable("userId") Integer userId) {
		resultMap = new HashMap<String, Object>();

		UserInfo userInfo = userinfoSerivce.getBriefUserInfoByUserId(userId);
		if (userInfo != null) {
			resultMap.put("success", true);
			resultMap.put("userInfo", userInfo);
			return resultMap;
		}
		resultMap.put("success", false);
		return resultMap;
	}

	/**
	 * 通过sessionId来查询当前用户信息
	 * @param sessionId
	 * @return
	 */
	@GetMapping("/getMyInfo")
	public Map<String, Object> getMyUserInfo(@RequestHeader("sessionId") String sessionId) {
		resultMap = new HashMap<String, Object>();
		Integer userId = userRedis.getUserId(sessionId);

		UserInfo userInfo = userinfoSerivce.getUserInfoByUserId(userId);
		if (userInfo != null) {
			resultMap.put("success", true);
			resultMap.put("userInfo", userInfo);
			return resultMap;
		}
		resultMap.put("success", false);
		return resultMap;
	}

	@GetMapping("/hasPhone")
	public Map<String, Object> hasPhone(@RequestHeader("sessionId") String sessionId) {
		resultMap = new HashMap<String, Object>();
		logger.debug(sessionId);

		System.err.println(sessionId);
		Integer userId = userRedis.getUserId(sessionId);
		System.out.println(userId);
		UserInfo userInfo = userinfoSerivce.getUserInfoByUserId(userId);
		if (userInfo != null && !MyStringUtil.isEmpty(userInfo.getUserPhone())) {
			logger.debug(userInfo.getUserPhone());
			resultMap.put("success", true);
		} else {
			resultMap.put("success", false);
		}
		return resultMap;
	}

	/**
	 * 电话、头像、用户名是否存在
	 * @param sessionId
	 * @return
	 */
	@GetMapping("/checkBriefInfoComplete")
	public Map<String, Object> checkBriefInfoComplete(@RequestHeader("sessionId") String sessionId) {
		resultMap = new HashMap<String, Object>();
		Integer userId = userRedis.getUserId(sessionId);
		UserInfo userInfo = userinfoSerivce.getUserInfoByUserId(userId);

		if (userInfo != null && !MyStringUtil.isEmpty(userInfo.getUserName())
				&& !MyStringUtil.isEmpty(userInfo.getUserAvatarUrl())) {
			resultMap.put("success", true);
			resultMap.put("isComplete", true);
		} else {
			resultMap.put("success", false);
			resultMap.put("isComplete", false);
		}
		return resultMap;
	}

	/**
	 * 
	 * 修改手机号时获取验证码
	 * @param sessionId
	 * @return
	 */
	@GetMapping("/getVertifyCode")
	public Map<String, Object> getVertifyCode(@RequestHeader("sessionId") String sessionId) {
		resultMap = new HashMap<String, Object>();
		Integer userId = userRedis.getUserId(sessionId);
		if (userId != null) {
			// 生成验证码
			String vertifyCode = VertifyCodeUtil.getCode();
			logger.debug(vertifyCode);
			// 发送验证码
			boolean isSuccess = VertifyCodeUtil.SendVertifyCode(vertifyCode);
			if (isSuccess) {
				// 将验证码保存到数据库中
				UserInfo userInfo = new UserInfo();
				userInfo.setUserId(userId);
				userInfo.setVertifyCode(vertifyCode);
				userinfoSerivce.update(userInfo);
			}
			resultMap.put("success", isSuccess);
		}
		resultMap.put("success", false);
		return resultMap;
	}

	/**
	 * 使用验证码修改手机号---暂未采用
	 * @param userInfoCustom
	 * @param sessionId
	 * @return
	 */
	@PostMapping("/alterPhone")
	public Map<String, Object> getVertifyCode(@RequestBody UserInfo userInfoCustom,
			@RequestHeader("sessionId") String sessionId) {
		resultMap = new HashMap<String, Object>();
		Integer userId = userRedis.getUserId(sessionId);

		if (userId != null) {
			// 查询数据库
			UserInfo tempUserInfo = userinfoSerivce.getUserInfoByUserId(userId);

			if (MyStringUtil.isEmpty(tempUserInfo.getVertifyCode())) {
				resultMap.put("success", false);
			} else if (userInfoCustom.getVertifyCode().equals(tempUserInfo.getVertifyCode())) {
				// 验证码正确
				tempUserInfo = new UserInfo();
				tempUserInfo.setUserId(userInfoCustom.getUserId());
				tempUserInfo.setUserPhone(userInfoCustom.getUserPhone());
				// 数据库中删除证码
				tempUserInfo.setVertifyCode("");
				userinfoSerivce.update(tempUserInfo);
				resultMap.put("success", true);
			}
		}
		resultMap.put("success", false);
		return resultMap;
	}

//	@GetMapping("getOthersPhoneByBookId")
//	public Map<String, Object> getOthersPhoneByBookId(@PathVariable("bookId") Integer bookId) {
//		resultMap = new HashMap<String, Object>();
//
//		BookPublish bookPublish = bookPublishSerivce.getByBookId(bookId);
//		if (bookPublish != null) {
//			String phone = userinfoSerivce.getPhoneByUserId(bookPublish.getUserId());
//			resultMap.put("success", true);
//			resultMap.put("phone", phone);
//		}
//		resultMap.put("success", false);
//		return resultMap;
//	}

	@GetMapping("getPhone/{userId}")
	public Map<String, Object> getUserPhoneByUserId(@PathVariable("userId") Integer userId) {
		resultMap = new HashMap<String, Object>();
		String phone = userinfoSerivce.getPhoneByUserId(userId);
		resultMap.put("success", MyStringUtil.isEmpty(phone));
		resultMap.put("phone", phone);
		return resultMap;
	}

}
