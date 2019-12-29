package tabele;




import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;
import modeli.BazaPredmeta;

public class AbstractTableModelPredmeti extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static String kolonaPrikazi = "Spisak studenata";
	
	public AbstractTableModelPredmeti() {
		
		
	}
	
	
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex >= 6;
	}

	@Override
	public int getRowCount() {
		return BazaPredmeta.getInstance().getPredmeti().size();
	}

	@Override
	public int getColumnCount() {
		return BazaPredmeta.getInstance().getColumnCount() + 1;
	}

	@Override
	public String getColumnName(int column) {
		if(column >= BazaPredmeta.getInstance().getColumnCount())
			return kolonaPrikazi;
		else
			return  BazaPredmeta.getInstance().getColumnName(column);
	}
	@Override
	public Class<?> getColumnClass(int columnIndex){
		switch (columnIndex) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
			return String.class;
		case 5:
			return JPanel.class;		
		default:
		return null;
		}
		
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex<=4) {
			return BazaPredmeta.getInstance().getValueAt(rowIndex, columnIndex);
		}else {
			
			
			return "prikazi";
			
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
		
	}

}
