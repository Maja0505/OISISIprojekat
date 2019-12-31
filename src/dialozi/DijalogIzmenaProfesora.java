package dialozi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DijalogIzmenaProfesora {
	public DijalogIzmenaProfesora(boolean vidljiv) {
		JDialog  dodajStudenta = new ModalniDijalog(new JFrame(), "Izmeni profesora", true,600,750);
		
		
		JLabel statusBar = new JLabel();
		dodajStudenta.add(statusBar,BorderLayout.SOUTH);
		statusBar.setPreferredSize(new Dimension(dodajStudenta.getWidth(), 25));
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.WHITE);
		dodajStudenta.add(panel,BorderLayout.CENTER);
		
		dodajStudenta.add(panel);
		
		JLabel ime = new JLabel("Ime*");
		JLabel prz = new JLabel("Prezime*");
		JLabel dat = new JLabel("Datum rodjenja*");
		JLabel adresa = new JLabel("Adresa stanovanja*");
		JLabel broj = new JLabel("Broj telefona*");
		JLabel adresaKancelarije = new JLabel("Adresa kancelarije*");
		JLabel email = new JLabel("Email* ");
		JLabel brojLicne = new JLabel("Broj licne karte(JMBG)* ");
		JLabel titula = new JLabel("Titula* ");
		JLabel zvanje = new JLabel("Zvanje* ");
		
		JTextField Ime = new JTextField();
		Ime.setPreferredSize(new Dimension(100,30));
		JTextField Prz = new JTextField();
		Prz.setPreferredSize(new Dimension(100,30));
		JTextField Dat = new JTextField();
		Dat.setPreferredSize(new Dimension(100,30));
		JTextField Adresa = new JTextField();
		Adresa.setPreferredSize(new Dimension(100,30));
		JTextField Broj = new JTextField();
		Broj.setPreferredSize(new Dimension(100,30));
		JTextField AdresaKancelarije = new JTextField();
		AdresaKancelarije.setPreferredSize(new Dimension(100,30));
		JTextField Email = new JTextField();
		Email.setPreferredSize(new Dimension(100,30));
		JTextField BrojLicne = new JTextField();
		BrojLicne.setPreferredSize(new Dimension(100,30));
		JTextField Titula = new JTextField();
		Titula.setPreferredSize(new Dimension(100,30));
		JTextField Zvanje = new JTextField();
		Zvanje.setPreferredSize(new Dimension(100,30));
		
	    
	    JButton odustanak = new JButton("Odustanak");
	    JButton potvrda = new JButton("Potvrda");
	    
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 20, 20,0);
		panel.add(ime, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(prz, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(dat, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(adresa, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(broj, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		panel.add(adresaKancelarije, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		panel.add(titula, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 7;
		panel.add(zvanje, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 8;
		panel.add(email, gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 9;
		panel.add(brojLicne, gbc);
		
		
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 100;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 20, 70);
		panel.add(Ime, gbc);
		
		
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(Prz, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(Dat, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		panel.add(Adresa, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		panel.add(Broj, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 5;
		panel.add(AdresaKancelarije, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 6;
		panel.add(Titula, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 7;
		panel.add(Zvanje, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 8;
		panel.add(Email, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 9;
		panel.add(BrojLicne, gbc);

		
		gbc.gridx = 1;
		gbc.gridy = 10;
		gbc.insets = new Insets(50, 300, 0, 40);
		panel.add(potvrda, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 10;
		gbc.insets = new Insets(50, 170, 0, 150);
		panel.add(odustanak, gbc);
		
		dodajStudenta.setVisible(vidljiv);
	}
}
