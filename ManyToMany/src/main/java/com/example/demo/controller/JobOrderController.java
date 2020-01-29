package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.engine.transaction.jta.platform.internal.JOnASJtaPlatform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.JobOrder;
import com.example.demo.entity.User;
import com.example.demo.service.JobOrderService;

@RestController
public class JobOrderController {
	
	@Autowired
	private JobOrderService jobService;
	
	@PostMapping("/saveJobOrder")
	public ResponseEntity<Object> saveJobOrder()
	{
		try {

			JobOrder j = new JobOrder();
			j.setClient("BA");

			User u = new User();
			u.setUserName("suresh");
			u.setUserId("ssarvey");

			User u1 = new User();
			u1.setUserId("vnarani");
			u1.setUserName("venkat");

			List<User> users = new ArrayList<User>();
			users.add(u);
			users.add(u1);

			j.setUsers(users);

			jobService.saveJobOrder(j);

			return ResponseEntity.ok().body("success");

		} catch (Exception e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping("/getJobOrder/{id}")
	public ResponseEntity<Object> getJobOrderById(@PathVariable("id") String id) {
		try {
			List<Object[]> list = jobService.getJobOrder(id);
			java.util.Iterator<Object[]> itr = list.iterator();
			//List<JobOrder> jobOrders = new ArrayList<JobOrder>();
			Map<Integer,JobOrder> map = new HashMap<Integer,JobOrder>();
			JobOrder j = new JobOrder();
			List<User> users = new ArrayList<User>();
			while(itr.hasNext())
			{
				Object[] obj = itr.next();
				Integer jobOrderId = Integer.valueOf(obj[0].toString());
				j.setJobOrderId(jobOrderId);
				User user = (User) obj[1];
				users.add(user);
			}
			j.setUsers(users);
			return ResponseEntity.ok().body(j);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}
	
	@GetMapping("/getJobOrders/{id}")
	public ResponseEntity<Object> getJobOrdersById(@PathVariable("id") String id) {
		try {
			JobOrder job = jobService.getJobOrders(id);
			return ResponseEntity.ok().body(job);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

}
