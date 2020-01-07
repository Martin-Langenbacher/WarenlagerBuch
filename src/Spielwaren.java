
public class Spielwaren extends Produkte {
	private int mindestalter;
	private int hoechstalter;
	public Spielwaren (int artnr, String bezeichnung, double preis, int anzahl, int min, int max) {
		super(artnr, bezeichnung, preis, anzahl);
		this.mindestalter = min;
		this.hoechstalter = max;
	}
	public int getMindestalter() {
		return this.mindestalter;
	}
	public int getHoechstalter() {
		return this.hoechstalter;
	}

}
