package com.lti.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.model.Cart;
import com.lti.model.Customer;
import com.lti.model.Items;
import com.lti.model.Order;
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
		List<Cart> carts = new ArrayList<Cart>();

		Cart cart = new Cart();
		cart.setCartQuantity(0);
		cart.setCartStatus(true);
		carts.add(cart);
		addCart(carts, uId);
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

		Product product = em.find(Product.class, productId);

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

	@Transactional
	public int addCart(List<Cart> carts, int customerId) {
		Customer customer = em.find(Customer.class, customerId);
		customer.setCart(carts);

		for (Cart c : carts) {
			c.setCustomer(customer);
		}

		em.merge(customer);
		return 1;
	}

	@Transactional
	public int addItem(List<Items> items, int cartId, int productId) {
		Cart cart = em.find(Cart.class, cartId);
		Product product = em.find(Product.class, productId);

		/* for (Items i : items) { */

		Items item = items.get(0);
		item.setProduct(product);

		// product.setItem(item);
		item.setCart(cart);
		// }

		cart.setItem(items);
		em.merge(cart);
		return 1;
	}

	@Transactional
	public int placeOrderforCustomer(Order order, int cartId) {
		Cart cart = em.find(Cart.class, cartId);

		// cart.setOrder(order);
		order.setCart(cart);

		Order od = em.merge(order);
		
		return od.getOrderId();
	}
	
	public List<Items> displayProductByUserId(int customerId) {
		String sql = "select ti from Items ti where ti.cart.cartId=(select tc.cartId from Cart tc where tc.customer.customerId=:cid)";

		TypedQuery<Items> query = em.createQuery(sql, Items.class);
		query.setParameter("cid", customerId);
		List<Items> resultList = query.getResultList();
		return resultList;
	}	
}
