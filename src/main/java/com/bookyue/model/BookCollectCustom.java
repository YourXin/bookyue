package com.bookyue.model;

import java.math.BigDecimal;

public class BookCollectCustom extends BookCollect {

	// 书名
	private String bookName;
	// 书的图片路径地址
	private String bookPicPath;
	// 书的原价
	private BigDecimal bookPrimePrice;
	// 书的当前卖价
	private BigDecimal bookSellPrice;
	
	// 卖家用户名
	private String sellerUsername;
	// 卖家性别
	private Byte sellerUserSex;
	// 卖家头像路径地址
	private String sellerUserAvatarUrl;
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookPicPath() {
		return bookPicPath;
	}
	public void setBookPicPath(String bookPicPath) {
		this.bookPicPath = bookPicPath;
	}

	public BigDecimal getBookPrimePrice() {
		return bookPrimePrice;
	}

	public void setBookPrimePrice(BigDecimal bookPrimePrice) {
		this.bookPrimePrice = bookPrimePrice;
	}

	public BigDecimal getBookSellPrice() {
		return bookSellPrice;
	}

	public void setBookSellPrice(BigDecimal bookSellPrice) {
		this.bookSellPrice = bookSellPrice;
	}

	public String getSellerUsername() {
		return sellerUsername;
	}

	public void setSellerUsername(String sellerUsername) {
		this.sellerUsername = sellerUsername;
	}

	public Byte getSellerUserSex() {
		return sellerUserSex;
	}

	public void setSellerUserSex(Byte sellerUserSex) {
		this.sellerUserSex = sellerUserSex;
	}

	public String getSellerUserAvatarUrl() {
		return sellerUserAvatarUrl;
	}

	public void setSellerUserAvatarUrl(String sellerUserAvatarUrl) {
		this.sellerUserAvatarUrl = sellerUserAvatarUrl;
	}

}
