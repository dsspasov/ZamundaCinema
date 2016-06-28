package com.zamunda.cinema.service;

import java.util.List;

import com.zamunda.cinema.model.Hall;

//example of service
public interface UserService {
	public Long addUser(); // 1st create a Model User and a DB
	public List<Hall> getHalls();
}
