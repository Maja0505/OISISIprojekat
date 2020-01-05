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

import listeners.MouseListenerPredmeti;
import modeli.BazaPredmeta;
import modeli.Predmet;

public class PredmetiJTable extends JTable {
	


	private static final long serialVersionUID = 1L;

	public static boolean selektovanPredmet = false; //da li je vrsta predmeta oznacena
	public static int selektovanaVrsta=-1;
	
	public PredmetiJTable() {
		super();
		this.setRowHeight(30);
		Font font = new Font("Serif",Font.BOLD,14);
		this.setFont(font);
		this.setBackground(Color.WHITE);
		this.setForeground(Color.BLACK);
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelPredmeti());
		this.setShowHorizontalLines(false);
		

		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(this.getModel());
		
		sorter.setSortable(4, false);
		sorter.setSortable(5, false);  
		
		sorter.addRowSorterListener(new RowSorterListener() {

			@Override
			public void sorterChanged(RowSorterEvent e) {

			List<? extends SortKey> i = getRowSorter().getSortKeys();   
			Iterator<? extends SortKey> it = i.iterator();

			SortKey sortKey = it.next();
			int sortitanaKolona = sortKey.getColumn();   //dobijamo koja kolona se sortita
			SortOrder sort = sortKey.getSortOrder();     // dobijamo vrstu sortitanja rastuce/opadajuce
		
			if(sortitanaKolona == 0 && sort == SortOrder.ASCENDING) {
				
				
				for (int j = 0; j < BazaPredmeta.getInstance().getPredmeti().size() - 1; j++) {
				    for (int k = j + 1; k < BazaPredmeta.getInstance().getPredmeti().size(); k++) {
				    	Predmet tmp1 = BazaPredmeta.getInstance().getPredmeti().get(j);
			            Predmet tmp2 = BazaPredmeta.getInstance().getPredmeti().get(k);
			    	   
			          		if(tmp1.getSifraPredmeta().compareTo(tmp2.getSifraPredmeta()) > 0) {
			            		
			          			BazaPredmeta.getInstance().getPredmeti().remove(j);
			          			BazaPredmeta.getInstance().getPredmeti().add(j, tmp2);
			          			BazaPredmeta.getInstance().getPredmeti().remove(k);
			          			BazaPredmeta.getInstance().getPredmeti().add(k,tmp1);
			
			            		}
				    }
				}
			}
			
			
			
			if(sortitanaKolona == 0 && sort == SortOrder.DESCENDING) {
				
				
				for (int j = 0; j < BazaPredmeta.getInstance().getPredmeti().size() - 1; j++) {
				    for (int k = j + 1; k < BazaPredmeta.getInstance().getPredmeti().size(); k++) {
				    	Predmet tmp1 = BazaPredmeta.getInstance().getPredmeti().get(j);
			            Predmet tmp2 = BazaPredmeta.getInstance().getPredmeti().get(k);
			    	   
			          		if(tmp1.getSifraPredmeta().compareTo(tmp2.getSifraPredmeta()) <= 0) {
			            		
			          			BazaPredmeta.getInstance().getPredmeti().remove(j);
			          			BazaPredmeta.getInstance().getPredmeti().add(j, tmp2);
			          			BazaPredmeta.getInstance().getPredmeti().remove(k);
			          			BazaPredmeta.getInstance().getPredmeti().add(k,tmp1);
			
			            		}
				    }
				}
			}
			
			
			
			if(sortitanaKolona == 1 && sort == SortOrder.ASCENDING) {
				
				
				for (int j = 0; j < BazaPredmeta.getInstance().getPredmeti().size() - 1; j++) {
				    for (int k = j+1; k < BazaPredmeta.getInstance().getPredmeti().size(); k++) {
				    	Predmet tmp1 =BazaPredmeta.getInstance().getPredmeti().get(j);
			            Predmet tmp2 =BazaPredmeta.getInstance().getPredmeti().get(k);
			            
			          		if(tmp1.getNazivPredmet().compareTo(tmp2.getNazivPredmet()) > 0) {
			            		
			          			BazaPredmeta.getInstance().getPredmeti().remove(j);
			          			BazaPredmeta.getInstance().getPredmeti().add(j, tmp2);
			          			BazaPredmeta.getInstance().getPredmeti().remove(k);
			          			BazaPredmeta.getInstance().getPredmeti().add(k,tmp1);
			
			            		}
				    }
				}
			}
			
			if(sortitanaKolona == 1 && sort == SortOrder.DESCENDING) {
				
				
				for (int j = 0; j < BazaPredmeta.getInstance().getPredmeti().size() - 1; j++) {
				    for (int k = j + 1; k <BazaPredmeta.getInstance().getPredmeti().size(); k++) {
				    	Predmet tmp1 = BazaPredmeta.getInstance().getPredmeti().get(j);
			            Predmet tmp2 =BazaPredmeta.getInstance().getPredmeti().get(k);
			    	   
			          		if(tmp1.getNazivPredmet().compareTo(tmp2.getNazivPredmet()) <= 0) {
			            		
			          			BazaPredmeta.getInstance().getPredmeti().remove(j);
			          			BazaPredmeta.getInstance().getPredmeti().add(j, tmp2);
			          			BazaPredmeta.getInstance().getPredmeti().remove(k);
			          			BazaPredmeta.getInstance().getPredmeti().add(k,tmp1);
			
			            		}
				    }
				}
			}
			
	
			
			
			if(sortitanaKolona == 2 && sort == SortOrder.ASCENDING) {
				
			
				for (int j = 0; j < BazaPredmeta.getInstance().getPredmeti().size() - 1; j++) {
				    for (int k = j + 1; k < BazaPredmeta.getInstance().getPredmeti().size(); k++) {
				    	Predmet tmp1 = BazaPredmeta.getInstance().getPredmeti().get(j);
			            Predmet tmp2 =BazaPredmeta.getInstance().getPredmeti().get(k);
			    
			    	   if (tmp1.getSemestar() > tmp2.getSemestar()) {
						    
			    		   BazaPredmeta.getInstance().getPredmeti().remove(j);
			    		   BazaPredmeta.getInstance().getPredmeti().add(j, tmp2);
			    		   BazaPredmeta.getInstance().getPredmeti().remove(k);
			    		   BazaPredmeta.getInstance().getPredmeti().add(k,tmp1);
			
			    	   	}
				    }
				}
			}
			
			if(sortitanaKolona == 2 && sort == SortOrder.DESCENDING) {
				
				
				for (int j = 0; j < BazaPredmeta.getInstance().getPredmeti().size() - 1; j++) {
				    for (int k = j + 1; k < BazaPredmeta.getInstance().getPredmeti().size(); k++) {
				    	Predmet tmp1 = BazaPredmeta.getInstance().getPredmeti().get(j);
			            Predmet tmp2 = BazaPredmeta.getInstance().getPredmeti().get(k);
			           
			    	   if (tmp1.getSemestar() <= tmp2.getSemestar()) {
						    
			    		   BazaPredmeta.getInstance().getPredmeti().remove(j);
			    		   BazaPredmeta.getInstance().getPredmeti().add(j, tmp2);
			    		   BazaPredmeta.getInstance().getPredmeti().remove(k);
			    		   BazaPredmeta.getInstance().getPredmeti().add(k,tmp1);
			    	   }
				    }
				}
			}
			
			if(sortitanaKolona == 3 && sort == SortOrder.ASCENDING) {
				
				
				for (int j = 0; j < BazaPredmeta.getInstance().getPredmeti().size() - 1; j++) {
				    for (int k = j + 1; k < BazaPredmeta.getInstance().getPredmeti().size(); k++) {
				    	Predmet tmp1 = BazaPredmeta.getInstance().getPredmeti().get(j);
			            Predmet tmp2 =BazaPredmeta.getInstance().getPredmeti().get(k);
			    
			    	   if (tmp1.getGodinaIzvodjenjaPredmeta() > tmp2.getGodinaIzvodjenjaPredmeta()) {
						    
			    		   BazaPredmeta.getInstance().getPredmeti().remove(j);
			    		   BazaPredmeta.getInstance().getPredmeti().add(j, tmp2);
			    		   BazaPredmeta.getInstance().getPredmeti().remove(k);
			    		   BazaPredmeta.getInstance().getPredmeti().add(k,tmp1);
			
			    	   	}
				    }
				}
			}
			
			if(sortitanaKolona == 3 && sort == SortOrder.DESCENDING) {
				
				
				for (int j = 0; j < BazaPredmeta.getInstance().getPredmeti().size() - 1; j++) {
				    for (int k = j + 1; k < BazaPredmeta.getInstance().getPredmeti().size(); k++) {
				    	Predmet tmp1 = BazaPredmeta.getInstance().getPredmeti().get(j);
			            Predmet tmp2 = BazaPredmeta.getInstance().getPredmeti().get(k);
			           
			    	   if (tmp1.getGodinaIzvodjenjaPredmeta()<= tmp2.getGodinaIzvodjenjaPredmeta()) {
						    
			    		   BazaPredmeta.getInstance().getPredmeti().remove(j);
			    		   BazaPredmeta.getInstance().getPredmeti().add(j, tmp2);
			    		   BazaPredmeta.getInstance().getPredmeti().remove(k);
			    		   BazaPredmeta.getInstance().getPredmeti().add(k,tmp1);
			    	   }
				    }
				}
			}
			
			}
		});
		
		
		this.setRowSorter(sorter);
		
        this.addMouseListener(new MouseListenerPredmeti(this));
		
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.CYAN);
			selektovanPredmet = true;
			selektovanaVrsta=row;			//pamti selektovanu vrstu
		} else {
			c.setBackground(Color.WHITE);
			selektovanPredmet=false;		//vraca na false,kad nije selektovano nista
		}
		return c;
	}
	
}
