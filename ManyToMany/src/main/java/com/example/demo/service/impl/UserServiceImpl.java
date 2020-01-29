package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.UserService;

public class UserServiceImpl implements  UserService

{
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
	}

}
