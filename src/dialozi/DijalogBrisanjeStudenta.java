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

import tabele.StudentiJTable;

public class DijalogBrisanjeStudenta {

	public DijalogBrisanjeStudenta(boolean vidljiv) {
		JDialog  obrisiStudenta = new ModalniDijalog(new JFrame(), "Brisanje studenta", true,400,200);
		
		
		JLabel statusBar = new JLabel();
		obrisiStudenta.add(statusBar,BorderLayout.SOUTH);
		statusBar.setPreferredSize(new Dimension(obrisiStudenta.getWidth(), 25));
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.WHITE);
		obrisiStudenta.add(panel,BorderLayout.CENTER);
		
		obrisiStudenta.add(panel);
		
		JLabel brisanje = new JLabel("Da li ste sigurni da zelite da obrisete studenta ?");
		JLabel kantaZaBrisanje = new JLabel();
		kantaZaBrisanje.setIcon(new ImageIcon("images/delete.jpg"));
		
		
	    JButton odustanak = new JButton("Odustanak");
	    odustanak.setBackground(Color.LIGHT_GRAY);
	    JButton potvrda = new JButton("Potvrda");
	    potvrda.setBackground(Color.CYAN);
	    
	    potvrda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controlleri.StudentiController.getInstance().izbrisiStudenta(StudentiJTable.selektovanaVrsta);
				obrisiStudenta.dispose();
			}
		});
	    
	    odustanak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				obrisiStudenta.dispose();
				
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
		
		
		
		
		
		
		
		
		
		obrisiStudenta.setVisible(vidljiv);
		
	}

	
	
}
