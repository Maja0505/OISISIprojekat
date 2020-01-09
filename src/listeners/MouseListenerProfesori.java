package listeners;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import controlleri.PredmetiController;
import controlleri.ProfesoriController;
import dialozi.ModalniDijalog;
import gui.MainFrame;
import modeli.BazaProfesora;


public class MouseListenerProfesori extends MouseAdapter {
	  private JTable table;
		
     
	  public MouseListenerProfesori(JTable table) {
	        this.table = table;
	    }
	     
	  public void mouseClicked(MouseEvent event) {
	        Point point = event.getPoint();
	        int column = table.columnAtPoint(point);
	        int row1=table.rowAtPoint(point);
			int row = MainFrame.getInstance().getTabelaProfesora().getRowSorter().convertRowIndexToModel(row1);
	        if(column==3) { //prikazi
		        	JDialog predmeti = new ModalniDijalog(new JFrame(), "Predmeti", true);
			  	   	  
					JLabel statusBar = new JLabel();
					predmeti.add(statusBar,BorderLayout.SOUTH);
					statusBar.setPreferredSize((new Dimension(predmeti.getHeight(), 25)));
					
					
					JPanel panel=new JPanel();
					panel.setLayout(new GridBagLayout());
					panel.setBackground(Color.CYAN);
					predmeti.add(panel,BorderLayout.CENTER);
		        
					String[] nizSifriPredmeta = new String[BazaProfesora.getInstance().getProfesori().get(row).getSpisakPredmeta().size()]; 
		    
					//popunjavanje niza svim predmetima na kojima profesor predaje
					for(int i = 0;i<BazaProfesora.getInstance().getProfesori().get(row).getSpisakPredmeta().size();i++) {
						
								nizSifriPredmeta[i]=BazaProfesora.getInstance().getProfesori().get(row).getSpisakPredmeta().get(i);
								
								
						
			
					}
		
					@SuppressWarnings({ "unchecked", "rawtypes" })
					JList list = new JList(nizSifriPredmeta);
					
					
					 GridBagConstraints gbc=new GridBagConstraints();
					 gbc.insets = new Insets(5, 5, 5, 5);
					
					
					
					 JButton nazadButton = new JButton("Nazad");
						   gbc.gridx=1;
					       gbc.gridy=1;
					       gbc.insets = new Insets(10,70,10, 0);
					       panel.add(nazadButton,gbc);
					       
					       nazadButton.addActionListener(new ActionListener() {
						
								@Override
								public void actionPerformed(ActionEvent e) {
									predmeti.dispose(); 
									
								}
					       });
					       
					  
				      
				     JButton obrisiButton = new JButton("Obrisi");
						   gbc.gridx=1;
						   gbc.gridy=1;
						   gbc.anchor = GridBagConstraints.EAST;
						   gbc.insets = new Insets(10,0,10, 100);
						   panel.add(obrisiButton,gbc); 	
						   panel.add(obrisiButton,gbc);  
						   
						   obrisiButton.addActionListener(new ActionListener(){
							
							@Override
							public void actionPerformed(ActionEvent e) {
								String sifra=(String) list.getSelectedValue();	//koja sifra predmeta je selektovana
								int predmetKojiSeBrise=0;			
								
								if(sifra!=null) {
									for(int i=0;i<BazaProfesora.getInstance().getProfesori().get(row).getSpisakPredmeta().size();i++) {
										if(sifra.equals(BazaProfesora.getInstance().getProfesori().get(row).getSpisakPredmeta().get(i))) {
											predmetKojiSeBrise=i;				//indeks predmeta koji treba da izbrisemo
											break;
										}
									}
									
									
									
									ProfesoriController.getInstance().izbrisiPredmetProfesoru(predmetKojiSeBrise, row);
									PredmetiController.getInstance().izbrisiProfesoraSaPredmeta(sifra);
									predmeti.dispose();
								}else {
								
									JOptionPane.showMessageDialog(null, "Niste izabrali predmet za brisanje");
							}
								
							}
	        				

						});
			
						 	
					        
					  
						
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
					
			 	     
						   predmeti.setVisible(true);


	        }
	        
	        if(column==4) {  //info
	        	
	        	
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
							JLabel adresaStanovanjaL = new JLabel("Adresa stanovanja :");
							adresaStanovanjaL.setFont(f);
							JLabel kontaktTelL = new JLabel("Kontakt telefon :");
							kontaktTelL.setFont(f);
							JLabel brojLicneLabela = new JLabel("Broj licne karte:");
							brojLicneLabela.setFont(f);
							JLabel emailLabela = new JLabel("E-mail:");
							emailLabela.setFont(f);
							JLabel adresaKancelarijeL = new JLabel("Adresa kancelarije :");
							adresaKancelarijeL.setFont(f);
							
							
							JLabel titula = new JLabel(BazaProfesora.getInstance().getProfesori().get(row).getTitula());
							titula.setFont(f);
							JLabel zvanje = new JLabel(BazaProfesora.getInstance().getProfesori().get(row).getZvanje());
							zvanje.setFont(f);	
							JLabel adresa = new JLabel(BazaProfesora.getInstance().getProfesori().get(row).getAdresaStanivanja());
							adresa.setFont(f);
							JLabel telefon = new JLabel(BazaProfesora.getInstance().getProfesori().get(row).getKontaktTelefon());
							telefon.setFont(f);
							JLabel brojLicne = new JLabel(BazaProfesora.getInstance().getProfesori().get(row).getBrojLicneKarte());
							brojLicne.setFont(f);
							JLabel email = new JLabel(BazaProfesora.getInstance().getProfesori().get(row).getEmail());
							email.setFont(f);
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

