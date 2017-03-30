package com.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

//POJO Class for Comment

@Entity
@Table(name = "CommentsData")
@Component
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer parent;
	private Date created;
	private Date modified;
	private String content;
	private Integer pings;
	private Integer creator;
	private String fullname;
	private String profile_picture_url;
	private boolean created_by_admin;
	private boolean created_by_current_user;
	private Integer upvote_count;
	private boolean user_has_upvote;
	@Transient
	private List<Link> links = new ArrayList<Link>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getPings() {
		return pings;
	}

	public void setPings(Integer pings) {
		this.pings = pings;
	}

	public Integer getCreator() {
		return creator;
	}

	public void setCreator(Integer creator) {
		this.creator = creator;
	}

	public boolean isCreated_by_admin() {
		return created_by_admin;
	}

	public void setCreated_by_admin(boolean created_by_admin) {
		this.created_by_admin = created_by_admin;
	}

	public boolean isCreated_by_current_user() {
		return created_by_current_user;
	}

	public void setCreated_by_current_user(boolean created_by_current_user) {
		this.created_by_current_user = created_by_current_user;
	}

	public Integer getUpvote_count() {
		return upvote_count;
	}

	public void setUpvote_count(Integer upvote_count) {
		this.upvote_count = upvote_count;
	}

	public boolean isUser_has_upvote() {
		return user_has_upvote;
	}

	public void setUser_has_upvote(boolean user_has_upvote) {
		this.user_has_upvote = user_has_upvote;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getProfile_picture_url() {
		return profile_picture_url;
	}

	public void setProfile_picture_url(String profile_picture_url) {
		this.profile_picture_url = profile_picture_url;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public List<Link> addCommentLink(String href, String rel) {

		Link link = new Link();
		link.setRel(rel);
		link.setHref(href);
		links.add(link);
		return links;
	}

}
