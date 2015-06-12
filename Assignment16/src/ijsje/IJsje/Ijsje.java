package ijsje.IJsje;

/**
 * Abstract class for an ijsje.
 * @author Haye Bohm - 4290402
 * @author Ylja Remmits - 4373510
 *
 */
public abstract class Ijsje {

	private String beschrijving;

	public abstract int prijs() ;

	/**
	 * Method should be overridden to give the real description.
	 * @return
	 */
	public String geefBeschrijving() {
		return "Het lege ijsje" ;
	}

}