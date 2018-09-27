package com.bookyue.model;

import java.math.BigDecimal;
import java.util.Date;

public class BookPublish {
	
	/**
	 * 书籍id
	 */
    private Integer bookId;

    /**
     * ISBN
     */
    private String bookIsbn;

    /**
     * 书名
     */
    private String bookName;

    /**
     * 书籍原价
     */
    private BigDecimal bookPrimePrice;

    /**
     * 书籍作者
     */
    private String bookAuthor;

    /**
     * 出版社
     */
    private String bookPublisher;

    /**
     * 准备出售/购入的价格
     */
    private BigDecimal bookSellPrice;

    /**
     * 需求或者出售的数量
     */
    private Short bookAmount;

    /**
     * 书籍的图片路径
     */
    private String bookPicPath;

    /**
     * 准备出售/购入的发布者的描述
     */
    private String bookDesc;

    /**
     * 书籍概要信息
     */
    private String summary;
    
    /**
     * 书籍分类id
     */
    private Byte bookTypeId;

    /**
     * 发布者的用户id
     */
    private Integer userId;

    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * 发布类型,1代表卖书,2代表买书
     */
    private Byte publishType;
    
    
    

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn == null ? null : bookIsbn.trim();
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public BigDecimal getBookPrimePrice() {
        return bookPrimePrice;
    }

    public void setBookPrimePrice(BigDecimal bookPrimePrice) {
        this.bookPrimePrice = bookPrimePrice;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor == null ? null : bookAuthor.trim();
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher == null ? null : bookPublisher.trim();
    }

    public BigDecimal getBookSellPrice() {
        return bookSellPrice;
    }

    public void setBookSellPrice(BigDecimal bookSellPrice) {
        this.bookSellPrice = bookSellPrice;
    }

    public Short getBookAmount() {
        return bookAmount;
    }

    public void setBookAmount(Short bookAmount) {
        this.bookAmount = bookAmount;
    }

    public String getBookPicPath() {
        return bookPicPath;
    }

    public void setBookPicPath(String bookPicPath) {
        this.bookPicPath = bookPicPath == null ? null : bookPicPath.trim();
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc == null ? null : bookDesc.trim();
    }

    public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Byte getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(Byte bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Byte getPublishType() {
        return publishType;
    }

    public void setPublishType(Byte publishType) {
        this.publishType = publishType;
    }

	@Override
	public String toString() {
		return "BookPublish [bookId=" + bookId + ", bookIsbn=" + bookIsbn + ", bookName=" + bookName
				+ ", bookPrimePrice=" + bookPrimePrice + ", bookAuthor=" + bookAuthor + ", bookPublisher="
				+ bookPublisher + ", bookSellPrice=" + bookSellPrice + ", bookAmount=" + bookAmount + ", bookPicPath="
				+ bookPicPath + ", bookDesc=" + bookDesc + ", summary=" + summary + ", bookTypeId=" + bookTypeId
				+ ", userId=" + userId + ", publishTime=" + publishTime + ", publishType=" + publishType + "]";
	}

    
}

