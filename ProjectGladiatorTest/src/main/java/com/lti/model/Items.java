package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "tbl_item1")
public class Items {
	
	@Id
	@SequenceGenerator(name = "seq_item1", initialValue = 30001, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_item1")
	private int itemId;
	
	@Column
	private int itemQuantity;
	@Column
	private int itemTotalPrice;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="productId")
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cartId")
	private Cart cart;
	

}
