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
			if(!txt.getText().trim().equals("")) {
				if( txt.getText().trim().equals("Nepravilan unos imena") || !m.matches()) {
					txt.setText("Nepravilan unos imena");
					txt.setForeground(Color.RED);
				} else {
					txt.setForeground(Color.BLACK);
				}
			}
		}
		
		 if (txt.getName().equals("Prz*")) {
			Pattern regExp = Pattern.compile("[A-Z][a-zA-Z]+$");
			Matcher m = regExp.matcher(txt.getText());
			if(!txt.getText().trim().equals("")) {
				if( txt.getText().trim().equals("Nepravilan unos prezimena") || !m.matches()) {
					txt.setText("Nepravilan unos prezimena");
					txt.setForeground(Color.RED);
				} else {
					txt.setForeground(Color.BLACK);
				}
			}
		}
		
		 
		 if (txt.getName().equals("Dat*")) {
				Pattern regExp = Pattern.compile("([12]\\d{3}[.](0[1-9]|1[0-2])[.](0[1-9]|[12]\\d|3[01])[.])$");
				Matcher m = regExp.matcher(txt.getText());
				if(!txt.getText().trim().equals("")) {
					if( txt.getText().trim().equals("Nepravilan unos datuma") || !m.matches()) {
						txt.setText("Nepravilan unos datuma");
						txt.setForeground(Color.RED);
					} else {
						txt.setForeground(Color.BLACK);
					}
				}
			} 
		
		 if (txt.getName().equals("Adresa*")) {
				Pattern regExp = Pattern.compile("[A-Za-z0-9 ]+[,][A-Za-z ]+$");
				Matcher m = regExp.matcher(txt.getText());
				if(!txt.getText().trim().equals("")) {
					if( txt.getText().trim().equals("Nepravilan unos adrese") || !m.matches()) {
						txt.setText("Nepravilan unos adrese");
						txt.setForeground(Color.RED);
					} else {
						txt.setForeground(Color.BLACK);
					}
				}
			} 
		
		 if (txt.getName().equals("Broj*")) {
				Pattern regExp = Pattern.compile("([+][0-9]{2,3}|[0])[1-9]{2,2}[/][0-9]{3,4}[-][0-9]{3,3}$");
				Matcher m = regExp.matcher(txt.getText());
				if(!txt.getText().trim().equals("")) {
					if( txt.getText().trim().equals("Nepravilan unos broja telefona") || !m.matches()) {
						txt.setText("Nepravilan unos broja telefona");
						txt.setForeground(Color.RED);
					} else {
						txt.setForeground(Color.BLACK);
					}
				}
			} 
		 
		 if (txt.getName().equals("Indeks*")) {
				Pattern regExp = Pattern.compile("[a-zA-Z ]{2,2}[0-9]{1,3}[/]20[0-9]{1,2}$");
				Matcher m = regExp.matcher(txt.getText());
				if(!txt.getText().trim().equals("")) {
					if( txt.getText().trim().equals("Nepravilan unos indeksa") || !m.matches()) {
						txt.setText("Nepravilan unos indeksa");
						txt.setForeground(Color.RED);
					} else {
						txt.setForeground(Color.BLACK);
					}
				}
			} 
		 
		 if (txt.getName().equals("Email*")) {
				Pattern regExp = Pattern.compile("^[a-zA-Z0-9]{1,10}[._]?[a-zA-Z0-9]{1,10}@[a-zA-Z0-9]{1,10}[.][a-z]{1,5}$");
				Matcher m = regExp.matcher(txt.getText());
				if(!txt.getText().trim().equals("")) {
					if( txt.getText().trim().equals("Nepravilan unos email-a") || !m.matches()) {
						txt.setText("Nepravilan unos email-a");
						txt.setForeground(Color.RED);
					} else {
						txt.setForeground(Color.BLACK);
					}
				}
			}
		 
		 if (txt.getName().equals("Prosecna ocena*")) {
				Pattern regExp = Pattern.compile("([6-9][.][0-9]*|[6789]|10)$");
				Matcher m = regExp.matcher(txt.getText());
				if(!txt.getText().trim().equals("")) {
					if( txt.getText().trim().equals("Nepravilan unos prosecne ocene") || !m.matches()) {
						txt.setText("Nepravilan unos prosecne ocene");
						txt.setForeground(Color.RED);
					} else {
						txt.setForeground(Color.BLACK);
					}
				}
			} 
		 
		 if (txt.getName().equals("GodUpis*")) {
				Pattern regExp = Pattern.compile("([12]\\d{3}[.](0[1-9]|1[0-2])[.](0[1-9]|[12]\\d|3[01])[.])$");
				Matcher m = regExp.matcher(txt.getText());
				if(!txt.getText().trim().equals("")) {
					if( txt.getText().trim().equals("Nepravilan unos datuma upisa") || !m.matches()) {
						txt.setText("Nepravilan unos datuma upisa");
						txt.setForeground(Color.RED);
					} else {
						txt.setForeground(Color.BLACK);
					}
				}
			} 
	
	
