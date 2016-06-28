package com.zamunda.cinema.repository;

import java.util.List;

import com.zamunda.cinema.model.Hall;

public interface UserRepository {
	public Long addUser();

	public List<Hall> getHalls();
}
