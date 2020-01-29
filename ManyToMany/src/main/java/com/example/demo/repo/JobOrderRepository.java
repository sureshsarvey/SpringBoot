package com.example.demo.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.JobOrder;

@Repository
public interface JobOrderRepository extends JpaRepository<JobOrder,Integer>
{
	 @Query("select j.jobOrderId,ju from JobOrder j join fetch j.users ju where j.jobOrderId = :id and ju.userId = 'vnarani'")
     public List<Object[]> findJobOrderById(@Param("id") Integer id);
     
     @Query("from JobOrder j where j.jobOrderId = :id")
     public JobOrder findJobOrdersById(@Param("id") Integer id);
}
