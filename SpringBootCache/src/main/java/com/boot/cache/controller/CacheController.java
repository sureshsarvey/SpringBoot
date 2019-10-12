package com.boot.cache.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.cache.service.CacheService;

@RestController	
@RequestMapping("/cache")
public class CacheController {
	
	@Autowired
	private CacheService service;
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/users")
	public ResponseEntity<Object> getUsers(){
		try {
			List l = service.getUsers();
			return ResponseEntity.ok().body(l);
		}catch(Exception e)
		{
			System.out.println(e);
			return ResponseEntity.badRequest().body(null);
		}
		
	}
	
}
