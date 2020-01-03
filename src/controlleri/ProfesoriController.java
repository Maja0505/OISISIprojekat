package controlleri;

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
}
