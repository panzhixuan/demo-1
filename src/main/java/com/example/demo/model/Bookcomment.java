package com.example.demo.model;


public class Bookcomment {
    private Integer commentId;

	private Integer bookId;

	private Integer userId;

	private String commentText;

	private String commentModifytime;

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText == null ? null : commentText.trim();
	}

	public String getCommentModifytime() {
		return commentModifytime;
	}

	public void setCommentModifytime(String commentModifytime) {
		this.commentModifytime = commentModifytime;
	}

}