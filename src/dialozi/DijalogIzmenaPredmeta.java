package dialozi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlleri.PredmetiController;
import gui.MainFrame;
import modeli.BazaPredmeta;
import modeli.BazaProfesora;
import modeli.Predmet;
import tabele.PredmetiJTable;

public class DijalogIzmenaPredmeta {

	private static int onemoguciTxtField = 0;

	public DijalogIzmenaPredmeta(boolean vidljiv) {
		JDialog izmeniPredmet = new ModalniDijalog(MainFrame.getInstance(), "Izmeni predmet", true, 600, 750);

		JLabel statusBar = new JLabel();
		izmeniPredmet.add(statusBar, BorderLayout.SOUTH);
		statusBar.setPreferredSize(new Dimension(izmeniPredmet.getWidth(), 25));

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.WHITE);
		izmeniPredmet.add(panel, BorderLayout.CENTER);

		izmeniPredmet.add(panel);

		JLabel sifra = new JLabel("Sifra predmeta*");
		JLabel nazivPredmeta = new JLabel("Naziv predmeta*");
		JLabel semestar = new JLabel("Semestar izvodjenja*");
		JLabel godinaIzvodjenja = new JLabel("Godina studija izvodjenja*");
		JLabel profesor = new JLabel("Predmetni profesor*");

		int selektovanaVrsta = MainFrame.getInstance().getTabelaPredmeta().getRowSorter()
				.convertRowIndexToModel(PredmetiJTable.selektovanaVrsta);

		JTextField Sifra = new JTextField(BazaPredmeta.getInstance().getRow(selektovanaVrsta).getSifraPredmeta());
		Sifra.setPreferredSize(new Dimension(100, 30));
		JTextField NazivPredmeta = new JTextField(
				BazaPredmeta.getInstance().getRow(selektovanaVrsta).getNazivPredmet());
		NazivPredmeta.setPreferredSize(new Dimension(100, 30));

		// PremdetniProfesor comboBox
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
			Profesor.setSelectedItem(BazaPredmeta.getInstance().getRow(selektovanaVrsta).getPredmetniProfesor());
		// Semestar comboBox
		String[] izbor = { "1 (prvi)", "2 (drugi) ", "3 (treci)", "4 (cetvrti)", "5 (peti)", "6 (sesti) ", "7 (sedmi)",
				"8 (osmi)", };

		final JComboBox<String> semestarCB = new JComboBox<String>(izbor);
		semestarCB.setPreferredSize(new Dimension(100, 30));
		String s = semestarCB.getItemAt(BazaPredmeta.getInstance().getRow(selektovanaVrsta).getSemestar() - 1);
		semestarCB.setSelectedItem(s);
		// GodinaIzvodjenja comboBox
		String[] izbor1 = { "I (prva)", "II (druga) ", "III (treca)", "IV (cetvrta)" };

		final JComboBox<String> godinaIzvodjenjaCB = new JComboBox<String>(izbor1);
		godinaIzvodjenjaCB.setPreferredSize(new Dimension(100, 30));
		String g = godinaIzvodjenjaCB
				.getItemAt(BazaPredmeta.getInstance().getRow(selektovanaVrsta).getGodinaIzvodjenjaPredmeta() - 1);
		godinaIzvodjenjaCB.setSelectedItem(g);

		JButton odustanak = new JButton("Odustanak");
		JButton potvrda = new JButton("Potvrda");
		odustanak.setBackground(Color.LIGHT_GRAY);
		potvrda.setBackground(Color.CYAN);

		odustanak.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				izmeniPredmet.dispose();

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
					List<String> lista = new ArrayList<String>();
					lista = BazaPredmeta.getInstance().getPredmeti().get(selektovanaVrsta).getSpisakStudenata();
					Predmet predmet = new Predmet(sifra, naziv, semestar, godinaIzvodjenja, profesor, lista);

					boolean omoguciIzmenu = true;

					for (int i = 0; i < BazaPredmeta.getInstance().getPredmeti().size(); i++) {
						if (!sifra.equals(
								BazaPredmeta.getInstance().getPredmeti().get(selektovanaVrsta).getSifraPredmeta())) {
							if (sifra.equals(BazaPredmeta.getInstance().getPredmeti().get(i).getSifraPredmeta())) {
								omoguciIzmenu = false;
								break;
							}
						}
					}

					if (omoguciIzmenu) {
						PredmetiController.getInstance().izmeniPredmet(predmet);
						onemoguciTxtField = 0;
						PredmetiJTable.selektovanaVrsta = -1;
						izmeniPredmet.dispose();
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

		izmeniPredmet.setVisible(vidljiv);
	}

}
