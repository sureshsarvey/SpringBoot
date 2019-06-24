package com.boot.database.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.database.model.User;
import com.boot.database.test.model.Employee;
import com.boot.database.test2repository.UserRepository;
import com.boot.database.testrepo.EmployeeRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
   
	@Transactional(value = "transactionManager")
	public boolean processLogin(String userId,String password)
	{
		User user = userRepository.getOne(userId);
		if(password.equalsIgnoreCase(user.getPassword()))
		{
			return true;
		}
		return false;
	}
	
	@Transactional(value = "bartransactionManager")
	public Employee getEmployee()
	{
		try
		{
			return employeeRepository.findAll().get(0);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Transactional(value = "bartransactionManager")
	public void registerEmployee(Employee emp) {
		// TODO Auto-generated method stub
		  try {
			  employeeRepository.save(emp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
