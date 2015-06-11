package ijsje.IJsje;

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