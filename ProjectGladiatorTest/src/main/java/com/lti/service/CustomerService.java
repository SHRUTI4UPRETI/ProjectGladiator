package com.lti.service;

import java.util.List;

import com.lti.model.Cart;
import com.lti.model.Customer;
import com.lti.model.Items;
import com.lti.model.Order;
import com.lti.model.Product;
import com.lti.model.Retailer;

public interface CustomerService {
	public int addNewCustomer(Customer customer);

	boolean updateCustomer(Customer customer);

	boolean isValidCustomer(String customerEmail, String customerPassword);

	public int addNewProduct(List<Product> products, int retailerId);

	boolean updateProduct(Product product);

	boolean approveProduct(int productId);

	boolean removeProduct(int productId);

	List<Product> viewAllProducts();

	Product searchProductById(int productId);

	public int addNewRetailer(Retailer retailer);

	public int addCart(List<Cart> carts, int customerId);

	public int addItem(List<Items> items, int cartId, int productId);
	
	public int placeOrderforCustomer(Order order, int cartId);
	
	public List<Items> displayProductByUserId(int customerId);
}
