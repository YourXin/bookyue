package com.bookyue.model;

import java.math.BigDecimal;
import java.util.Date;

public class BookCollect {
    private Integer id;

    private Integer userId;

    private Integer bookId;

    private String bookName;

    private String bookPicPath;

    private BigDecimal bookSellPrice;

    private BigDecimal bookPrimePrice;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getBookPicPath() {
        return bookPicPath;
    }

    public void setBookPicPath(String bookPicPath) {
        this.bookPicPath = bookPicPath == null ? null : bookPicPath.trim();
    }

    public BigDecimal getBookSellPrice() {
        return bookSellPrice;
    }

    public void setBookSellPrice(BigDecimal bookSellPrice) {
        this.bookSellPrice = bookSellPrice;
    }

    public BigDecimal getBookPrimePrice() {
        return bookPrimePrice;
    }

    public void setBookPrimePrice(BigDecimal bookPrimePrice) {
        this.bookPrimePrice = bookPrimePrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	@Override
	public String toString() {
		return "BookCollect [id=" + id + ", userId=" + userId + ", bookId=" + bookId + ", bookName=" + bookName
				+ ", bookPicPath=" + bookPicPath + ", bookSellPrice=" + bookSellPrice + ", bookPrimePrice="
				+ bookPrimePrice + ", createTime=" + createTime + "]";
	}
    
    
}