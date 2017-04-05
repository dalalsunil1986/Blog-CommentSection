package com.model1;

public class Message {

	private String content;
	private Date date;
	private Integer up_count;
	private Integer pings;

	public Integer getPings() {
		return pings;
	}

	public void setPings(Integer pings) {
		this.pings = pings;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getUp_count() {
		return up_count;
	}

	public void setUp_count(Integer up_count) {
		this.up_count = up_count;
	}

}
