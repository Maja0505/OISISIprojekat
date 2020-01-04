package controlleri;

import java.sql.Date;

import gui.MainFrame;
import modeli.BazaProfesora;
import modeli.Profesor;

public class ProfesoriController {
	private static ProfesoriController instance = null;
	
	public static ProfesoriController getInstance() {
		if (instance == null) {
			instance = new ProfesoriController();
		}
		return instance;
	}
	
	private ProfesoriController() {}
	
	public void izbrisiProfesora(int rowSelectedIndex) {
    	if (rowSelectedIndex < 0) {
			return;
		}
    	
    	// izmena modela
    	Profesor profesor = BazaProfesora.getInstance().getRow(rowSelectedIndex);
    	BazaProfesora.getInstance().izbrisiProfesora(profesor.getBrojLicneKarte());
		
		// azuriranje prikaza
		MainFrame.getInstance().azurirajTabeluProfesora();
    }
	
	
	public void dodajProfesora(Profesor p) {
		//izmena modela Profesor (dodavanje)
		BazaProfesora.getInstance().dodajProfesora(p);
		//azuriranje prikaza
		MainFrame.getInstance().azurirajTabeluProfesora();
	}
	
	public void izmeniProfesora(Profesor p) {
		// izmena modela Profesor (izmena)
		BazaProfesora.getInstance().izmeniProfesora(p.getIme(), p.getPrezime(), (Date) p.getDatum_rodjenja(), 
				p.getAdresaStanivanja(), p.getKontaktTelefon(), p.getEmail(), p.getAdresaKancelarije(), 
				p.getBrojLicneKarte(), p.getTitula(), p.getZvanje(), p.getSpisakPredmeta());
		// azuriranje prikaza
		MainFrame.getInstance().azurirajTabeluProfesora();
	}
}
