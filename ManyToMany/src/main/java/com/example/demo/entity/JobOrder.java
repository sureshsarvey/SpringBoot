package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "many_job_order")
public class JobOrder {
	
	@Id
	@GeneratedValue
	@Column(name = "order_id")
	private Integer jobOrderId;
	
	@Column
	private String client;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "joborder_user",joinColumns = @JoinColumn(name = "order_id",referencedColumnName = "order_id" ),
	inverseJoinColumns = @JoinColumn(name = "user_id",referencedColumnName = "user_id"))
	private List<User> users;

	public Integer getJobOrderId() {
		return jobOrderId;
	}

	public void setJobOrderId(Integer jobOrderId) {
		this.jobOrderId = jobOrderId;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
   
}
