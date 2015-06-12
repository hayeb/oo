package ijsje.IJsje;

/**
 * represents a spikkels DLC for the class Ijsje.
 * 
 * @author Haye Bohm - 4290402
 * @author Ylja Remmits - 4373510
 */
public class Spikkels extends IjsjeDecorator {

	/**
	 * 
	 * @param ijsje
	 */
	public Spikkels(Ijsje ijsje) {
		super(ijsje);
	}

	/**
	 * Returns the price of the ijsje.
	 */
	public int prijs() {
		return ijsje.prijs() + 0;
	}

	/**
	 * Returns the description of this ijsje.
	 */
	public String geefBeschrijving() {
		return ijsje.geefBeschrijving() + ", spikkels";
	}

}