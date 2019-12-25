package gui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuBar() {
		super();
		
		
		
		JMenu file = new JMenu("File");
		
				
		JMenuItem New = new JMenuItem("New", new ImageIcon("images/plusIcon.jpg"));
		JMenuItem close = new JMenuItem("Close",new ImageIcon("images/xIcon.jpg"));
		
		KeyStroke ctrlN = KeyStroke.getKeyStroke(KeyEvent.VK_N,Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
		New.setAccelerator(ctrlN);	
		file.add(New);	 
		
		file.addSeparator();
		
		close.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		
			
		
		file.add(close);
		
		add(file);
		
		
		
		JMenu edit = new JMenu("Edit");
		
		JMenuItem editItem = new JMenuItem("Edit");
		JMenuItem delete = new JMenuItem("Delete");
		
		edit.add(editItem);
		edit.addSeparator();
		edit.add(delete);
		
		add(edit);
		
		JMenu help = new JMenu("Help");
		
		JMenuItem helpItem = new JMenuItem("Help");
		JMenuItem aboutItem = new JMenuItem("About");
		
		help.add(helpItem);
		help.add(aboutItem);
		
		add(help);
	}
	
	
	
		
}
