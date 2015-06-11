package ijsje.IJsje;

public class Slagroom extends IjsjeDecorator {

	/**
	 * 
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