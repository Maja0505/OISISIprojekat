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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.MainFrame;
import modeli.BazaPredmeta;
import modeli.BazaProfesora;
import tabele.ProfesoriJTable;

public class DijalogBrisanjeProfesora {
	public DijalogBrisanjeProfesora(boolean vidljiv) {
		JDialog  obrisiProfesora = new ModalniDijalog(new JFrame(), "Brisanje profesora", true,400,200);
		
		
		JLabel statusBar = new JLabel();
		obrisiProfesora.add(statusBar,BorderLayout.SOUTH);
		statusBar.setPreferredSize(new Dimension(obrisiProfesora.getWidth(), 25));
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.WHITE);
		obrisiProfesora.add(panel,BorderLayout.CENTER);
		
		obrisiProfesora.add(panel);
		
		JLabel brisanje = new JLabel("Da li ste sigurni da zelite da obrisete profesora ?");
		JLabel kantaZaBrisanje = new JLabel();
		kantaZaBrisanje.setIcon(new ImageIcon("images/delete.jpg"));
		
		
	    JButton odustanak = new JButton("Odustanak");
	    JButton potvrda = new JButton("Potvrda");
	    
	    	odustanak.addActionListener(new ActionListener() {
			
					@Override
					public void actionPerformed(ActionEvent e) {
						obrisiProfesora.dispose();
						
					}
	    	}); 

			int selektovanaVrsta = MainFrame.getInstance().getTabelaProfesora().getRowSorter().convertRowIndexToModel(ProfesoriJTable.selektovanaVrsta);

	    	
	    	potvrda.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						for(int i=0;i<BazaProfesora.getInstance().getProfesori().get(selektovanaVrsta).getSpisakPredmeta().size();i++) {
							for(int j=0;j<BazaPredmeta.getInstance().getPredmeti().size();j++) {
								if(BazaPredmeta.getInstance().getPredmeti().get(j).getSifraPredmeta().equals(BazaProfesora.getInstance().getProfesori().get(selektovanaVrsta).getSpisakPredmeta().get(i))) {
									BazaPredmeta.getInstance().izbrisiProfesora(BazaPredmeta.getInstance().getPredmeti().get(j));
								}
							}
							
						}
						
						controlleri.ProfesoriController.getInstance().izbrisiProfesora(selektovanaVrsta);
						obrisiProfesora.dispose();
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
		
		
		
		
		
		
		
		
		
		obrisiProfesora.setVisible(vidljiv);
		
	}

	
}
