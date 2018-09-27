package com.bookyue.model;

public class UserInfoCustom extends UserInfo{
	
	private String sessionId;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public UserInfoCustom() {
		super();
	}

	@Override
	public String toString() {
		return "UserCustom [sessionId=" + sessionId + ", toString()=" + super.toString() + "]";
	}
	
}
