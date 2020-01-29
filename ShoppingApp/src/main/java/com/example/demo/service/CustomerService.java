package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.Customer;

public interface CustomerService {

	public void saveCustomer(Customer customer);
	
	public List<Customer> getCustomers();
}
