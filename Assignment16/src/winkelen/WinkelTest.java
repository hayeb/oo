package winkelen;

/**
 * Class to test the implementation of WinkelMandje, Betaalmethode and Artikel
 * classes.
 * 
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 *
 */
public class WinkelTest {

	public static void main(String[] args) {
		WinkelMandje w = new WinkelMandje();
		w.addArtikel(new Wasmachine("Dit is een wasmachine", 499));
		w.addArtikel(new Watermeloenen("Dit zijn watermeloenen", 4.50));
		w.addArtikel(new Wijnglazen("Dit zijn wijnglazen", 8.50));
		System.out.print("Price, including shipping costs: "
				+ w.totaalPrijs() + "\n\n");
		w.veranderBetaalwijze("I");
		w.betaal();
	}

}
