package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lti.model.Customer;
import com.lti.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	CustomerService serv;
	
	public int addCustomer(Customer customer) {
		return serv.addNewCustomer(customer);
	}
	
	public boolean updateCustomer(Customer customer) {
		return serv.updateCustomer(customer);
	}
	public boolean isValidCustomer(int customerId, String customerPassword) {
		return serv.isValidCustomer(customerId, customerPassword);
	}
}