//za profesora
	
	if (txt.getName().equals("ImeProf*")) {
		Pattern regExp = Pattern.compile("[A-Z][a-zA-Z]+$");
		Matcher m = regExp.matcher(txt.getText());
		if(!txt.getText().trim().equals("")) {
			if( txt.getText().trim().equals("Nepravilan unos imena") || !m.matches()) {
				txt.setText("Nepravilan unos imena");
				txt.setForeground(Color.RED);
			} else {
				txt.setForeground(Color.BLACK);
			}
		}
	}
	
	 if (txt.getName().equals("PrzProf*")) {
		Pattern regExp = Pattern.compile("[A-Z][a-zA-Z]+$");
		Matcher m = regExp.matcher(txt.getText());
		if(!txt.getText().trim().equals("")) {
			if( txt.getText().trim().equals("Nepravilan unos prezimena") || !m.matches()) {
				txt.setText("Nepravilan unos prezimena");
				txt.setForeground(Color.RED);
			} else {
				txt.setForeground(Color.BLACK);
			}
		}
	}
	
	 
	 if (txt.getName().equals("DatProf*")) {
			Pattern regExp = Pattern.compile("([12]\\d{3}[.](0[1-9]|1[0-2])[.](0[1-9]|[12]\\d|3[01])[.])$");
			Matcher m = regExp.matcher(txt.getText());
			if(!txt.getText().trim().equals("")) {
				if( txt.getText().trim().equals("Nepravilan unos datuma rodjenja") || !m.matches()) {
					txt.setText("Nepravilan unos datuma rodjenja");
					txt.setForeground(Color.RED);
				} else {
					txt.setForeground(Color.BLACK);
				}
			}
		} 
	
	 if (txt.getName().equals("AdresaProf*")) {
			Pattern regExp = Pattern.compile("[A-Za-z0-9 ]+[,][A-Za-z ]+$");
			Matcher m = regExp.matcher(txt.getText());
			if(!txt.getText().trim().equals("")) {
				if( txt.getText().trim().equals("Nepravilan unos adrese stanovanja") || !m.matches()) {
					txt.setText("Nepravilan unos adrese stanovanja");
					txt.setForeground(Color.RED);
				} else {
					txt.setForeground(Color.BLACK);
				}
			}
		} 
	
	 if (txt.getName().equals("BrojProf*")) {
			Pattern regExp = Pattern.compile("([+][0-9]{2,3}|[0])[1-9]{2,2}[/][0-9]{3,4}[-][0-9]{3,3}$");
			Matcher m = regExp.matcher(txt.getText());
			if(!txt.getText().trim().equals("")) {
				if( txt.getText().trim().equals("Nepravilan unos broja telefona") || !m.matches()) {
					txt.setText("Nepravilan unos broja telefona");
					txt.setForeground(Color.RED);
				} else {
					txt.setForeground(Color.BLACK);
				}
			}
		}
	 
	 if (txt.getName().equals("AdresaProfKanc*")) {
			Pattern regExp = Pattern.compile("[A-Za-z0-9 ]+[,][A-Za-z ]+[,][A-Za-z0-9 ]+$");
			Matcher m = regExp.matcher(txt.getText());
			if(!txt.getText().trim().equals("")) {
				if( txt.getText().trim().equals("Nepravilan unos adrese kancelarije") || !m.matches()) {
					txt.setText("Nepravilan unos adrese kancelarije");
					txt.setForeground(Color.RED);
				} else {
					txt.setForeground(Color.BLACK);
				}
			}
		} 
	
	 if (txt.getName().equals("EmailProf*")) {
			Pattern regExp = Pattern.compile("^[a-zA-Z0-9]{1,10}[._]?[a-zA-Z0-9]{1,10}@[a-zA-Z0-9]{1,10}[.][a-z]{1,5}$");
			Matcher m = regExp.matcher(txt.getText());
			if(!txt.getText().trim().equals("")) {
				if( txt.getText().trim().equals("Nepravilan unos email-a") || !m.matches()) {
					txt.setText("Nepravilan unos email-a");
					txt.setForeground(Color.RED);
				} else {
					txt.setForeground(Color.BLACK);
				}
			}
		}
	 
	 
	 if (txt.getName().equals("BrojLicneProf*")) {
			Pattern regExp = Pattern.compile("[0-9]{9,9}$");
			Matcher m = regExp.matcher(txt.getText());
			if(!txt.getText().trim().equals("")) {
				if( txt.getText().trim().equals("Nepravilan unos licne karte") || !m.matches()) {
					txt.setText("Nepravilan unos licne karte");
					txt.setForeground(Color.RED);
				} else {
					txt.setForeground(Color.BLACK);
				}
			}
		}
	 
	 
	 if (txt.getName().equals("TitulaProf*")) {
			Pattern regExp = Pattern.compile("[A-Za-z]+[.]?[ ]?[a-z]+$");
			Matcher m = regExp.matcher(txt.getText());
			if(!txt.getText().trim().equals("")) {
				if( txt.getText().trim().equals("Nepravilan unos titule") || !m.matches()) {
					txt.setText("Nepravilan unos titule");
					txt.setForeground(Color.RED);
				} else {
					txt.setForeground(Color.BLACK);
				}
			}
		}
	 
	 if (txt.getName().equals("ZvanjeProf*")) {
			Pattern regExp = Pattern.compile("[A-Za-z ]{1,20}$");
			Matcher m = regExp.matcher(txt.getText());
			if(!txt.getText().trim().equals("")) {
				if( txt.getText().trim().equals("Nepravilan unos zvanja") || !m.matches()) {
					txt.setText("Nepravilan unos zvanja");
					txt.setForeground(Color.RED);
				} else {
					txt.setForeground(Color.BLACK);
				}
			}
		}
	 
	 
//ZA PREDMET
	 if (txt.getName().equals("Sifra predmeta*")) {
			Pattern regExp = Pattern.compile("[A-Z0-9]+[-]?[A-Z0-9]+");
			Matcher m = regExp.matcher(txt.getText());
			if (!txt.getText().trim().equals("")) {
				if( txt.getText().trim().equals("Nepravilan unos sifre predmeta") || !m.matches()) {
					txt.setText("Nepravilan unos sifre predmeta");
					txt.setForeground(Color.RED);
				} else {
					txt.setForeground(Color.BLACK);
				}
		}
	
		}
	 
	 if (txt.getName().equals("Naziv predmeta*")) {
			Pattern regExp = Pattern.compile("[A-Z][a-z0-9 ]+");
			Matcher m = regExp.matcher(txt.getText());
			if (!txt.getText().trim().equals("")) {
					if( txt.getText().trim().equals("Nepravilan unos naziva predmeta") || !m.matches()) {
						txt.setText("Nepravilan unos naziva predmeta");
						txt.setForeground(Color.RED);
					} else {
						txt.setForeground(Color.BLACK);
					}
			}
		}
	 
	}
	
	
}
