package modeli;

import java.util.ArrayList;
import java.util.List;

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
	
	private BazaPredmeta() {
		
	
		initPredmeti();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Sifra");
		this.kolone.add("Naziv");
		this.kolone.add("Semestar");
		this.kolone.add("Godina izvodjenja");
		this.kolone.add("Predmetni profesor");	
		
		
		
	}
	
	private void initPredmeti() {
		
		this.predmeti = new ArrayList<Predmet>();
		List<String> listaStudenata = new ArrayList<String>();
		
		
		predmeti.add(new Predmet("MA2-E2","Matematicka analiza 2",3,2,"Mila Stojakovic",listaStudenata));
		predmeti.add(new Predmet("BP2-E2","Baze podataka 2",7,4,"Ivan Lukovic",listaStudenata));
		
	
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
		Predmet Predmet = this.predmeti.get(row);
		switch (column) {
		case 0:
			return Predmet.getSifraPredmeta();
		case 1:
			return Predmet.getNazivPredmet();
		case 2:
			return Integer.toString(Predmet.getSemestar());
		case 3:
			return Integer.toString(Predmet.getGodinaIzvodjenjaPredmeta());
		case 4:
			return Predmet.getPredmetniProfesor();
		default:
			return null;
		}
	}
	
	public void popunjavanjeListeStudenata() {
		for(int j = 0;j<BazaPredmeta.getInstance().getPredmeti().size();j++) {	
			List<String> listaStudenata = new ArrayList<String>();
			for(int i = 0;i<BazaStudenata.getInstance().getStudenti().size();i++) {
				if(Integer.parseInt(BazaStudenata.getInstance().getValueAt(i, 4))==BazaPredmeta.getInstance().getPredmeti().get(j).getGodinaIzvodjenjaPredmeta()){
						listaStudenata.add(BazaStudenata.getInstance().getValueAt(i, 0).toString());
						
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
		BazaProfesora.getInstance().popunjavanjeListePredmeta();
		
		
	}
	
	public void izmeniPredmet(String sifra, String nazivPredmet, int semestar, int godinaIzvodjenjaPredmeta, String predmetniProfesor) {		//menja u bazi
				Predmet p=BazaPredmeta.getInstance().getRow(PredmetiJTable.selektovanaVrsta);
	
				p.setSifraPredmeta(sifra);
				p.setNazivPredmet(nazivPredmet);
				p.setSemestar(semestar);
				p.setGodinaIzvodjenjaPredmeta(godinaIzvodjenjaPredmeta);
				p.setPredmetniProfesor(predmetniProfesor);
				p.setSpisakStudenata(null);
			
			
		
	}
	
	public void dodajStudentaNapredmet(String indeks,int rowSelectedIndex) {
		  BazaPredmeta.getInstance().getPredmeti().get(rowSelectedIndex).dodajStudentaUlistu(indeks);
	}
	
	public void obrisiStudentaSaPredmeta(int index,int  rowSelectedIndex) {
			BazaPredmeta.getInstance().getPredmeti().get(rowSelectedIndex).obrisiStudentaIzListe(index);
	}
	
	
}
