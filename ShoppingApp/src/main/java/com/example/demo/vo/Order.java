package com.example.demo.vo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "test_order")
public class Order {
	
	@Id
	@GeneratedValue
	@Column(name = "order_id")
	private Integer orderId;
	
	@Column(name = "shipping_city")
	private String shippingCity;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id_fk",referencedColumnName = "order_id")
	private List<LineItem> lineItems;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getShippingCity() {
		return shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	
	
	

}
