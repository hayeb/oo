package assignment9;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Seller, Buyer, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1507356662434606896L;
	private final int id;
	private final String name;
	private ArrayList<Product> basket;
	
	public Customer(int id, String name) {
		this.id = id;
		this.name = name;
		this.basket = new ArrayList<Product>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getID() {
		return this.id;
	}

	public ArrayList<Product> getBasket() {
		return basket;
	}
	
	public void addToBasket(Product p) {
		basket.add(p);
	}
	
	public String toString() {
		return "Name: "+ this.name + "\t\tCost: " + this.id + ".\n";
	}
	
	/**
	 * Returns a string representation of the current basket. Items are seperated with newlines.
	 * @return
	 */
	public String getBasketString(){
		StringBuilder sb = new StringBuilder();
		for (Product p : basket) {
			sb.append(p.toString());
		}
		return sb.toString();
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
