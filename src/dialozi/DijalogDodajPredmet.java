package dialozi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlleri.PredmetiController;
import listeners.FocusListener;
import modeli.BazaProfesora;
import modeli.Predmet;

public class DijalogDodajPredmet {
	public DijalogDodajPredmet(boolean vidljiv) {
				JDialog  dodajPredmet = new ModalniDijalog(new JFrame(), "Dodaj predmet", true,600,750);
				
				
				JLabel statusBar = new JLabel();
				dodajPredmet.add(statusBar,BorderLayout.SOUTH);
				statusBar.setPreferredSize(new Dimension(dodajPredmet.getWidth(), 25));
				
				JPanel panel = new JPanel();
				panel.setLayout(new GridBagLayout());
				panel.setBackground(Color.WHITE);
				dodajPredmet.add(panel,BorderLayout.CENTER);
				
				dodajPredmet.add(panel);
				
				JLabel sifra = new JLabel("Sifra predmeta*");
				JLabel nazivPredmeta = new JLabel("Naziv predmeta*");
				JLabel semestar = new JLabel("Semestar izvodjenja*");
				JLabel godinaIzvodjenja = new JLabel("Godina studija izvodjenja*");
				JLabel profesor = new JLabel("Predmetni profesor*");
				
				
				JTextField Sifra = new JTextField();
				Sifra.setName("Sifra predmeta*");
				Sifra.setPreferredSize(new Dimension(100,30));
				Sifra.addFocusListener(new FocusListener());
				
				JTextField NazivPredmeta = new JTextField();
				NazivPredmeta.setName("Naziv predmeta*");
				NazivPredmeta.setPreferredSize(new Dimension(100,30));
				NazivPredmeta.addFocusListener(new FocusListener());
				
				
			    String[] izborProfesora=new String[BazaProfesora.getInstance().getProfesori().size()];
				
					for(int i=0;i<BazaProfesora.getInstance().getProfesori().size();i++) {
						izborProfesora[i]=BazaProfesora.getInstance().getProfesori().get(i).getIme().concat(" ").concat(BazaProfesora.getInstance().getProfesori().get(i).getPrezime());
					}
					
				    final JComboBox<String> Profesor = new JComboBox<String>(izborProfesora);
					    Profesor.setPreferredSize(new Dimension(100,30));
				
				
			   String[] izbor = { "1 (prvi)","2 (drugi) ", "3 (treci)","4 (cetvrti)", "5 (peti)","6 (sesti) ", "7 (sedmi)","8 (osmi)",};
		
				    final JComboBox<String> semestarCB = new JComboBox<String>(izbor);
				    semestarCB.setPreferredSize(new Dimension(100,30));
				    
			   String[] izbor1 = { "I (prva)","II (druga) ", "III (treca)","IV (cetvrta)"};
		
				    final JComboBox<String> godinaIzvodjenjaCB = new JComboBox<String>(izbor1);
				    godinaIzvodjenjaCB.setPreferredSize(new Dimension(100,30));
				
			    
			    JButton odustanak = new JButton("Odustanak");
			    JButton potvrda = new JButton("Potvrda");
			    
				    odustanak.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							dodajPredmet.dispose();
							
						}
					}); 
				    
					
				    potvrda.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							String sifra=Sifra.getText();
							String naziv=NazivPredmeta.getText();
							int  semestar=semestarCB.getSelectedIndex()+1;
							int godinaIzvodjenja=godinaIzvodjenjaCB.getSelectedIndex()+1;
							String profesor=Profesor.getSelectedItem().toString();
							Predmet predmet=new Predmet(sifra, naziv, semestar, godinaIzvodjenja, profesor, null);
							PredmetiController.getInstance().dodajPredmet(predmet);
							dodajPredmet.dispose();
						}
					});
			    
			GridBagConstraints gbc = new GridBagConstraints();
				
				
				gbc.gridx = 0;
				gbc.gridy = 0;
				gbc.anchor = GridBagConstraints.WEST;
				gbc.insets = new Insets(0, 20, 70,0);
				panel.add(sifra, gbc);
				
				gbc.gridx = 0;
				gbc.gridy = 1;
				panel.add(nazivPredmeta, gbc);
				
				gbc.gridx = 0;
				gbc.gridy = 2;
				panel.add(semestar, gbc);
				
				gbc.gridx = 0;
				gbc.gridy = 3;
				panel.add(godinaIzvodjenja, gbc);
				
				gbc.gridx = 0;
				gbc.gridy = 4;
				panel.add(profesor, gbc);
				
				
				
				
				gbc.gridx = 1;
				gbc.gridy = 0;
				gbc.weightx = 100;
				gbc.fill = GridBagConstraints.HORIZONTAL;
				gbc.insets = new Insets(0, 0, 70, 70);
				panel.add(Sifra, gbc);
				
				
				
				gbc.gridx = 1;
				gbc.gridy = 1;
				panel.add(NazivPredmeta, gbc);
				
				gbc.gridx = 1;
				gbc.gridy = 2;
				gbc.insets = new Insets(0, 100, 70, 70);
				panel.add(semestarCB, gbc);
				
				gbc.gridx = 1;
				gbc.gridy = 3;
				panel.add(godinaIzvodjenjaCB, gbc);
				
				gbc.gridx = 1;
				gbc.gridy = 4;
				panel.add(Profesor, gbc);
				
				
		
				
				gbc.gridx = 1;
				gbc.gridy = 10;
				gbc.insets = new Insets(50, 300, 0, 40);
				panel.add(potvrda, gbc);
				
				gbc.gridx = 1;
				gbc.gridy = 10;
				gbc.insets = new Insets(50, 170, 0, 150);
				panel.add(odustanak, gbc);
				
				dodajPredmet.setVisible(vidljiv);
	}
}
