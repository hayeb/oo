package assignment9;

import java.util.Scanner;

/**
 * 
 * Class to control our webshop
 * @author Haye Bohm - 4290402
 * @author Ylja Remmits - 4373510
 *
 */
public class Controller {

	private WebShopModel ws;
	private TextUserInterface ui;
	private Scanner scan;

	/**
	 * Initializes this controller with a WebShopModel and a TextUserInterface.
	 * Also initializes a new scanner form std::in.
	 * 
	 * @param ws
	 * @param ui
	 */
	public Controller(WebShopModel ws, TextUserInterface ui) {
		this.ws = ws;
		this.ui = ui;
		scan = new Scanner(System.in);
	}

	/**
	 * Shows a welcome message and asks if the user is familiar with our shop.
	 */
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

	/**
	 * Function to register a new user according to a name and an ID.
	 */
	public void registerUser() {
		boolean done = false;
		while (!done) {
			ui.requestRegistered();
			int id = scan.nextInt();
			String name = scan.nextLine();
			if (id > 0 && !name.isEmpty()) {
				done = true;
				ws.addCustomer(id, name);
				ws.setCurrentCustomer(id);
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

	/**
	 * Shows the main menu for the program.
	 * 
	 * @return
	 */
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
	public void buy() {
		boolean done1 = false;
		while (!done1) {
			ui.showProducts(ws.showProducts());
			if (!ws.isEmpty()) {
				ui.getProductNumbers();
			}
			int number = scan.nextInt();
			scan.nextLine();
			if (number > 0) {
				Product p = ws.getProduct(number - 1);
				if (p != null) {
					Customer c = ws.getCurrentCustomer();
					c.addToBasket(p);
					ui.showProductsBasket(c.getBasketString());
					p.setReserved(true);
					handleBasket();
					done1 = true;
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
	 * Handles the current user's basket: Asks what the user would like to do,
	 * and either finishes the transaction or edits the basket.
	 */
	public void handleBasket() {
		Customer c = ws.getCurrentCustomer();
		while (true) {
			ui.basketOption();
			int i = scan.nextInt();
			scan.nextLine();
			if (i == 1) {
				transaction();
				return;
			} else if (i == 2) {
				ui.removeWhich();
				int r = scan.nextInt();
				scan.nextLine();
				c.removeFromBasket(r - 1);
			} else
				return;
		}
	}
	
	
	/**
	 * Function to let the user "pay". No real practical use yet.
	 */
	public void transaction() {

		ui.finalTransaction(ws.getCurrentCustomer().getBasketString());
		ws.transaction();
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

	/**
	 * Main function to run the shop.
	 */
	public void run() {
		welcome();
		boolean done = false;
		while (!done) {
			done = chooseMenu();
		}
		ws.sluit();
	}
}