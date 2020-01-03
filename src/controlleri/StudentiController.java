package controlleri;


import gui.MainFrame;
import modeli.BazaStudenata;
import modeli.Student;

public class StudentiController {

private static StudentiController instance = null;
	
	public static StudentiController getInstance() {
		if (instance == null) {
			instance = new StudentiController();
		}
		return instance;
	}
	
	private StudentiController() {}
	
	public void dodajStudenta(Student s) {
		//izmena modela Student (dodavanje)
		BazaStudenata.getInstance().dodajStudenta(s);
		//azuriranje prikaza
		MainFrame.getInstance().azurirajTabeluStudent();
	}
	
	
	public void izbrisiStudenta(int rowSelectedIndex) {
    	if (rowSelectedIndex < 0) {
			return;
		}
    	// izmena modela Student (brisanje)
    	Student student = BazaStudenata.getInstance().getRow(rowSelectedIndex);
		BazaStudenata.getInstance().izbrisiStudenta(student.getBrIndeksa());
		// azuriranje prikaza
		MainFrame.getInstance().azurirajTabeluStudent();;
    }
	
	
	public void izmeniStudenta(Student s) {
		// izmena modela Student (izmena)
		BazaStudenata.getInstance().izmeniStudenta(s.getIme(), s.getPrezime(), s.getDatumRodjenja(),
				s.getAdresa(), s.getBrojTelefona(), s.getEmail(), s.getBrIndeksa(), s.getGodinaUpisa(),s.getTrenutnaGodinaStudija(),
				s.getProsecnaOcena(), s.getSpisakPredmeta(), s.getStatus());
		// azuriranje prikaza
		MainFrame.getInstance().azurirajTabeluStudent();
	}
	
	
}
