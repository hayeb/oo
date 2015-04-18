package assignment9;

import java.io.Serializable;
import java.util.ArrayList;

public class ProductList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 783243563309913981L;
	private ArrayList<Product> productlist;

	/**
	 * Create a new, empty list of products
	 */
	public ProductList() {
		this.productlist = new ArrayList<Product>();
	}

	public void addProduct(int cost, String name, Seller seller) {
		productlist.add(new Product(name, cost, seller));
	}

	/**
	 * Returns the i-th non-reserved product form the list. Returns null if
	 * there is no such product.
	 * 
	 * @param i
	 * @return
	 */
	public Product getProduct(int i) {
		int index = 0;
		for (Product p : productlist) {
			if (p.getReserved() == false) {
				if (index == i) {
					return p;
				}
				index++;
			}
		}
		return null;
	}

	/**
	 * returns a string representation of the products in the list. Only lists
	 * the products which are not reserved by someone else.
	 * 
	 * @return
	 */
	@Override
	public String toString() {
		if (productlist.isEmpty()) {
			return "The product list is empty.\n";
		} else {
			StringBuilder sb = new StringBuilder();
			for (Product p : productlist) {
				if (p.getReserved() == false) {
					sb.append(p.toString());
				}
			}
			return sb.toString();
		}

	}
}
