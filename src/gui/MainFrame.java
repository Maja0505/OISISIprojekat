package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.HeadlessException;

import java.awt.Toolkit;


import javax.swing.ImageIcon;
import javax.swing.JFrame;







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
		
		
		
	}

}
