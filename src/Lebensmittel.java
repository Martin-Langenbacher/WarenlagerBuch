
public class Lebensmittel extends Produkte {
	private boolean kuehlung;
	public Lebensmittel (int artnr, String bezeichnung, double preis, int anzahl, boolean kuehlung) {
		super(artnr, bezeichnung, preis, anzahl);
		this.kuehlung = kuehlung;
	}
	public boolean getKuehlung () {
		return this.kuehlung;
	}

}
