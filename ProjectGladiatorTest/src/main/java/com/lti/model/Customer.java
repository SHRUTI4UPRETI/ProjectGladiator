package com.lti.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_customer1")
public class Customer {

	@Id
	@SequenceGenerator(name = "seq_customer1", initialValue = 20001, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_customer1")
	private int customerId;
	@Column
	private String customerName;
	@Column
	private String customerEmail;
	@Column
	private String customerPassword;
	@Column
	private String customerAddress;
	@Column
	private int customerMobile;
	
	@OneToMany(mappedBy="Customer", cascade=CascadeType.ALL)
	private List<Cart> cart;
}
