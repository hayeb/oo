package ijsje.IJsje;

public class YoghurtIjs extends Ijsje {

	private String beschrijving;

	public YoghurtIjs() {
		beschrijving = "Yoghurtijs";
	}
	@Override
	public int prijs() {
		return 200;
	}

	@Override
	public String geefBeschrijving() {
		return beschrijving;
	}

}