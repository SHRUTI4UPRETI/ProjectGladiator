package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.model.Customer;
@Repository
public class CustomerRepoImpl implements CustomerRepo {

	@PersistenceContext
	EntityManager em;
	Customer customer;
	@Transactional
	public int addNewCustomer(Customer customer) {
		Customer c = em.merge(customer);
		return c.getCustomerId();
	}
	@Transactional
	public boolean updateCustomer(Customer customer) {
		if(em.find(Customer.class, customer.getCustomerId()) != null)
        {
           // tx.begin();
            em.merge(customer);
           // tx.commit();
            return true;
        }
        else
            return false;
	}

	public boolean isValidCustomer(int customerId, String customerPassword) {
		// TODO Auto-generated method stub
		return false;
	}

}
