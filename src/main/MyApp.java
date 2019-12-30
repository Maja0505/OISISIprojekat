package main;

import gui.MainFrame;
import modeli.BazaPredmeta;
import modeli.BazaProfesora;
import modeli.BazaStudenata;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				MainFrame mf=new MainFrame();
				mf.setVisible(true);
				BazaStudenata.getInstance();
				BazaPredmeta.getInstance();
				BazaProfesora.getInstance();
				MainFrame.getInstance(); 
				BazaStudenata.getInstance().popunjavanjeListePredmeta();
				BazaPredmeta.getInstance().popunjavanjeListeStudenata();
				BazaProfesora.getInstance().popunjavanjeListePredmeta();
	}

}