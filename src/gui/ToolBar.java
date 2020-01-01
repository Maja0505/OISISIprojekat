package gui;






import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import dialozi.DijalogBrisanjePredmeta;
import dialozi.DijalogBrisanjeProfesora;
import dialozi.DijalogBrisanjeStudenta;
import dialozi.DijalogDodajPredmet;
import dialozi.DijalogDodajProfesora;
import dialozi.DijalogDodajStudenta;
import dialozi.DijalogIzmenaPredmeta;
import dialozi.DijalogIzmenaProfesora;
import dialozi.DijalogIzmenaStudenta;
import tabele.PredmetiJTable;
import tabele.ProfesoriJTable;
import tabele.StudentiJTable;

public class ToolBar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public ToolBar() {
		super(SwingConstants.HORIZONTAL);
		
	//dodaj	
		JButton buttonNew=new JButton();
		buttonNew.setToolTipText("Dodaj");
		buttonNew.setIcon(new ImageIcon("images/add.jpg"));
		add(buttonNew);
		
		buttonNew.addActionListener(new ActionListener() {

//iskace odgovarajuvi dijalog za dodavanje			
			//@Override  
			public void actionPerformed(ActionEvent e) {
				if(MainFrame.tab == 0) {
					new DijalogDodajStudenta(true);
				}else if(MainFrame.tab == 1) {
					new DijalogDodajProfesora(true);
				}else if(MainFrame.tab == 2) {
					new DijalogDodajPredmet(true);
				}
			}
		});
		
		addSeparator();
		
	//izmena	
		JButton buttonEdit=new JButton();
		buttonEdit.setToolTipText("Izmeni");
		buttonEdit.setIcon(new ImageIcon("images/edit.jpg"));
		add(buttonEdit);
		
		
		buttonEdit.addActionListener(new ActionListener() {
//iskace odgovarajuvi dijalog za izmenu			
						//@Override  
						public void actionPerformed(ActionEvent e) {
							if(MainFrame.tab == 0 && StudentiJTable.selektovanStudent) {
								new DijalogIzmenaStudenta(true);
							}else if(MainFrame.tab == 1 && ProfesoriJTable.selektovanProfesor) {
								new DijalogIzmenaProfesora(true);
							}else if(MainFrame.tab == 2 && PredmetiJTable.selektovanPredmet) {
								new DijalogIzmenaPredmeta(true);
							}
						}
					});
		
		addSeparator();
		
	//brisanje	
		
		JButton buttonDelete=new JButton();
		buttonDelete.setToolTipText("Obrisi");
		buttonDelete.setIcon(new ImageIcon("images/delete.jpg"));

		add(buttonDelete);
		
		
		buttonDelete.addActionListener(new ActionListener() {

//iskace odgovarajuvi dijalog za brisanje			
						//@Override  
						public void actionPerformed(ActionEvent e) {
							if(MainFrame.tab == 0 && StudentiJTable.selektovanStudent) {
								new DijalogBrisanjeStudenta(true);
							}else if(MainFrame.tab == 1 && ProfesoriJTable.selektovanProfesor) {
								new DijalogBrisanjeProfesora(true);
							}else if(MainFrame.tab == 2 && PredmetiJTable.selektovanPredmet) {
								new DijalogBrisanjePredmeta(true);
							
							}
						}
					});
		
		
		for(int i =0;i<90;i++) {
		addSeparator();
		}

		JTextField textField=new JTextField();
		textField.setDocument(new JTextFieldLimit(80));
		 Font font = new Font("Serif", Font.BOLD, 15); 			//font za unos
		 textField.setFont(font);
		 add(textField);
		
		setFloatable(false);
		
	//pretraga	
		JButton buttonSearch=new JButton();
		buttonSearch.setToolTipText("Pretraga");
		buttonSearch.setIcon(new ImageIcon("images/pretraga.jpg"));
		
		add(buttonSearch);
		
		
	}
	
	
	

}
class JTextFieldLimit extends PlainDocument {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int limit;
	  JTextFieldLimit(int limit) {
	    super();
	    this.limit = limit;
	  }

	  JTextFieldLimit(int limit, boolean upper) {
	    super();
	    this.limit = limit;
	  }

	  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
	    if (str == null)
	      return;

	    if ((getLength() + str.length()) <= limit) {
	      super.insertString(offset, str, attr);
	    }
	  }
	}
