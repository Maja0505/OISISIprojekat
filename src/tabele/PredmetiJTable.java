package tabele;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import listeners.MouseListenerPredmeti;

public class PredmetiJTable extends JTable {
	private static final long serialVersionUID = 1L;

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
		this.setAutoCreateRowSorter(true);
		
        this.addMouseListener(new MouseListenerPredmeti(this));
		
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.CYAN);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	
}
