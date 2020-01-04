package tabele;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SortOrder;
import javax.swing.RowSorter.SortKey;
import javax.swing.event.RowSorterEvent;
import javax.swing.event.RowSorterListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import listeners.MouseListenerProfesori;
import modeli.BazaProfesora;
import modeli.Profesor;

public class ProfesoriJTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static boolean selektovanProfesor = false; //za izmenu i brisanje
	public static int selektovanaVrsta=-1;
	
	public ProfesoriJTable() {
		super();
		this.setRowHeight(30);
		Font font = new Font("Serif",Font.BOLD,14);
		this.setFont(font);
		this.setBackground(Color.WHITE);
		this.setForeground(Color.BLACK);
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelProfesori());
		this.setShowHorizontalLines(false);
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(this.getModel());
		sorter.setSortable(3, false);
		sorter.setSortable(4, false);
		
		sorter.addRowSorterListener(new RowSorterListener() {
			
			@Override
			public void sorterChanged(RowSorterEvent e) {

				List<? extends SortKey> i = getRowSorter().getSortKeys();
				Iterator<? extends SortKey> it = i.iterator();

				SortKey sortKey = it.next();
				int sortitanaKolona = sortKey.getColumn();
				SortOrder sort = sortKey.getSortOrder();
				
				
				if(sortitanaKolona == 0 && sort == SortOrder.ASCENDING) {
					
					for (int j = 0; j < BazaProfesora.getInstance().getProfesori().size() - 1; j++) {
					    for (int k = j + 1; k < BazaProfesora.getInstance().getProfesori().size(); k++) {
					    	Profesor tmp1 = BazaProfesora.getInstance().getProfesori().get(j);
					    	Profesor tmp2 = BazaProfesora.getInstance().getProfesori().get(k);
				    	   
				          		if(tmp1.getIme().compareTo(tmp2.getIme()) > 0) {
				            		
					            BazaProfesora.getInstance().getProfesori().remove(j);
					            BazaProfesora.getInstance().getProfesori().add(j, tmp2);
					            BazaProfesora.getInstance().getProfesori().remove(k);
					            BazaProfesora.getInstance().getProfesori().add(k,tmp1);
				
				            		}
					    }
					}
				}
				
				if(sortitanaKolona == 0 && sort == SortOrder.DESCENDING) {
					
					for (int j = 0; j < BazaProfesora.getInstance().getProfesori().size() - 1; j++) {
					    for (int k = j + 1; k < BazaProfesora.getInstance().getProfesori().size(); k++) {
					    	Profesor tmp1 = BazaProfesora.getInstance().getProfesori().get(j);
				            Profesor tmp2 = BazaProfesora.getInstance().getProfesori().get(k);
				    	   
				          		if(tmp1.getIme().compareTo(tmp2.getIme()) <= 0) {
				            		
					            BazaProfesora.getInstance().getProfesori().remove(j);
					            BazaProfesora.getInstance().getProfesori().add(j, tmp2);
					            BazaProfesora.getInstance().getProfesori().remove(k);
					            BazaProfesora.getInstance().getProfesori().add(k,tmp1);
				
				            		}
					    }
					}
				}
				
				
				if(sortitanaKolona == 1 && sort == SortOrder.ASCENDING) {
					
					for (int j = 0; j < BazaProfesora.getInstance().getProfesori().size() - 1; j++) {
					    for (int k = j + 1; k < BazaProfesora.getInstance().getProfesori().size(); k++) {
					    	Profesor tmp1 = BazaProfesora.getInstance().getProfesori().get(j);
					    	Profesor tmp2 = BazaProfesora.getInstance().getProfesori().get(k);
				    	   
				          		if(tmp1.getPrezime().compareTo(tmp2.getPrezime()) > 0) {
				            		
					            BazaProfesora.getInstance().getProfesori().remove(j);
					            BazaProfesora.getInstance().getProfesori().add(j, tmp2);
					            BazaProfesora.getInstance().getProfesori().remove(k);
					            BazaProfesora.getInstance().getProfesori().add(k,tmp1);
				
				            		}
					    }
					}
				}
				
				if(sortitanaKolona == 1 && sort == SortOrder.DESCENDING) {
					
					for (int j = 0; j < BazaProfesora.getInstance().getProfesori().size() - 1; j++) {
					    for (int k = j + 1; k < BazaProfesora.getInstance().getProfesori().size(); k++) {
					    	Profesor tmp1 = BazaProfesora.getInstance().getProfesori().get(j);
				            Profesor tmp2 = BazaProfesora.getInstance().getProfesori().get(k);
				    	   
				          		if(tmp1.getPrezime().compareTo(tmp2.getPrezime()) <= 0) {
				            		
					            BazaProfesora.getInstance().getProfesori().remove(j);
					            BazaProfesora.getInstance().getProfesori().add(j, tmp2);
					            BazaProfesora.getInstance().getProfesori().remove(k);
					            BazaProfesora.getInstance().getProfesori().add(k,tmp1);
				
				            		}
					    }
					}
				}
				
				if(sortitanaKolona == 2 && sort == SortOrder.ASCENDING) {
					
					for (int j = 0; j < BazaProfesora.getInstance().getProfesori().size() - 1; j++) {
					    for (int k = j + 1; k < BazaProfesora.getInstance().getProfesori().size(); k++) {
					    	Profesor tmp1 = BazaProfesora.getInstance().getProfesori().get(j);
					    	Profesor tmp2 = BazaProfesora.getInstance().getProfesori().get(k);
				    	   
				          		if(tmp1.getDatum_rodjenja().compareTo(tmp2.getDatum_rodjenja()) > 0) {
				            		
					            BazaProfesora.getInstance().getProfesori().remove(j);
					            BazaProfesora.getInstance().getProfesori().add(j, tmp2);
					            BazaProfesora.getInstance().getProfesori().remove(k);
					            BazaProfesora.getInstance().getProfesori().add(k,tmp1);
				
				            		}
					    }
					}
				}
				
				if(sortitanaKolona == 2 && sort == SortOrder.DESCENDING) {
					
					for (int j = 0; j < BazaProfesora.getInstance().getProfesori().size() - 1; j++) {
					    for (int k = j + 1; k < BazaProfesora.getInstance().getProfesori().size(); k++) {
					    	Profesor tmp1 = BazaProfesora.getInstance().getProfesori().get(j);
				            Profesor tmp2 = BazaProfesora.getInstance().getProfesori().get(k);
				    	   
				          		if(tmp1.getDatum_rodjenja().compareTo(tmp2.getDatum_rodjenja()) <= 0) {
				            		
					            BazaProfesora.getInstance().getProfesori().remove(j);
					            BazaProfesora.getInstance().getProfesori().add(j, tmp2);
					            BazaProfesora.getInstance().getProfesori().remove(k);
					            BazaProfesora.getInstance().getProfesori().add(k,tmp1);
				
				            		}
					    }
					}
				}			
				
			}
		});
		
		
		this.setRowSorter(sorter);
        this.addMouseListener(new MouseListenerProfesori(this));
	}
		
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.CYAN);
			selektovanProfesor = true;
			selektovanaVrsta=row;	//pamti selektovanu vrstu
		} else {
			c.setBackground(Color.WHITE);
			selektovanProfesor = false;		//vraca na false,kad nije selektovano nista
		}
		return c;
	}

}
