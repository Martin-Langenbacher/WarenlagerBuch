import java.io.*;
import java.util.ArrayList;

public class Sortiment {
	ArrayList<Produkte> sortiment;
	public Sortiment () {
		this.sortiment = new ArrayList<>();
	}
	public void warenlieferung() {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Geben Sie die Artikelnummer des gelieferten Produkts ein:");
			String eingabe = br.readLine();
			int artikelnummer = Integer.parseInt(eingabe);
			System.out.println("Geben Sie die Anzahl ein:");
			eingabe = br.readLine();
			int anzahl = Integer.parseInt(eingabe);
			boolean vorhanden = false;
			for (int i = 0; i < sortiment.size(); i++) {
				if (sortiment.get(i).getArtnr() == artikelnummer) {
					sortiment.get(i).wareneingang(anzahl);
					System.out.println("Produkt bereits im Sortiment enthalten.");
					System.out.println("Neue Waren hinzugefügt.");
					vorhanden = true;
					break;
				}
			}
			if (!vorhanden) {
				System.out.println("Um welchen Produkttyp handelt es sich?");
				System.out.println("1: Lebensmittel");
				System.out.println("2: Spielwaren");
				System.out.println("3: Elektrogeräte");
				System.out.println("Geben Sie bitte die passende Nummer ein: ");
				int typ = -1;
				try {
					eingabe = br.readLine();
					typ = Integer.parseInt(eingabe);
				}
				catch(NumberFormatException ausnahme) {
					System.out.println("Bitte eine Zahl eingeben!");
				}
				System.out.println("Geben Sie bitte die Produtbezeichnung ein: ");
				String bezeichnung = br.readLine();
				System.out.println("Geben Sie bitte den Preis ein: ");
				eingabe = br.readLine();
				double preis = Double.parseDouble(eingabe);
				switch (typ) {
				    case 1:
				    	System.out.println("Kühlung erforderlich (j/n): ");
				    	eingabe = br.readLine();
				    	boolean kuehlung = (eingabe.contentEquals("j"));
				    	sortiment.add(new Lebensmittel(artikelnummer, bezeichnung, preis, anzahl, kuehlung));
				    	System.out.println("Produkt zum Sortiment hinzugefügt.");
				    	break;
				    case 2:
				    	System.out.println("Mindestalter: ");
				    	eingabe = br.readLine();
				    	int min = Integer.parseInt(eingabe);
				    	System.out.println("Höchstalter: ");
				    	eingabe = br.readLine();
				    	int max = Integer.parseInt(eingabe);
				    	sortiment.add(new Spielwaren(artikelnummer, bezeichnung, preis, anzahl, min, max));
				    	System.out.println("Produkt zum Sortiment hinzugefügt.");
				    	break;
				    case 3:
				    	System.out.println("Energieeffizienzklasse: ");
				    	eingabe = br.readLine();
				    	char effizienz = eingabe.charAt(0);
				    	System.out.println("Verbrauch: ");
				    	eingabe = br.readLine();
				    	int verbrauch = Integer.parseInt(eingabe);
				    	sortiment.add(new Elektro(artikelnummer, bezeichnung, preis, anzahl, effizienz, verbrauch));
				    	System.out.println("Produkt zum Sortiment hinzugefügt.");
				    	break;
				    default:
				    	System.out.println("Sie haben einen ungültigen Wert eingegeben.");
				}
			}
		}
		catch (IOException ausnahme) {
			System.out.println("Fehler bei der Eingabe der Daten.");
		}
		catch (NumberFormatException ausnahme) {
			System.out.println("Bitte geben Sie das nächste Mal eine Zahl ein!");
		}
	}
	public void verkaufen() {
		try {
			// Stream reader für Input:
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Geben Sie die Artikelnummer des verkauften Produkts ein: ");
			String eingabe = br.readLine();
			int artikelnummer = Integer.parseInt(eingabe);
			System.out.println("Geben Sie die Anzahl ein:");
			eingabe = br.readLine();
			int anzahl = Integer.parseInt(eingabe);
			boolean vorhanden = false;
			for (int i = 0; i < sortiment.size(); i++) {
				if (sortiment.get(i).warenausgang(anzahl)) {
					System.out.println("Artikel verkauft! Bestand erfolgreich angepasst!");
				}
				else {
					System.out.println("Nicht genügend Artikel auf Lager!");
				}
				vorhanden = true;
				break;
			}
			
		if (!vorhanden) {
			System.out.println("Artikel nicht im Sortiment enthalten!");
		}
	}
	catch (IOException ausnahme) {
		System.out.println("Fehler bei der Eingabe der Daten");
	}
	catch (NumberFormatException ausnahme) {
		System.out.println("Bitte Geben Sie das nächste Mal eine Zahl ein!");
	}
}

	
	
	public void sonderangebot() {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Geben Sie die Artikelnummer für das Sonderangebot ein:");
			String eingabe = br.readLine();
			int artikelnummer = Integer.parseInt(eingabe);
			System.out.println("Um wie viel Prozent möchten Sie den aktuellen Preis reduzieren? ");
			eingabe = br.readLine();
			int rabatt = Integer.parseInt(eingabe);
			boolean vorhanden = false;
			for (int i = 0; i < sortiment.size(); i++) {
				if (sortiment.get(i).getArtnr() == artikelnummer) {
					sortiment.get(i).setPreis(sortiment.get(i).getPreis() * 1 - (double)rabatt/100);
					System.out.println("Preis erfolgreich angepasst! ");
					vorhanden = true;
					break;
				}
			}
			if (!vorhanden) {
				System.out.println("Artikel nicht im Sortiment enthalten!");
			}
		}
		catch (IOException ausnahme) {
			System.out.println("Fehler bei der Eingabe der Daten");
		}
		catch (NumberFormatException ausnahme) {
			System.out.println("Bitte Geben Sie das nächste Mal eine Zahl ein!");
		}
	}
	
	public void ausgeben() {
		System.out.println("Das Sortiment umfasst folgende Artikel");
		for (Produkte produkt : sortiment) {
			if (produkt instanceof Lebensmittel) {
				System.out.println("Lebensmittel");
				System.out.println("Artikelnummer: " + produkt.getArtnr());
				System.out.println("Produktbezeichnung: " + produkt.getProduktbezeichnung());
				System.out.println("Preis: " + produkt.getPreis());
				System.out.println("Anzahl: " + produkt.getAnzahl());
				System.out.println("Kühlung erforderlich: " + ((Lebensmittel) produkt).getKuehlung() + "\n");
			}
			else if (produkt instanceof Spielwaren) {
				System.out.println("Spielwaren");
				System.out.println("Artikelnummer: " + produkt.getArtnr());
				System.out.println("Produktbezeichnung: " + produkt.getProduktbezeichnung());
				System.out.println("Preis: " + produkt.getPreis());
				System.out.println("Anzahl: " + produkt.getAnzahl());
				System.out.println("Mindestalter: " + ((Spielwaren) produkt).getMindestalter());
				System.out.println("Höchstalter: " + ((Spielwaren) produkt).getHoechstalter() +"\n");
			}
			else if (produkt instanceof Elektro) {
				System.out.println("Elektrogeräte");
				System.out.println("Artikelnummer: " + produkt.getArtnr());
				System.out.println("Produktbezeichnung: " + produkt.getProduktbezeichnung());
				System.out.println("Preis: " + produkt.getPreis());
				System.out.println("Anzahl: " + produkt.getAnzahl());
				System.out.println("Energieeffizienz: " + ((Elektro) produkt).getEffizienz());
				System.out.println("Verbrauch: " + ((Elektro) produkt).getVerbrauch() +"\n");
			}
		}
		
	}
	
}
