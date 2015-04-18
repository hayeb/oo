package assignment9;

import java.io.Serializable;

/**
 * represents a product in the webshop. Has a reserved state: if the product is
 * reserved, it will not be shown in the product list.
 * 
 * @author Haye Bohm - 4290402
 * @author Ylja Remmits - 4373510
 *
 */
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -513010162380869674L;
	private final String name;
	private final int cost;
	private boolean reserved = false;
	private final Seller seller;

	public Product(String name, int cost, Seller seller) {
		this.name = name;
		this.cost = cost;
		this.seller = seller;
	}

	public int getSellerID() {
		return seller.getID();
	}

	public int getCost() {
		return this.cost;
	}

	public boolean getReserved() {
		return this.reserved;
	}

	public void setReserved(boolean state) {
		this.reserved = state;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * Returns a string representation of the product.
	 */
	@Override
	public String toString() {
		return "Name: " + this.name + "\tCost: \u20ac" + this.cost + ".\n";
	}

	/**
	 * For all we care about, products with the same prize and name are the
	 * same.
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Product)) {
			return false;
		}
		if (o == this) {
			return true;
		}
		Product p = (Product) o;
		return p.getName() == name && p.getCost() == cost;
	}

}