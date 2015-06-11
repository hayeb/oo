package ijsje.IJsje;

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