import java.io.*;
import javax.swing.JOptionPane;

public class Verwaltung {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String eingabe;
		int auswahl;
		int weiter;
		Sortiment sortiment = new Sortiment();
		System.out.println("Herzlich Willkommen zum Verwaltungsprogramm!\n\n\n");
		while (true) {
			System.out.println("Wählen Sie eine Aktion aus:\n");
			System.out.println("Wareneingang annehmen: Option 1");
			System.out.println("Verkauf tätigen: Option 2");
			System.out.println("Ein Sonderangebot durchführen: Option 3");
			System.out.println("Das Sortiment ausgeben: Option 4\n");
			System.out.println("Geben Sie die Nummer der gewünschten Aktion ein: ");
			try {
				eingabe = br.readLine();
				auswahl = Integer.parseInt(eingabe);
			}
			catch(NumberFormatException Ausnahme) {
				System.out.println("Bitte eine Zahl eingeben!");
				continue;
			}
			switch (auswahl) {
			    case 1:
			    	sortiment.warenlieferung();
			    	break;
			    case 2:
			    	sortiment.verkaufen();
			    	break;
			    case 3:
			    	sortiment.sonderangebot();
			    	break;
			    case 4:
			    	sortiment.ausgeben();
			    	break;
			    default:
			    	System.out.println("Sie haben eine ungültige Zahl eingegeben.");
			}
			weiter = JOptionPane.showConfirmDialog(null,
					"Möchten Sie eine weitere Aktion durchführen?", "Bestätigung",
					JOptionPane.YES_NO_OPTION);
			if (weiter == 1) {
				break;
			}
		}
		System.out.println("Auf Wiedersehen!");

	}

}
