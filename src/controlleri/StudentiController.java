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
	
	
	
}
