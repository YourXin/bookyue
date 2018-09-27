package com.bookyue.model;

public class OrderQueryVo {

	// 用户id
	private Integer userId;
	// 订单状态
	private Byte status;
	
	// 不考虑状态查询所有订单
	private boolean queryMyAll;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public boolean isQueryMyAll() {
		return queryMyAll;
	}

	public void setQueryMyAll(boolean queryMyAll) {
		this.queryMyAll = queryMyAll;
	}

}
