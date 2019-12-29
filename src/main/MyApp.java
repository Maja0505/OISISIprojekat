package main;

import gui.MainFrame;
import modeli.BazaStudenata;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				MainFrame mf=new MainFrame();
				mf.setVisible(true);
				BazaStudenata.getInstance();
				MainFrame.getInstance(); 
				 
	}

}