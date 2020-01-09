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
import controlleri.StudentiController;
import dialozi.ModalniDijalog;
import gui.MainFrame;
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
	        int row1=table.rowAtPoint(point);
			int row = MainFrame.getInstance().getTabelaPredmeta().getRowSorter().convertRowIndexToModel(row1);
			if(column==5) {
	       
	        	JDialog studenti = new ModalniDijalog(new JFrame(), "Spisak studenata", true);
		  	   	  
				JLabel statusBar = new JLabel();
				studenti.add(statusBar,BorderLayout.SOUTH);
				statusBar.setPreferredSize((new Dimension(studenti.getHeight(), 25)));
				
				
				JPanel panel=new JPanel();
				panel.setLayout(new GridBagLayout());
				panel.setBackground(Color.CYAN);
				studenti.add(panel,BorderLayout.CENTER);
	        
				String[] nizIndeksa = new String[BazaPredmeta.getInstance().getPredmeti().get(row).getSpisakStudenata().size()]; 
	    
	    
				for(int i = 0;i<BazaPredmeta.getInstance().getPredmeti().get(row).getSpisakStudenata().size();i++) {
							nizIndeksa[i]=BazaPredmeta.getInstance().getPredmeti().get(row).getSpisakStudenata().get(i);
							
							
			
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
		
		  nazadButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				studenti.dispose();
			}
		});     
		       
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
				
		 obrisiButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							String indeks = (String) list.getSelectedValue();
							int studentKojiSeBrise = 0;
					if(indeks != null) {		
							for(int i = 0;i < BazaPredmeta.getInstance().getPredmeti().get(row).getSpisakStudenata().size();i++) {
								if(indeks.equals(BazaPredmeta.getInstance().getPredmeti().get(row).getSpisakStudenata().get(i))) {
									studentKojiSeBrise = i;
									break;
								}
							}
							int vrstaPredmetaKojaSeBrise = 0;
							
							for(int i = 0;i < BazaStudenata.getInstance().getStudenti().size();i++) {
								if(indeks.equals(BazaStudenata.getInstance().getStudenti().get(i).getBrIndeksa())) {
									vrstaPredmetaKojaSeBrise = i;
									break;
								}
							}
							int predmetKojiSeBrise = 0;
							
							for(int i = 0; i < BazaStudenata.getInstance().getStudenti().get(vrstaPredmetaKojaSeBrise).getSpisakPredmeta().size();i++) {
								if(BazaPredmeta.getInstance().getPredmeti().get(row).getNazivPredmet().equals(BazaStudenata.getInstance().getStudenti().get(vrstaPredmetaKojaSeBrise).getSpisakPredmeta().get(i))) {
									predmetKojiSeBrise = i;
									break;
								}
							}
							
							
							PredmetiController.getInstance().izbrisiStudentaSaPredmeta(studentKojiSeBrise, row);
							StudentiController.getInstance().obrisiPredmetStudentu(predmetKojiSeBrise, vrstaPredmetaKojaSeBrise);
							studenti.dispose();
					}else
						JOptionPane.showMessageDialog(null, "Niste izabrali studenta za brisanje");
					}
					});   		
				
	   	     
	   	  		studenti.setVisible(true);
	        }
	    }
	    
}
