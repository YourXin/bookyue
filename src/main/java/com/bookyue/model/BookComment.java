package com.bookyue.model;

import java.util.Date;

public class BookComment {
    private Integer commentId;

    private Integer commentBookId;

    private String commentContent;

    private Date commentTime;

    private Integer userId;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getCommentBookId() {
        return commentBookId;
    }

    public void setCommentBookId(Integer commentBookId) {
        this.commentBookId = commentBookId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

	@Override
	public String toString() {
		return "BookComment [commentId=" + commentId + ", commentBookId=" + commentBookId + ", commentContent="
				+ commentContent + ", commentTime=" + commentTime + ", userId=" + userId + "]";
	}
    
    
}