package dialozi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DijalogHelp {

	 public DijalogHelp() {
		 JDialog  dijalogHelp = new ModalniDijalog(new JFrame(), "Pomoc i nacin koriscenja aplikacije", true,800,500);
		 
		 JLabel statusBar = new JLabel();
		 dijalogHelp.add(statusBar,BorderLayout.SOUTH);
		 statusBar.setPreferredSize(new Dimension(dijalogHelp.getWidth(), 25));
		
		
		 JPanel panel = new JPanel();
		 panel.setLayout(new GridBagLayout());
		 panel.setBackground(Color.WHITE);
		 dijalogHelp.add(panel,BorderLayout.CENTER);
		 
		JLabel dodavanjeEntiteta = new JLabel("Klikom na ikonicu omogucuje se dodavanje novog entiteta ");
		JLabel dodavanjeIkonica = new JLabel(new ImageIcon("images/add.jpg"));
		JLabel izmenaEntiteta = new JLabel("Klikom na ikonicu omogucuje se izmena postojeceg entiteta samo ako je red selektovan");
		JLabel izmenaIkonica = new JLabel(new ImageIcon("images/edit.jpg"));
		JLabel brisanjeEntiteta = new JLabel("Klikom na ikonicu omogucuje se brisanje postojeceg entiteta samo ako je red selektovan");
		JLabel brisanjeIkonica = new JLabel(new ImageIcon("images/delete.jpg"));
		JLabel precice = new JLabel("Precice");
		JLabel opisKoriscenja = new JLabel("Kratak opis koriscenja ikonica");
		JLabel ikonice = new JLabel("Ikonice");
		JLabel ctrlN = new JLabel("CTRL+N");
		JLabel ctrlE = new JLabel("CTRL+E");
		JLabel ctrlD = new JLabel("CTRL+D");
		
		Font font = new Font("Serif", Font.BOLD, 20);
		precice.setFont(font);
		precice.setForeground(Color.RED);
		opisKoriscenja.setFont(font);
		opisKoriscenja.setForeground(Color.RED);
		ikonice.setFont(font);
		ikonice.setForeground(Color.RED);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(5, 0, 5, 20);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(ikonice,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(dodavanjeIkonica,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(izmenaIkonica,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(brisanjeIkonica,gbc);
		
		gbc.insets = new Insets(5, 20, 5, 20);
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(opisKoriscenja,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(dodavanjeEntiteta,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(izmenaEntiteta,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		panel.add(brisanjeEntiteta,gbc);
		
		gbc.insets = new Insets(5, 20, 5, 0);
		gbc.gridx = 2;
		gbc.gridy = 0;
		panel.add(precice,gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		panel.add(ctrlN,gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		panel.add(ctrlE,gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 3;
		panel.add(ctrlD,gbc);
		
		 dijalogHelp.setVisible(true);
	}
	
	
}
