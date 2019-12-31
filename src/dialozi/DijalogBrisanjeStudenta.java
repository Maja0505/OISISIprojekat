package dialozi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DijalogBrisanjeStudenta {

	public DijalogBrisanjeStudenta(boolean vidljiv) {
		JDialog  dodajStudenta = new ModalniDijalog(new JFrame(), "Brisanje studenta", true,400,200);
		
		
		JLabel statusBar = new JLabel();
		dodajStudenta.add(statusBar,BorderLayout.SOUTH);
		statusBar.setPreferredSize(new Dimension(dodajStudenta.getWidth(), 25));
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.WHITE);
		dodajStudenta.add(panel,BorderLayout.CENTER);
		
		dodajStudenta.add(panel);
		
		JLabel brisanje = new JLabel("Da li ste sigurni da zelite da obrisete studenta ?");
		JLabel kantaZaBrisanje = new JLabel();
		kantaZaBrisanje.setIcon(new ImageIcon("images/delete.jpg"));
		
		
	    JButton odustanak = new JButton("Odustanak");
	    JButton potvrda = new JButton("Potvrda");
	    
		
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
		
		
		
		
		
		
		
		
		
		dodajStudenta.setVisible(vidljiv);
		
	}

	
	
}
