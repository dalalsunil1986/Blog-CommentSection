package com.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Transient
	private Href self;
	@Transient
	private List<Elements> elements = new ArrayList<Elements>();
	@Transient
	private Href next;

	public Href getSelf() {
		return self;
	}

	public void setSelf(Href self) {
		this.self = self;
	}

	public List<Elements> getElements() {
		return elements;
	}

	public void setElements(List<Elements> elements) {
		this.elements = elements;
	}

	public Href getNext() {
		return next;
	}

	public void setNext(Href next) {
		this.next = next;
	}

}
