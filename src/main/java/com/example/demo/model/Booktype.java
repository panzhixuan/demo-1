package com.example.demo.model;


public class Booktype {
    private Integer booktypeId;

	private String booktypeName;

	public Integer getBooktypeId() {
		return booktypeId;
	}

	public void setBooktypeId(Integer booktypeId) {
		this.booktypeId = booktypeId;
	}

	public String getBooktypeName() {
		return booktypeName;
	}

	public void setBooktypeName(String booktypeName) {
		this.booktypeName = booktypeName == null ? null : booktypeName.trim();
	}
}