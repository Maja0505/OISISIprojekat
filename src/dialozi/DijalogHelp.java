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
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.MainFrame;

public class DijalogHelp {

	 public DijalogHelp() {
		 JDialog  dijalogHelp = new ModalniDijalog(MainFrame.getInstance(), "Pomoc i nacin koriscenja aplikacije", true,1200,700);
		 
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
		JLabel ctrlC = new JLabel("CTRL+C");
		JLabel ctrlI = new JLabel("CTRL+I");
		JLabel opisKoriscenja = new JLabel("Kratak opis koriscenja ikonica");
		JLabel ikonice = new JLabel("Ikonice");
		JLabel closeOpis = new JLabel("Klikom na ikonicu zatvara se program i vrsi se cuvanje podataka");
		JLabel infOpis = new JLabel("Klikom na ikonicu pruza se biografija autora");
		JLabel dsnpOpis = new JLabel("Klikom na ikonicu omogucava se dodavanje studenta na oznaceni predmet");
		JLabel dpnpOpis = new JLabel("Klikom na ikonicu omogucava se dodavanje profesora na oznaceni predmet");
		JLabel lupaOpis = new JLabel("Pretraga primer - ime:*****;prezime:*****;....");
		JLabel colse = new JLabel(new ImageIcon("images/xIcon.jpg"));
		JLabel info = new JLabel(new ImageIcon("images/aboutIcon.jpg"));
		JLabel dsnp = new JLabel(new ImageIcon("images/add.jpg"));
		JLabel dpnp = new JLabel(new ImageIcon("images/profesor.jpg"));
		JLabel lupa = new JLabel(new ImageIcon("images/pretraga.jpg"));
		JLabel ctrlN = new JLabel("CTRL+N");
		JLabel ctrlE = new JLabel("CTRL+E");
		JLabel ctrlD = new JLabel("CTRL+D");
		
		JLabel izmenaDodavanje = new JLabel("Ogranicenja pri dodavanju/izmeni");
		
		JLabel Student = new JLabel("STUDENT");
		JLabel indeksOgranicenje = new JLabel("Ocekivani format indeksa : XXBROJ/GODINAUPISA");
		JLabel datumOgranicenje = new JLabel("Ocekivani format za datume : yyyy.MM.dd.");
		JLabel adresaOgranicenje = new JLabel("Ocekivani format za adresu : Ulica [broj] , grad");
		JLabel brojTelefonaOgranicenje = new JLabel("Ocekivani format za broj tel : pozivNaBroj**/****-***");
		
		JLabel Profesor = new JLabel("PROFESOR");
		JLabel datumOgranicenje2 = new JLabel("Ocekivani format za datume : yyyy.MM.dd.");
		JLabel adresaOgranicenje2 = new JLabel("Ocekivani format za adresu : Ulica [broj] , grad");
		JLabel brojTelefonaOgranicenje2 = new JLabel("Ocekivani format za broj tel : pb/****-***");
		JLabel adresaOgranicenje3 = new JLabel("Ocekivani format za adresu : Ulica [broj] , grad , kancelarija");
		JLabel brLicneOgranicenje = new JLabel("Ocekivani format licne karte je 9-tocifreni broj");
		
		JLabel Predmet = new JLabel("PREDMET");
		JLabel sifraOgranicenje = new JLabel("Sifra predmeta se sastoji od velikog slova");
		JLabel ogranicenjeNastavak = new JLabel("celobrojnog broja i moze da sadrzi i karakter -");
		JLabel ogranicenjeSemestra = new JLabel("Voditi racuna o pravilnom izboru semestra");
		JLabel ogranicenjeNastavak2 = new JLabel("i odgovarajucoj godini studija za taj semestar");
		
		Font font = new Font("Serif", Font.BOLD, 20);
		Font font2 = new Font("Serif", Font.BOLD, 15);
		precice.setFont(font);
		precice.setForeground(Color.RED);
		opisKoriscenja.setFont(font);
		opisKoriscenja.setForeground(Color.RED);
		ikonice.setFont(font);
		ikonice.setForeground(Color.RED);
		izmenaDodavanje.setFont(font);
		izmenaDodavanje.setForeground(Color.RED);
		Student.setFont(font2);
		Student.setForeground(Color.RED);
		Profesor.setFont(font2);
		Profesor.setForeground(Color.RED);
		Predmet.setFont(font2);
		Predmet.setForeground(Color.RED);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(10, 0, 10, 20);
		gbc.gridx = 1;
		gbc.gridy = 9;
		panel.add(izmenaDodavanje,gbc);
		
		gbc.insets = new Insets(5, 0, 5, 20);
		gbc.gridx = 0;
		gbc.gridy = 10;
		panel.add(Student,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 11;
		panel.add(indeksOgranicenje,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 12;
		panel.add(datumOgranicenje,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 13;
		panel.add(adresaOgranicenje,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 14;
		panel.add(brojTelefonaOgranicenje,gbc);
		
		gbc.insets = new Insets(5, 0, 5, 20);
		gbc.gridx = 1;
		gbc.gridy = 10;
		panel.add(Profesor,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 11;
		panel.add(datumOgranicenje2,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 12;
		panel.add(adresaOgranicenje2,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 13;
		panel.add(brojTelefonaOgranicenje2,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 14;
		panel.add(adresaOgranicenje3,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 15;
		panel.add(brLicneOgranicenje,gbc);
		
		gbc.insets = new Insets(5, 0, 5, 20);
		gbc.gridx = 2;
		gbc.gridy = 10;
		panel.add(Predmet,gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 11;
		panel.add(sifraOgranicenje,gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 12;
		panel.add(ogranicenjeNastavak,gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 13;
		panel.add(ogranicenjeSemestra,gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 14;
		panel.add(ogranicenjeNastavak2,gbc);
		
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
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(colse,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		panel.add(info,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		panel.add(dsnp,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 7;
		panel.add(dpnp,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 8;
		panel.add(lupa,gbc);
		
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
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		panel.add(closeOpis,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 5;
		panel.add(infOpis,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 6;
		panel.add(dsnpOpis,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 7;
		panel.add(dpnpOpis,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 8;
		panel.add(lupaOpis,gbc);
		
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
		
		gbc.gridx = 2;
		gbc.gridy = 4;
		panel.add(ctrlC,gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 5;
		panel.add(ctrlI,gbc);
		
		
		 dijalogHelp.setVisible(true);
	}
	
	
}
