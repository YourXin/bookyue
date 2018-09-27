package com.bookyue.model;

import java.math.BigDecimal;
import java.util.Date;

public class OrderInfo {
    private Integer id;

    private Integer bookId;

    private Short bookAmount;

    private BigDecimal bookPrice;

    private String bookName;

    private String bookAuthor;

    private String bookPicPath;
    
    private String bookPublisher;

    private Integer buyerUserId;

    private BigDecimal totalPrice;

    private Integer sellerUserId;

    private Byte status;

    private Date createTime;

    private Date completeTime;

    private Short cancleCause;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Short getBookAmount() {
        return bookAmount;
    }

    public void setBookAmount(Short bookAmount) {
        this.bookAmount = bookAmount;
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
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

    public Integer getBuyerUserId() {
        return buyerUserId;
    }

    public void setBuyerUserId(Integer buyerUserId) {
        this.buyerUserId = buyerUserId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getSellerUserId() {
        return sellerUserId;
    }

    public void setSellerUserId(Integer sellerUserId) {
        this.sellerUserId = sellerUserId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public Short getCancleCause() {
        return cancleCause;
    }

    public void setCancleCause(Short cancleCause) {
        this.cancleCause = cancleCause;
    }

	public String getBookPicPath() {
		return bookPicPath;
	}

	public void setBookPicPath(String bookPicPath) {
		this.bookPicPath = bookPicPath;
	}
    
}