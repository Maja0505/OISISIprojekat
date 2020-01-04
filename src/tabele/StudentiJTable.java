package tabele;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
import javax.swing.event.RowSorterEvent;
import javax.swing.event.RowSorterListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import listeners.MouseListenerStudenti;
import modeli.BazaStudenata;
import modeli.Student;




public class StudentiJTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static boolean selektovanStudent = false; //da bi znali da li je vrsta studenta selektovana (ako nije brisanje i izmena nisu moguci)
	public static int selektovanaVrsta=-1;   //da bi znali koja vrsta tacno je selektovana
	
	
	public StudentiJTable() {
		super();
		this.setRowHeight(30);
		Font font = new Font("Serif",Font.BOLD,14);
		this.setFont(font);
		this.setBackground(Color.WHITE);
		this.setForeground(Color.BLACK);
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelStudenti());
		this.setShowHorizontalLines(false);
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(this.getModel());
		sorter.setSortable(8, false);  
		sorter.setSortable(9, false);
		
		sorter.addRowSorterListener(new RowSorterListener() {
			
			@Override
			public void sorterChanged(RowSorterEvent e) {

			List<? extends SortKey> i = getRowSorter().getSortKeys();   
			Iterator<? extends SortKey> it = i.iterator();

			SortKey sortKey = it.next();
			int sortitanaKolona = sortKey.getColumn();   //dobijamo koja kolona se sortita
			SortOrder sort = sortKey.getSortOrder();     // dobijamo vrstu sortitanja rastuce/opadajuce
		
			if(sortitanaKolona == 0 && sort == SortOrder.ASCENDING) {
				
				
				for (int j = 0; j < BazaStudenata.getInstance().getStudenti().size() - 1; j++) {
				    for (int k = j + 1; k < BazaStudenata.getInstance().getStudenti().size(); k++) {
				    	Student tmp1 = BazaStudenata.getInstance().getStudenti().get(j);
			            Student tmp2 = BazaStudenata.getInstance().getStudenti().get(k);
			    	   
			          		if(tmp1.getBrIndeksa().compareTo(tmp2.getBrIndeksa()) > 0) {
			            		
				            BazaStudenata.getInstance().getStudenti().remove(j);
				            BazaStudenata.getInstance().getStudenti().add(j, tmp2);
				            BazaStudenata.getInstance().getStudenti().remove(k);
				            BazaStudenata.getInstance().getStudenti().add(k,tmp1);
			
			            		}
				    }
				}
			}
			
			if(sortitanaKolona == 0 && sort == SortOrder.DESCENDING) {
				
				
				for (int j = 0; j < BazaStudenata.getInstance().getStudenti().size() - 1; j++) {
				    for (int k = j + 1; k < BazaStudenata.getInstance().getStudenti().size(); k++) {
				    	Student tmp1 = BazaStudenata.getInstance().getStudenti().get(j);
			            Student tmp2 = BazaStudenata.getInstance().getStudenti().get(k);
			    	   
			          		if(tmp1.getBrIndeksa().compareTo(tmp2.getBrIndeksa()) <= 0) {
			            		
				            BazaStudenata.getInstance().getStudenti().remove(j);
				            BazaStudenata.getInstance().getStudenti().add(j, tmp2);
				            BazaStudenata.getInstance().getStudenti().remove(k);
				            BazaStudenata.getInstance().getStudenti().add(k,tmp1);
			
			            		}
				    }
				}
			}
			
			
			
			if(sortitanaKolona == 1 && sort == SortOrder.ASCENDING) {
				
				
				for (int j = 0; j < BazaStudenata.getInstance().getStudenti().size() - 1; j++) {
				    for (int k = j+1; k < BazaStudenata.getInstance().getStudenti().size(); k++) {
				    	Student tmp1 = BazaStudenata.getInstance().getStudenti().get(j);
			            Student tmp2 = BazaStudenata.getInstance().getStudenti().get(k);
			            
			          		if(tmp1.getIme().compareTo(tmp2.getIme()) > 0) {
			            		
				            BazaStudenata.getInstance().getStudenti().remove(j);
				            BazaStudenata.getInstance().getStudenti().add(j, tmp2);
				            BazaStudenata.getInstance().getStudenti().remove(k);
				            BazaStudenata.getInstance().getStudenti().add(k,tmp1);
			
			            		}
				    }
				}
			}
			
			if(sortitanaKolona == 1 && sort == SortOrder.DESCENDING) {
				
				
				for (int j = 0; j < BazaStudenata.getInstance().getStudenti().size() - 1; j++) {
				    for (int k = j + 1; k < BazaStudenata.getInstance().getStudenti().size(); k++) {
				    	Student tmp1 = BazaStudenata.getInstance().getStudenti().get(j);
			            Student tmp2 = BazaStudenata.getInstance().getStudenti().get(k);
			    	   
			          		if(tmp1.getIme().compareTo(tmp2.getIme()) <= 0) {
			            		
				            BazaStudenata.getInstance().getStudenti().remove(j);
				            BazaStudenata.getInstance().getStudenti().add(j, tmp2);
				            BazaStudenata.getInstance().getStudenti().remove(k);
				            BazaStudenata.getInstance().getStudenti().add(k,tmp1);
			
			            		}
				    }
				}
			}
			
			if(sortitanaKolona == 2 && sort == SortOrder.ASCENDING) {
				
				
				for (int j = 0; j < BazaStudenata.getInstance().getStudenti().size() - 1; j++) {
				    for (int k = j + 1; k < BazaStudenata.getInstance().getStudenti().size(); k++) {
				    	Student tmp1 = BazaStudenata.getInstance().getStudenti().get(j);
			            Student tmp2 = BazaStudenata.getInstance().getStudenti().get(k);
			    	   
			          		if(tmp1.getPrezime().compareTo(tmp2.getPrezime()) > 0) {
			            		
				            BazaStudenata.getInstance().getStudenti().remove(j);
				            BazaStudenata.getInstance().getStudenti().add(j, tmp2);
				            BazaStudenata.getInstance().getStudenti().remove(k);
				            BazaStudenata.getInstance().getStudenti().add(k,tmp1);
			
			            		}
				    }
				}
			}
			
			if(sortitanaKolona == 2 && sort == SortOrder.DESCENDING) {
				
				
				for (int j = 0; j < BazaStudenata.getInstance().getStudenti().size() - 1; j++) {
				    for (int k = j + 1; k < BazaStudenata.getInstance().getStudenti().size(); k++) {
				    	Student tmp1 = BazaStudenata.getInstance().getStudenti().get(j);
			            Student tmp2 = BazaStudenata.getInstance().getStudenti().get(k);
			            	
			          		if(tmp1.getPrezime().compareTo(tmp2.getPrezime()) <= 0) {
			            		
				            BazaStudenata.getInstance().getStudenti().remove(j);
				            BazaStudenata.getInstance().getStudenti().add(j, tmp2);
				            BazaStudenata.getInstance().getStudenti().remove(k);
				            BazaStudenata.getInstance().getStudenti().add(k,tmp1);
			
			            		}
				    }
				}
			}
			
			
			if(sortitanaKolona == 3 && sort == SortOrder.ASCENDING) {
				
			
				for (int j = 0; j < BazaStudenata.getInstance().getStudenti().size() - 1; j++) {
				    for (int k = j + 1; k < BazaStudenata.getInstance().getStudenti().size(); k++) {
				    	Student tmp1 = BazaStudenata.getInstance().getStudenti().get(j);
			            Student tmp2 = BazaStudenata.getInstance().getStudenti().get(k);
			    
			    	   if (tmp1.getGodinaUpisa() > tmp2.getGodinaUpisa()) {
						    
				            BazaStudenata.getInstance().getStudenti().remove(j);
				            BazaStudenata.getInstance().getStudenti().add(j, tmp2);
				            BazaStudenata.getInstance().getStudenti().remove(k);
				            BazaStudenata.getInstance().getStudenti().add(k,tmp1);
			
			    	   	}
				    }
				}
			}
			
			if(sortitanaKolona == 3 && sort == SortOrder.DESCENDING) {
				
				
				for (int j = 0; j < BazaStudenata.getInstance().getStudenti().size() - 1; j++) {
				    for (int k = j + 1; k < BazaStudenata.getInstance().getStudenti().size(); k++) {
				    	Student tmp1 = BazaStudenata.getInstance().getStudenti().get(j);
			            Student tmp2 = BazaStudenata.getInstance().getStudenti().get(k);
			           
			    	   if (tmp1.getGodinaUpisa() <= tmp2.getGodinaUpisa()) {
						    
				            BazaStudenata.getInstance().getStudenti().remove(j);
				            BazaStudenata.getInstance().getStudenti().add(j, tmp2);
				            BazaStudenata.getInstance().getStudenti().remove(k);
				            BazaStudenata.getInstance().getStudenti().add(k,tmp1);
			    	   }
				    }
				}
			}
			
			if(sortitanaKolona == 4 && sort == SortOrder.ASCENDING) {
				
				
				for (int j = 0; j < BazaStudenata.getInstance().getStudenti().size() - 1; j++) {
				    for (int k = j + 1; k < BazaStudenata.getInstance().getStudenti().size(); k++) {
				    	Student tmp1 = BazaStudenata.getInstance().getStudenti().get(j);
			            Student tmp2 = BazaStudenata.getInstance().getStudenti().get(k);
			    	   if (tmp1.getTrenutnaGodinaStudija() > tmp2.getTrenutnaGodinaStudija()) {
						    
				            BazaStudenata.getInstance().getStudenti().remove(j);
				            BazaStudenata.getInstance().getStudenti().add(j, tmp2);
				            BazaStudenata.getInstance().getStudenti().remove(k);
				            BazaStudenata.getInstance().getStudenti().add(k,tmp1);
			
			    	   	}
				    }
				}
			}
			
			if(sortitanaKolona == 4 && sort == SortOrder.DESCENDING) {
				
				
				for (int j = 0; j < BazaStudenata.getInstance().getStudenti().size() - 1; j++) {
				    for (int k = j + 1; k < BazaStudenata.getInstance().getStudenti().size(); k++) {
				    	Student tmp1 = BazaStudenata.getInstance().getStudenti().get(j);
			            Student tmp2 = BazaStudenata.getInstance().getStudenti().get(k);
			    
			    	   if (tmp1.getTrenutnaGodinaStudija() <= tmp2.getTrenutnaGodinaStudija()) {
						    
				            BazaStudenata.getInstance().getStudenti().remove(j);
				            BazaStudenata.getInstance().getStudenti().add(j, tmp2);
				            BazaStudenata.getInstance().getStudenti().remove(k);
				            BazaStudenata.getInstance().getStudenti().add(k,tmp1);
			    	   }
				    }
				}
			}
			
			if(sortitanaKolona == 5 && sort == SortOrder.ASCENDING) {
				
				
				for (int j = 0; j < BazaStudenata.getInstance().getStudenti().size() - 1; j++) {
				    for (int k = j + 1; k < BazaStudenata.getInstance().getStudenti().size(); k++) {
				    	Student tmp1 = BazaStudenata.getInstance().getStudenti().get(j);
			            Student tmp2 = BazaStudenata.getInstance().getStudenti().get(k);
			    	   if (tmp1.getDatumRodjenja().compareTo(tmp2.getDatumRodjenja()) > 0) {
						    
				            BazaStudenata.getInstance().getStudenti().remove(j);
				            BazaStudenata.getInstance().getStudenti().add(j, tmp2);
				            BazaStudenata.getInstance().getStudenti().remove(k);
				            BazaStudenata.getInstance().getStudenti().add(k,tmp1);
			
			    	   	}
				    }
				}
			}
			
			if(sortitanaKolona == 5 && sort == SortOrder.DESCENDING) {
				
				
				for (int j = 0; j < BazaStudenata.getInstance().getStudenti().size() - 1; j++) {
				    for (int k = j + 1; k < BazaStudenata.getInstance().getStudenti().size(); k++) {
				    	Student tmp1 = BazaStudenata.getInstance().getStudenti().get(j);
			            Student tmp2 = BazaStudenata.getInstance().getStudenti().get(k);
			    
			    	   if (tmp1.getDatumRodjenja().compareTo(tmp2.getDatumRodjenja()) <= 0) {
						    
				            BazaStudenata.getInstance().getStudenti().remove(j);
				            BazaStudenata.getInstance().getStudenti().add(j, tmp2);
				            BazaStudenata.getInstance().getStudenti().remove(k);
				            BazaStudenata.getInstance().getStudenti().add(k,tmp1);
			    	   }
				    }
				}
			}
		
			
			if(sortitanaKolona == 6 && sort == SortOrder.ASCENDING) {
				
				
				for (int j = 0; j < BazaStudenata.getInstance().getStudenti().size() - 1; j++) {
				    for (int k = j + 1; k < BazaStudenata.getInstance().getStudenti().size(); k++) {
				    	Student tmp1 = BazaStudenata.getInstance().getStudenti().get(j);
			            Student tmp2 = BazaStudenata.getInstance().getStudenti().get(k);
			    	   if (tmp1.getProsecnaOcena() > tmp2.getProsecnaOcena()) {
						    
				            BazaStudenata.getInstance().getStudenti().remove(j);
				            BazaStudenata.getInstance().getStudenti().add(j, tmp2);
				            BazaStudenata.getInstance().getStudenti().remove(k);
				            BazaStudenata.getInstance().getStudenti().add(k,tmp1);
			
			    	   	}
				    }
				}
			}
			
			if(sortitanaKolona == 6 && sort == SortOrder.DESCENDING) {
				
				
				for (int j = 0; j < BazaStudenata.getInstance().getStudenti().size() - 1; j++) {
				    for (int k = j + 1; k < BazaStudenata.getInstance().getStudenti().size(); k++) {
				    	Student tmp1 = BazaStudenata.getInstance().getStudenti().get(j);
			            Student tmp2 = BazaStudenata.getInstance().getStudenti().get(k);
			    
			    	   if (tmp1.getProsecnaOcena() <= tmp2.getProsecnaOcena()) {
						    
				            BazaStudenata.getInstance().getStudenti().remove(j);
				            BazaStudenata.getInstance().getStudenti().add(j, tmp2);
				            BazaStudenata.getInstance().getStudenti().remove(k);
				            BazaStudenata.getInstance().getStudenti().add(k,tmp1);
			    	   }
				    }
				}
			}
	
			
			if(sortitanaKolona == 7 && sort == SortOrder.ASCENDING) {
				
				
				for (int j = 0; j < BazaStudenata.getInstance().getStudenti().size() - 1; j++) {
				    for (int k = j + 1; k < BazaStudenata.getInstance().getStudenti().size(); k++) {
				    	Student tmp1 = BazaStudenata.getInstance().getStudenti().get(j);
			            Student tmp2 = BazaStudenata.getInstance().getStudenti().get(k);
			    	   if (tmp1.getStatus().toString().compareTo( tmp2.getStatus().toString()) > 0) {
						    
				            BazaStudenata.getInstance().getStudenti().remove(j);
				            BazaStudenata.getInstance().getStudenti().add(j, tmp2);
				            BazaStudenata.getInstance().getStudenti().remove(k);
				            BazaStudenata.getInstance().getStudenti().add(k,tmp1);
			
			    	   	}
				    }
				}
			}
			
			if(sortitanaKolona == 7 && sort == SortOrder.DESCENDING) {
				
				
				for (int j = 0; j < BazaStudenata.getInstance().getStudenti().size() - 1; j++) {
				    for (int k = j + 1; k < BazaStudenata.getInstance().getStudenti().size(); k++) {
				    	Student tmp1 = BazaStudenata.getInstance().getStudenti().get(j);
			            Student tmp2 = BazaStudenata.getInstance().getStudenti().get(k);
			    
			    	   if (tmp1.getStatus().toString().compareTo( tmp2.getStatus().toString()) <= 0) {
						    
				            BazaStudenata.getInstance().getStudenti().remove(j);
				            BazaStudenata.getInstance().getStudenti().add(j, tmp2);
				            BazaStudenata.getInstance().getStudenti().remove(k);
				            BazaStudenata.getInstance().getStudenti().add(k,tmp1);
			    	   }
				    }
				}
			}
		
			
			}
		});
		
		
		this.setRowSorter(sorter);
        this.addMouseListener(new MouseListenerStudenti(this));
		
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.CYAN);
			selektovanStudent = true;
			selektovanaVrsta = row;
		} else {
			c.setBackground(Color.WHITE);
			selektovanStudent = false;
		}
		return c;
	}
	
	
	
}
