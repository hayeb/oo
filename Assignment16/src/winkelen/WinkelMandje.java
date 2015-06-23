package winkelen;

import java.util.ArrayList;

/**
 * Class modeling a Winkelmandje. Can add artikelen, remove artikelen and calculate the total price.
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 *
 */
public class WinkelMandje {

	private ArrayList<Artikel> artikelLijst;
	private Betaalmethode betaalMethode;

	/**
	 * Initialize the "Winkelmandje", using iDeal as standard payment
	 * method.
	 */
	public WinkelMandje() {
		artikelLijst = new ArrayList<Artikel>();
		betaalMethode = new iDeal();
	}

	/**
	 * 
	 * @param artikel
	 */
	public void addArtikel(Artikel artikel) {
		artikelLijst.add(artikel);
	}

	/**
	 * 
	 * @param artikel
	 */
	public void removeArtikel(Artikel artikel) {
		artikelLijst.remove(artikel);
	}

	/**
	 * calculates the total price, including the shipping costs.
	 * @return
	 */
	public double totaalPrijs() {
		double tp = 0.0;
		ArrayList<Double> vk = new ArrayList<Double>();
		for (Artikel a : artikelLijst) {
			tp += a.getPrijs();
			if (!vk.contains(a.getVerzendkosten())) {
				vk.add(a.getVerzendkosten());
			}
		}
		for (double k : vk) {
			tp += k;
		}

		return tp;
	}

	/**
	 * Stats the selected payment method.
	 * @return
	 */
	public boolean betaal() {
		betaalMethode.invoerGegevens();
		return betaalMethode.betaal(totaalPrijs());

	}
	
	
	/**
	 * Changes payments method. Accepts "P" (PayPal), "C" (CreditCard), "I" (iDeal). 
	 * @param be
	 */
	public void veranderBetaalwijze(String be) {
		switch (be) {
		case "P":
			betaalMethode = new PayPal();
			break;
		case "C":
			betaalMethode = new CreditCard();
			break;
		case "I":
			betaalMethode = new iDeal();
			break;
		}
	}

}