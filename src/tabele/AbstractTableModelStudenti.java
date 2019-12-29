package tabele;


import javax.swing.table.AbstractTableModel;

import modeli.BazaStudenata;

public class AbstractTableModelStudenti extends AbstractTableModel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AbstractTableModelStudenti() {
	
		
	}
	
	
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex >= 8;
	}

	@Override
	public int getRowCount() {
		return BazaStudenata.getInstance().getStudenti().size();
	}

	@Override
	public int getColumnCount() {
		return BazaStudenata.getInstance().getColumnCount();
	}

	@Override
	public String getColumnName(int column) {
		return BazaStudenata.getInstance().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
			return BazaStudenata.getInstance().getValueAt(rowIndex, columnIndex);
		
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
		
	}


}
