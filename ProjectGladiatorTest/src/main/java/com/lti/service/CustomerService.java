package com.lti.service;

import com.lti.model.Customer;

public interface CustomerService {
	public int addNewCustomer(Customer customer);
	boolean updateCustomer(Customer customer);
	boolean isValidCustomer(int customerId, String customerPassword);
}
