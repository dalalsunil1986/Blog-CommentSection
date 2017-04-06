package com.model.comment;

public class CommentData {

	private Integer id;
	private boolean created_by_current_user;
	private boolean created_by_admin;
	private boolean user_has_upvoted;
	private Integer parent;
	private Author author;
	private Message message;
	private Avatar avatar;
	private Href self;

	public Href getSelf() {
		return self;
	}

	public void setSelf(Href self) {
		this.self = self;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public boolean isUser_has_upvoted() {
		return user_has_upvoted;
	}

	public void setUser_has_upvoted(boolean user_has_upvoted) {
		this.user_has_upvoted = user_has_upvoted;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
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
