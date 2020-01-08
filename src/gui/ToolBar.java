package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import dialozi.DijalogBrisanjePredmeta;
import dialozi.DijalogBrisanjeProfesora;
import dialozi.DijalogBrisanjeStudenta;
import dialozi.DijalogDodajPredmet;
import dialozi.DijalogDodajProfesora;
import dialozi.DijalogDodajProfesoraNaPredmet;
import dialozi.DijalogDodajStudenta;
import dialozi.DijalogDodajStudentaNaPredmet;
import dialozi.DijalogIzmenaPredmeta;
import dialozi.DijalogIzmenaProfesora;
import dialozi.DijalogIzmenaStudenta;
import tabele.AbstractTableModelPredmeti;
import tabele.AbstractTableModelStudenti;
import tabele.PredmetiJTable;
import tabele.ProfesoriJTable;
import tabele.StudentiJTable;

public class ToolBar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ToolBar() {
		super(SwingConstants.HORIZONTAL);

		// dodaj
		JButton buttonNew = new JButton();
		buttonNew.setToolTipText("Dodaj");
		buttonNew.setIcon(new ImageIcon("images/add.jpg"));
		add(buttonNew);

		buttonNew.addActionListener(new ActionListener() {

			//iskace odgovarajuvi dijalog za dodavanje			
			// @Override
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

		addSeparator();

		// izmena
		JButton buttonEdit = new JButton();
		buttonEdit.setToolTipText("Izmeni");
		buttonEdit.setIcon(new ImageIcon("images/edit.jpg"));
		add(buttonEdit);

		buttonEdit.addActionListener(new ActionListener() {
			//iskace odgovarajuvi dijalog za izmenu			
			// @Override
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.tab == 0 && StudentiJTable.selektovanStudent) {
					new DijalogIzmenaStudenta(true);
				} else if (MainFrame.tab == 1 && ProfesoriJTable.selektovanProfesor) {
					new DijalogIzmenaProfesora(true);
				} else if (MainFrame.tab == 2 && PredmetiJTable.selektovanPredmet) {
					new DijalogIzmenaPredmeta(true);
				}
			}
		});

		addSeparator();

		// brisanje

		JButton buttonDelete = new JButton();
		buttonDelete.setToolTipText("Obrisi");
		buttonDelete.setIcon(new ImageIcon("images/delete.jpg"));

		add(buttonDelete);

