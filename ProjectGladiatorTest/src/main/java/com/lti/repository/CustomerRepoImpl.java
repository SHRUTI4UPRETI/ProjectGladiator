package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.model.Customer;
import com.lti.model.Product;
import com.lti.model.Retailer;

@Repository
public class CustomerRepoImpl implements CustomerRepo {

	@PersistenceContext
	EntityManager em;

	@Transactional
	public int addNewCustomer(Customer customer) {
		Customer customer1 = em.merge(customer);
		int uId = customer1.getCustomerId();
		return uId;
	}

	@Transactional
	public boolean updateCustomer(Customer customer) {
		if (em.find(Customer.class, customer.getCustomerId()) != null) {
			// tx.begin();
			em.merge(customer);
			// tx.commit();
			return true;
		} else
			return false;
	}

	public boolean isValidCustomer(String customerEmail, String customerPassword) {

		String sql = "select cust from Customer cust";
		Query qry = em.createQuery(sql);

		List<Customer> users = qry.getResultList();

		for (Customer u : users) {
			if (u.getCustomerEmail().equals(customerEmail) && customerPassword.equals(u.getCustomerPassword()))
				return true;
		}
		return false;
	}

	@Transactional
	public boolean updateProduct(Product product) {
		if (em.find(Product.class, product.getProductId()) != null) {

			em.merge(product);

			return true;
		} else
			return false;
	}

	public boolean approveProduct(int productId) {
		String sql = ("UPDATE Product pa SET pa.isProductApproved true where pa.productId=:id");
		TypedQuery<Product> qry = em.createQuery(sql, Product.class);

		qry.setParameter("id", productId);
		return true;
	}

	public boolean removeProduct(int productId) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Product> viewAllProducts() {
		String sql = "select prod from Product prod";
		Query qry = em.createQuery(sql);

		List<Product> products = qry.getResultList();
		
		return products;
	}

	
	public Product searchProductById(int productId) {
		
		Product product=em.find(Product.class, productId);
		
		return product;
	}

	@Transactional
	public int addNewRetailer(Retailer retailer) {

		Retailer retailer1 = em.merge(retailer);
		int rId = retailer1.getRetailerId();
		return rId;
	}

	@Transactional
	public int addNewProduct(List<Product> products, int retailerId) {

		Retailer retailer = em.find(Retailer.class, retailerId);
		retailer.setProducts(products);

		for (Product p : products) {
			p.setRetailer(retailer);
		}

		Retailer r = em.merge(retailer);
		return 1;
	}

}
