package com.model;

public class Author {

	private String name;
	private Href via;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Href getHref() {
		return via;
	}

	public void setHref(Href href) {
		this.via = href;
	}

}