		buttonDelete.addActionListener(new ActionListener() {

			//iskace odgovarajuvi dijalog za brisanje			
			// @Override
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.tab == 0 && StudentiJTable.selektovanStudent) {
					new DijalogBrisanjeStudenta(true);
				} else if (MainFrame.tab == 1 && ProfesoriJTable.selektovanProfesor) {
					new DijalogBrisanjeProfesora(true);
				} else if (MainFrame.tab == 2 && PredmetiJTable.selektovanPredmet) {
					new DijalogBrisanjePredmeta(true);

				}
			}
		});

		addSeparator();

		JButton studentButton = new JButton();
		studentButton.setToolTipText("Dodavanje studenta na predmet");
		studentButton.setIcon(new ImageIcon("images/add.jpg"));

		studentButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (MainFrame.tab == 2)
					if (PredmetiJTable.selektovanPredmet)
						new DijalogDodajStudentaNaPredmet();
					else
						JOptionPane.showMessageDialog(null, "Niste oznacili predmet na koji zelite da dodate studenta");
			}
		});

		add(studentButton);

		addSeparator();

		JButton profesorButton = new JButton();
		profesorButton.setToolTipText("Dodavanje profesora na predmet");
		profesorButton.setIcon(new ImageIcon("images/profesor.jpg"));

		profesorButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.tab == 2) {
					if (PredmetiJTable.selektovanPredmet) {
						new DijalogDodajProfesoraNaPredmet();
					} else {
						JOptionPane.showMessageDialog(null,
								"Niste oznacili predmet na koji zelite da dodate profesora");
					}
				}

			}
		});

		add(profesorButton);

		for (int i = 0; i < 85; i++) {
			addSeparator();
		}

		JTextField textField = new JTextField();
		textField.setDocument(new JTextFieldLimit(100));
		Font font = new Font("Serif", Font.BOLD, 15); // font za unos
		textField.setFont(font);
		add(textField);

		setFloatable(false);

		// pretraga
		JButton buttonSearch = new JButton();
		buttonSearch.setToolTipText("Pretraga");
		buttonSearch.setIcon(new ImageIcon("images/pretraga.jpg"));
		buttonSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(MainFrame.tab == 0) {
					if(!textField.getText().equals("") ) {
						
						if(textField.getText().contains(":")) {
							String[] kolone=textField.getText().split(";");
							String nazivKolone;
							String tekst=null;
								@SuppressWarnings("unchecked")
								TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>)  MainFrame.getInstance().getTabelaStudenata().getRowSorter();
								List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(2);
							for(int i=0;i<kolone.length;i++) {
								String[] podela2=kolone[i].split(":");
									if(podela2.length == 2) {
										nazivKolone = podela2[0];
										tekst = podela2[1];
										AbstractTableModelStudenti atms = new AbstractTableModelStudenti();
										String indeks = null;
										String ime = null;
										String prezime = null;
										String godinaUpisa = null;
										String godinaStudija = null;
										String datum = null;
										String prosecnaOcena = null;
										String status = null;
									
										if(nazivKolone.toLowerCase().equals(atms.getColumnName(0).toLowerCase())) {
											indeks = tekst;
											filters.add(RowFilter.regexFilter("(?i)" + indeks,0));
										}else if(nazivKolone.toLowerCase().equals(atms.getColumnName(1).toLowerCase())) {
											ime = tekst;
											filters.add(RowFilter.regexFilter("(?i)" + ime,1));
										}else if(nazivKolone.toLowerCase().equals(atms.getColumnName(2).toLowerCase())) {
											prezime = tekst;
											filters.add(RowFilter.regexFilter("(?i)" + prezime,2));
										}else if(nazivKolone.toLowerCase().equals(atms.getColumnName(3).toLowerCase())) {
											godinaUpisa = tekst;
											filters.add(RowFilter.regexFilter("(?i)" + godinaUpisa,3));
										}else if(nazivKolone.toLowerCase().equals(atms.getColumnName(4).toLowerCase())) {
											godinaStudija = tekst;
											filters.add(RowFilter.regexFilter("(?i)" + godinaStudija,4));
										}else if(nazivKolone.toLowerCase().equals(atms.getColumnName(5).toLowerCase())) {
											datum = tekst;
											filters.add(RowFilter.regexFilter("(?i)" + datum,5));
										}else if(nazivKolone.toLowerCase().equals(atms.getColumnName(6).toLowerCase())) {
											prosecnaOcena = tekst;
											filters.add(RowFilter.regexFilter("(?i)" + prosecnaOcena,6));
										}else if(nazivKolone.toLowerCase().equals(atms.getColumnName(7).toLowerCase())) {
											status = tekst;
											filters.add(RowFilter.regexFilter("(?i)" + status,7));
										}else {
											JOptionPane.showMessageDialog(null, "Ne postoji kolona " + nazivKolone + " u tabeli predmeta", "Greska",0);
											break;
										}
										
									
										sorter = new TableRowSorter<TableModel>( MainFrame.getInstance().getTabelaStudenata().getModel());
									    sorter.setRowFilter(RowFilter.andFilter(filters));
					
									    
										 MainFrame.getInstance().getTabelaStudenata().setRowSorter(sorter);
										 textField.setText("");
									
									}else {
										JOptionPane.showMessageDialog(null, "Neispravan format pretrage pravilno [Ime:******;Prezime:*****;...]");
									}
									
							}	
							
						}else {
							JOptionPane.showMessageDialog(null, "Neispravan format pretrage pravilno [Ime:******;Prezime:*****;...]");
						}
						
					}else {
						
						@SuppressWarnings("unchecked")
						TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) MainFrame.getInstance().getTabelaStudenata().getRowSorter();
						
					    sorter.setRowFilter(null);
					}
				}
				
				if (MainFrame.tab == 2) {
					if (!textField.getText().equals("")) {
						if (textField.getText().contains(":")) {
							String[] kolone = textField.getText().split(";");
							String nazivKolone;
							String tekst = null;
							@SuppressWarnings("unchecked")
							TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) MainFrame.getInstance()
									.getTabelaPredmeta().getRowSorter();
							List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(2);
							for (int i = 0; i < kolone.length; i++) {
								String[] podela2 = kolone[i].split(":");
								if (podela2.length == 2) {
									nazivKolone = podela2[0];
									tekst = podela2[1];
									AbstractTableModelPredmeti atmp = new AbstractTableModelPredmeti();
									String sifraPredmeta = null;
									String nazivPredmeta = null;
									String semestar = null;
									String godinaIzvodjenja = null;
									String predmetniProfesor = null;

									if (nazivKolone.toLowerCase().equals(atmp.getColumnName(0).toLowerCase())) {
										sifraPredmeta = tekst;

										filters.add(RowFilter.regexFilter("(?i)" +sifraPredmeta, 0));

									} else if (nazivKolone.toLowerCase().equals(atmp.getColumnName(1).toLowerCase())) {
										nazivPredmeta = tekst;

										filters.add(RowFilter.regexFilter("(?i)" +nazivPredmeta, 1));

									} else if (nazivKolone.toLowerCase().equals(atmp.getColumnName(2).toLowerCase())) {
										semestar = tekst;

										filters.add(RowFilter.regexFilter("(?i)" +semestar, 2));

									} else if (nazivKolone.toLowerCase().equals(atmp.getColumnName(3).toLowerCase())) {
										godinaIzvodjenja = tekst;

										filters.add(RowFilter.regexFilter("(?i)" +godinaIzvodjenja, 3));

									} else if (nazivKolone.toLowerCase().equals(atmp.getColumnName(4).toLowerCase())) {
										predmetniProfesor = tekst;

										filters.add(RowFilter.regexFilter("(?i)" +predmetniProfesor, 4));

									} else {
										JOptionPane.showMessageDialog(null,
												"Ne postoji kolona " + nazivKolone + " u tabeli predmeta", "Greska", 0);
										break;
									}

									sorter = new TableRowSorter<TableModel>(
											MainFrame.getInstance().getTabelaPredmeta().getModel());
									sorter.setRowFilter(RowFilter.andFilter(filters));

									MainFrame.getInstance().getTabelaPredmeta().setRowSorter(sorter);
									textField.setText("");

								}else {
									JOptionPane.showMessageDialog(null, "Neispravan format pretrage! PRAVILNO [Sifra:***;Naziv:***;...]");
								}
							}
						}else {
							JOptionPane.showMessageDialog(null, "Neispravan format pretrage! PRAVILNO [Sifra:***;Naziv:***;...]");
						}

					} else {

						@SuppressWarnings("unchecked")
						TableRowSorter<TableModel> sorter=(TableRowSorter<TableModel>) MainFrame.getInstance().getTabelaPredmeta().getRowSorter();
						sorter.setRowFilter(null);
					}
				}
			}
		});

		add(buttonSearch);

	}

}

class JTextFieldLimit extends PlainDocument {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private int limit;

	JTextFieldLimit(int limit) {
		super();
		this.limit = limit;
	}

	JTextFieldLimit(int limit, boolean upper) {
		super();
		this.limit = limit;
	}

	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		if (str == null)
			return;

		if ((getLength() + str.length()) <= limit) {
			super.insertString(offset, str, attr);
		}
	}
}
