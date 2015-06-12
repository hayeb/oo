package ijsje.IJsje;

/**
 * Represents an ijsje made from Yoghurtijs.
 * @author Haye Bohm - 4290402
 * @author Ylja Remmits - 4373510
 *
 */
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