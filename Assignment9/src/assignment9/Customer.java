package assignment9;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A implementation of the Seller and Buyer interfaces.
 * 
 * @author Haye Bohm - 4290402
 * @author Ylja Remmits - 4373510
 */
public class Customer implements Seller, Buyer, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1507356662434606896L;
	private final int id;
	private final String name;
	private ProductList basket;

	/**
	 * Initializes a customer according to an ID and a name.
	 * @param id
	 * @param name
	 */
	public Customer(int id, String name) {
		this.id = id;
		this.name = name;
		this.basket = new ProductList();
	}

	/**
	 * returns the name of the customer.
	 */
	public String getName() {
		return this.name;
	}

	public int getID() {
		return this.id;
	}

	/**
	 * Returns the basket for this user.
	 * @return
	 */
	public ProductList getBasket() {
		return basket;
	}

	/**
	 * Add product p to the current user's basket.
	 * @param p
	 */
	public void addToBasket(Product p) {
		basket.addProduct(p);
	}

	/**
	 * Returns a string representation of this customer.
	 */
	public String toString() {
		return "Name: " + this.name + "\t\tCost: \u20ac" + this.id + ".\n";
	}

	/**
	 * Returns a string representation of the current basket. Items are
	 * separated with newlines.
	 * 
	 * @return
	 */
	public String getBasketString() {
		return basket.bToString()
				+ "\nThe total cost of these products: \n\u20ac "
				+ basket.totalPrize() + "\n\n";
	}

	/**
	 * Removes the i-th item from the basket.
	 * @param i
	 */
	public void removeFromBasket(int i) {
		Product p = basket.removeProduct(i);
		p.setReserved(false);
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Customer)) {
			return false;
		}
		if (o == this) {
			return true;
		}
		Customer p = (Customer) o;
		return p.getName() == name && p.getID() == id;
	}
}
