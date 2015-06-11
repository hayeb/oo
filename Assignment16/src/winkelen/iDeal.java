package winkelen;

import java.util.Scanner;

public class iDeal implements Betaalmethode {

	private String bankname;
	private int accnumber;
	private int pin;

	@Override
	public boolean betaal() {
		System.out.println("Starting external payment method..");
		System.err.println("Method not yet implemented.");
		return false;
	}

	@Override
	public void invoerGegevens() {
		Scanner s = new Scanner(System.in);
		System.out.print("Please enter your bank name:\n");
		bankname = s.nextLine();
		System.out.print("Please enter your account number:\n");
		accnumber = s.nextInt();
		s.nextLine();
		System.out.println("Please enter your pin code::");
		pin = s.nextInt();
		s.nextLine();
	}

}