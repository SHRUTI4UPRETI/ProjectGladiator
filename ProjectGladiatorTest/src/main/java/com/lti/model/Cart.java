package com.lti.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_cart1")
public class Cart {
	
	@Id
	@SequenceGenerator(name = "seq_cart1", initialValue = 40001, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cart1")
	private int cartId;
	
	@Column
	private int cartQuantity;   //item quantity total
	
	@Column
	private boolean cartStatus;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	
	@OneToMany(mappedBy="Cart", cascade=CascadeType.ALL)
	private List<Items> item;
	
	@OneToOne(mappedBy="Cart", cascade=CascadeType.ALL)
	private Order order;
	 

}
