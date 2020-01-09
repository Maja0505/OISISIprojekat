package dialozi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlleri.ProfesoriController;
import listeners.FocusListener;
import listeners.KeyListener;
import modeli.BazaProfesora;
import modeli.Profesor;

public class DijalogDodajProfesora {

	private static int onemoguciTxtField = 0; //onemogucuje dodavanje profesora ako sva polja nisu uneta	
	
	public DijalogDodajProfesora(boolean vidljiv) {
		JDialog  dodajProfesora = new ModalniDijalog(new JFrame(), "Dodaj profesora", true,600,750);
		
		
		JLabel statusBar = new JLabel();
		dodajProfesora.add(statusBar,BorderLayout.SOUTH);
		statusBar.setPreferredSize(new Dimension(dodajProfesora.getWidth(), 25));
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.WHITE);
		dodajProfesora.add(panel,BorderLayout.CENTER);
		
		dodajProfesora.add(panel);
		
		JLabel ime = new JLabel("Ime*");
		JLabel prz = new JLabel("Prezime*");
		JLabel dat = new JLabel("Datum rodjenja*");
		JLabel adresa = new JLabel("Adresa stanovanja*");
		JLabel broj = new JLabel("Broj telefona*");
		JLabel adresaKancelarije = new JLabel("Adresa kancelarije*");
		JLabel email = new JLabel("Email* ");
		JLabel brojLicne = new JLabel("Broj licne karte*");
		JLabel titula = new JLabel("Titula* ");
		JLabel zvanje = new JLabel("Zvanje* ");
		
		JTextField Ime = new JTextField();
		Ime.setName("ImeProf*");
		Ime.setPreferredSize(new Dimension(100,30));
		Ime.addFocusListener(new FocusListener());
		
		JTextField Prz = new JTextField();
		Prz.setName("PrzProf*");
		Prz.setPreferredSize(new Dimension(100,30));
		Prz.addFocusListener(new FocusListener());
		
		JTextField Dat = new JTextField();
		Dat.setName("DatProf*");
		Dat.setPreferredSize(new Dimension(100,30));
		Dat.addFocusListener(new FocusListener());
		
		JTextField Adresa = new JTextField();
		Adresa.setName("AdresaProf*");
		Adresa.setPreferredSize(new Dimension(100,30));
		Adresa.addFocusListener(new FocusListener());
		
		JTextField Broj = new JTextField();
		Broj.setName("BrojProf*");
		Broj.setPreferredSize(new Dimension(100,30));
		Broj.addFocusListener(new FocusListener());
		
		JTextField AdresaKancelarije = new JTextField();
		AdresaKancelarije.setName("AdresaProfKanc*");
		AdresaKancelarije.setPreferredSize(new Dimension(100,30));
		AdresaKancelarije.addFocusListener(new FocusListener());
		
		JTextField Email = new JTextField();
		Email.setName("EmailProf*");
		Email.setPreferredSize(new Dimension(100,30));
		Email.addFocusListener(new FocusListener());
		
		JTextField BrojLicne = new JTextField();
		BrojLicne.setName("BrojLicneProf*");
		BrojLicne.setPreferredSize(new Dimension(100,30));
		BrojLicne.addFocusListener(new FocusListener());
		BrojLicne.addKeyListener(new KeyListener());
		
		JTextField Titula = new JTextField();
		Titula.setName("TitulaProf*");
		Titula.setPreferredSize(new Dimension(100,30));
		Titula.addFocusListener(new FocusListener());
		
		JTextField Zvanje = new JTextField();
		Zvanje.setName("ZvanjeProf*");
		Zvanje.setPreferredSize(new Dimension(100,30));
		Zvanje.addFocusListener(new FocusListener());
		
	    
	    JButton odustanak = new JButton("Odustanak");
	    odustanak.setBackground(Color.LIGHT_GRAY);
	    JButton potvrda = new JButton("Potvrda");
	    potvrda.setBackground(Color.CYAN);
		
	    
	    potvrda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			
				
				if(!Ime.getText().equals("")  && !Ime.getText().equals("Nepravilan unos imena")) {
					onemoguciTxtField++;
					}
				if(!Prz.getText().equals("")  && !Prz.getText().equals("Nepravilan unos prezimena")) {
					onemoguciTxtField++;
					}
				if(!Dat.getText().equals("") && !Dat.getText().equals("Nepravilan unos datuma rodjenja")) {
					onemoguciTxtField++;
					}
				if(!Adresa.getText().equals("") && !Adresa.getText().equals("Nepravilan unos adrese stanovanja")) {
					onemoguciTxtField++;
					}
				if(!Broj.getText().equals("") && !Broj.getText().equals("Nepravilan unos broja telefona")) {
					onemoguciTxtField++;
					}
				if(!Email.getText().equals("") && !Email.getText().equals("Nepravilan unos email-a")) {
					onemoguciTxtField++;
					}
				if(!AdresaKancelarije.getText().equals("") && !AdresaKancelarije.getText().equals("Nepravilan unos adrese kancelarije")) {
					onemoguciTxtField++;
				}
				if(!BrojLicne.getText().equals("") && !BrojLicne.getText().equals("Nepravilan unos licne karte")) {
					onemoguciTxtField++;
					}
				if(!Titula.getText().equals("") && !Titula.getText().equals("Nepravilan unos titule")) {
					onemoguciTxtField++;
					}
				if(!Zvanje.getText().equals("") && !Zvanje.getText().equals("Nepravilan unos zvanja")) {
					onemoguciTxtField++;
					}
				
			if(onemoguciTxtField == 10) {
				
				String ime = Ime.getText();
				String prz = Prz.getText();
				String dat = Dat.getText();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.");
				Date god = null;
				try {
					 god = new Date(sdf.parse(dat).getTime());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				String adresa = Adresa.getText();
				String broj = Broj.getText();
				String email = Email.getText();
				String adresaKancelarije = AdresaKancelarije.getText();
				String zvanje = Zvanje.getText();
				String titula = Titula.getText();
				String brLicne = BrojLicne.getText();
				List<String> spisakPredmeta = new ArrayList<String>();
				
				boolean mogucUnos = true;
				
				for(int i = 0;i < BazaProfesora.getInstance().getProfesori().size();i++) {
					if(brLicne.equals(BazaProfesora.getInstance().getProfesori().get(i).getBrojLicneKarte())) {
						mogucUnos = false;
						break;
					}
				}
				
				if(mogucUnos) {
					ProfesoriController.getInstance().dodajProfesora(new Profesor(ime, prz, god, adresa, broj, email, adresaKancelarije, brLicne, titula, zvanje, spisakPredmeta));
					onemoguciTxtField = 0;
					dodajProfesora.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Vec postoji takav profesor");
					onemoguciTxtField = 0;	
				}
					
			}
			else {
				JOptionPane.showMessageDialog(null, "Niste uneli sva polja");
				onemoguciTxtField = 0;
				}
			}
			
		});
	    
	    
	    odustanak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onemoguciTxtField = 0;
				dodajProfesora.dispose();
			}
		});
	    
	    
	    
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
		
		dodajProfesora.setVisible(vidljiv);
	}

}
