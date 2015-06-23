package winkelen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * A creditCard implementation of the Betaalmethode interface.
 * @author Haye Bohm - 4290402
 * @author Ylja Remmits - 4373510
 *
 */
public class CreditCard implements Betaalmethode {

	private int cnumber = -1;
	private String name;
	private Date date;

	@Override
	public boolean betaal(double bedrag) {
		System.out.println("Starting external payment method..");
		System.err.println("Method not yet implemented.");
		return false;
	}

	@Override
	public void invoerGegevens() {
		Scanner s = new Scanner(System.in);
		System.out.print("Please enter your Credit Card number:\n");
		cnumber = s.nextInt();
		s.nextLine();
		System.out.print("Please enter your name:\n");
		name = s.nextLine();
		System.out.println("Please enter the expiration data of your card:");

		String expectedPattern = "dd/MM/yyyy";
		SimpleDateFormat formatter = new SimpleDateFormat(
				expectedPattern);
		try {
			String input = s.nextLine();
			date = formatter.parse(input);
		} catch (ParseException e) {
			System.out.println("Data parsing failed.");
		}
	}

}