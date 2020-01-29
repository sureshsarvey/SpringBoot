package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.CustomerRepository;
import com.example.demo.service.CustomerService;
import com.example.demo.vo.Customer;

@Service
public class CustomerServiceImpl implements CustomerService 
{
	@Autowired
   private CustomerRepository repository;
	
	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		repository.save(customer);
	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
   
}
