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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlleri.PredmetiController;
import gui.MainFrame;
import listeners.FocusListener;
import modeli.BazaPredmeta;
import modeli.BazaProfesora;
import modeli.Predmet;
import tabele.PredmetiJTable;

public class DijalogDodajPredmet {

	private static int onemoguciTxtField = 0;

	public DijalogDodajPredmet(boolean vidljiv) {
		JDialog dodajPredmet = new ModalniDijalog(MainFrame.getInstance(), "Dodaj predmet", true, 600, 750);

		JLabel statusBar = new JLabel();
		dodajPredmet.add(statusBar, BorderLayout.SOUTH);
		statusBar.setPreferredSize(new Dimension(dodajPredmet.getWidth(), 25));

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.WHITE);
		dodajPredmet.add(panel, BorderLayout.CENTER);

		dodajPredmet.add(panel);

		JLabel sifra = new JLabel("Sifra predmeta*");
		JLabel nazivPredmeta = new JLabel("Naziv predmeta*");
		JLabel semestar = new JLabel("Semestar izvodjenja*");
		JLabel godinaIzvodjenja = new JLabel("Godina studija izvodjenja*");
		JLabel profesor = new JLabel("Predmetni profesor*");

		JTextField Sifra = new JTextField();
		Sifra.setName("Sifra predmeta*");
		Sifra.setPreferredSize(new Dimension(100, 30));
		Sifra.addFocusListener(new FocusListener());

		JTextField NazivPredmeta = new JTextField();
		NazivPredmeta.setName("Naziv predmeta*");
		NazivPredmeta.setPreferredSize(new Dimension(100, 30));
		NazivPredmeta.addFocusListener(new FocusListener());

		String[] izborProfesora = new String[BazaProfesora.getInstance().getProfesori().size() + 1];
		
		izborProfesora[0] = "NEMA PROFESORA";
		int j=0;
		
		for (int i = 0; i < BazaProfesora.getInstance().getProfesori().size(); i++) {
			j = i + 1;
			izborProfesora[j] = BazaProfesora.getInstance().getProfesori().get(i).getBrojLicneKarte() + ","
					+ BazaProfesora.getInstance().getProfesori().get(i).getIme().concat(" ")
							.concat(BazaProfesora.getInstance().getProfesori().get(i).getPrezime());
		}
		
		final JComboBox<String> Profesor;
	
			Profesor = new JComboBox<String>(izborProfesora);

			Profesor.setPreferredSize(new Dimension(100, 30));
		

		String[] izbor = { "1 (prvi)", "2 (drugi) ", "3 (treci)", "4 (cetvrti)", "5 (peti)", "6 (sesti) ", "7 (sedmi)",
				"8 (osmi)", };

		final JComboBox<String> semestarCB = new JComboBox<String>(izbor);
		semestarCB.setPreferredSize(new Dimension(100, 30));

		String[] izbor1 = { "I (prva)", "II (druga) ", "III (treca)", "IV (cetvrta)" };

		final JComboBox<String> godinaIzvodjenjaCB = new JComboBox<String>(izbor1);
		godinaIzvodjenjaCB.setPreferredSize(new Dimension(100, 30));

		JButton odustanak = new JButton("Odustanak");
		JButton potvrda = new JButton("Potvrda");
		 odustanak.setBackground(Color.LIGHT_GRAY);
		 potvrda.setBackground(Color.CYAN);

		odustanak.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dodajPredmet.dispose();

			}
		});

		potvrda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (!Sifra.getText().equals("") && !Sifra.getText().equals("Nepravilan unos sifre predmeta")) {
					onemoguciTxtField++;
				}
				if (!NazivPredmeta.getText().equals("")
						&& !NazivPredmeta.getText().equals("Nepravilan unos naziva predmeta")) {
					onemoguciTxtField++;
				}
				if (onemoguciTxtField == 2) {
					String sifra = Sifra.getText();
					String naziv = NazivPredmeta.getText();
					int semestar = semestarCB.getSelectedIndex() + 1;
					int godinaIzvodjenja = godinaIzvodjenjaCB.getSelectedIndex() + 1;
					if (semestar != godinaIzvodjenja * 2 && semestar != godinaIzvodjenja * 2 - 1) {
						JOptionPane.showMessageDialog(null,
								"Za godinu " + godinaIzvodjenja + " morate izabrati ili " + (godinaIzvodjenja * 2 - 1)
										+ " ili " + godinaIzvodjenja * 2 + " semestar, ili promenite godinu");
						onemoguciTxtField = 0;
						return;
					}
					String profesor = Profesor.getSelectedItem().toString();
					Predmet predmet = new Predmet(sifra, naziv, semestar, godinaIzvodjenja, profesor, null);

					boolean mogucUnos = true;
					for (int i = 0; i < BazaPredmeta.getInstance().getPredmeti().size(); i++) {
						if (sifra.equals(BazaPredmeta.getInstance().getPredmeti().get(i).getSifraPredmeta())) {
							mogucUnos = false;
							break;
						}
					}

					if (mogucUnos) {
						PredmetiController.getInstance().dodajPredmet(predmet);
						onemoguciTxtField = 0;
						PredmetiJTable.selektovanaVrsta = -1;
						dodajPredmet.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Vec postoji takav predmet");
						onemoguciTxtField = 0;
					}
				} else {
					JOptionPane.showMessageDialog(null, "Niste uneli sva polja");
					onemoguciTxtField = 0;
				}
			}
		});

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 20, 70, 0);
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
