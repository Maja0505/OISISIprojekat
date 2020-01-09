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
	
	public void popunjavanjeListeStudenata() {
		for(int j = 0;j<BazaPredmeta.getInstance().getPredmeti().size();j++) {	
			List<String> listaStudenata = new ArrayList<String>();
			for(int i = 0;i<BazaStudenata.getInstance().getStudenti().size();i++) {
				if(Integer.parseInt(BazaStudenata.getInstance().getValueAt(i, 4))==BazaPredmeta.getInstance().getPredmeti().get(j).getGodinaIzvodjenjaPredmeta()){
						listaStudenata.add(BazaStudenata.getInstance().getValueAt(i, 0).toString() + "," + BazaStudenata.getInstance().getStudenti().get(i).getIme() + " " + BazaStudenata.getInstance().getStudenti().get(i).getPrezime());
						
					}
			}
			BazaPredmeta.getInstance().getPredmeti().get(j).setSpisakStudenata(listaStudenata);
		}		
	}

	public void izbrisiPredmet(String id) {				//brise iz baze
		for (Predmet p : predmeti) {
			if (p.getSifraPredmeta().equals(id)) {
				predmeti.remove(p);
				
				break;
			}
		}
	}
	
	public void dodajPredmet(Predmet p) {				//dodaje u bazu
		this.predmeti.add(p);
		this.popunjavanjeListeStudenata();
		BazaProfesora.getInstance().popunjavanjeListePredmeta();
		BazaStudenata.getInstance().popunjavanjeListePredmeta();
		
		
	}
	
	public void izmeniPredmet(String sifra, String nazivPredmet, int semestar, int godinaIzvodjenjaPredmeta, String predmetniProfesor,List<String> listaStudenata) {		//menja u bazi
				Predmet p=BazaPredmeta.getInstance().getRow(PredmetiJTable.selektovanaVrsta);
	
				p.setSifraPredmeta(sifra);
				p.setNazivPredmet(nazivPredmet);
				p.setSemestar(semestar);
				p.setGodinaIzvodjenjaPredmeta(godinaIzvodjenjaPredmeta);
				p.setPredmetniProfesor(predmetniProfesor);
				p.setSpisakStudenata(listaStudenata);
			
			
		
	}
	
	public void dodajStudentaNapredmet(String indeks,int rowSelectedIndex) {
		  BazaPredmeta.getInstance().getPredmeti().get(rowSelectedIndex).dodajStudentaUlistu(indeks);
	}
	
	public void obrisiStudentaSaPredmeta(int index,int  rowSelectedIndex) {
			BazaPredmeta.getInstance().getPredmeti().get(rowSelectedIndex).obrisiStudentaIzListe(index);
	}

	public void dodajProfesoraNaPredmet(int rowSelectedIndexProfesora, int selektovanaVrsta) {
	/*	for(int i=0;i<BazaProfesora.getInstance().getProfesori().size();i++) {		//brise predmet sa profesora koga smo zamenili
			if(BazaPredmeta.getInstance().getPredmeti().get(selektovanaVrsta).getPredmetniProfesor().equals(BazaProfesora.getInstance().getProfesori().get(i).getIme().concat(" ").concat(BazaProfesora.getInstance().getProfesori().get(i).getPrezime()))) {
				for(int j=0;j<BazaProfesora.getInstance().getProfesori().get(i).getSpisakPredmeta().size();j++) {
					if(BazaProfesora.getInstance().getProfesori().get(i).getSpisakPredmeta().get(j).equals(BazaPredmeta.getInstance().getPredmeti().get(selektovanaVrsta).getSifraPredmeta())) {
						BazaProfesora.getInstance().getProfesori().get(i).getSpisakPredmeta().remove(j);
					}
				}
			}
		}
		*/
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
		p.setPredmetniProfesor("");
		
	}
	
	
}
