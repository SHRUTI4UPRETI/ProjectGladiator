package com.lti.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="tbl_product1")
public class Product {

	@Id
	@SequenceGenerator(name = "seq_product1", initialValue = 10001, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product1")
	private int productId;
	
	@Column
	private String productName;
	@Column
	private String productBrandName;
	@Column
	private int productPrice;
	@Column
	private int productQuantity;
	@Column
	private String productCategory;
	@Column
	private String productSubCategory;
	@Column
	private String productDescription;
	@Column
	private String productImagePath;
	@Column
	private boolean isProductApproved;
	
	@ManyToOne
	@JoinColumn(name="retailerId")
	private Retailer retailer;
	
	@OneToOne(mappedBy="Product", cascade=CascadeType.ALL)
	private Items item;
	
}
