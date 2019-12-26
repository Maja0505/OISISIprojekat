package gui;


import java.awt.BorderLayout;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StatusBar() {
		
		super();
		this.setLayout(new BorderLayout());
		
		JLabel statusBar = new JLabel("Studentska sluzba");
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		JLabel vreme = new JLabel(dtf.format(now));
		
		this.add(statusBar,BorderLayout.WEST);
	
		this.add(vreme,BorderLayout.EAST);
		
	}

	
	
	
}


