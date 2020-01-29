package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IngradinetRepo;
import com.example.demo.service.IngradinetService;
import com.example.demo.vo.Ingradinet;

@Service
public class IngradinetServiceImpl implements IngradinetService
{
	@Autowired
    private IngradinetRepo repo;
	
	@Override
	public void saveIngradinet(Ingradinet ing) {
		// TODO Auto-generated method stub
		repo.save(ing);
	}

	@Override
	public Ingradinet findById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}
     
}
