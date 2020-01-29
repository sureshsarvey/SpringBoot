package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.JobOrder;

public interface JobOrderService {

	public void saveJobOrder(JobOrder joborder);
	
	public List<Object[]> getJobOrder(String id);
	
	public JobOrder getJobOrders(String id);
}
