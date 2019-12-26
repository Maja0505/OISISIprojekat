package gui;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class StatusBar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StatusBar() {
		super();
		this.setBorder(new BevelBorder(BevelBorder.RAISED));
		
		JLabel statusBar = new JLabel("Studentska sluzba", SwingConstants.LEFT);
		
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		
		JLabel vreme = new JLabel(dtf.format(now));
		
	
		add(statusBar);
		
		add(vreme);
		
	}

	
	
	
}


