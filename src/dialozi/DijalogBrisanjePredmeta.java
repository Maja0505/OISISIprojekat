package dialozi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.MainFrame;
import tabele.PredmetiJTable;

public class DijalogBrisanjePredmeta {
	public DijalogBrisanjePredmeta(boolean vidljiv) {
				JDialog  obrisiPredmet = new ModalniDijalog(MainFrame.getInstance(), "Brisanje predmeta", true,400,200);
				
				
				JLabel statusBar = new JLabel();
				obrisiPredmet.add(statusBar,BorderLayout.SOUTH);
				statusBar.setPreferredSize(new Dimension(obrisiPredmet.getWidth(), 25));
				
				JPanel panel = new JPanel();
				panel.setLayout(new GridBagLayout());
				panel.setBackground(Color.WHITE);
				obrisiPredmet.add(panel,BorderLayout.CENTER);
				
				obrisiPredmet.add(panel);
				
				JLabel brisanje = new JLabel("Da li ste sigurni da zelite da obrisete predmet ?");
				JLabel kantaZaBrisanje = new JLabel();
				kantaZaBrisanje.setIcon(new ImageIcon("images/delete.jpg"));
				
				
			    JButton odustanak = new JButton("Odustanak");
			    JButton potvrda = new JButton("Potvrda");
			    
				odustanak.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								obrisiPredmet.dispose();
								
							}
						}); 
		
				int selektovanaVrsta=MainFrame.getInstance().getTabelaPredmeta().getRowSorter().convertRowIndexToModel(PredmetiJTable.selektovanaVrsta);

				
			    potvrda.addActionListener(new ActionListener() {
				
							@Override
							public void actionPerformed(ActionEvent e) {
								
								controlleri.PredmetiController.getInstance().izbrisiPredmet(selektovanaVrsta);
								PredmetiJTable.selektovanaVrsta = -1;
								obrisiPredmet.dispose();
							}
						});
				
					GridBagConstraints gbc = new GridBagConstraints();
					
					gbc.gridx = 0;
					gbc.gridy = 0;
					gbc.insets = new Insets(20, 5, 20, 0);
					panel.add(kantaZaBrisanje, gbc);
					
					gbc.gridx = 1;
					gbc.gridy = 0;
					gbc.insets = new Insets(20, 10, 20,0);
					panel.add(brisanje, gbc);
					
					gbc.gridx = 1;
					gbc.gridy = 1;
					gbc.insets = new Insets(20, 0, 10, 10);
					panel.add(odustanak, gbc);
					
					gbc.gridx = 1;
					gbc.gridy = 1;
					gbc.insets = new Insets(20, 230, 10, 0);
					panel.add(potvrda, gbc);
				
				
				
				
				
				
				
				
				
					obrisiPredmet.setVisible(vidljiv);
				
	}
}
