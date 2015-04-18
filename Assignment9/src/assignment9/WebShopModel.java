package assignment9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class WebShopModel {

	CustomerList customerlist;
	ProductList productlist;
	Customer currentcustomer;
	
	private File artFile;
	private File custFile;
	private final static String productsfilename = "products.data";
	private final static String customersfilename = "customers.data";
	
	
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
	 * @param id
	 * @param name
	 */
	public void addCustomer(int id, String name) {
		customerlist.addCustomer(id, name);
	}

	/**
	 * Returns of the user is already registered in the customer list.
	 * @param id
	 * 			The student/employee number of the customer.
	 * @return
	 * 			True if the user already exists.
	 */
	public boolean userExists(int id) {
		return customerlist.exists(id);
	}
	
	public Product getProduct(int i) {
		return productlist.getProduct(i);
	}

	/**
	 * Set the current customer according to the ID of the customer.
	 * @param id
	 */
	public void setCurrentCustomer(int id) {
		currentcustomer = customerlist.getCustomer(id);
	}

	/**
	 * 
	 * @param order
	 * @return
	 */
	public boolean processOrder(ArrayList<Integer> order) {
		
		return false;
	}
	
	/**
	 * Returns a string representation of the products in the shop.
	 * @return
	 */
	public String showProducts() {
		return productlist.toString();
	}

	public Customer getCurrentCustomer() {
		return currentcustomer;
	}

	public void addProduct(String name, int cost, Seller seller) {
		productlist.addProduct(cost, name, seller);		
	}
	
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
