package com.example.demo.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "line_item")
public class LineItem implements Serializable
{

	@Id
	@GeneratedValue
	@Column(name ="line_item_id")
	private Integer lineItemNumber;
	
	@ManyToOne
	@JoinColumn(name = "item_id",referencedColumnName = "item_id")
	private Ingradinet ingr;
	
	@Column
	private Integer count;

	public Integer getLineItemNumber() {
		return lineItemNumber;
	}

	public void setLineItemNumber(Integer lineItemNumber) {
		this.lineItemNumber = lineItemNumber;
	}

	public Ingradinet getIngr() {
		return ingr;
	}

	public void setIngr(Ingradinet ingr) {
		this.ingr = ingr;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
