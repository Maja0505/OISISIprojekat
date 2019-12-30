package tabele;

import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;
import modeli.BazaProfesora;

public class AbstractTableModelProfesori extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static String kolonaPrikazi = "Spisak predmeta";
	private static String kolonaInfo="Info";
	
	public AbstractTableModelProfesori() {
		
		
	}
	
	
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex >= 3;
	}

	@Override
	public int getRowCount() {
		return BazaProfesora.getInstance().getProfesori().size();
	}

	@Override
	public int getColumnCount() {
		return BazaProfesora.getInstance().getColumnCount() + 2;
	}

	@Override
	public String getColumnName(int column) {
		if(column < BazaProfesora.getInstance().getColumnCount()) {
			return BazaProfesora.getInstance().getColumnName(column);
	}else if (column==BazaProfesora.getInstance().getColumnCount()) {
			return kolonaPrikazi;
		}else {
			return kolonaInfo;
		}
		
	}
	@Override
	public Class<?> getColumnClass(int columnIndex){
		switch (columnIndex) {
		case 0:
		case 1:
		case 2:	
			return String.class;
		case 3:
			return JPanel.class;
		case 4:
			 return JPanel.class;
		default:
		return null;
		}
		
	}
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex<=2) {
			return BazaProfesora.getInstance().getValueAt(rowIndex, columnIndex);
		}else if (columnIndex==3) {
			return "Prikazi";
		}else {
			return "Info";
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
		
	}

}
