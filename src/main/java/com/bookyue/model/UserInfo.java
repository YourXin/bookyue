package com.bookyue.model;

import java.util.Date;

public class UserInfo {
    private Integer userId;

    private String userWxopenid;

    private String userName;

    private Byte userSex;

    private String userPhone;

    private Short userSchoolId;

    private String userMajor;

    private Integer userBonusPoints;

    private Byte userTypeId;

    private String userAvatarUrl;

    private Date userCreateTime;

    private String vertifyCode;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserWxopenid() {
        return userWxopenid;
    }

    public void setUserWxopenid(String userWxopenid) {
        this.userWxopenid = userWxopenid == null ? null : userWxopenid.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Byte getUserSex() {
        return userSex;
    }

    public void setUserSex(Byte userSex) {
        this.userSex = userSex;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public Short getUserSchoolId() {
        return userSchoolId;
    }

    public void setUserSchoolId(Short userSchoolId) {
        this.userSchoolId = userSchoolId;
    }

    public String getUserMajor() {
        return userMajor;
    }

    public void setUserMajor(String userMajor) {
        this.userMajor = userMajor == null ? null : userMajor.trim();
    }

    public Integer getUserBonusPoints() {
        return userBonusPoints;
    }

    public void setUserBonusPoints(Integer userBonusPoints) {
        this.userBonusPoints = userBonusPoints;
    }

    public Byte getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Byte userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserAvatarUrl() {
        return userAvatarUrl;
    }

    public void setUserAvatarUrl(String userAvatarUrl) {
        this.userAvatarUrl = userAvatarUrl == null ? null : userAvatarUrl.trim();
    }

    public Date getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Date userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    public String getVertifyCode() {
        return vertifyCode;
    }

    public void setVertifyCode(String vertifyCode) {
        this.vertifyCode = vertifyCode == null ? null : vertifyCode.trim();
    }

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userWxopenid=" + userWxopenid + ", userName=" + userName + ", userSex="
				+ userSex + ", userPhone=" + userPhone + ", userSchoolId=" + userSchoolId + ", userMajor=" + userMajor
				+ ", userBonusPoints=" + userBonusPoints + ", userTypeId=" + userTypeId + ", userAvatarUrl="
				+ userAvatarUrl + ", userCreateTime=" + userCreateTime + ", vertifyCode=" + vertifyCode + "]";
	}
    
    
}