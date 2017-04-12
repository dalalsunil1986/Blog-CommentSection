package com.model.user;

import com.model.comment.Avatar;

public class UserData extends ErrorLog {

	private Integer id;
	private Member user;
	private Avatar avatar;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public Member getUser() {
		return user;
	}

	public void setUser(Member user) {
		this.user = user;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

}
