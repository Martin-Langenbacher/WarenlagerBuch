
public class Elektro extends Produkte {
	private char effizienz;
	private int verbrauch;
	public Elektro (int artnr, String bezeichnung, double preis, int anzahl, char effizienz, int verbrauch) {
		super(artnr, bezeichnung, preis, anzahl);
		this.effizienz = effizienz;
		this.verbrauch = verbrauch;
	}
	public char getEffizienz() {
		return effizienz;
	}
	public int getVerbrauch() {
		return verbrauch;
	}
	

}
