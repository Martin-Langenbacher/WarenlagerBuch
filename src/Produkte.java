
public class Produkte {
	private int artnr;
	private String produktbezeichnung;
	private double preis;
	private int anzahl;
	public Produkte (int artnr, String typ, double preis, int anzahl) {
		this.artnr = artnr;
		this.produktbezeichnung = typ;
		this.preis = preis;
		this.anzahl = anzahl;
	}
	
	public int getArtnr() {
		return artnr;
	}
	
	public String getProduktbezeichnung() {
		return produktbezeichnung;
	}
	
	public double getPreis() {
		return preis;
	}
	
	public int getAnzahl() {
		return anzahl;
	}
	
	
	public void setPreis(double preis) {
		this.preis = preis;
	}
	
	public void wareneingang (int zahl) {
		this.anzahl += zahl;
	}
	
	public boolean warenausgang (int zahl) {
		if (zahl <= this.anzahl) {
			this.anzahl -= zahl;
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	
	
	
	

}
