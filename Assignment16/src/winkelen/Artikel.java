package winkelen;

/**
 * Abstract class representing a product/artikel.
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 *
 */
public abstract class Artikel {

	private String naam;
	private double prijs;

	public Artikel(String naam, double prijs){
		this.naam = naam;
		this.prijs = prijs;
	}


	public String getNaam() {
		return naam;
	}


	public double getPrijs() {
		return prijs;
	}


	public abstract double getVerzendkosten() ;
	
	

}