package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.JobOrder;
import com.example.demo.repo.JobOrderRepository;
import com.example.demo.service.JobOrderService;

@Service
public class JobOrderServiceImpl implements JobOrderService
{
	@Autowired
	private JobOrderRepository jobRepo;

	@Override
	public void saveJobOrder(JobOrder job) {
		// TODO Auto-generated method stub
		jobRepo.save(job);
	}

	@Override
	public List<Object[]> getJobOrder(String id) {
		return jobRepo.findJobOrderById(Integer.valueOf(id));
	}
	
	@Override
	public JobOrder getJobOrders(String id) {
		return jobRepo.findJobOrdersById(Integer.valueOf(id));
	}

}
