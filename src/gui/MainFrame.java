package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import modeli.BazaPredmeta;
import modeli.BazaProfesora;
import modeli.BazaStudenata;
import tabele.AbstractTableModelPredmeti;
import tabele.AbstractTableModelProfesori;
import tabele.AbstractTableModelStudenti;
import tabele.PredmetiJTable;
import tabele.ProfesoriJTable;
import tabele.StudentiJTable;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static MainFrame instance = null;

	private JTable tabelaStudenata;
	private JTable tabelaPredmeta;
	private JTable tabelaProfesora;
	public static int tab; // da bi znali koji tab je aktivan

	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}

	private MainFrame() throws HeadlessException {

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth * 3 / 4, screenHeight * 3 / 4);
		setTitle("Studentska sluzba");
		getContentPane().setBackground(Color.WHITE);

		setResizable(true);

		addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				BazaStudenata.getInstance().saveStudente();
				BazaPredmeta.getInstance().savePredmete();
				BazaProfesora.getInstance().saveProfesore();
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		setIconImage(new ImageIcon("images/ftn_logo.jpg").getImage());
		MenuBar mb = new MenuBar();
		this.setJMenuBar(mb);

		mb.setPreferredSize((new Dimension(screenWidth, 30)));

		ToolBar toolbar = new ToolBar();
		add(toolbar, BorderLayout.NORTH);

		StatusBar statusBar = new StatusBar();
		this.add(statusBar, BorderLayout.SOUTH);
		statusBar.setPreferredSize((new Dimension(screenWidth, 35)));

		inicijalizacijaTabbedPane();
		prikaziTabele();

		setVisible(true);
	}

	public void inicijalizacijaTabbedPane() {
		JTabbedPane tabbedPane = new JTabbedPane();
		JPanel panel1, panel2, panel3;
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();

		tabbedPane.addTab("STUDENTI", panel1);
		tabbedPane.addTab("PROFESORI ", panel2);
		tabbedPane.addTab("PREDMETI", panel3);

		tabelaStudenata = new StudentiJTable();
		JScrollPane scrollPane = new JScrollPane(tabelaStudenata);
		scrollPane.setPreferredSize(new Dimension(1300, 500));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(new EmptyBorder(60, 50, 0, 50));

		tabelaPredmeta = new PredmetiJTable();
		JScrollPane scrollPane1 = new JScrollPane(tabelaPredmeta);
		scrollPane1.setPreferredSize(new Dimension(1300, 500));
		scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane1.setBorder(new EmptyBorder(60, 50, 0, 50));

		tabelaProfesora = new ProfesoriJTable();
		JScrollPane scrollPane2 = new JScrollPane(tabelaProfesora);
		scrollPane2.setPreferredSize(new Dimension(1300, 500));
		scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane2.setBorder(new EmptyBorder(60, 50, 0, 50));

		panel1.add(scrollPane);
		panel2.add(scrollPane2);
		panel3.add(scrollPane1);

		Font font = new Font("Serif", Font.BOLD, 20);
		tabbedPane.setFont(font);
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.setBackground(Color.GRAY);

		// reaguje na promenu taba
		tabbedPane.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JTabbedPane sourceJTabbedPane = (JTabbedPane) e.getSource();
				tab = sourceJTabbedPane.getSelectedIndex();
				if (tab == 0) {
					TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(getTabelaStudenata().getModel());
					sorter.setSortable(8, false);
					sorter.setSortable(9, false);
					getTabelaStudenata().setRowSorter(sorter);
				}
				if (tab == 1) {
					TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(getTabelaProfesora().getModel());
					sorter.setSortable(3, false);
					sorter.setSortable(4, false);
					getTabelaProfesora().setRowSorter(sorter);
				}
				if (tab == 2) {
					TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(getTabelaPredmeta().getModel());
					sorter.setSortable(4, false);
					sorter.setSortable(5, false);
					getTabelaPredmeta().setRowSorter(sorter);
				}
			}
		});

		this.add(tabbedPane);

	}

	// metoda da azuriranje modela Student
	public void azurirajTabeluStudent() {
		AbstractTableModelStudenti model = (AbstractTableModelStudenti) tabelaStudenata.getModel();
		model.fireTableDataChanged();
		validate();
	}

	// metoda da azuriranje modela Predmeta
	public void azurirajTabeluPredmeta() {
		AbstractTableModelPredmeti model = (AbstractTableModelPredmeti) tabelaPredmeta.getModel();
		model.fireTableDataChanged();
		validate();
	}

	// metoda da azuriranje modela Profesora
	public void azurirajTabeluProfesora() {
		AbstractTableModelProfesori model = (AbstractTableModelProfesori) tabelaProfesora.getModel();
		model.fireTableDataChanged();
		validate();
	}

	private void prikaziTabele() {
		this.azurirajTabeluStudent();
		this.azurirajTabeluPredmeta();
		this.azurirajTabeluProfesora();
	}

	public JTable getTabelaStudenata() {
		return tabelaStudenata;
	}

	public JTable getTabelaPredmeta() {
		return tabelaPredmeta;
	}

	public JTable getTabelaProfesora() {
		return tabelaProfesora;
	}

}
