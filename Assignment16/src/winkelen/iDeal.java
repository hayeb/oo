package winkelen;

import java.util.Scanner;

/**
 * An iDeal implementation of the betaalmethode interface.
 * @author Haye Bohm - 4290402
 * @author Ylja Remmits - 4373510
 *
 */
public class iDeal implements Betaalmethode {

	private String bankname;
	private int accnumber;
	private int pin;

	@Override
	public boolean betaal(double bedrag) {
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