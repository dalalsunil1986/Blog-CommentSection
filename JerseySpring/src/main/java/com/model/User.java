package com.model;

import java.util.List;

public class User {

	private String next;
	private List<Elements> elements;
	private String self;

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public List<Elements> getElements() {
		return elements;
	}

	public void setElements(List<Elements> elements) {
		this.elements = elements;
	}

}
