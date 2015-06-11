package ijsje.IJsje;

public class Spikkels extends IjsjeDecorator {

	/**
	 * 
	 * @param ijsje
	 */
	public Spikkels(Ijsje ijsje) {
		super(ijsje);
	}

	public int prijs() {
		return ijsje.prijs() + 0;
	}

	public String geefBeschrijving() {
		return ijsje.geefBeschrijving() + ", spikkels";
	}

}