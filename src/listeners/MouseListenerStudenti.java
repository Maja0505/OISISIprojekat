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



public class MouseListenerStudenti extends MouseAdapter {
	
	 private JTable table;
		
     
	    public MouseListenerStudenti(JTable table) {
	        this.table = table;
	    }
	     
	    public void mouseClicked(MouseEvent event) {
	        Point point = event.getPoint();
	        int column = table.columnAtPoint(point);
	        int row=table.rowAtPoint(point);
	        if(column == 6) {
	        	
	         
			JDialog predmeti = new ModalniDijalog(new JFrame(), "Lista predmeta", true);
	   	  
			JLabel statusBar = new JLabel();
			predmeti.add(statusBar,BorderLayout.SOUTH);
			statusBar.setPreferredSize((new Dimension(predmeti.getHeight(), 25)));
			
			
			JPanel panel=new JPanel();
			panel.setLayout(new GridBagLayout());
			panel.setBackground(Color.CYAN);
			predmeti.add(panel,BorderLayout.CENTER);
			
			 String nizPredmeta[] = new String[BazaStudenata.getInstance().getStudenti().size()]; 
			    
				for(int i = 0;i<BazaPredmeta.getInstance().getPredmeti().size();i++) {
					if(BazaStudenata.getInstance().getValueAt(row, 4).equals(BazaPredmeta.getInstance().getValueAt(i, 3))){
							nizPredmeta[i]=BazaPredmeta.getInstance().getValueAt(i, 0).toString();
						
							
					}
				
			}
			
				@SuppressWarnings({ "rawtypes", "unchecked" })
				JList list = new JList(nizPredmeta);
				
				Font f = new Font(Font.DIALOG, Font.BOLD, 15);
				list.setFont(f);
				
			    JScrollPane scrollPane = new JScrollPane(list); 
				 
				   
				    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
					GridBagConstraints gbc = new GridBagConstraints();
				    
						gbc.gridx = 1;
						gbc.gridy = 1;
						gbc.weightx = 200;
						gbc.weighty = 200;
						gbc.fill = GridBagConstraints.HORIZONTAL;
						gbc.insets = new Insets(10, 100, 10, 100);					
					
					panel.add(scrollPane,gbc);
			
	   	     
	   	  	predmeti.setVisible(true);
			
	        }
	        
	        if(column == 7) {
	        	JDialog predmeti = new ModalniDijalog(new JFrame(), "Informacije o studentima", true);
	  	   	  
				JLabel statusBar = new JLabel();
				predmeti.add(statusBar,BorderLayout.SOUTH);
				statusBar.setPreferredSize((new Dimension(predmeti.getHeight(), 25)));
				
				
				JPanel panel=new JPanel();
				panel.setLayout(new GridBagLayout());
				panel.setBackground(Color.CYAN);
				predmeti.add(panel,BorderLayout.CENTER);
				
				Font f = new Font(Font.DIALOG, Font.BOLD, 15);
				
				JLabel brojtel = new JLabel("Broj telefona :");
				brojtel.setFont(f);
				JLabel email = new JLabel("Email :");
				email.setFont(f);
				JLabel brojTelefona = new JLabel(BazaStudenata.getInstance().getStudenti().get(row).getBrojTelefona());
				brojTelefona.setFont(f);
				JLabel Email = new JLabel(BazaStudenata.getInstance().getStudenti().get(row).getEmail());
				Email.setFont(f);
				JLabel adresa = new JLabel("Adresa :");
				adresa.setFont(f);
				JLabel datum = new JLabel("Datum rodjenja :");
				datum.setFont(f);
				JLabel Adresa = new JLabel(BazaStudenata.getInstance().getStudenti().get(row).getAdresa());
				Adresa.setFont(f);
				JLabel Datum = new JLabel(BazaStudenata.getInstance().getStudenti().get(row).getDatumRodjenja().toString());
				Datum.setFont(f);
				
				
				GridBagConstraints gbc = new GridBagConstraints();
				
				
				gbc.gridx = 0;
				gbc.gridy = 0;
				gbc.weightx = 10;
				gbc.weighty = 2; 
				gbc.insets = new Insets(5, 5, 5,5);	
				panel.add(brojtel,gbc);
				
				gbc.gridx = 1;
				gbc.gridy = 0;
				gbc.insets = new Insets(5, 5, 5,5);
				panel.add(brojTelefona,gbc);
				
				gbc.gridx = 0;
				gbc.gridy = 1;
				panel.add(email,gbc);
				
				gbc.gridx = 1;
				gbc.gridy = 1;
				panel.add(Email,gbc);
				
				gbc.gridx = 0;
				gbc.gridy = 2;
				panel.add(adresa,gbc);
				gbc.gridx = 1;
				gbc.gridy = 2;
				panel.add(Adresa,gbc);
				
				gbc.gridx = 0;
				gbc.gridy = 3;
				panel.add(datum,gbc);
				gbc.gridx = 1;
				gbc.gridy = 3;
				panel.add(Datum,gbc);
	
		   	     
		   	  	predmeti.setVisible(true);
	        }
	        
	    }
	    
	    
	    
	    
	
}
