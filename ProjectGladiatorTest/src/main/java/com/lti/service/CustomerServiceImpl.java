package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.model.Cart;
import com.lti.model.Customer;
import com.lti.model.Items;
import com.lti.model.Product;
import com.lti.model.Retailer;
import com.lti.repository.CustomerRepo;

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

	public boolean isValidCustomer(String customerEmail, String customerPassword) {
		// TODO Auto-generated method stub
		return repo.isValidCustomer(customerEmail, customerPassword);
	}

	public int addNewProduct(List<Product> products, int retailerId) {
		// TODO Auto-generated method stub
		return repo.addNewProduct(products, retailerId);
	}

	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return repo.updateProduct(product);
	}

	public boolean approveProduct(int productId) {
		// TODO Auto-generated method stub
		return repo.approveProduct(productId);
	}

	public boolean removeProduct(int productId) {
		// TODO Auto-generated method stub
		return repo.removeProduct(productId);
	}

	public List<Product> viewAllProducts() {
		// TODO Auto-generated method stub
		return repo.viewAllProducts();
	}

	public Product searchProductById(int productId) {
		// TODO Auto-generated method stub
		return repo.searchProductById(productId);
	}

	public int addNewRetailer(Retailer retailer) {
		// TODO Auto-generated method stub
		return repo.addNewRetailer(retailer);
	}

	public int addCart(List<Cart> cart, int customerId) {
		return repo.addCart(cart, customerId);
	}

	public int addItem(List<Items> items, int cartId, int productId) {
		return repo.addItem(items, cartId, productId);
	}

}
