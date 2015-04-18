package assignment9;

import java.util.Scanner;

public class Controller {

	private WebShopModel ws;
	private TextUserInterface ui;
	private Scanner scan;

	public Controller(WebShopModel ws, TextUserInterface ui) {
		this.ws = ws;
		this.ui = ui;
		scan = new Scanner(System.in);
	}

	public void welcome() {
		ui.showWelcomeMessage();
		boolean done = false;
		while (!done) {
			String input = scan.nextLine();
			if (input.equals("y")) {
				done = true;
				login();
			} else if (input.equals("n")) {
				done = true;
				registerUser();
			} else {
				System.out.println("Please try again: [y/n]");
			}
		}
	}

	public void registerUser() {
		
		boolean done = false;
		while (!done) {
			ui.requestRegistered();
			int id = scan.nextInt();
			String name = scan.nextLine();
			if (id > 0 && !name.isEmpty()) {
				done = true;
				ws.addCustomer(id, name);
				ui.userAdded();
			} else {
				System.out.println("Please try again.");
			}
		}

	}

	/**
	 * Asks the user for login information, and checks if that login id exists.
	 */
	public void login() {
		boolean done = false;
		while (!done) {
			ui.getLoginNumber();
			int id = scan.nextInt();
			scan.nextLine();
			if (ws.userExists(id)) {
				done = true;
				ws.setCurrentCustomer(id);
				ui.userLoggedIn();
			} else if (id == 0) {
				done = true;
				registerUser();
			} else {
				ui.userLoginError();
			}
		}
	}

	public boolean chooseMenu() {
		ui.askWhichOperation();
		boolean done = false;
		while (!done) {
			String input = scan.nextLine();
			if (input.equalsIgnoreCase("buy")) {
				done = true;
				buy();
				return false;
			} else if (input.equalsIgnoreCase("sell")) {
				done = true;
				sell();
				return false;
			} else if (input.equalsIgnoreCase("exit")) {
				done = true;
				ui.exitMessage();
				return true;

			} else {
				ui.tryAgain();

			}
		}
		return false;
	}

	/**
	 * Main function which is concerned with the buying action. Steps: 1. Show a
	 * list of products currently in the store. Show only those not reserved. 2.
	 * Ask user to enter number of the products which the user would like to
	 * buy. 3. Add those products to the current user's basket. Mark those
	 * products as reserved. 4. Ask if the user is done or if he would like to
	 * add more to the basket. 5. If user agrees, show the total cost of the
	 * basket and proceed to checkout. Else, go repeat steps 1 - 4.
	 */
	public void buy() { boolean done1 = false;
		while (!done1) {
			ui.showProducts(ws.showProducts());
			ui.getProductNumbers();
			int number = scan.nextInt();
			scan.nextLine();
			if (number > 0) {
				Product p = ws.getProduct(number - 1);
				if (p != null) {
					p.setReserved(true);
					Customer c = ws.getCurrentCustomer();
					c.addToBasket(p);
					done1 = true;
					ui.showProductsBasket(c.getBasketString());
				} else {
					ui.buyInputError();
				}
			} else {
				ui.cancelBuy();
				done1 = true;
			}
		}
	}

	/**
	 * Main function which is concerned with the selling action.Steps: 1. Ask
	 * the user what he would like to sell. (name) 2. Ask for the price of the
	 * object. (cost) 3. Add a new product to the products list.
	 */
	public void sell() {
		boolean done1 = false;
		while (!done1) {
			ui.askSellName();
			String name = scan.nextLine();
			ui.askSellPrice();
			int price = scan.nextInt();
			scan.nextLine();
			ui.showProduct(name, price);
			boolean done2 = false;

			while (!done2) {
				ui.askCorrect();
				String s = scan.nextLine();
				if (s.equals("y")) {
					done1 = true;
					done2 = true;
					ws.addProduct(name, price, ws.getCurrentCustomer());
				} else if (s.equals("n")) {
					ui.tryAgain();
					done2 = true;
				} else {
					ui.sellError();
				}
			}
		}
	}

	public void run() {
		welcome();
		boolean done = false;
		while (!done) {
			done = chooseMenu();
		}
		ws.sluit();
	}
}