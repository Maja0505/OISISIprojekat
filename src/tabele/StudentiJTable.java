package tabele;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import listeners.MouseListenerStudenti;




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
		this.getTableHeader().setReorderingAllowed(false);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelStudenti());
		this.setShowHorizontalLines(false);
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(this.getModel());
		sorter.setSortable(8, false);  
		sorter.setSortable(9, false);
		
		this.setRowSorter(sorter);
        this.addMouseListener(new MouseListenerStudenti(this));
		
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.CYAN);
			selektovanaVrsta = row;
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	
	
	
}
