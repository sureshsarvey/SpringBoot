package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.vo.LineItem;

public interface LineItemRepo extends JpaRepository<LineItem, Integer>
{

}
