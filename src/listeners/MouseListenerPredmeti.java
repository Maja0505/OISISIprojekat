package listeners;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import modeli.BazaPredmeta;
import modeli.BazaStudenata;

public class MouseListenerPredmeti extends MouseAdapter {
	 private JTable table;
	
     
	    public MouseListenerPredmeti(JTable table) {
	        this.table = table;
	    }
	     
	    public void mouseClicked(MouseEvent event) {
	        Point point = event.getPoint();
	        int column = table.columnAtPoint(point);
	        int row=table.rowAtPoint(point);
	        if(column==5) {
	       
	        JFrame nasfrejm = new JFrame();
	        nasfrejm.setTitle("Spisak studenata");
	        nasfrejm.getContentPane().setBackground(Color.WHITE);
	        nasfrejm.setVisible(true);
	        nasfrejm.setSize(500, 300);
	        nasfrejm.setLocationRelativeTo(null);
	        
	      
	        JLabel statusBar = new JLabel();
	  
			nasfrejm.add(statusBar,BorderLayout.SOUTH);
			statusBar.setPreferredSize((new Dimension(nasfrejm.getHeight(), 25)));
			JPanel panel=new JPanel();
			panel.setLayout(new GridBagLayout());
			nasfrejm.add(panel,BorderLayout.CENTER);
	        
	       String nizIndeksa[] = new String[BazaStudenata.getInstance().getStudenti().size()]; 
	    
	    
			for(int i = 0;i<BazaStudenata.getInstance().getStudenti().size();i++) {
				if(BazaStudenata.getInstance().getValueAt(i, 4).equals(BazaPredmeta.getInstance().getValueAt(row, 3))){
						nizIndeksa[i]=BazaStudenata.getInstance().getValueAt(i, 0).toString();
						
						
				}
			
		}
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JList list = new JList(nizIndeksa);
		
		
		 GridBagConstraints gbc=new GridBagConstraints();
		 gbc.insets = new Insets(5, 5, 5, 5);
		
		
		
		JButton nazadButton = new JButton("Nazad");
			   gbc.gridx=3;
		       gbc.gridy=3;

		       panel.add(nazadButton,gbc);
		      
	    JButton obrisiButton = new JButton("Obrisi");
			   gbc.gridx=2;
			   gbc.gridy=3;
			   gbc.anchor = GridBagConstraints.EAST;
			   gbc.insets = new Insets(0,70, 0, 20);

			   panel.add(obrisiButton,gbc);  
			        
		 JScrollPane scrollPane = new JScrollPane(list); 
					 
					   
			    gbc.gridx=0;
			    gbc.gridy=0;
			    gbc.weightx = 2;
			    gbc.weighty = 2;
			    gbc.gridwidth = 3;
			    gbc.fill =  GridBagConstraints.HORIZONTAL; 
			    gbc.anchor = GridBagConstraints.NORTH;
			    gbc.insets = new Insets(20, 70, 0, 0);
			    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
					
			    panel.add(scrollPane,gbc);
  

	        }
	    }
	    
}
