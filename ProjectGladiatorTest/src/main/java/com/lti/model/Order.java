package com.lti.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "tbl_order1")
public class Order {
	
	@Id
	@SequenceGenerator(name = "seq_order1", initialValue = 50001, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_order1")
	private int orderId;
	
	@Column
	private double orderTotalPrice;
	
	@Column
	private LocalDate orderDate;
	
	@OneToOne
	@JoinColumn(name="cartId")
	private Cart cart;

}
