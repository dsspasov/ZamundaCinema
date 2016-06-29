package com.zamunda.cinema.model;

import org.joda.time.Minutes;

public class Film {
	private long id;
	private String name;
	private Minutes length;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Minutes getLength() {
		return length;
	}

	public void setLength(Minutes length) {
		this.length = length;
	}

}
