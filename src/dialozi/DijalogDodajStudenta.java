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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controlleri.StudentiController;
import modeli.Student;
import modeli.Student.Status;

public class DijalogDodajStudenta {

	public DijalogDodajStudenta(boolean vidljiv) {
		JDialog  dodajStudenta = new ModalniDijalog(new JFrame(), "Dodaj studenta", true,600,750);
		
		
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
		JLabel adresa = new JLabel("Adresa*");
		JLabel broj = new JLabel("Broj telefona*");
		JLabel indeks = new JLabel("Broj indeksa*");
		JLabel godStud = new JLabel("Trenutna godina studija* ");
		JLabel email = new JLabel("Email* ");
		JLabel prosecnaOcena = new JLabel("Prosecna ocena* ");
		JLabel godUpis = new JLabel("Godina upisa* ");
		
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
		JTextField Indeks = new JTextField();
		Indeks.setPreferredSize(new Dimension(100,30));
		JTextField Email = new JTextField();
		Email.setPreferredSize(new Dimension(100,30));
		JTextField ProsecnaOcena = new JTextField();
		ProsecnaOcena.setPreferredSize(new Dimension(100,30));
		JTextField GodUpis = new JTextField();
		GodUpis.setPreferredSize(new Dimension(100,30));
		
		List<String> predmeti = new ArrayList<String>();
		Student student = new Student();
		
		student.setSpisakPredmeta(predmeti);
		
		
	    String[] izbor = { "I (prva)","II (druga) ", "III (treca)","IV (cetvrta)"};

	    final JComboBox<String> cb = new JComboBox<String>(izbor);
	    cb.setPreferredSize(new Dimension(100,30));
		
	    cb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int godStud = cb.getSelectedIndex() + 1; //indeksiranje ide od 0
				student.setTrenutnaGodinaStudija(godStud);
			}
		});
	    
	    
	    JRadioButton button1 = new JRadioButton("Budzet");
	    JRadioButton button2 = new JRadioButton("Samofinansiranje");
	    ButtonGroup buttonGroup = new ButtonGroup();
	    
	    buttonGroup.add(button1);
	    buttonGroup.add(button2);
	    
	    
	   button1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(button1.isSelected())
				student.setStatus(Status.B);
		}
	});
	   
	   button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(button2.isSelected())
					student.setStatus(Status.S);
			}
		});
	   
	   
	   
	   
	    
	    JButton odustanak = new JButton("Odustanak");
	    JButton potvrda = new JButton("Potvrda");
	    
	    
	    potvrda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String ime = Ime.getText();
				student.setIme(ime);
				String prz = Prz.getText();
				student.setPrezime(prz);
				String dat = Dat.getText();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
				try {
					Date god = new Date(sdf.parse(dat).getTime());
					student.setDatumRodjenja(god);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String adresa = Adresa.getText();
				student.setAdresa(adresa);
				String broj = Broj.getText();
				student.setBrojTelefona(broj);
				String email = Email.getText();
				student.setEmail(email);
				String indeks = Indeks.getText();
				student.setBrIndeksa(indeks);
				String prosecnaOcena = ProsecnaOcena.getText();
				float prosecna = Float.parseFloat(prosecnaOcena);
				student.setProsecnaOcena(prosecna);
				String godString = GodUpis.getText();
				int godUpis = Integer.parseInt(godString);
				student.setGodinaUpisa(godUpis);
				
				
				StudentiController.getInstance().dodajStudenta(student);

				dodajStudenta.dispose();
			}
		});
	    
	    
	    odustanak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dodajStudenta.dispose();
				
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
		panel.add(indeks, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		panel.add(godStud, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 7;
		panel.add(email, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 8;
		panel.add(prosecnaOcena, gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 9;
		panel.add(godUpis, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 10;
		panel.add(button1, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 11;
		panel.add(button2, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 100;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 30, 70);
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
		panel.add(Indeks, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 7;
		panel.add(Email, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 8;
		panel.add(ProsecnaOcena, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 9;
		panel.add(GodUpis, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.insets = new Insets(0, 100, 20, 70);
		panel.add(cb, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 11;
		gbc.insets = new Insets(0, 300, 0, 40);
		panel.add(potvrda, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 11;
		gbc.insets = new Insets(0, 170, 0, 150);
		panel.add(odustanak, gbc);
		
		dodajStudenta.setVisible(vidljiv);
	}

	
	
	
}
