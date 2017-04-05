package com.model1;

public class CommentData {

	private Integer commentId;
	private boolean created_by_current_user;
	private boolean created_by_admin;
	private boolean user_has_upvote;
	private Integer parent;
	private Creator creator;
	private Author author;
	private Message message;
	private Avatar avatar;

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

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public Creator getCreator() {
		return creator;
	}

	public void setCreator(Creator creator) {
		this.creator = creator;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

}
