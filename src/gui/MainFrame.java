package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;



import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import tabele.PredmetiJTable;
import tabele.ProfesoriJTable;
import tabele.StudentiJTable;







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
	
	public static int tab;  // da bi znali koji tab je aktivan

	private void inicijalizacijaTabbedPane() {
		 JTabbedPane tabbedPane = new JTabbedPane();
		 JPanel panel1, panel2, panel3;
	      panel1 = new JPanel();
	      panel2 = new JPanel();
	      panel3 = new JPanel();
	   
	      tabbedPane.addTab("STUDENTI", panel1);
	      tabbedPane.addTab("PROFESORI ", panel2);
	      tabbedPane.addTab("PREDMETI", panel3);
	      
	      tabelaStudenata = new StudentiJTable();
			JScrollPane scrollPane = new JScrollPane(tabelaStudenata);
			scrollPane.setPreferredSize(new Dimension(1300, 1500));
			scrollPane.setBorder(new EmptyBorder(60, 50, 30, 40));
			
		 tabelaPredmeta = new PredmetiJTable();
				JScrollPane scrollPane1 = new JScrollPane(tabelaPredmeta);
				scrollPane1.setPreferredSize(new Dimension(1300, 1500));
				scrollPane1.setBorder(new EmptyBorder(60, 50, 30, 40));
				
		tabelaProfesora=new ProfesoriJTable();		
				JScrollPane scrollPane2 = new JScrollPane(tabelaProfesora);
				scrollPane2.setPreferredSize(new Dimension(1300, 1500));
				scrollPane2.setBorder(new EmptyBorder(60, 50, 30, 40));
			

			panel1.add(scrollPane, BorderLayout.SOUTH);
			panel2.add(scrollPane2,BorderLayout.SOUTH);
			panel3.add(scrollPane1, BorderLayout.SOUTH);
			
	      Font font = new Font("Serif", Font.BOLD, 20); 
	      tabbedPane.setFont(font);
	      tabbedPane.setForeground(Color.WHITE);
	      tabbedPane.setBackground(Color.GRAY);
	      
//reaguje na promenu taba	
	      tabbedPane.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JTabbedPane sourceJTabbedPane = (JTabbedPane) e.getSource();
				tab = sourceJTabbedPane.getSelectedIndex();
			}
		});
	    	this.add(tabbedPane);
		
	}

	

	private static MainFrame instance = null;

	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}

	private JTable tabelaStudenata;
	private JTable tabelaPredmeta;
	private JTable tabelaProfesora;
	
		
		
		
	
	
	

}
