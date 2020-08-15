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

import org.springframework.stereotype.Component;

@Entity
@Table(name = "tbl_retailer1")
public class Retailer {

	@Id
	@SequenceGenerator(name = "seq_retailer1", initialValue = 60001, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_retailer1")
	private int retailerId;
	@Column
	private String retailerName;
	@Column
	private String retailerEmail;
	@Column
	private String retailerPassword;
	@Column
	private int retailerMobile;

	@OneToMany(mappedBy = "Retailer", cascade = CascadeType.ALL)
	private List<Product> products;

}
