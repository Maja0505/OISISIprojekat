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
import modeli.BazaProfesora;
import modeli.BazaStudenata;

public class MouseListenerProfesori extends MouseAdapter {
	 private JTable table;
		
     
	    public MouseListenerProfesori(JTable table) {
	        this.table = table;
	    }
	     
	    public void mouseClicked(MouseEvent event) {
	        Point point = event.getPoint();
	        int column = table.columnAtPoint(point);
	        int row=table.rowAtPoint(point);
	        if(column==3) {
	        	JDialog predmeti = new ModalniDijalog(new JFrame(), "Predmeti", true);
		  	   	  
				JLabel statusBar = new JLabel();
				predmeti.add(statusBar,BorderLayout.SOUTH);
				statusBar.setPreferredSize((new Dimension(predmeti.getHeight(), 25)));
				
				
				JPanel panel=new JPanel();
				panel.setLayout(new GridBagLayout());
				panel.setBackground(Color.CYAN);
				predmeti.add(panel,BorderLayout.CENTER);
	        
	       String nizSifriPredmeta[] = new String[BazaStudenata.getInstance().getStudenti().size()]; 
	    
	    
			for(int i = 0;i<BazaPredmeta.getInstance().getPredmeti().size();i++) {
				if(BazaPredmeta.getInstance().getValueAt(i, 4).equals(BazaProfesora.getInstance().getValueAt(row, 0).concat(" ").concat(BazaProfesora.getInstance().getValueAt(row, 1)))){
						nizSifriPredmeta[i]=BazaPredmeta.getInstance().getValueAt(i, 0).toString();
						
						
				}
			
		}
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JList list = new JList(nizSifriPredmeta);
		
		
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
			    
			    //predmeti.setUndecorated(true);
				predmeti.setVisible(true);


	        }
	        if(column==4) {
	        	
	        	
	        	JDialog predmeti = new ModalniDijalog(new JFrame(), "Informacije o profesorima", true);
		  	   	  
				JLabel statusBar = new JLabel();
				predmeti.add(statusBar,BorderLayout.SOUTH);
				statusBar.setPreferredSize((new Dimension(predmeti.getHeight(), 25)));
				
				
				JPanel panel=new JPanel();
				panel.setLayout(new GridBagLayout());
				panel.setBackground(Color.CYAN);
				predmeti.add(panel,BorderLayout.CENTER);
				
				Font f = new Font(Font.DIALOG, Font.BOLD, 15);
				
				JLabel titulaLabela = new JLabel("Titula :");
				titulaLabela.setFont(f);
				JLabel zvanjeLabela = new JLabel("Zvanje:");
				zvanjeLabela.setFont(f);
				JLabel titula = new JLabel(BazaProfesora.getInstance().getProfesori().get(row).getTitula());
				titula.setFont(f);
				JLabel zvanje = new JLabel(BazaProfesora.getInstance().getProfesori().get(row).getZvanje());
				zvanje.setFont(f);
				JLabel adresaStanovanjaL = new JLabel("Adresa stanovanja :");
				adresaStanovanjaL.setFont(f);
				JLabel kontaktTelL = new JLabel("Kontakt telefon :");
				kontaktTelL.setFont(f);
				JLabel adresa = new JLabel(BazaProfesora.getInstance().getProfesori().get(row).getAdresaStanivanja());
				adresa.setFont(f);
				JLabel telefon = new JLabel(BazaProfesora.getInstance().getProfesori().get(row).getKontaktTelefon());
				telefon.setFont(f);
				JLabel brojLicneLabela = new JLabel("Broj licne karte:");
				brojLicneLabela.setFont(f);
				JLabel emailLabela = new JLabel("E-mail:");
				emailLabela.setFont(f);
				JLabel brojLicne = new JLabel(BazaProfesora.getInstance().getProfesori().get(row).getBrojLicneKarte());
				brojLicne.setFont(f);
				JLabel email = new JLabel(BazaProfesora.getInstance().getProfesori().get(row).getEmail());
				email.setFont(f);
				JLabel adresaKancelarijeL = new JLabel("Adresa kancelarije :");
				adresaKancelarijeL.setFont(f);
				JLabel adresaKancelarije = new JLabel(BazaProfesora.getInstance().getProfesori().get(row).getAdresaKancelarije());
				adresaKancelarije.setFont(f);
				
				GridBagConstraints gbc = new GridBagConstraints();
				
				
				gbc.gridx = 0;
				gbc.gridy = 0;
				gbc.weightx = 10;
				gbc.weighty = 2; 
				gbc.insets = new Insets(5, 5, 5,5);	
				panel.add(titulaLabela,gbc);
				
				gbc.gridx = 1;
				gbc.gridy = 0;
				gbc.insets = new Insets(5, 5, 5,5);
				panel.add(titula,gbc);
				
				gbc.gridx = 0;
				gbc.gridy = 1;
				panel.add(zvanjeLabela,gbc);
				
				gbc.gridx = 1;
				gbc.gridy = 1;
				panel.add(zvanje,gbc);
				
				gbc.gridx = 0;
				gbc.gridy = 2;
				panel.add(adresaKancelarijeL,gbc);
				gbc.gridx = 1;
				gbc.gridy = 2;
				panel.add(adresaKancelarije,gbc);
				
				gbc.gridx = 0;
				gbc.gridy = 3;
				panel.add(emailLabela,gbc);
				gbc.gridx = 1;
				gbc.gridy = 3;
				panel.add(email,gbc);
				
				gbc.gridx = 0;
				gbc.gridy = 4;
				panel.add(kontaktTelL,gbc);
				gbc.gridx = 1;
				gbc.gridy = 4;
				panel.add(telefon,gbc);
				
				gbc.gridx = 0;
				gbc.gridy = 5;
				panel.add(adresaStanovanjaL,gbc);
				gbc.gridx = 1;
				gbc.gridy = 5;
				panel.add(adresa,gbc);
				
				gbc.gridx = 0;
				gbc.gridy = 6;
				panel.add(brojLicneLabela,gbc);
				gbc.gridx = 1;
				gbc.gridy = 6;
				panel.add(brojLicne,gbc);
	
		   	     
		   	  	predmeti.setVisible(true);
	        }
	    
	        	
	        	
	        	
	        	
	        	
	        	
	        	
	        	
	        }
	    }

