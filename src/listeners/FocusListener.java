package listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;

public class FocusListener implements java.awt.event.FocusListener {

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		JTextField txt = (JTextField) arg0.getComponent();
		txt.setBackground(Color.WHITE);
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		JTextField txt = (JTextField) arg0.getComponent();
		txt.setBackground(Color.CYAN);
		
	
		if (txt.getName().equals("Ime*")) {
			Pattern regExp = Pattern.compile("[A-Z][a-zA-Z]+$");
			Matcher m = regExp.matcher(txt.getText());
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Nije validan unos imena...") || !m.matches()) {
				txt.setText("Nije validan unos imena...");
				txt.setForeground(Color.RED);
			} else {
				txt.setForeground(Color.BLACK);
			}
		}
		
		 if (txt.getName().equals("Prz*")) {
			Pattern regExp = Pattern.compile("[A-Z][a-zA-Z]+$");
			Matcher m = regExp.matcher(txt.getText());
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Nije validan unos prezimena...") || !m.matches()) {
				txt.setText("Nije validan unos prezimena...");
				txt.setForeground(Color.RED);
			} else {
				txt.setForeground(Color.BLACK);
			}
		}
		
		 
		 if (txt.getName().equals("Dat*")) {
				Pattern regExp = Pattern.compile("[12][0-9]{3,3}[-][01][0-9][-][0123][0-9]$");
				Matcher m = regExp.matcher(txt.getText());
				if (txt.getText().trim().equals("") || txt.getText().trim().equals("Nije validan format datuma (ocekivani 'YYYY - MM - DD')...") || !m.matches()) {
					txt.setText("Nije validan format datuma (ocekivani 'YYYY - MM - DD')...");
					txt.setForeground(Color.RED);
				} else {
					txt.setForeground(Color.BLACK);
				}
			} 
		
		 if (txt.getName().equals("Adresa*")) {
				Pattern regExp = Pattern.compile("[A-Z][A-Za-z0-9 ]*$");
				Matcher m = regExp.matcher(txt.getText());
				if (txt.getText().trim().equals("") || txt.getText().trim().equals("Nije valian unos adrese...") || !m.matches()) {
					txt.setText("Nije valian unos adrese...");
					txt.setForeground(Color.RED);
				} else {
					txt.setForeground(Color.BLACK);
				}
			} 
		
		 if (txt.getName().equals("Broj*")) {
				Pattern regExp = Pattern.compile("[\\+]381[0-9]{9,9}$");
				Matcher m = regExp.matcher(txt.getText());
				if (txt.getText().trim().equals("") || txt.getText().trim().equals("Validan format je +381*********...") || !m.matches()) {
					txt.setText("Validan format je +381*********...");
					txt.setForeground(Color.RED);
				} else {
					txt.setForeground(Color.BLACK);
				}
			} 
		 
		 if (txt.getName().equals("Indeks*")) {
				Pattern regExp = Pattern.compile("[a-zA-Z]{2,2}[0-9]{1,3}[-]20[0-9]{1,2}$");
				Matcher m = regExp.matcher(txt.getText());
				if (txt.getText().trim().equals("") || txt.getText().trim().equals("Validan format je xxBROJ-20YY...") || !m.matches()) {
					txt.setText("Validan format je xxBROJ-20YY...");
					txt.setForeground(Color.RED);
				} else {
					txt.setForeground(Color.BLACK);
				}
			} 
		 
		 if (txt.getName().equals("Email*")) {
				Pattern regExp = Pattern.compile("^[a-zA-Z0-9]{1,20}@[a-zA-Z0-9]{1,20}.[a-z]{1,5}$");
				Matcher m = regExp.matcher(txt.getText());
				if (txt.getText().trim().equals("") || txt.getText().trim().equals("Nije validan format za email...") || !m.matches()) {
					txt.setText("Nije validan format za email...");
					txt.setForeground(Color.RED);
				} else {
					txt.setForeground(Color.BLACK);
				}
			}
		 
		 if (txt.getName().equals("Prosecna ocena*")) {
				Pattern regExp = Pattern.compile("([6-9].[0-9]*)|10$");
				Matcher m = regExp.matcher(txt.getText());
				if (txt.getText().trim().equals("") || txt.getText().trim().equals("Ocene su u rasponu od 6 - 10...") || !m.matches()) {
					txt.setText("Ocene su u rasponu od 6 - 10...");
					txt.setForeground(Color.RED);
				} else {
					txt.setForeground(Color.BLACK);
				}
			} 
		 
		 if (txt.getName().equals("GodUpis*")) {
				Pattern regExp = Pattern.compile("[0-9]{1,4}$");
				Matcher m = regExp.matcher(txt.getText());
				if (txt.getText().trim().equals("") || txt.getText().trim().equals("Nije validan unos...") || !m.matches()) {
					txt.setText("Nije validan unos...");
					txt.setForeground(Color.RED);
				} else {
					txt.setForeground(Color.BLACK);
				}
			} 
	
	
