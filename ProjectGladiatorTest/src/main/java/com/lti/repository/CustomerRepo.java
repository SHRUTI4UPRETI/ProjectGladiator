package com.lti.repository;

import com.lti.model.Customer;

public interface CustomerRepo {

	public int addNewCustomer(Customer customer);
	boolean updateCustomer(Customer customer);
	boolean isValidCustomer(int customerId, String customerPassword);
	
	
}
