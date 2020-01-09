package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import dialozi.DijalogBrisanjePredmeta;
import dialozi.DijalogBrisanjeProfesora;
import dialozi.DijalogBrisanjeStudenta;
import dialozi.DijalogDodajPredmet;
import dialozi.DijalogDodajProfesora;
import dialozi.DijalogDodajStudenta;
import dialozi.DijalogHelp;
import dialozi.DijalogIzmenaPredmeta;
import dialozi.DijalogIzmenaProfesora;
import dialozi.DijalogIzmenaStudenta;
import modeli.BazaPredmeta;
import modeli.BazaProfesora;
import modeli.BazaStudenata;
import tabele.PredmetiJTable;
import tabele.ProfesoriJTable;
import tabele.StudentiJTable;

public class MenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuBar() {
		super();

		// File
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);

		// dodavanje novog entiteta i zatvaranje aplikacije sa njihovim mnemonicima
		JMenuItem New = new JMenuItem("New", new ImageIcon("images/plusIcon.jpg"));
		JMenuItem close = new JMenuItem("Close", new ImageIcon("images/xIcon.jpg"));
		close.setMnemonic(KeyEvent.VK_C);
		New.setMnemonic(KeyEvent.VK_N);

		// Acceleratori za new i close
		New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));

		New.addActionListener(new ActionListener() {
			// iskace odgovarajuvi dijalog za dodavanje
			@Override
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.tab == 0) {
					new DijalogDodajStudenta(true);
				} else if (MainFrame.tab == 1) {
					new DijalogDodajProfesora(true);
				} else if (MainFrame.tab == 2) {
					new DijalogDodajPredmet(true);
				}
			}
		});

		close.addActionListener(new ActionListener() {
			// zatvara JFrame prozor
			@Override
			public void actionPerformed(ActionEvent arg0) {
				BazaStudenata.getInstance().saveStudente();
				BazaPredmeta.getInstance().savePredmete();
				BazaProfesora.getInstance().saveProfesore();
				MainFrame.getInstance().dispose();
			}
		});

		file.add(New);
		file.addSeparator();
		file.add(close);

		add(file);

		// Edit
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);

		// Izmena postojeceg i brisanje entiteta sa njihovim mnemonicima
		JMenuItem editItem = new JMenuItem("Edit", new ImageIcon("images/editIcon.jpg"));
		JMenuItem delete = new JMenuItem("Delete", new ImageIcon("images/deleteIcon.jpg"));
		editItem.setMnemonic(KeyEvent.VK_E);
		delete.setMnemonic(KeyEvent.VK_D);

		// Acceleratori za edit i delete
		editItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));

		editItem.addActionListener(new ActionListener() {
			// iskace odgovarajuvi dijalog za izmenu
			@Override
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.tab == 0) {
					if (StudentiJTable.selektovanStudent)
						new DijalogIzmenaStudenta(true);
					else
						JOptionPane.showMessageDialog(null, "Niste oznacili studenta za izmenu");
				} else if (MainFrame.tab == 1) {
					if (ProfesoriJTable.selektovanProfesor)
						new DijalogIzmenaProfesora(true);
					else
						JOptionPane.showMessageDialog(null, "Niste oznacili profesora za izmenu");
				} else if (MainFrame.tab == 2) {
					if (PredmetiJTable.selektovanPredmet)
						new DijalogIzmenaPredmeta(true);
					else
						JOptionPane.showMessageDialog(null, "Niste oznacili predmet za izmenu");
				}
			}
		});

		delete.addActionListener(new ActionListener() {
			// iskace odgovarajuvi dijalog za brisanje
			@Override
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.tab == 0) {
					if (StudentiJTable.selektovanStudent)
						new DijalogBrisanjeStudenta(true);
					else
						JOptionPane.showMessageDialog(null, "Niste oznacili studenta za brisanje");
				} else if (MainFrame.tab == 1) {
					if (ProfesoriJTable.selektovanProfesor)
						new DijalogBrisanjeProfesora(true);
					else
						JOptionPane.showMessageDialog(null, "Niste oznacili profesora za brisanje");
				} else if (MainFrame.tab == 2) {
					if (PredmetiJTable.selektovanPredmet)
						new DijalogBrisanjePredmeta(true);
					else
						JOptionPane.showMessageDialog(null, "Niste oznacili predmet za brisanje");
				}
			}
		});

		edit.add(editItem);
		edit.addSeparator();
		edit.add(delete);

		add(edit);

		// Help
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);

		// Help i delete sa njihovim mnemonicima
		JMenuItem helpItem = new JMenuItem("Help", new ImageIcon("images/helpIcon.jpg"));
		JMenuItem aboutItem = new JMenuItem("About", new ImageIcon("images/aboutIcon.jpg"));
		helpItem.setMnemonic(KeyEvent.VK_H);
		aboutItem.setMnemonic(KeyEvent.VK_A);

		// Acceleratori za help i about
		helpItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		aboutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));

		helpItem.addActionListener(new ActionListener() {
			// iskace dijalog za pomoc
			@Override
			public void actionPerformed(ActionEvent e) {
				new DijalogHelp();
			}
		});

		help.add(helpItem);
		help.addSeparator();
		help.add(aboutItem);

		add(help);

	}

}
