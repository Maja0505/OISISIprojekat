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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controlleri.StudentiController;
import listeners.FocusListener;
import modeli.BazaStudenata;
import modeli.Student;
import modeli.Student.Status;

public class DijalogDodajStudenta {

	private static int onemoguciTxtField = 0;  //omogucuje potvrdu ukoliko su sva polja validno uneta  
	private static boolean onemoguciButton = false; //omgucuje potvrdu ukoliko je oznaceno jedno od dugmadi
	
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
		Ime.setName("Ime*");
		Ime.setPreferredSize(new Dimension(100,30));
		Ime.addFocusListener(new FocusListener());
		
		JTextField Prz = new JTextField();
		Prz.setName("Prz*");
		Prz.setPreferredSize(new Dimension(100,30));
		Prz.addFocusListener(new FocusListener());
		
		JTextField Dat = new JTextField();
		Dat.setName("Dat*");
		Dat.setPreferredSize(new Dimension(100,30));
		Dat.addFocusListener(new FocusListener());
		
		JTextField Adresa = new JTextField();
		Adresa.setName("Adresa*");
		Adresa.setPreferredSize(new Dimension(100,30));
		Adresa.addFocusListener(new FocusListener());
		
		JTextField Broj = new JTextField();
		Broj.setName("Broj*");
		Broj.setPreferredSize(new Dimension(100,30));
		Broj.addFocusListener(new FocusListener());
		
		JTextField Indeks = new JTextField();
		Indeks.setName("Indeks*");
		Indeks.setPreferredSize(new Dimension(100,30));
		Indeks.addFocusListener(new FocusListener());
		
		JTextField Email = new JTextField();
		Email.setName("Email*");
		Email.setPreferredSize(new Dimension(100,30));
		Email.addFocusListener(new FocusListener());
		
		JTextField ProsecnaOcena = new JTextField();
		ProsecnaOcena.setName("Prosecna ocena*");
		ProsecnaOcena.setPreferredSize(new Dimension(100,30));
		ProsecnaOcena.addFocusListener(new FocusListener());
		
		JTextField GodUpis = new JTextField();
		GodUpis.setName("GodUpis*");
		GodUpis.setPreferredSize(new Dimension(100,30));
		GodUpis.addFocusListener(new FocusListener());
		
		List<String> predmeti = new ArrayList<String>();
		Student student = new Student();
		
		student.setSpisakPredmeta(predmeti);
		
		
	    String[] izbor = { "I (prva)","II (druga) ", "III (treca)","IV (cetvrta)"};

	    final JComboBox<String> cb = new JComboBox<String>(izbor);
	    cb.setPreferredSize(new Dimension(100,30));
		
	    
	    
	    JRadioButton button1 = new JRadioButton("Budzet");
	    JRadioButton button2 = new JRadioButton("Samofinansiranje");
	    ButtonGroup buttonGroup = new ButtonGroup();
	    button1.setBackground(Color.WHITE);
	    button2.setBackground(Color.WHITE);
	    
	    buttonGroup.add(button1);
	    buttonGroup.add(button2);
	    
	    
	    
	   button1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(button1.isSelected()) {
				student.setStatus(Status.B);
					onemoguciButton = true;
			}
		}
	});
	   
	   button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(button2.isSelected()) {
					student.setStatus(Status.S);
					onemoguciButton = true;
				}
				}
		});
	   
	   
	   
	   
	    
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
				if(!Dat.getText().equals("") && !Dat.getText().equals("Nepravilan unos datuma")) {
					onemoguciTxtField++;
					}
				if(!Adresa.getText().equals("") && !Adresa.getText().equals("Nepravilan unos adrese")) {
					onemoguciTxtField++;
					}
				if(!Broj.getText().equals("") && !Broj.getText().equals("Nepravilan unos broja telefona")) {
					onemoguciTxtField++;
					}
				if(!Email.getText().equals("") && !Email.getText().equals("Nepravilan unos email-a")) {
					onemoguciTxtField++;
					}
				if(!Indeks.getText().equals("") && !Indeks.getText().equals("Nepravilan unos indeksa")) {
					onemoguciTxtField++;
				}
				if(!ProsecnaOcena.getText().equals("") && !ProsecnaOcena.getText().equals("Nepravilan unos prosecne ocene")) {
					onemoguciTxtField++;
					}
				if(!GodUpis.getText().equals("") && !GodUpis.getText().equals("Nepravilan unos datuma upisa")) {
					onemoguciTxtField++;
					}
				
		if(onemoguciButton) {		
			if(onemoguciTxtField == 9) {
				
				String ime = Ime.getText();
				student.setIme(ime);
				String prz = Prz.getText();
				student.setPrezime(prz);
				String dat = Dat.getText();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.");
				Date god = null;
				try {
					 god = new Date(sdf.parse(dat).getTime());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
                student.setDatumRodjenja(god);
				String adresa = Adresa.getText();
				student.setAdresa(adresa);
				String broj = Broj.getText();
				student.setBrojTelefona(broj);
				String email = Email.getText();
				student.setEmail(email);
				String indeks = Indeks.getText();
				student.setBrIndeksa(indeks);
				String prosecnaOcena = ProsecnaOcena.getText();
				double prosecna = Double.parseDouble(prosecnaOcena);
				student.setProsecnaOcena(prosecna);
				String godString = GodUpis.getText();
				Date god2 = null;
				try {
					 god2 = new Date(sdf.parse(godString).getTime());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				student.setGodinaUpisa(god2);
				
				student.setTrenutnaGodinaStudija(cb.getSelectedIndex() + 1);
				
				boolean mogucUnos = true;
				
				for(int i = 0;i<BazaStudenata.getInstance().getStudenti().size();i++) {
					if(indeks.equals(BazaStudenata.getInstance().getStudenti().get(i).getBrIndeksa())) {
						mogucUnos = false;
						break;
					}
				}	
				
				if(mogucUnos) {
					
					if(student.getTrenutnaGodinaStudija() == 1) {
						if(student.getProsecnaOcena() != 0) {
							student.setProsecnaOcena(0);
						}
					}else {
						if(student.getProsecnaOcena() == 0) {
							JOptionPane.showMessageDialog(null, "Student nije prva godina i mora imati prosek");
							onemoguciTxtField = 0;
							return;
						}
					}
					
					if(student.getDatumRodjenja().after(student.getGodinaUpisa())) {
						JOptionPane.showMessageDialog(null, "Student mora biti rodjen pre upisa");
						onemoguciTxtField = 0;
						return;
					}
					
				StudentiController.getInstance().dodajStudenta(student);
				onemoguciTxtField = 0;
				dodajStudenta.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Vec postoji takav student");
					onemoguciTxtField = 0;	
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Niste uneli sva polja");
				onemoguciTxtField = 0;
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Niste oznacili dugme");
				
				}
			}
		});
	    
	    
	    
	    odustanak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onemoguciTxtField = 0;
				onemoguciButton = false;
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
