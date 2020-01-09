package tabele;



import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;

import modeli.BazaStudenata;

public class AbstractTableModelStudenti extends AbstractTableModel {

	
	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;
	
	private static String kolonaPrikazi = "Lista predmta";
	private static String kolonaOstaleInfo = "Vise informacija";
	
	public AbstractTableModelStudenti() {
	
		
	}
	
	
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex >= 8;
	}

	@Override
	public int getRowCount() {
		return BazaStudenata.getInstance().getStudenti().size() ;  
	}

	@Override
	public int getColumnCount() {
		return BazaStudenata.getInstance().getColumnCount() + 2;  //dodajemo 2 zbog novih kolona
	}

	@Override
	public String getColumnName(int column) {
		if(column < BazaStudenata.getInstance().getColumnCount())
			return BazaStudenata.getInstance().getColumnName(column);
		else if(column == BazaStudenata.getInstance().getColumnCount())
			return kolonaPrikazi;
		else
			return kolonaOstaleInfo;
	}
	

	@Override
	public Class<?> getColumnClass(int columnIndex){
		switch (columnIndex) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:	
		case 6:	
		case 7:	
			return String.class;
		case 8:
			return JPanel.class;
		case 9:
			return JPanel.class;
		default:
		return null;
		}
		
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex <= 7)
			return BazaStudenata.getInstance().getValueAt(rowIndex, columnIndex);
		else if(columnIndex == 8)
			return "prikaz";
		else
			return "info";
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
		
	}


}
