package tabele;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import listeners.MouseListenerPredmeti;


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
		this.getTableHeader().setReorderingAllowed(false);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelPredmeti());
		this.setShowHorizontalLines(false);
		

		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(this.getModel());
		
		sorter.setSortable(4, false);
		sorter.setSortable(5, false);  
		
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
