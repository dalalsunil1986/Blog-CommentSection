package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Elements {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer elementId;

	private String authorName;
	private String content;
	private String creationDate;
	private boolean isFlagged;
	private boolean systemGenerated;
	private String type;

	@Transient
	private Author author;
	@Transient
	private Href self;
	@Transient
	private Tags tagAssignments;

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Href getSelf() {
		return self;
	}

	public void setSelf(Href self) {
		this.self = self;
	}

	public Tags getTagAssignments() {
		return tagAssignments;
	}

	public void setTagAssignments(Tags tagAssignments) {
		this.tagAssignments = tagAssignments;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Integer getElementId() {
		return elementId;
	}

	public void setElementId(Integer elementId) {
		this.elementId = elementId;
	}

	public String getAuthor() {
		return authorName;
	}

	public void setAuthor(String author) {
		this.authorName = author;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
