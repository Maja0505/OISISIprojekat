package gui;


import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StatusBar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StatusBar() {
		
		super();
		this.setLayout(new BorderLayout());
		
		Font f = new Font("Serif", Font.BOLD, 17);
		JLabel statusBar = new JLabel("Studentska sluzba");
		statusBar.setFont(f);
		
		//podesavanje trenutnog datuma i vremena vremena
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss   dd.MM.yyyy");
		LocalDateTime now = LocalDateTime.now();
		JLabel vreme = new JLabel(dtf.format(now)); 
		vreme.setFont(f);
		
		Timer tajmer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				vreme.setText(DateFormat.getDateTimeInstance().format(new Date()));
			}
		});
		
		tajmer.start();
		
		this.add(statusBar,BorderLayout.WEST);
	
		this.add(vreme,BorderLayout.EAST);
		
	}

	
	
	
}


