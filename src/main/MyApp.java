package main;

import controlleri.StudentiController;
import gui.MainFrame;
import modeli.BazaPredmeta;
import modeli.BazaProfesora;
import modeli.BazaStudenata;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				BazaStudenata.getInstance();
				StudentiController.getInstance();
				BazaPredmeta.getInstance();
				BazaProfesora.getInstance();
				MainFrame.getInstance(); 
	}

}