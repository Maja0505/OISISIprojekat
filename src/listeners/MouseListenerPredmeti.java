package listeners;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dialozi.ModalniDijalog;
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
	       
	        	JDialog studenti = new ModalniDijalog(new JFrame(), "Spisak studenata", true);
		  	   	  
				JLabel statusBar = new JLabel();
				studenti.add(statusBar,BorderLayout.SOUTH);
				statusBar.setPreferredSize((new Dimension(studenti.getHeight(), 25)));
				
				
				JPanel panel=new JPanel();
				panel.setLayout(new GridBagLayout());
				panel.setBackground(Color.CYAN);
				studenti.add(panel,BorderLayout.CENTER);
	        
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
			   gbc.gridx=1;
		       gbc.gridy=1;
		       gbc.insets = new Insets(10,70,10, 0);
		       panel.add(nazadButton,gbc);
		      
	    JButton obrisiButton = new JButton("Obrisi");
			   gbc.gridx=1;
			   gbc.gridy=1;
			   gbc.anchor = GridBagConstraints.EAST;
			   gbc.insets = new Insets(10,0,10, 100);

			   panel.add(obrisiButton,gbc);  
			        
			  
				
			   Font f = new Font(Font.DIALOG, Font.BOLD, 15);
			   list.setFont(f);
				
		 JScrollPane scrollPane = new JScrollPane(list); 
				   
		 scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
					
				    
				gbc.gridx = 0;
				gbc.gridy = 0;
				gbc.weightx = 100;
				gbc.weighty = 100;
				gbc.fill = GridBagConstraints.BOTH;   
				gbc.insets = new Insets(20, 70, 0, 0);					
					
				panel.add(scrollPane,gbc);
			
	   	     
	   	  		studenti.setVisible(true);
	        }
	    }
	    
}
