package controlleri;

import gui.MainFrame;
import modeli.BazaPredmeta;
import modeli.Predmet;


public class PredmetiController {
	
private static PredmetiController instance = null;
	
	public static PredmetiController getInstance() {
		if (instance == null) {
			instance = new PredmetiController();
		}
		return instance;
	}
	
	private PredmetiController() {}
	
	public void izbrisiPredmet(int rowSelectedIndex) {
    	if (rowSelectedIndex < 0) {
			return;
		}
    	
    	// izmena modela
    	Predmet predmet = BazaPredmeta.getInstance().getRow(rowSelectedIndex);
		BazaPredmeta.getInstance().izbrisiPredmet(predmet.getSifraPredmeta());
		
		// azuriranje prikaza
		MainFrame.getInstance().azurirajTabeluPredmeta();
    }
	  
	public void dodajPredmet(Predmet p) {
			BazaPredmeta.getInstance().dodajPredmet(p);
			MainFrame.getInstance().azurirajTabeluPredmeta();
	}
	
	public void izmeniPredmet(Predmet p) {
		/*if (rowSelectedIndex < 0) {
			return;
		}
		// izmena modela
		Predmet predmet = BazaPredmeta.getInstance().getRow(rowSelectedIndex);
		*/
		BazaPredmeta.getInstance().izmeniPredmet(p.getSifraPredmeta(), p.getNazivPredmet(),p.getSemestar(),p.getGodinaIzvodjenjaPredmeta(),p.getPredmetniProfesor());
	
		// azuriranje prikaza
		MainFrame.getInstance().azurirajTabeluPredmeta();
	}
}
