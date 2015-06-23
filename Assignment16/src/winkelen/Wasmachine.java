package winkelen;

/**
 * Class representing a wasmachine.
 * 
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 *
 */
public class Wasmachine extends Artikel {

	public Wasmachine(String naam, double prijs) {
		super(naam, prijs);
	}

	@Override
	public double getVerzendkosten() {
		return 30.00;
	}

}
