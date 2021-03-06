package assignment9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * A class for the model of our webshop. Handles internal representations of the
 * webshop.
 * 
 * @author Haye Bohm - 4290402
 * @author Ylja Remmits - 4373510
 *
 */
public class WebShopModel {

	CustomerList customerlist;
	ProductList productlist;
	Customer currentcustomer;

	private File artFile;
	private File custFile;
	private final static String productsfilename = "products.data";
	private final static String customersfilename = "customers.data";

	/**
	 * Initializes the WebShop and tries to read existing customer/product
	 * databases.
	 */
	public WebShopModel() {
		artFile = new File(productsfilename);
		custFile = new File(customersfilename);
		if (artFile.exists()) {
			try {

				ObjectInputStream prod_in = new ObjectInputStream(
						new FileInputStream(artFile));

				productlist = (ProductList) prod_in.readObject();
				prod_in.close();
				System.out.println("Product database loaded.");
			} catch (IOException iOException) {
				System.out.println(iOException);
				System.exit(1);
			} catch (ClassNotFoundException classNotFoundException) {
				System.out.println(classNotFoundException);
				System.exit(1);
			}
		} else {
			productlist = new ProductList();
		}
		if (custFile.exists()) {

			try {
				ObjectInputStream cust_in = new ObjectInputStream(
						new FileInputStream(custFile));
				customerlist = (CustomerList) cust_in.readObject();
				cust_in.close();
				System.out.println("Customer database loaded.");
			} catch (IOException e) {
				System.out.println(e);
				System.exit(1);
			} catch (ClassNotFoundException e) {
				System.out.println(e);
				System.exit(1);
			}

		} else {
			customerlist = new CustomerList();
		}
	}

	/**
	 * Add a new customer to the customer list.
	 * 
	 * @param id
	 * @param name
	 */
	public void addCustomer(int id, String name) {
		customerlist.addCustomer(id, name);
	}

	/**
	 * Returns of the user is already registered in the customer list.
	 * 
	 * @param id
	 *            The student/employee number of the customer.
	 * @return True if the user already exists.
	 */
	public boolean userExists(int id) {
		return customerlist.exists(id);
	}

	/**
	 * Returns the ith product from the product list.
	 * 
	 * @param i
	 * @return
	 */
	public Product getProduct(int i) {
		return productlist.getProduct(i);
	}

	/**
	 * Clears the current user's basket, removes all those items from the
	 * product list.
	 */
	public void transaction() {
		ProductList basket = currentcustomer.getBasket();
		productlist.removeAll(basket);
		basket.clear();
	}

	/**
	 * Set the current customer according to the ID of the customer.
	 * 
	 * @param id
	 */
	public void setCurrentCustomer(int id) {
		currentcustomer = customerlist.getCustomer(id);
	}

	/**
	 * Returns a string representation of the products in the shop.
	 * 
	 * @return
	 */
	public String showProducts() {
		return productlist.toString();
	}

	public Customer getCurrentCustomer() {
		return currentcustomer;
	}

	/**
	 * Returns if the product list is empty.
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return productlist.isEmpty();
	}

	/**
	 * Adds a product to the product list.
	 * 
	 * @param name
	 * @param cost
	 * @param seller
	 *            Customer who sells the product.
	 */
	public void addProduct(String name, int cost, Seller seller) {
		productlist.addProduct(cost, name, seller);
	}

	/**
	 * Closes the shop: Tries to save all databases.
	 */
	public void sluit() {
		try {
			ObjectOutputStream prod_out = new ObjectOutputStream(
					new FileOutputStream(artFile));
			ObjectOutputStream cust_out = new ObjectOutputStream(
					new FileOutputStream(custFile));
			prod_out.writeObject(productlist);
			cust_out.writeObject(customerlist);
			prod_out.close();
			cust_out.close();
			System.out.println("Databases saved.");
		} catch (IOException iOException) {
			System.out.println(iOException);
			System.exit(1);
		}
	}

}
