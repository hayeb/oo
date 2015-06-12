package ijsje.IJsje;

/**
 * A decorator for the ijsje class.
 * @author Haye Bohm - 4290402
 * @author Ylja Remmits - 4373510
 *
 */
public abstract class IjsjeDecorator extends Ijsje {

	protected final Ijsje ijsje;

	/**
	 * 
	 * @param ijsje
	 */
	public IjsjeDecorator(Ijsje ijsje) {
		this.ijsje = ijsje;
	}

	public int prijs() {
		return ijsje.prijs();
	}

	public abstract String geefBeschrijving() ;

}