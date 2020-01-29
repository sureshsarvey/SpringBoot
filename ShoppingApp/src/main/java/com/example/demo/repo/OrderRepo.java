package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.vo.Order;

public interface OrderRepo extends JpaRepository<Order, Integer>
{

}
