package com.zamunda.cinema.model;

import java.util.List;

import org.joda.time.Minutes;

public class Film {
	private Long id;
	private String name;
	private Minutes length;
	private String description;
	private List<String> types;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

}
