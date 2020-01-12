package modeli;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import gui.MainFrame;
import tabele.PredmetiJTable;




public class BazaPredmeta {
	private static BazaPredmeta instance = null;

	public static BazaPredmeta getInstance() {
		if(instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}
	
	private List<Predmet> predmeti;
	private List<String> kolone;
	private File file;
	
	private BazaPredmeta() {
		this.predmeti = new ArrayList<Predmet>();
	    this.file = new File("predmeti.txt");
	    if(file.length() != 0)
	    	initPredmeti(); 
	
		

		this.kolone = new ArrayList<String>();
		this.kolone.add("Sifra");
		this.kolone.add("Naziv");
		this.kolone.add("Semestar");
		this.kolone.add("Godina izvodjenja");
		this.kolone.add("Predmetni profesor");	
		
		
		
	}
	
	@SuppressWarnings("unchecked")
	private void initPredmeti() {
		
		ArrayList<?> listaPredmeta = null;
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			listaPredmeta = (ArrayList<Object>) ois.readObject();
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if(predmeti != null) {
			for(Object p : listaPredmeta)
				this.predmeti.add((Predmet) p);
		}
		
	
}
	public void savePredmete() {
		 file = new File("predmeti.txt");
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(predmeti);
			oos.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}


	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public List<String> getKolone() {
		return kolone;
	}

	public void setKolone(List<String> kolone) {
		this.kolone = kolone;
	}
	
	//broj koliko kolona ima
	public int getColumnCount() {
		return 5;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	
	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		switch (column) {
		case 0:
			return predmet.getSifraPredmeta();
		case 1:
			return predmet.getNazivPredmet();
		case 2:
			return Integer.toString(predmet.getSemestar());
		case 3:
			return Integer.toString(predmet.getGodinaIzvodjenjaPredmeta());
		case 4:
			return predmet.getPredmetniProfesor();
		default:
			return null;
		}
	}
	

	public void izbrisiPredmet(String id) {				//brise iz baze
		for (Predmet p : predmeti) {
			if (p.getSifraPredmeta().equals(id)) {
				predmeti.remove(p);
				
				break;
			}
		}
		//Ako izbrisemo predmet,potrebno je izbrisati ga i iz liste predmeta studenata i profesora koji ga slusaju/predaju
		for(int i = 0; i < BazaStudenata.getInstance().getStudenti().size();i++) {
			for(int j = 0; j < BazaStudenata.getInstance().getStudenti().get(i).getSpisakPredmeta().size();j++) {
				if(id.equals(BazaStudenata.getInstance().getStudenti().get(i).getSpisakPredmeta().get(j))) {
					BazaStudenata.getInstance().getStudenti().get(i).getSpisakPredmeta().remove(j);
				}
			}
		}
		
		for(int i = 0; i < BazaProfesora.getInstance().getProfesori().size();i++) {
			for(int j = 0; j <BazaProfesora.getInstance().getProfesori().get(i).getSpisakPredmeta().size();j++) {
				if(id.equals(BazaProfesora.getInstance().getProfesori().get(i).getSpisakPredmeta().get(j))) {
					BazaProfesora.getInstance().getProfesori().get(i).getSpisakPredmeta().remove(j);
				}
			}
		}
		
	}
	
	public void dodajPredmet(Predmet p) {				//dodaje u bazu
		this.predmeti.add(p);

	}
	
	
	public void izmeniPredmet(String sifra, String nazivPredmet, int semestar, int godinaIzvodjenjaPredmeta, String predmetniProfesor,List<String> listaStudenata) {			//menja u bazi
			
				int selektovanaVrsta=MainFrame.getInstance().getTabelaPredmeta().getRowSorter().convertRowIndexToModel(PredmetiJTable.selektovanaVrsta);
																							
				Predmet p=BazaPredmeta.getInstance().getRow(selektovanaVrsta);
				int staraGodina = p.getGodinaIzvodjenjaPredmeta();
				String staraSifra= p.getSifraPredmeta();
				
				p.setSifraPredmeta(sifra);
				p.setNazivPredmet(nazivPredmet);
				p.setSemestar(semestar);
				p.setGodinaIzvodjenjaPredmeta(godinaIzvodjenjaPredmeta);
				p.setPredmetniProfesor(predmetniProfesor);
				
			
				if(staraGodina != p.getGodinaIzvodjenjaPredmeta()) {						//ukoliko se promeni godina brisemo sve studente iz liste i brisemo predmet iz svih listi predmeta u studntima u kojima je bio
					p.setSpisakStudenata(new ArrayList<String>()); 
					for(int i = 0; i < BazaStudenata.getInstance().getStudenti().size(); i++) {
						if(staraGodina == BazaStudenata.getInstance().getStudenti().get(i).getTrenutnaGodinaStudija()) {
							for(int j = 0; j < BazaStudenata.getInstance().getStudenti().get(i).getSpisakPredmeta().size(); j++) {
								if(staraSifra.equals(BazaStudenata.getInstance().getStudenti().get(i).getSpisakPredmeta().get(j))) {
									BazaStudenata.getInstance().getStudenti().get(i).getSpisakPredmeta().remove(j);
								}
							}
						}
					}
					
																
				}else {
					//ako nismo izmenili godinu izvodjenja a izmenili smo sifru potrebno je promeniti sifru predmeta u spisku predmeta profesora i studenata koji predaju/slusaju taj predmet
					if(!staraSifra.equals(p.getSifraPredmeta())) {
						
						for(int i = 0; i < BazaStudenata.getInstance().getStudenti().size(); i++) {
							if(p.getGodinaIzvodjenjaPredmeta() == BazaStudenata.getInstance().getStudenti().get(i).getTrenutnaGodinaStudija()) {
								for(int j = 0; j < BazaStudenata.getInstance().getStudenti().get(i).getSpisakPredmeta().size(); j++) {
									if(staraSifra.equals(BazaStudenata.getInstance().getStudenti().get(i).getSpisakPredmeta().get(j))) {
										BazaStudenata.getInstance().getStudenti().get(i).getSpisakPredmeta().set(j, p.getSifraPredmeta());
										break;
									}
								}
							}
						}
						
						for(int i = 0; i < BazaProfesora.getInstance().getProfesori().size(); i++) {
							String[] niz = p.getPredmetniProfesor().split(",");
							String licna = niz[0];
							if(licna.equals(BazaProfesora.getInstance().getProfesori().get(i).getBrojLicneKarte())) {
								for(int j = 0; j < BazaProfesora.getInstance().getProfesori().get(i).getSpisakPredmeta().size(); j++) {
									if(staraSifra.equals(BazaProfesora.getInstance().getProfesori().get(i).getSpisakPredmeta().get(j))) {
										BazaProfesora.getInstance().getProfesori().get(i).getSpisakPredmeta().set(j, p.getSifraPredmeta());
										break;
									}
								}
							}
						}
					}
					
					
					p.setSpisakStudenata(listaStudenata);
				}
	}	
	public void dodajStudentaNapredmet(String indeks,int rowSelectedIndex) {
		  BazaPredmeta.getInstance().getPredmeti().get(rowSelectedIndex).dodajStudentaUlistu(indeks);
	}
	
	public void obrisiStudentaSaPredmeta(int index,int  rowSelectedIndex) {
			BazaPredmeta.getInstance().getPredmeti().get(rowSelectedIndex).obrisiStudentaIzListe(index);
	}

	public void dodajProfesoraNaPredmet(int rowSelectedIndexProfesora, int selektovanaVrsta) {
	
		String[] niz=BazaPredmeta.getInstance().getPredmeti().get(selektovanaVrsta).getPredmetniProfesor().split(",");
		String brojLicne=niz[0];
		int indeks = 0;
		for(int i = 0;i < BazaProfesora.getInstance().getProfesori().size();i++) {
			if(brojLicne.equals( BazaProfesora.getInstance().getProfesori().get(i).getBrojLicneKarte())) {
				indeks = i;
				break;
			}
		}
		
		for(int i = 0; i < BazaProfesora.getInstance().getProfesori().get(indeks).getSpisakPredmeta().size();i++) {
			if(BazaProfesora.getInstance().getProfesori().get(indeks).getSpisakPredmeta().get(i).equals(BazaPredmeta.getInstance().getPredmeti().get(selektovanaVrsta).getSifraPredmeta())) {
				BazaProfesora.getInstance().getProfesori().get(indeks).getSpisakPredmeta().remove(i);
				break;
			}
		}
		
		Profesor p=BazaProfesora.getInstance().getRow(rowSelectedIndexProfesora);
		BazaPredmeta.getInstance().getPredmeti().get(selektovanaVrsta).setPredmetniProfesor(p.getBrojLicneKarte()+","+p.getIme().concat(" ").concat(p.getPrezime()));
		
		MainFrame.getInstance().azurirajTabeluPredmeta();
	}

	public void izbrisiProfesora(Predmet p) {
		p.setPredmetniProfesor("NEMA PROFESORA");
		
	}
	
	
}
