package assignment9;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class to keep a list of customers.
 * 
 * @author Haye Bohm - 4290402
 * @author Ylja Remmits - 4373510
 *
 */
public class CustomerList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5239760034068242493L;
	/**
	 * 
	 */
	private ArrayList<Customer> customers;

	/**
	 * Create a new customerlist
	 */
	public CustomerList() {
		this.customers = new ArrayList<Customer>();
	}

	/**
	 * Add a new customer, which is not in the list yet.
	 * 
	 * @param id
	 * @param name
	 */
	public void addCustomer(int id, String name) {
		customers.add(new Customer(id, name));
	}

	/**
	 * Returns the customer with specified ID. If the customer does not exist,
	 * return null.
	 * 
	 * @param id
	 * @return
	 */
	public Customer getCustomer(int id) {
		for (Customer c : customers) {
			if (c.getID() == id) {
				return c;
			}
		}
		return null;
	}

	/**
	 * Returns if the given ID is one of the customer ids present in the list.
	 * 
	 * @param id
	 * @return
	 */
	public boolean exists(int id) {
		if (customers.isEmpty()) {
			return false;
		}
		for (Customer c : customers) {
			if (c.getID() == id) {
				return true;
			}
		}
		return false;
	}
}
