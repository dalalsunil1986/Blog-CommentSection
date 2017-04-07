package com.model.comment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer commentId;

	private boolean created_by_current_user;
	private boolean created_by_admin;
	private boolean user_has_upvote;
	private Integer creator;
	private String fullName;
	private String content;
	private String created;
	private String modified;
	private Integer upvote_count;
	private String profile_picture_url;
	private Integer pings;
	private Integer parent;
	private String uniqueId;

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public boolean isCreated_by_current_user() {
		return created_by_current_user;
	}

	public void setCreated_by_current_user(boolean created_by_current_user) {
		this.created_by_current_user = created_by_current_user;
	}

	public boolean isCreated_by_admin() {
		return created_by_admin;
	}

	public void setCreated_by_admin(boolean created_by_admin) {
		this.created_by_admin = created_by_admin;
	}

	public boolean isUser_has_upvote() {
		return user_has_upvote;
	}

	public void setUser_has_upvote(boolean user_has_upvote) {
		this.user_has_upvote = user_has_upvote;
	}

	public Integer getCreator() {
		return creator;
	}

	public void setCreator(Integer creator) {
		this.creator = creator;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public Integer getPings() {
		return pings;
	}

	public void setPings(Integer pings) {
		this.pings = pings;
	}

	public Integer getUpvote_count() {
		return upvote_count;
	}

	public void setUpvote_count(Integer upvote_count) {
		this.upvote_count = upvote_count;
	}

	public String getProfile_picture_url() {
		return profile_picture_url;
	}

	public void setProfile_picture_url(String profile_picture_url) {
		this.profile_picture_url = profile_picture_url;
	}

}
