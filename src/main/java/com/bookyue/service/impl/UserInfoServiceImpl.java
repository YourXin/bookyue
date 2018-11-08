package com.bookyue.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookyue.mapper.UserInfoMapper;
import com.bookyue.model.UserInfo;
import com.bookyue.model.UserInfoExample;
import com.bookyue.service.UserInfoService;
import com.bookyue.util.MyStringUtil;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	@Override
	public Integer getUserIdByWxopenid(String wxOpenid) {
		UserInfoExample userInfoExample = new UserInfoExample();
		userInfoExample.createCriteria().andUserWxopenidEqualTo(wxOpenid);
		List<UserInfo> list = userInfoMapper.selectByExample(userInfoExample);
		if (list.size() > 0) {
			return list.get(0).getUserId();
		} else {
			return null;
		}
	}

	@Override
	public boolean addUserInfo(UserInfo userInfo) {
		if (userInfo.getUserTypeId() != null && userInfo.getUserWxopenid() != null) {
			try {
				userInfo.setUserCreateTime(new Date());
				int effectNum = userInfoMapper.insertSelective(userInfo);
				if (effectNum > 0) {
					return true;
				} else {
					throw new RuntimeException("插入用户信息数据失败");
				}
			} catch (Exception e) {
				throw new RuntimeException();
			}
		} else {
			throw new RuntimeException("信息不完整,插入用户信息数据失败");
		}
	}

	@Override
	public boolean update(UserInfo userInfo) {
		if (userInfo.getUserId() != null) {
			try {
				int effectNum = userInfoMapper.updateByPrimaryKeySelective(userInfo);
				if (effectNum > 0) {
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				throw new RuntimeException("数据库操作失败");
			}
		}
		throw new RuntimeException("用户id为空");
	}

	@Override
	public UserInfo getBriefUserInfoByUserId(Integer userId) {
		if (userId == null) {
			throw new RuntimeException("userId为空");
		} else {
			UserInfo obtainedUserInfo = userInfoMapper.selectByPrimaryKey(userId);

			UserInfo tempUserInfo = new UserInfo();
			tempUserInfo.setUserId(obtainedUserInfo.getUserId());
			tempUserInfo.setUserAvatarUrl(obtainedUserInfo.getUserAvatarUrl());
			tempUserInfo.setUserName(obtainedUserInfo.getUserName());
			tempUserInfo.setUserSex(obtainedUserInfo.getUserSex());
			tempUserInfo.setUserBonusPoints(obtainedUserInfo.getUserBonusPoints());
			return tempUserInfo;
		}
	}

	@Override
	public UserInfo getUserInfoByUserId(Integer userId) {
		if (userId == null) {
			throw new RuntimeException("userId为空");
		} else {
			UserInfo obtainedUserInfo = userInfoMapper.selectByPrimaryKey(userId);
			obtainedUserInfo.setUserWxopenid(null);

			return obtainedUserInfo;
		}
	}

	@Override
	public boolean checkBriefInfoComplete(Integer userId) {

		if (userId == null) {
			throw new RuntimeException("userId为空");
		} else {
			UserInfo obtainedUserInfo = userInfoMapper.selectByPrimaryKey(userId);

			if (obtainedUserInfo != null && !MyStringUtil.isEmpty(obtainedUserInfo.getUserName())
					&& !MyStringUtil.isEmpty(obtainedUserInfo.getUserAvatarUrl())) {
			}
			return false;
		}
	}

	@Override
	public String getPhoneByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return userInfoMapper.selectByPrimaryKey(userId).getUserPhone();
	}

}
