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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlleri.PredmetiController;
import controlleri.StudentiController;
import gui.MainFrame;
import listeners.FocusListener;
import modeli.BazaPredmeta;
import modeli.BazaStudenata;
import tabele.PredmetiJTable;

public class DijalogDodajStudentaNaPredmet {

	private static boolean omoguci = false; //omugucaca unos studenta na predmet
	
	public DijalogDodajStudentaNaPredmet() {
		JDialog  dodajStudentaNaPredmet = new ModalniDijalog(new JFrame(), "Predmet - dodavanje studenta", true,550,300);
		
		
		JLabel statusBar = new JLabel();
		dodajStudentaNaPredmet.add(statusBar,BorderLayout.SOUTH);
		statusBar.setPreferredSize(new Dimension(dodajStudentaNaPredmet.getWidth(), 25));
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.WHITE);
		dodajStudentaNaPredmet.add(panel,BorderLayout.CENTER);
		
		
		JLabel indeks = new JLabel("Indeks studenta*");
		
		JTextField Indeks = new JTextField();
		Indeks.setName("Indeks*");
		Indeks.setPreferredSize(new Dimension(100,30));
		Indeks.addFocusListener(new FocusListener());
		
		
		 JButton odustanak = new JButton("Odustanak");
		 odustanak.setBackground(Color.LIGHT_GRAY);
		 JButton potvrda = new JButton("Potvrda");
		 potvrda.setBackground(Color.CYAN);
		 
		int selektovanaVrsta = MainFrame.getInstance().getTabelaPredmeta().getRowSorter().convertRowIndexToModel(PredmetiJTable.selektovanaVrsta);
		 
		 potvrda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String indeksStudentaKojiSeUnosi = null;
				int rowSelectedIndex = 0;
				if(!Indeks.getText().equals("") && !Indeks.getText().equals("Nije pravilan unos indeska")) {
						 indeksStudentaKojiSeUnosi = Indeks.getText();
					for(int i = 0;i<BazaStudenata.getInstance().getStudenti().size();i++) {
						if(indeksStudentaKojiSeUnosi.equals(BazaStudenata.getInstance().getStudenti().get(i).getBrIndeksa()) 
								&& BazaStudenata.getInstance().getStudenti().get(i).getTrenutnaGodinaStudija() >= BazaPredmeta.getInstance().getPredmeti().get(selektovanaVrsta).getGodinaIzvodjenjaPredmeta()){
							omoguci = true;
							rowSelectedIndex = i;
							break;
						}
						if(indeksStudentaKojiSeUnosi.equals(BazaStudenata.getInstance().getStudenti().get(i).getBrIndeksa()) 
								&& BazaStudenata.getInstance().getStudenti().get(i).getTrenutnaGodinaStudija() < BazaPredmeta.getInstance().getPredmeti().get(selektovanaVrsta).getGodinaIzvodjenjaPredmeta()){
							JOptionPane.showMessageDialog(null, "Student mora da bude odgovarajuca godina");
							return;
						}
					}
					for(int i = 0;i< BazaPredmeta.getInstance().getPredmeti().get(selektovanaVrsta).getSpisakStudenata().size();i++) {
						if(indeksStudentaKojiSeUnosi.equals(BazaPredmeta.getInstance().getPredmeti().get(selektovanaVrsta).getSpisakStudenata().get(i))) {
							omoguci = false;
						}
					}
					
					if(omoguci) {
						
						PredmetiController.getInstance().dodajStudentaNaPredmet(indeksStudentaKojiSeUnosi, selektovanaVrsta);
						StudentiController.getInstance().dodajPredmetStudentu(BazaPredmeta.getInstance().getPredmeti().get(selektovanaVrsta).getSifraPredmeta(), rowSelectedIndex);
						dodajStudentaNaPredmet.dispose();

					}else {
						JOptionPane.showMessageDialog(null, "Ne postoji indeks u bazi studenata ili je vec slusa taj predmet");
					}
				
				
				}else {
					JOptionPane.showMessageDialog(null, "Niste  ispravno uneli format");
				}
				
				
				
				
				
			}
		});
		 
		 
		 odustanak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dodajStudentaNaPredmet.dispose();
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
		 panel.add(indeks, gbc);
		 
		 gbc.gridx = 1;
		 gbc.gridy = 0;
		 gbc.weighty = 200;
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.insets = new Insets(10, 10, 70, 0);
		 panel.add(Indeks, gbc);
		 
		 
		
		
		
		dodajStudentaNaPredmet.setVisible(true);
	}
}
