package assignment9;

import java.util.ArrayList;

public class TextUserInterface {

	
	// LOGGING IN/REGISTERING
	//*************************************************************************//
	public void showWelcomeMessage() {
		System.out
				.println("Welcome to the Magnificent Radboud University Web Shop!");
		System.out
				.println("Have you ever sold or bought something here before? [y/n]");
	}

	public void getLoginNumber() {
		System.out.println("Please enter your ID number:");
	}

	public void requestRegistered() {
		System.out
				.println("To register you, we need your student or employee ID and your name. Please use the following format:");
		System.out.println("1234567 firstname lastname");
	}

	public void userAdded() {
		System.out.println("Thank you for registering with us.");
	}

	public void userLoggedIn() {
		System.out.println("You have successfully logged in.");
	}
	
	public void userLoginError() {
		System.out.println("There is no user with that number. Please try again. Enter 0 if you want to register a new user.");
	}

	
	// BUYING/SELLING
	//******************************************************************************
	/**
	 * 
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

	public void askWhichOperation() {
		System.out.println("Would you like to buy or sell? [buy/sell/exit]");
	}

	public void getProductNumbers() {
		System.out.print("Please enter the productnumber of your choice.\n");
		System.out.print("Enter 0 if you don't want to buy anything.\n>");
	}
	
	public void displayOrderError() {
		System.out.print("There was an error in your order. Please enter it again:\n>");
	}

	public void askCorrect() {
		System.out.println("Is this correct? [y/n]\n>");
	}

	public void askSellName() {
		System.out.print("What would you like to sell? PLease enter the name: \n>");
	}
	
	public void askSellPrice() {
		System.out.print("Please enter the price:\n>");
		
	}
	public void printPrice(int p) {
		System.out.println("The price is: " + p);
	}
	
	public void productAdded(Product p) {
		System.out.println("Product added. Name: " + p.getName() + ". Cost: " + p.getCost() + ".");
	}
	
	public void showProduct(String name, int price) {
		System.out.print("Product entered: " + name + "\t\tprice:" + price + ".\n");
	}
	
	public void sellError() {
		System.out.print("Please enter y or n.\n>");
	}
	
	public void tryAgain() {
		System.out.print("Let's try again.\n");
	}
	
	public void exitMessage() {
		System.out.print("Webshop closing..\n");
	}
	
	public void cancelBuy() {
		System.out.print("Cancelling buy.\n");
	}
	
	public void buyInputError() {
		System.out.print("You entered an incorrect number. Please try again or enter 0 to cancel.\n");
	}
}
