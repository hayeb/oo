package winkelen;

/**
 * Class representing watermeloenen. 
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 *
 */
public class Watermeloenen extends Artikel {

	public Watermeloenen(String naam, double prijs) {
		super(naam, prijs);
	}

	@Override
	public double getVerzendkosten() {
		return 6.75;
	}

}
