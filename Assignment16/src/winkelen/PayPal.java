package winkelen;

import java.util.Scanner;

/**
 * Implementation of the Betaalmethode interface representing a PayPal payment method.
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 *
 */
public class PayPal implements Betaalmethode {

	private String email;
	private String password;

	@Override
	public boolean betaal(double bedrag) {
		System.out.println("Starting external payment method..");
		System.err.println("Method not yet implemented.");
		return false;

	}

	@Override
	public void invoerGegevens() {
		Scanner s = new Scanner(System.in);
		System.out.print("Please enter your e-mail address:\n");
		email = s.nextLine();
		System.out.print("Please enter your password:\n");
		password = s.nextLine();
	}

}