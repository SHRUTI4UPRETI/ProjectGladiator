package com.lti.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.controller.CustomerController;
import com.lti.model.Customer;

public class CustomerTest {

	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
	CustomerController controller = ctx.getBean(CustomerController.class);
	
	Customer customer = new Customer();

	@Test
	public void addNewCustomer() {
	
		
		customer.setCustomerName("Emma");
		customer.setCustomerPassword("emma123");
		customer.setCustomerEmail("emma@xyz");
		customer.setCustomerMobile(811145674);
		customer.setCustomerAddress("St..");
		
		int id=controller.addCustomer(customer);
		System.out.println("User Id : "+id);
		}

}
