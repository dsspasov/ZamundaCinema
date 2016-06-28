package com.zamunda.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zamunda.cinema.model.Hall;
import com.zamunda.cinema.repository.UserRepository;

@Transactional
@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserRepository ur;
	
	@Override
	public Long addUser() {
		// TODO Auto-generated method stub
		return ur.addUser();
	}

	@Override
	public List<Hall> getHalls() {
		// TODO Auto-generated method stub
		return ur.getHalls();
	}

}