//za profesora
	
	if (txt.getName().equals("ImeProf*")) {
		Pattern regExp = Pattern.compile("[A-Z][a-zA-Z]+$");
		Matcher m = regExp.matcher(txt.getText());
		if (txt.getText().trim().equals("") || txt.getText().trim().equals("Nije validan unos imena...") || !m.matches()) {
			txt.setText("Nije validan unos imena...");
			txt.setForeground(Color.RED);
		} else {
			txt.setForeground(Color.BLACK);
		}
	}
	
	 if (txt.getName().equals("PrzProf*")) {
		Pattern regExp = Pattern.compile("[A-Z][a-zA-Z]+$");
		Matcher m = regExp.matcher(txt.getText());
		if (txt.getText().trim().equals("") || txt.getText().trim().equals("Nije validan unos prezimena...") || !m.matches()) {
			txt.setText("Nije validan unos prezimena...");
			txt.setForeground(Color.RED);
		} else {
			txt.setForeground(Color.BLACK);
		}
	}
	
	 
	 if (txt.getName().equals("DatProf*")) {
			Pattern regExp = Pattern.compile("[12][0-9]{3,3}[-][01][0-9][-][0123][0-9]$");
			Matcher m = regExp.matcher(txt.getText());
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Nije validan format datuma (ocekivani 'YYYY - MM - DD')...") || !m.matches()) {
				txt.setText("Nije validan format datuma (ocekivani 'YYYY - MM - DD')...");
				txt.setForeground(Color.RED);
			} else {
				txt.setForeground(Color.BLACK);
			}
		} 
	
	 if (txt.getName().equals("AdresaProf*")) {
			Pattern regExp = Pattern.compile("[A-Z][A-Za-z0-9 ]*$");
			Matcher m = regExp.matcher(txt.getText());
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Nije valian unos adrese...") || !m.matches()) {
				txt.setText("Nije valian unos adrese...");
				txt.setForeground(Color.RED);
			} else {
				txt.setForeground(Color.BLACK);
			}
		} 
	
	 if (txt.getName().equals("BrojProf*")) {
			Pattern regExp = Pattern.compile("[\\+]381[0-9]{9,9}$");
			Matcher m = regExp.matcher(txt.getText());
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Validan format je +381*********...") || !m.matches()) {
				txt.setText("Validan format je +381*********...");
				txt.setForeground(Color.RED);
			} else {
				txt.setForeground(Color.BLACK);
			}
		}
	 
	 if (txt.getName().equals("AdresaProfKanc*")) {
			Pattern regExp = Pattern.compile("[A-Z][A-Za-z0-9 ]*$");
			Matcher m = regExp.matcher(txt.getText());
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Nije valian unos adrese kancelarije...") || !m.matches()) {
				txt.setText("Nije valian unos adrese kancelarije...");
				txt.setForeground(Color.RED);
			} else {
				txt.setForeground(Color.BLACK);
			}
		} 
	
	 if (txt.getName().equals("EmailProf*")) {
			Pattern regExp = Pattern.compile("^[a-zA-Z0-9]{1,20}@[a-zA-Z0-9]{1,20}.[a-z]{1,5}$");
			Matcher m = regExp.matcher(txt.getText());
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Nije validan format za email...") || !m.matches()) {
				txt.setText("Nije validan format za email...");
				txt.setForeground(Color.RED);
			} else {
				txt.setForeground(Color.BLACK);
			}
		}
	 
	 
	 if (txt.getName().equals("BrojLicneProf*")) {
			Pattern regExp = Pattern.compile("[a-zA-Z0-9]{1,20}$");
			Matcher m = regExp.matcher(txt.getText());
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Nije validan unos...") || !m.matches()) {
				txt.setText("Nije validan unos...");
				txt.setForeground(Color.RED);
			} else {
				txt.setForeground(Color.BLACK);
			}
		}
	 
	 
	 if (txt.getName().equals("TitulaProf*")) {
			Pattern regExp = Pattern.compile("[a-z ]{1,20}$");
			Matcher m = regExp.matcher(txt.getText());
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Nije validan unos titule...") || !m.matches()) {
				txt.setText("Nije validan unos titule...");
				txt.setForeground(Color.RED);
			} else {
				txt.setForeground(Color.BLACK);
			}
		}
	 
	 if (txt.getName().equals("ZvanjeProf*")) {
			Pattern regExp = Pattern.compile("[a-z ]{1,20}$");
			Matcher m = regExp.matcher(txt.getText());
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Nije validan unos zvanja...") || !m.matches()) {
				txt.setText("Nije validan unos zvanja...");
				txt.setForeground(Color.RED);
			} else {
				txt.setForeground(Color.BLACK);
			}
		}
	 
	 
//ZA PREDMET
	 if (txt.getName().equals("Sifra predmeta*")) {
			Pattern regExp = Pattern.compile("[A-Z0-9]+[-]?[A-Z0-9]+");
			Matcher m = regExp.matcher(txt.getText());
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Nije validan unos sifre! Sifru morate uneti velikim slovima") || !m.matches()) {
				txt.setText("Nije validan unos sifre! Sifru morate uneti velikim slovima");
				txt.setForeground(Color.RED);
			} else {
				txt.setForeground(Color.BLACK);
			}
		}
	 
	 if (txt.getName().equals("Naziv predmeta*")) {
			Pattern regExp = Pattern.compile("[A-Z][a-z0-9 ]+");
			Matcher m = regExp.matcher(txt.getText());
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Nije validan unos naziva predmeta...") || !m.matches()) {
				txt.setText("Nije validan unos naziva predmeta...");
				txt.setForeground(Color.RED);
			} else {
				txt.setForeground(Color.BLACK);
			}
		}
	 
	}
	
	
}
