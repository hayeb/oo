package assignment9;

import java.util.ArrayList;

/**
 * Class to show text information to the user. A lot of JavaDoc is left out: the
 * methods are self-explanatory.
 * 
 * @author Haye Bohm - 4290402
 * @author Ylja Remmits - 4373510
 */
public class TextUserInterface {

	// LOGGING IN/REGISTERING
	// *************************************************************************//
	public void showWelcomeMessage() {
		System.out
				.println("Welcome to the Magnificent Radboud University Web Shop!");
		System.out
				.print("Have you ever sold or bought something here before? [y/n]\n> ");
	}

	public void getLoginNumber() {
		System.out.print("Please enter your ID number:\n> ");
	}

	public void requestRegistered() {
		System.out
				.print("To register you, we need your student or employee ID and your name.\nPlease use the following format: ");
		System.out.print("1234567 firstname lastname\n> ");
	}

	public void userAdded() {
		System.out.print("Thank you for registering with us.\n");
	}

	public void userLoggedIn() {
		System.out.print("You have successfully logged in.\n");
	}

	public void userLoginError() {
		System.out
				.print("There is no user with that number. Please try again. Enter 0 if you want to register a new user.\n> ");
	}

	public void askWhichOperation() {
		System.out.print("Would you like to buy or sell? [buy/sell/exit]\n> ");
	}

	// BUYING/SELLING
	// ******************************************************************************
	/**
	 * Shows a list of products, but only those which are not reserved.
	 * @param products
	 */
	public void showProducts(ArrayList<Product> products) {
		for (Product p : products) {
			if (p.getReserved() == false) {
				System.out.print(p.toString() + "\n\n");
			}
		}
	}

	public void showProducts(String s) {
		System.out.print(s);
	}

	public void showProductsBasket(String s) {
		System.out.print("Your current shopping basket is:\n");
		System.out.print(s);
	}

	public void finalizeTransaction() {
		System.out.println("DONE!");
	}

	public void getProductNumbers() {
		System.out.print("Please enter the productnumber of your choice.\n");
		System.out.print("Enter 0 if you don't want to buy anything.\n> ");
	}

	public void displayOrderError() {
		System.out
				.print("There was an error in your order. Please enter it again:\n> ");
	}

	public void askCorrect() {
		System.out.print("Is this correct? [y/n]\n> ");
	}

	public void askSellName() {
		System.out
				.print("What would you like to sell? Please enter the name: \n> ");
	}

	public void askSellPrice() {
		System.out.print("Please enter the price:\n> ");

	}

	public void printPrice(int p) {
		System.out.println("The price is: \u20ac" + p);
	}

	public void showProduct(String name, int price) {
		System.out.print("Product entered: " + name + "\t\tprice: \u20ac"
				+ price + ".\n");
	}

	public void sellError() {
		System.out.print("Please enter y or n.\n>");
	}

	public void tryAgain() {
		System.out.print("Let's try again.\n\n> ");
	}

	public void exitMessage() {
		System.out.print("Webshop closing..\n");
	}

	public void cancelBuy() {
		System.out.print("Cancelling buy.\n");
	}

	public void basketOption() {
		System.out
				.print("Would you like to:\n[1] Continue with your transaction\n[2] Remove an item from your basket\n[3] Go back to the shop\n> ");
	}

	public void buyInputError() {
		System.out
				.print("You entered an incorrect number. Please try again or enter 0 to cancel.\n> ");
	}

	public void removeWhich() {
		System.out
				.print("Please enter the numer of the item you would like to remove.\n> ");
	}

	public void finalTransaction(String basket) {
		System.out
				.print("Thank you for buying with our webshop. You bought this: \n"
						+ basket);
	}
}
