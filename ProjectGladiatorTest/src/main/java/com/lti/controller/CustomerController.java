package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lti.model.Cart;
import com.lti.model.Customer;
import com.lti.model.Items;
import com.lti.model.Order;
import com.lti.model.Product;
import com.lti.model.Retailer;
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

	public boolean isValidCustomer(String customerEmail, String customerPassword) {
		return serv.isValidCustomer(customerEmail, customerPassword);
	}

	public int addNewProduct(List<Product> products, int retailerId) {
		return serv.addNewProduct(products, retailerId);
	}

	boolean updateProduct(Product product) {
		return serv.updateProduct(product);
	}

	boolean approveProduct(int productId) {
		return serv.approveProduct(productId);
	}

	boolean removeProduct(int productId) {
		return serv.removeProduct(productId);
	}

	public List<Product> viewAllProducts() {
		return serv.viewAllProducts();
	}

	public Product searchProductById(int productId) {
		return serv.searchProductById(productId);
	}

	public int addNewRetailer(Retailer retailer) {
		return serv.addNewRetailer(retailer);
	}

	public int addCart(List<Cart> carts, int customerId) {
		return serv.addCart(carts, customerId);
	}

	public int addItem(List<Items> items, int cartId, int productId) {
		return serv.addItem(items, cartId, productId);
	}
	
	public int placeOrderforCustomer(Order order, int cartId){
		return serv.placeOrderforCustomer(order, cartId);
	}
	
	public List<Items> displayProductByUserId(int customerId){
		return serv.displayProductByUserId(customerId);
	}
}
