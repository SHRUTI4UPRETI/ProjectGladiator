package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_admin1")
public class Admin {
	
	@Column
	private String adminEmail;
	@Column
	private String adminPassword;

}
