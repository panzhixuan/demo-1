package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Date;

public class Book {
    private Integer bookId;

	private String bookName;

	private Integer bookType;

	private Integer salerId;

	private String bookImage;

	private String bookAuthor;

	private String bookVersion;

	private Date bookModifytime;

	private BigDecimal bookPrice;

	private BigDecimal bookOriginalprice;

	private Integer bookFlag;

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

	public Integer getBookType() {
		return bookType;
	}

	public void setBookType(Integer bookType) {
		this.bookType = bookType;
	}

	public Integer getSalerId() {
		return salerId;
	}

	public void setSalerId(Integer salerId) {
		this.salerId = salerId;
	}

	public String getBookImage() {
		return bookImage;
	}

	public void setBookImage(String bookImage) {
		this.bookImage = bookImage == null ? null : bookImage.trim();
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor == null ? null : bookAuthor.trim();
	}

	public String getBookVersion() {
		return bookVersion;
	}

	public void setBookVersion(String bookVersion) {
		this.bookVersion = bookVersion == null ? null : bookVersion.trim();
	}

	public Date getBookModifytime() {
		return bookModifytime;
	}

	public void setBookModifytime(Date bookModifytime) {
		this.bookModifytime = bookModifytime;
	}

	public BigDecimal getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(BigDecimal bookPrice) {
		this.bookPrice = bookPrice;
	}

	public BigDecimal getBookOriginalprice() {
		return bookOriginalprice;
	}

	public void setBookOriginalprice(BigDecimal bookOriginalprice) {
		this.bookOriginalprice = bookOriginalprice;
	}

	public Integer getBookFlag() {
		return bookFlag;
	}

	public void setBookFlag(Integer bookFlag) {
		this.bookFlag = bookFlag;
	}

}