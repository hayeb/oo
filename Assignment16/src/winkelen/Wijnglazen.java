package winkelen;

/**
 * Class representing wijnglazen.
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 *
 */
public class Wijnglazen extends Artikel {

	public Wijnglazen(String naam, double prijs) {
		super(naam, prijs);
	}

	@Override
	public double getVerzendkosten() {
		return 6.75;
	}

}
