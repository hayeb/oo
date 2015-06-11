package winkelen;

public class Artikel {

	private String naam;
	private double prijs;
	private double verzendkosten;


	public Artikel(String naam, double prijs, double verzendkosten){
		this.naam = naam;
		this.prijs = prijs;
		this.verzendkosten = verzendkosten;
	}


	public String getNaam() {
		return naam;
	}


	public double getPrijs() {
		return prijs;
	}


	public double getVerzendkosten() {
		return verzendkosten;
	}
	
	

}