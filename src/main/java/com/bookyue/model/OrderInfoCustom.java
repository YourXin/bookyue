package com.bookyue.model;

public class OrderInfoCustom extends OrderInfo {

	private String sellerUserName;
	private String sellerAvatarUrl;

	public String getSellerUserName() {
		return sellerUserName;
	}

	public void setSellerUserName(String sellerUserName) {
		this.sellerUserName = sellerUserName;
	}

	public String getSellerAvatarUrl() {
		return sellerAvatarUrl;
	}

	public void setSellerAvatarUrl(String sellerAvatarUrl) {
		this.sellerAvatarUrl = sellerAvatarUrl;
	}
	
}
