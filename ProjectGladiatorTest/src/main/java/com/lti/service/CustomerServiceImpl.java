package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.model.Customer;
import com.lti.repository.CustomerRepo;
import com.lti.repository.CustomerRepoImpl;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepo repo;
	public int addNewCustomer(Customer customer) {
	
		return repo.addNewCustomer(customer);
	}

	public boolean updateCustomer(Customer customer) {
	
		return repo.updateCustomer(customer);
	}

	public boolean isValidCustomer(int customerId, String customerPassword) {
		// TODO Auto-generated method stub
		return repo.isValidCustomer(customerId, customerPassword);
	}

}
