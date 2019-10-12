package com.boot.cache.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
@Service
public class CacheService {
	
	@Cacheable(value = "ten-second-cache",key = "#root.methodName")
	public List getUsers() throws InterruptedException
	{
		Thread.sleep(5000);
		List l = new ArrayList();
		l.add(10);
		l.add("Suresh");
		l.add("25000");
		return l;
	}

}
