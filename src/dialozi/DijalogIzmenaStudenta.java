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
import listeners.KeyListener;
import modeli.BazaStudenata;
import modeli.Student;
import modeli.Student.Status;
import tabele.StudentiJTable;


public class DijalogIzmenaStudenta {

	private static int onemoguciTxtField = 0;
	
	public DijalogIzmenaStudenta(boolean vidljiv) {
JDialog  izmeniStudenta = new ModalniDijalog(new JFrame(), "Izmena studenta", true,600,750);
		
		
		JLabel statusBar = new JLabel();
		izmeniStudenta.add(statusBar,BorderLayout.SOUTH);
		statusBar.setPreferredSize(new Dimension(izmeniStudenta.getWidth(), 25));
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.WHITE);
		izmeniStudenta.add(panel,BorderLayout.CENTER);
		
		izmeniStudenta.add(panel);
		
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
		
		JTextField Ime = new JTextField(BazaStudenata.getInstance().getStudenti().get(StudentiJTable.selektovanaVrsta).getIme());
		Ime.setName("Ime*");
		Ime.setPreferredSize(new Dimension(100,30));
		Ime.addFocusListener(new FocusListener());
		
		JTextField Prz = new JTextField(BazaStudenata.getInstance().getStudenti().get(StudentiJTable.selektovanaVrsta).getPrezime());
		Prz.setName("Prz*");
		Prz.setPreferredSize(new Dimension(100,30));
		Prz.addFocusListener(new FocusListener());
		
		JTextField Dat = new JTextField(BazaStudenata.getInstance().getStudenti().get(StudentiJTable.selektovanaVrsta).getDatumRodjenja().toString());
		Dat.setName("Dat*");
		Dat.setPreferredSize(new Dimension(100,30));
		Dat.addFocusListener(new FocusListener());
		
		JTextField Adresa = new JTextField(BazaStudenata.getInstance().getStudenti().get(StudentiJTable.selektovanaVrsta).getAdresa());
		Adresa.setName("Adresa*");
		Adresa.setPreferredSize(new Dimension(100,30));
		Adresa.addFocusListener(new FocusListener());
		
		JTextField Broj = new JTextField(BazaStudenata.getInstance().getStudenti().get(StudentiJTable.selektovanaVrsta).getBrojTelefona());
		Broj.setName("Broj*");
		Broj.setPreferredSize(new Dimension(100,30));
		Broj.addKeyListener(new KeyListener());
		Broj.addFocusListener(new FocusListener());
		
		JTextField Indeks = new JTextField(BazaStudenata.getInstance().getStudenti().get(StudentiJTable.selektovanaVrsta).getBrIndeksa());
		Indeks.setName("Indeks*");
		Indeks.setPreferredSize(new Dimension(100,30));
		Indeks.addFocusListener(new FocusListener());
		
		JTextField Email = new JTextField(BazaStudenata.getInstance().getStudenti().get(StudentiJTable.selektovanaVrsta).getEmail());
		Email.setName("Email*");
		Email.setPreferredSize(new Dimension(100,30));
		Email.addFocusListener(new FocusListener());
		
		JTextField ProsecnaOcena = new JTextField(String.valueOf(BazaStudenata.getInstance().getStudenti().get(StudentiJTable.selektovanaVrsta).getProsecnaOcena()));
		ProsecnaOcena.setName("Prosecna ocena*");
		ProsecnaOcena.setPreferredSize(new Dimension(100,30));
		ProsecnaOcena.addFocusListener(new FocusListener());
		
		JTextField GodUpis = new JTextField(String.valueOf(BazaStudenata.getInstance().getStudenti().get(StudentiJTable.selektovanaVrsta).getGodinaUpisa()));
		GodUpis.setName("GodUpis*");
		GodUpis.setPreferredSize(new Dimension(100,30));
		GodUpis.addFocusListener(new FocusListener());
		
		List<String> predmeti = new ArrayList<String>();
		Student student = new Student();
		
		student.setSpisakPredmeta(predmeti);
		
		
	    String[] izbor = { "I (prva)","II (druga) ", "III (treca)","IV (cetvrta)"};

