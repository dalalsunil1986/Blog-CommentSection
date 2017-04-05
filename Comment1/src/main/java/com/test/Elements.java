package com.test;

import java.sql.Date;

public class Elements {

	private String type;
	private Href self;
	private String content;
	private String creationDate;
	private Author author;
	private boolean isFlagged;
	private boolean systemGenerated;
	private Tags tagAssignment;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Href getSelf() {
		return self;
	}

	public void setSelf(Href self) {
		this.self = self;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public boolean isFlagged() {
		return isFlagged;
	}

	public void setFlagged(boolean isFlagged) {
		this.isFlagged = isFlagged;
	}

	public boolean isSystemGenerated() {
		return systemGenerated;
	}

	public void setSystemGenerated(boolean systemGenerated) {
		this.systemGenerated = systemGenerated;
	}

	public Tags getTagAssignment() {
		return tagAssignment;
	}

	public void setTagAssignment(Tags tagAssignment) {
		this.tagAssignment = tagAssignment;
	}

}
