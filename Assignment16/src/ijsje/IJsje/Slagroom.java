package ijsje.IJsje;

/**
 * represents a slagroom DLC for the class Ijsje.
 * 
 * @author Haye Bohm - 4290402
 * @author Ylja Remmits - 4373510
 */
public class Slagroom extends IjsjeDecorator {

	/**
	 * Creates a slagroom instance and implicitely calls the decorator.
	 * @param ijsje
	 */
	public Slagroom(Ijsje ijsje) {
		super(ijsje);
	}

	public int prijs() {
		return ijsje.prijs() + 50;
	}

	public String geefBeschrijving() {
		return ijsje.geefBeschrijving() +  ", slagroom";
	}

}