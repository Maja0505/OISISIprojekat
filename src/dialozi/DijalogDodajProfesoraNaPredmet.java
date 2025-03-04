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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlleri.PredmetiController;
import controlleri.ProfesoriController;
import gui.MainFrame;
import listeners.FocusListener;
import modeli.BazaPredmeta;
import modeli.BazaProfesora;
import tabele.PredmetiJTable;

public class DijalogDodajProfesoraNaPredmet {
	
	private  boolean omoguci;
	
	public DijalogDodajProfesoraNaPredmet() {
		JDialog  dodajProfeosraNaPredmet = new ModalniDijalog(MainFrame.getInstance(), "Predmet - dodavanje profesora", true,550,300);
		
		omoguci = false;
		JLabel statusBar = new JLabel();
		dodajProfeosraNaPredmet.add(statusBar,BorderLayout.SOUTH);
		statusBar.setPreferredSize(new Dimension(dodajProfeosraNaPredmet.getWidth(), 25));
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.WHITE);
		dodajProfeosraNaPredmet.add(panel,BorderLayout.CENTER);
		
		
		JLabel licnaKarta = new JLabel("Broj licne karte*");
		
		JTextField brojLicneKarte = new JTextField();
		brojLicneKarte.setName("BrojLicneProf*");
		brojLicneKarte.setPreferredSize(new Dimension(100,30));
		brojLicneKarte.addFocusListener(new FocusListener());	//za unos ispravnog formata
		
		
		 JButton odustanak = new JButton("Odustanak");
		 odustanak.setBackground(Color.LIGHT_GRAY);
		 JButton potvrda = new JButton("Potvrda");
		 potvrda.setBackground(Color.CYAN);
	
		 int selektovanaVrsta=MainFrame.getInstance().getTabelaPredmeta().getRowSorter().convertRowIndexToModel(PredmetiJTable.selektovanaVrsta);
		 potvrda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String brojLicneKojaSeUnosi = null;
				int rowSelectedIndex = -1;
				if(!brojLicneKarte.getText().equals("") && !brojLicneKarte.getText().equals("Nepravilan unos licne karte")) {
					brojLicneKojaSeUnosi = brojLicneKarte.getText();
					for(int i = 0;i<BazaProfesora.getInstance().getProfesori().size();i++) {
						if(brojLicneKojaSeUnosi.equals(BazaProfesora.getInstance().getProfesori().get(i).getBrojLicneKarte())){
								
							omoguci = true;		//postoji profesor u bazi
							rowSelectedIndex = i;
							break;
						}
					}
					
					
					
					if(omoguci) {
						
						PredmetiController.getInstance().dodajProfeosraNaPredmet(rowSelectedIndex,selektovanaVrsta);
						ProfesoriController.getInstance().dodajPredmetProfesoru(BazaPredmeta.getInstance().getPredmeti().get(selektovanaVrsta).getSifraPredmeta(), rowSelectedIndex);
						PredmetiJTable.selektovanaVrsta = -1;
						dodajProfeosraNaPredmet.dispose();

					}else {
						JOptionPane.showMessageDialog(null, "Ne postoji profesor u bazi profesora sa unetim brojem licne karte");
					}
				
				
				}else {
					JOptionPane.showMessageDialog(null, "Niste  ispravno uneli format");
				}
				
				
				
				
				
			}
		});
		 
		 
		 odustanak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dodajProfeosraNaPredmet.dispose();
			}
		});
		 
		 
		 
		 GridBagConstraints gbc = new GridBagConstraints();
		 
		 gbc.gridx = 1;
		 gbc.gridy = 1;
		 gbc.insets = new Insets(10, 90, 10, 20);
		 panel.add(odustanak, gbc);
		 
		 gbc.gridx = 1;
		 gbc.gridy = 1;
		 gbc.insets = new Insets(10, 300, 10, 0);
		 panel.add(potvrda, gbc);
		 
		 
		 gbc.gridx = 0;
		 gbc.gridy = 0;
		 gbc.insets = new Insets(10, 0, 70, 10);
		 panel.add(licnaKarta, gbc);
		 
		 gbc.gridx = 1;
		 gbc.gridy = 0;
		 gbc.weighty = 200;
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.insets = new Insets(10, 10, 70, 0);
		 panel.add(brojLicneKarte, gbc);
		 
		 
		
		
		
		 dodajProfeosraNaPredmet.setVisible(true);
	}
}
