package com.bookyue.service;

import com.bookyue.model.UserInfo;

/**
 * 用户信息Service
 * @author bigOrang
 *
 */
public interface UserInfoService {

	/**
	 * 根据微信openid来获取userid
	 * 
	 * @param wxOpenid
	 * @return
	 */
	Integer getUserIdByWxopenid(String wxOpenid);

	/**
	 * 根据userId得到一个UserInfo
	 * 
	 * 返回用户的userId用户id、avatarUrl头像、username昵称、sex性别 3个属性
	 * @param userId
	 * @return
	 */
	UserInfo getBriefUserInfoByUserId(Integer userId);
	
	
	/**
	 * 根据userId获得手机号
	 * @param userId
	 * @return
	 */
	String getPhoneByUserId(Integer userId);

	
	/**
	 * 根据userId得到一个UserInfo
	 * <p>返回的信息不包含微信openId</p>
	 * @param userId
	 * @return
	 */
	UserInfo getUserInfoByUserId(Integer userId);
	
	
	/**
	 * 插入一个UserInfo记录
	 * 
	 * @param userInfo
	 * @return
	 */
	boolean addUserInfo(UserInfo userInfo);

	/**
	 * 修改用户信息
	 * 
	 * @param userInfo
	 * @return
	 */
	boolean update(UserInfo userInfo);
	
	boolean checkBriefInfoComplete(Integer userId);
	
	

}
