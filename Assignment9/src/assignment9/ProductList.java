package assignment9;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class which represents a list of products, with methods tailored to the produts.
 * @author Haye Bohm - 4290402
 * @author Ylja Remmits - 4373510
 */
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

	/**
	 * Adds a product to the list.
	 * @param cost
	 * @param name
	 * @param seller
	 * 				A customer selling this product.
	 */
	public void addProduct(int cost, String name, Seller seller) {
		productlist.add(new Product(name, cost, seller));
	}
	
	/**
	 * Adds product p to the list.
	 * @param p
	 */
	public void addProduct(Product p){
		productlist.add(p);
	}
	
	/**
	 * removes the i-th product from the list and returns it.
	 * @param i
	 * @return
	 */
	public Product removeProduct(int i){
		return productlist.remove(i);
	}

	/**
	 * Removes product p from the list.
	 * @param p
	 */
	public void removeProduct(Product p){
		productlist.remove(p);
	}
	
	/**
	 * Returns the ArrayList of products.
	 * @return
	 */
	public ArrayList<Product> getProductlist() {
		return productlist;
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
			return "The product list is empty.\n\n";
		} else {
			StringBuilder sb = new StringBuilder();
			int i = 1;
			for (Product p : productlist) {
				if (p.getReserved() == false) {
					sb.append(i + ": " + p.toString());
					i++;
				}
			}
			return sb.toString();
		}

	}
	
	/**
	 * Returns a string representation of this list as a basket.
	 * @return
	 */
	public String bToString() {
		if (productlist.isEmpty()) {
			return "The product list is empty.\n\n";
		} else {
			StringBuilder sb = new StringBuilder();
			int i = 1;
			for (Product p : productlist) {
					sb.append(i + ": " + p.toString());
					i++;
			}
			return sb.toString();
		}

	}
	
	public boolean isEmpty(){
		return productlist.isEmpty();
	}
	
	/**
	 * Returns the total price of the basket.
	 * @return
	 */
	public double totalPrize(){
		double total = 0.0;
		for (Product p: productlist){
			total += p.getCost();
		}
		return total;
	}
	
	/**
	 * Removes all items in list from this productlist.
	 * @param lijst
	 */
	public void removeAll(ProductList lijst){
		for (Product p : lijst.getProductlist()){
			productlist.remove(p);
		}
	}

	/**
	 * Clear all items from this list.
	 */
	public void clear() {
		this.productlist.clear();
		
	}
}
