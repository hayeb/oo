package ijsje.IJsje;

public class Chocodip extends IjsjeDecorator {

	/**
	 * 
	 * @param ijsje
	 */
	public Chocodip(Ijsje ijsje) {
		super(ijsje);
	}

	public int prijs() {
		return ijsje.prijs() + 50;
	}

	public String geefBeschrijving() {
		return ijsje.geefBeschrijving() + ", chocodip";
	}

}