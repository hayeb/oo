package winkelen;

public class WinkelTest {

	public WinkelTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		WinkelMandje w = new WinkelMandje();
		w.addArtikel(new Artikel("watermeloenen", 4.50, 6.75));
		w.addArtikel(new Artikel("wijnglazen", 8.50, 6.75));
		w.addArtikel(new Artikel("wasmachine", 499, 30.00));
		System.out.print("Price, including shipping costs: "
				+ w.totaalPrijs() + "\n\n");
		w.veranderBetaalwijze("I");
		w.betaal();
	}

}
