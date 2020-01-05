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
import dialozi.DijalogDodajStudenta;
import dialozi.DijalogDodajStudentaNaPredmet;
import dialozi.DijalogIzmenaPredmeta;
import dialozi.DijalogIzmenaProfesora;
import dialozi.DijalogIzmenaStudenta;
import tabele.AbstractTableModelPredmeti;
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
		
	//dodaj	
		JButton buttonNew=new JButton();
		buttonNew.setToolTipText("Dodaj");
		buttonNew.setIcon(new ImageIcon("images/add.jpg"));
		add(buttonNew);
		
		buttonNew.addActionListener(new ActionListener() {

//iskace odgovarajuvi dijalog za dodavanje			
			//@Override  
			public void actionPerformed(ActionEvent e) {
				if(MainFrame.tab == 0) {
					new DijalogDodajStudenta(true);
				}else if(MainFrame.tab == 1) {
					new DijalogDodajProfesora(true);
				}else if(MainFrame.tab == 2) {
					new DijalogDodajPredmet(true);
				}
			}
		});
		
		addSeparator();
		
	//izmena	
		JButton buttonEdit=new JButton();
		buttonEdit.setToolTipText("Izmeni");
		buttonEdit.setIcon(new ImageIcon("images/edit.jpg"));
		add(buttonEdit);
		
		
		buttonEdit.addActionListener(new ActionListener() {
//iskace odgovarajuvi dijalog za izmenu			
						//@Override  
						public void actionPerformed(ActionEvent e) {
							if(MainFrame.tab == 0 && StudentiJTable.selektovanStudent) {
								new DijalogIzmenaStudenta(true);
							}else if(MainFrame.tab == 1 && ProfesoriJTable.selektovanProfesor) {
								new DijalogIzmenaProfesora(true);
							}else if(MainFrame.tab == 2 && PredmetiJTable.selektovanPredmet) {
								new DijalogIzmenaPredmeta(true);
							}
						}
					});
		
		addSeparator();
		
	//brisanje	
		
		JButton buttonDelete=new JButton();
		buttonDelete.setToolTipText("Obrisi");
		buttonDelete.setIcon(new ImageIcon("images/delete.jpg"));

		add(buttonDelete);
		
		
		buttonDelete.addActionListener(new ActionListener() {

//iskace odgovarajuvi dijalog za brisanje			
						//@Override  
						public void actionPerformed(ActionEvent e) {
							if(MainFrame.tab == 0 && StudentiJTable.selektovanStudent) {
								new DijalogBrisanjeStudenta(true);
							}else if(MainFrame.tab == 1 && ProfesoriJTable.selektovanProfesor) {
								new DijalogBrisanjeProfesora(true);
							}else if(MainFrame.tab == 2 && PredmetiJTable.selektovanPredmet) {
								new DijalogBrisanjePredmeta(true);
							
							}
						}
					});
		
		addSeparator();
		
		JButton studentButton=new JButton();
		studentButton.setToolTipText("Dodavanje studenta na predmet");
		studentButton.setIcon(new ImageIcon("images/add.jpg"));
		
		studentButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(MainFrame.tab == 2)
					if(PredmetiJTable.selektovanPredmet)
						new DijalogDodajStudentaNaPredmet();
					else
						JOptionPane.showMessageDialog(null, "Niste oznacili predmet na koji zelite da dodate studenta");
			}
		});
		
		
		add(studentButton);
		
		addSeparator();
		
		JButton profesorButton=new JButton();
		profesorButton.setToolTipText("Dodavanje profesora na predmet");
		profesorButton.setIcon(new ImageIcon("images/profesor.jpg"));
		
		add(profesorButton);
		
		for(int i =0;i<85;i++) {
		addSeparator();
		}

		JTextField textField=new JTextField();
		textField.setDocument(new JTextFieldLimit(100));
		 Font font = new Font("Serif", Font.BOLD, 15); 			//font za unos
		 textField.setFont(font);
		 add(textField);
		
		setFloatable(false);
		
	//pretraga	
		JButton buttonSearch=new JButton();
		buttonSearch.setToolTipText("Pretraga");
		buttonSearch.setIcon(new ImageIcon("images/pretraga.jpg"));
		buttonSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(MainFrame.tab==2) {
						if(!textField.getText().equals("") ) {	
										if(textField.getText().contains(":")) {
												String[] kolone=textField.getText().split(";");
												String nazivKolone;
												String tekst=null;
												@SuppressWarnings("unchecked")
												TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>)  MainFrame.getInstance().getTabelaPredmeta().getRowSorter();
												List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(2);
												for(int i=0;i<kolone.length;i++) {
													String[] podela2=kolone[i].split(":");
													if(podela2.length==2 ) {		
														nazivKolone=podela2[0];
														tekst=podela2[1];
														AbstractTableModelPredmeti atmp=new AbstractTableModelPredmeti();
														String sifraPredmeta=null;
														String nazivPredmeta=null;
														String semestar=null;
														String godinaIzvodjenja=null;
														String predmetniProfesor=null;
														
														if(nazivKolone.toLowerCase().equals(atmp.getColumnName(0).toLowerCase())){
															sifraPredmeta=tekst.toUpperCase();
																													
															  filters.add(RowFilter.regexFilter(sifraPredmeta,0));
													          													
														}else if (nazivKolone.toLowerCase().equals(atmp.getColumnName(1).toLowerCase())) {
															nazivPredmeta=tekst.substring(0, 1).toUpperCase();
					
															  filters.add(RowFilter.regexFilter(nazivPredmeta,1));
													          								           
														}else if (nazivKolone.toLowerCase().equals(atmp.getColumnName(2).toLowerCase())) {
															semestar=tekst;
															
															 filters.add(RowFilter.regexFilter(semestar,2));
															
														}else if (nazivKolone.toLowerCase().equals(atmp.getColumnName(3).toLowerCase())) {
															godinaIzvodjenja=tekst;
															
															 filters.add(RowFilter.regexFilter(godinaIzvodjenja,3));
															 
														}else if (nazivKolone.toLowerCase().equals(atmp.getColumnName(4).toLowerCase())) {
																predmetniProfesor=tekst.substring(0,1).toUpperCase();
																											
																 filters.add(RowFilter.regexFilter(predmetniProfesor,4));
																									
														}else {
															JOptionPane.showMessageDialog(null, "Ne postoji kolona " + nazivKolone + " u tabeli predmeta", "Greska",0);
															break;
														}
																
													
													
													
													sorter = new TableRowSorter<TableModel>( MainFrame.getInstance().getTabelaPredmeta().getModel());
												    sorter.setRowFilter(RowFilter.andFilter(filters));
								
												    
													 MainFrame.getInstance().getTabelaPredmeta().setRowSorter(sorter);
													 textField.setText("");
														
														
														}
												}
										}
										
						}else {
							
							 MainFrame.getInstance().getTabelaPredmeta().setModel(new AbstractTableModelPredmeti());
							 MainFrame.getInstance().azurirajTabeluPredmeta();
								
								
							
								
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
