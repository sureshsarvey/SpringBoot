package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CustomerService;
import com.example.demo.service.IngradinetService;
import com.example.demo.vo.Customer;
import com.example.demo.vo.Ingradinet;
import com.example.demo.vo.LineItem;
import com.example.demo.vo.Order;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@Autowired
	private IngradinetService ingService;
	
	@PostMapping("/saveOrder")
	public ResponseEntity<Object> saveOrder()
	{
		
		try
		{
		Customer customer =new Customer();
		customer.setCustomerName("Suresh");
		
		Order order = new Order();
		order.setShippingCity("Hyderabad");
		
		LineItem item = new LineItem();
		item.setIngr(ingService.findById(2));
		item.setCount(2);
		
		LineItem item1 = new LineItem();
		item.setIngr(ingService.findById(3));
		item.setCount(5);
		
		List<LineItem> list = new ArrayList<LineItem>();
		list.add(item);
		list.add(item1);
		
		order.setLineItems(list);
		
		List<Order> orders = new ArrayList<Order>();
		orders.add(order);
		
		customer.setOrders(orders);
		
		service.saveCustomer(customer);
		
		return ResponseEntity.ok().body(null);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@PostMapping("/saveIng")
	public ResponseEntity<Object> saveIng()
	{
		try {
			
			Ingradinet in = new Ingradinet();
			in.setItemName("Apple");
			in.setPrice("200");
			ingService.saveIngradinet(in);
			return ResponseEntity.ok().body(null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping("/customers")
	public ResponseEntity<Object> getCustomers()
	{
		try {
			
			List<Customer> customers = service.getCustomers();
			return ResponseEntity.ok().body(customers);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
