package com.lti.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.controller.CustomerController;
import com.lti.model.Cart;
import com.lti.model.Customer;
import com.lti.model.Items;
import com.lti.model.Product;
import com.lti.model.Retailer;


public class CustomerTest {

	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
	CustomerController controller = ctx.getBean(CustomerController.class);

	Customer customer = new Customer();
	Product product=new Product();
	Retailer retailer=new Retailer();
	Cart cart = new Cart();
	Items item = new Items();

	@Test
	public void addNewCustomer() {

		customer.setCustomerName("Emma");
		customer.setCustomerPassword("emma123");
		customer.setCustomerEmail("emma@xyz");
		customer.setCustomerMobile(811145674);
		customer.setCustomerAddress("St..");

		int id = controller.addCustomer(customer);
		System.out.println("User added with Id : " + id);
	}

	@Test
	public void updateCustomer() {

		customer.setCustomerId(10001);
		customer.setCustomerName("Mark");
		customer.setCustomerPassword("emma123");
		customer.setCustomerEmail("emma@xyz");
		customer.setCustomerMobile(811145674);
		customer.setCustomerAddress("St..");

		boolean id = controller.updateCustomer(customer);
		System.out.println(id);
	}

	@Test
	public void isValidCustomer() {
		
		System.out.println(controller.isValidCustomer("emma@xyz", "emma123"));
	}
	
	
	
	@Test
	public void addNewProduct() {

		product.setProductName("Black Shirt");
		product.setProductCategory("Men");
		product.setProductSubCategory("Shirts");
		product.setProductBrandName("Arrow");
		product.setProductDescription("This is a Black shirt");
		product.setProductPrice(2000);
		product.setProductQuantity(10);
		product.setProductImagePath("/assets/abc.jpg");
		product.setProductApproved(true);
		
		List<Product> products=new ArrayList<Product>();
		products.add(product);

	/*	retailer.setRetailerId(60003);
		product.setRetailer(retailer);*/
		
		int id = controller.addNewProduct(products, 60001);
		if(id>0)
			System.out.println("Product added");
		else
			System.out.println("Not added");
	}

	
	@Test
	public void addNewRetailer(){
		retailer.setRetailerName("div");
		retailer.setRetailerEmail("div@lti");
		retailer.setRetailerMobile(98465165);
		retailer.setRetailerPassword("div@123");

		
		int id=controller.addNewRetailer(retailer);
		System.out.println("Retailer added with ID: "+id);
	}
	
	@Test
	public void searchProductById(){
		System.out.println(controller.searchProductById(20200));
	}
	
	@Test
	public void viewAllProducts(){
		System.out.println(controller.viewAllProducts());
	}
	
	@Test
	public void addItem(){
		
		List<Items> items = new ArrayList<Items>();
		item.setItemQuantity(2);
		item.setItemTotalPrice(1000);
		items.add(item);
		int id = controller.addItem(items, 40000, 20200);
		System.out.println("User items added with Id : " + id);
		
	}
	
	@Test
	public void addCart(){
		
		List<Cart> carts = new ArrayList<Cart>();
		
		cart.setCartQuantity(5);
		cart.setCartStatus(true);
		carts.add(cart);
		int id = controller.addCart(carts, 10001);
		System.out.println("User cart added with Id : " + id);
		
		
	}
	
}
