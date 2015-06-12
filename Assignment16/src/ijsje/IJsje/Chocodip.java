package ijsje.IJsje;

/**
 * represents a chocodip DLC for the class Ijsje.
 * 
 * @author Haye Bohm - 4290402
 * @author Ylja Remmits - 4373510
 */
public class Chocodip extends IjsjeDecorator {

	/**
	 * 
	 * @param ijsje
	 */
	public Chocodip(Ijsje ijsje) {
		super(ijsje);
	}

	/**
	 * Returns the price of the icecream plus the price of this add-on.
	 */
	public int prijs() {
		return ijsje.prijs() + 50;
	}

	/**
	 * Returns a description of the ice cream and this add-on.
	 */
	public String geefBeschrijving() {
		return ijsje.geefBeschrijving() + ", chocodip";
	}

}