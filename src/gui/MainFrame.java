package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;







public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame() throws HeadlessException {
		
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int screenHeight=screenSize.height;
		int screenWidth=screenSize.width;
		setSize(screenWidth*3/4,screenHeight*3/4);
		setTitle("Studentska sluzba");
		getContentPane().setBackground(Color.WHITE);
		
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setIconImage(new ImageIcon("images/ftn_logo.jpg").getImage());
		MenuBar mb = new MenuBar();
		this.setJMenuBar(mb);

		mb.setPreferredSize((new Dimension(screenWidth, 30)));

		
		
		ToolBar toolbar = new ToolBar();
		add(toolbar, BorderLayout.NORTH);

		
		StatusBar statusBar = new StatusBar();
		this.add(statusBar,BorderLayout.SOUTH);
		statusBar.setPreferredSize((new Dimension(screenWidth, 25)));
		
		
		inicijalizacijaTabbedPane();
		
		
		
	}

	private void inicijalizacijaTabbedPane() {
		 JTabbedPane tabbedPane = new JTabbedPane();
		 JPanel panel1, panel2, panel3;
	      panel1 = new JPanel();
	      panel2 = new JPanel();
	      panel3 = new JPanel();
	     
	      tabbedPane.addTab("STUDENTI", panel1);
	      tabbedPane.addTab("PROFESORI ", panel2);
	      tabbedPane.addTab("PREDMETI", panel3);
	      
	      Font font = new Font("Serif", Font.BOLD, 20); 
	      tabbedPane.setFont(font);
	      tabbedPane.setForeground(Color.WHITE);
	      tabbedPane.setBackground(Color.GRAY);
	    	this.add(tabbedPane);
		
	}

	

	
	
		
		
		
	
	
	

}