	    final JComboBox<String> cb = new JComboBox<String>(izbor);
	    cb.setPreferredSize(new Dimension(100,30));
	    String godina = cb.getItemAt(BazaStudenata.getInstance().getStudenti().get(StudentiJTable.selektovanaVrsta).getTrenutnaGodinaStudija() - 1);
	    cb.setSelectedItem(godina);
	    
	    
	    cb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int godStud = cb.getSelectedIndex() + 1; 
				student.setTrenutnaGodinaStudija(godStud);
			}
		});
	    
	    if(student.getGodinaUpisa() == 0)
	    	student.setTrenutnaGodinaStudija(1); 
	    
	    JRadioButton button1 = new JRadioButton("Budzet");
	    JRadioButton button2 = new JRadioButton("Samofinansiranje");
	    ButtonGroup buttonGroup = new ButtonGroup();
	    button1.setBackground(Color.WHITE);
	    button2.setBackground(Color.WHITE);
	   
	    if(String.valueOf(BazaStudenata.getInstance().getStudenti().get(StudentiJTable.selektovanaVrsta).getStatus()) == "B") {
	    	button1.setSelected(true);
	    	student.setStatus(Status.B);
	    	}else {
	    	button2.setSelected(true);
	    	student.setStatus(Status.S);
	    }
	    
	    buttonGroup.add(button1);
	    buttonGroup.add(button2);
	    
	    
	    
	   button1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(button1.isSelected()) {
				student.setStatus(Status.B);
			}
		}
	});
	   
	   button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(button2.isSelected()) {
					student.setStatus(Status.S);
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
			
				
				
				if(!Ime.getText().equals("")  && !Ime.getText().equals("Nije validan unos imena...")) {
					onemoguciTxtField++;
					}
				if(!Prz.getText().equals("")  && !Prz.getText().equals("Nije validan unos prezimena...")) {
					onemoguciTxtField++;
					}
				if(!Dat.getText().equals("") && !Dat.getText().equals("Nije validan format datuma (ocekivani 'YYYY - MM - DD')...")) {
					onemoguciTxtField++;
					}
				if(!Adresa.getText().equals("") && !Adresa.getText().equals("Nije valian unos adrese...")) {
					onemoguciTxtField++;
					}
				if(!Broj.getText().equals("") && !Broj.getText().equals("Validan format je +381*********...")) {
					onemoguciTxtField++;
					}
				if(!Email.getText().equals("") && !Email.getText().equals("Nije validan format za email...")) {
					onemoguciTxtField++;
					}
				if(!Indeks.getText().equals("") && !Indeks.getText().equals("Validan format je xxBROJ-20YY...")) {
					onemoguciTxtField++;
				}
				if(!ProsecnaOcena.getText().equals("") && !ProsecnaOcena.getText().equals("Ocene su u rasponu od 6 - 10...")) {
					onemoguciTxtField++;
					}
				if(!GodUpis.getText().equals("") && !GodUpis.getText().equals("Nije validan unos...")) {
					onemoguciTxtField++;
					}
				
			if(onemoguciTxtField == 9) {
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
				student.setSpisakPredmeta(BazaStudenata.getInstance().getStudenti().get(StudentiJTable.selektovanaVrsta).getSpisakPredmeta());
				
				boolean omoguciIzmenu = true;
				
				for(int i = 0;i < BazaStudenata.getInstance().getStudenti().size();i++) {
					if(!indeks.equals(BazaStudenata.getInstance().getStudenti().get(StudentiJTable.selektovanaVrsta).getBrIndeksa())) {
						if(indeks.equals(BazaStudenata.getInstance().getStudenti().get(i).getBrIndeksa())) {
							omoguciIzmenu = false;
							break;
						}
					}
				}
				
				if(omoguciIzmenu) {
					StudentiController.getInstance().izmeniStudenta(student);
					onemoguciTxtField = 0;
					izmeniStudenta.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Ne mozes izmeniti taj indeks jer vec postoji");
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
				izmeniStudenta.dispose();
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
		
		izmeniStudenta.setVisible(vidljiv);
	}

	
	
}
