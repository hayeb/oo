package ijsje.IJsje;

/**
 * Represents an ijsje made of vanille.
 * @author Haye Bohm - 4290402
 * @author Ylja Remmits - 4373510
 *
 */
public class VanilleIjs extends Ijsje {

	private String beschrijving;

	public VanilleIjs() {
		beschrijving = "Vanille Ijs";
	}
	@Override
	public int prijs() {
		return 150;
	}

	@Override
	public String geefBeschrijving() {
		return beschrijving;
	}

}