package dialozi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import gui.MainFrame;

public class DijalogAbout {

	
	public DijalogAbout() {
		JDialog dijalogAbout = new ModalniDijalog(MainFrame.getInstance(), "Informacije o aplikaciji i autorima", true,1000,700) ;
			
			 JLabel statusBar = new JLabel();
			 dijalogAbout.add(statusBar,BorderLayout.SOUTH);
			 statusBar.setPreferredSize(new Dimension(dijalogAbout.getWidth(), 25));
			
			
			 JPanel panel = new JPanel();
			 panel.setLayout(new BorderLayout());
			 panel.setBackground(Color.WHITE);
			 dijalogAbout.add(panel,BorderLayout.CENTER);
			 
			JPanel unutrasnjiPanel1 = new JPanel();
			unutrasnjiPanel1.setLayout(new GridBagLayout());
			unutrasnjiPanel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Informacije o aplikaciji"));
			unutrasnjiPanel1.setBackground(Color.LIGHT_GRAY);
			
			JTextArea aplikacija = new JTextArea("	Verzija aplikacije : V1.0 "
					+ "\n\nOpis aplikacije : Aplikacija je namenjena za lakse upravljanje studentskom sluzbom,neke od mogucih"
					+ "\nfunkcija su sortitanje,pretraga,dodavanje,izmena,brisanje studenata,profesora kao i predmeta."
					+ "\nSvi podaci se cuvaju u datotekama i azuriraju pri svakom zatvaranju aplikacije");
			Font font = new Font("Serif", Font.BOLD, 15);
			aplikacija.setFont(font);
			unutrasnjiPanel1.add(aplikacija);
			aplikacija.setEditable(false);
			aplikacija.setBackground(Color.LIGHT_GRAY);
			
			
			JPanel unutrasnjiPanel2 = new JPanel();
			unutrasnjiPanel2.setLayout(new GridBagLayout());
			unutrasnjiPanel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Informacije o studentima"));
			unutrasnjiPanel2.setBackground(Color.LIGHT_GRAY);
			
			JLabel student1 = new JLabel("Student 1");
			JLabel nemanja = new JLabel("Ime i prezime :");
			JLabel jevtic = new JLabel(" Nemanja Jevtic");
			JLabel mesto = new JLabel(" Mesto rodjenja: ");
			JLabel rodjenja	= new JLabel(" Loznica");
			JLabel datum = new JLabel("Datum rodjenja: ");
			JLabel rodjenje = new JLabel("11.08.1998.");
			JLabel srednja = new JLabel("Srednja skola: ");
			JLabel skola = new JLabel(" Sprotska gimnazija");
			JLabel faks = new JLabel("Trenutno pohadja : ");
			JLabel ftn = new JLabel(" FTN");
			
			JLabel student2 = new JLabel("Student 2");
			JLabel maja = new JLabel("Ime i prezime :");
			JLabel tomic = new JLabel(" Maja Tomic");
			JLabel mesto2 = new JLabel(" Mesto rodjenja: ");
			JLabel rodjenja2	= new JLabel(" Beograd");
			JLabel datum2 = new JLabel("Datum rodjenja: ");
			JLabel rodjenje2 = new JLabel("02.12.1998.");
			JLabel srednja2 = new JLabel("Srednja skola: ");
			JLabel skola2 = new JLabel(" Gimnazija u Indjiji");
			JLabel faks2 = new JLabel("Trenutno pohadja : ");
			JLabel ftn2 = new JLabel(" FTN");
			
			
			JPanel unutrasnjiPanel3 = new JPanel();
			unutrasnjiPanel3.setLayout(new GridBagLayout());
			unutrasnjiPanel3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Slike autora"));
			unutrasnjiPanel3.setBackground(Color.LIGHT_GRAY);
			
			JLabel majaSlika = new JLabel(new ImageIcon("images/maja.jpg"));
			JLabel nemanjaSlika = new JLabel(new ImageIcon("images/nemanja.jpg"));
			
			
			
			
			unutrasnjiPanel3.add(majaSlika);
			
			GridBagConstraints gbc = new GridBagConstraints();
			
			
			gbc.gridx = 1;
			gbc.gridy = 0;
			gbc.insets = new Insets(5, 30, 5, 5);
			unutrasnjiPanel3.add(majaSlika,gbc);
			
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.insets = new Insets(5, 5, 5, 30);
			unutrasnjiPanel3.add(nemanjaSlika,gbc);
			
			gbc.insets = new Insets(0, 0, 0, 0);
			gbc.gridx = 0;
			gbc.gridy = 0;
			unutrasnjiPanel2.add(student1, gbc);
			
			gbc.gridx = 0;
			gbc.gridy = 1;
			unutrasnjiPanel2.add(nemanja, gbc);

			gbc.gridx = 0;
			gbc.gridy = 2;
			unutrasnjiPanel2.add(mesto, gbc);
			
			gbc.gridx = 0;
			gbc.gridy = 3;
			unutrasnjiPanel2.add(datum, gbc);
			
			gbc.gridx = 0;
			gbc.gridy = 4;
			unutrasnjiPanel2.add(srednja, gbc);
			
			gbc.gridx = 0;
			gbc.gridy = 5;
			unutrasnjiPanel2.add(faks, gbc);
			
			
			gbc.insets = new Insets(5, 10, 5, 30);
			gbc.gridx = 1;
			gbc.gridy = 1;
			unutrasnjiPanel2.add(jevtic, gbc);
			
			gbc.gridx = 1;
			gbc.gridy = 2;
			unutrasnjiPanel2.add(rodjenja, gbc);
			
			gbc.gridx = 1;
			gbc.gridy = 3;
			unutrasnjiPanel2.add(rodjenje, gbc);
			
			gbc.gridx = 1;
			gbc.gridy = 4;
			unutrasnjiPanel2.add(skola, gbc);
			
			gbc.gridx = 1;
			gbc.gridy = 5;
			unutrasnjiPanel2.add(ftn, gbc);
			
			gbc.insets = new Insets(5, 150, 5, 5);
			gbc.gridx = 2;
			gbc.gridy = 0;
			unutrasnjiPanel2.add(student2, gbc);
			
			gbc.gridx = 2;
			gbc.gridy = 1;
			unutrasnjiPanel2.add(maja, gbc);
			
			gbc.gridx = 2;
			gbc.gridy = 2;
			unutrasnjiPanel2.add(mesto2, gbc);
			
			gbc.gridx = 2;
			gbc.gridy = 3;
			unutrasnjiPanel2.add(datum2, gbc);
			
			gbc.gridx = 2;
			gbc.gridy = 4;
			unutrasnjiPanel2.add(srednja2, gbc);
			
			gbc.gridx = 2;
			gbc.gridy = 5;
			unutrasnjiPanel2.add(faks2, gbc);
			
			gbc.insets = new Insets(5, 10, 5, 0);
			gbc.gridx = 3;
			gbc.gridy = 1;
			unutrasnjiPanel2.add(tomic, gbc);
			
			gbc.gridx = 3;
			gbc.gridy = 2;
			unutrasnjiPanel2.add(rodjenja2, gbc);
			
			gbc.gridx = 3;
			gbc.gridy = 3;
			unutrasnjiPanel2.add(rodjenje2, gbc);
			
			gbc.gridx = 3;
			gbc.gridy = 4;
			unutrasnjiPanel2.add(skola2, gbc);
			
			gbc.gridx = 3;
			gbc.gridy = 5;
			unutrasnjiPanel2.add(ftn2, gbc);
			
			

			panel.add(unutrasnjiPanel1,BorderLayout.NORTH);
			panel.add(unutrasnjiPanel2,BorderLayout.SOUTH);
			panel.add(unutrasnjiPanel3,BorderLayout.CENTER); 
			
		dijalogAbout.setVisible(true);
	}
	
}
