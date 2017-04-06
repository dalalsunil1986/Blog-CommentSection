package com.model.comment;

public class Message {

	private String content;
	private Date date;
	private Integer upvote_count;
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

	public Integer getUpvote_count() {
		return upvote_count;
	}

	public void setUpvote_count(Integer upvote_count) {
		this.upvote_count = upvote_count;
	}

}
