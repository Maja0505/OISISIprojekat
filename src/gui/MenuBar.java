package gui;

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
		 
		
		//File
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		
		//dodavanje novog entiteta i zatvaranje aplikacije sa njihovim mnemonicima		
		JMenuItem New = new JMenuItem("New", new ImageIcon("images/plusIcon.jpg"));
		JMenuItem close = new JMenuItem("Close",new ImageIcon("images/xIcon.jpg"));
		close.setMnemonic(KeyEvent.VK_C);
		New.setMnemonic(KeyEvent.VK_N);
		
			
		//Acceleratori za new i close
		New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		
		file.add(New);	 	
		file.addSeparator();	
		file.add(close);
		
		add(file);
		
		
		//Edit
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		
		//Izmena postojeceg i brisanje entiteta sa njihovim mnemonicima
		JMenuItem editItem = new JMenuItem("Edit",new ImageIcon("images/editIcon.jpg"));
		JMenuItem delete = new JMenuItem("Delete",new ImageIcon("images/deleteIcon.jpg"));
		editItem.setMnemonic(KeyEvent.VK_E);
		delete.setMnemonic(KeyEvent.VK_D);
		
		//Acceleratori za edit i delete
		editItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
		
		edit.add(editItem);
		edit.addSeparator();
		edit.add(delete);
		
		add(edit);
		
		
		//Help 
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		
		//Help i delete sa njihovim mnemonicima
		JMenuItem helpItem = new JMenuItem("Help",new ImageIcon("images/helpIcon.jpg"));
		JMenuItem aboutItem = new JMenuItem("About",new ImageIcon("images/aboutIcon.jpg"));
		helpItem.setMnemonic(KeyEvent.VK_H);
		aboutItem.setMnemonic(KeyEvent.VK_A);
		
		//Acceleratori za help i about
		helpItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
		aboutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));
		
		
		help.add(helpItem);
		help.addSeparator();
		help.add(aboutItem);
		
		add(help);
	}
	
	
	
		
}
