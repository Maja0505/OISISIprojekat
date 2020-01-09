package modeli;

import java.io.Serializable;
import java.util.List;

public class Predmet implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sifraPredmeta;
	private String nazivPredmet;
	private int semestar;
	private int godinaIzvodjenjaPredmeta;
	private String predmetniProfesor;
	private List<String> spisakStudenata;
	public Predmet(String sifraPredmeta, String nazivPredmet, int semestar, int godinaIzvodjenjaPredmeta,
			String predmetniProfesor, List<String> spisakStudenata) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmet = nazivPredmet;
		this.semestar = semestar;
		this.godinaIzvodjenjaPredmeta = godinaIzvodjenjaPredmeta;
		this.predmetniProfesor = predmetniProfesor;
		this.spisakStudenata = spisakStudenata;
	}
	


	public String getSifraPredmeta() {
		return sifraPredmeta;
	}
	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}
	public String getNazivPredmet() {
		return nazivPredmet;
	}
	public void setNazivPredmet(String nazivPredmet) {
		this.nazivPredmet = nazivPredmet;
	}
	public int getSemestar() {
		return semestar;
	}
	public void setSemestar(int semestar) {
		this.semestar = semestar;
	}
	public int getGodinaIzvodjenjaPredmeta() {
		return godinaIzvodjenjaPredmeta;
	}
	public void setGodinaIzvodjenjaPredmeta(int godinaIzvodjenjaPredmeta) {
		this.godinaIzvodjenjaPredmeta = godinaIzvodjenjaPredmeta;
	}
	public String getPredmetniProfesor() {
		return predmetniProfesor;
	}
	public void setPredmetniProfesor(String predmetniProfesor) {
		this.predmetniProfesor = predmetniProfesor;
	}
	public List<String> getSpisakStudenata() {
		return spisakStudenata;
	}
	public void setSpisakStudenata(List<String> spisakStudenata) {
		this.spisakStudenata = spisakStudenata;
	}
	
	public void dodajStudentaUlistu(String indeks) {
		this.spisakStudenata.add(indeks);
	}
	
	public void obrisiStudentaIzListe(int index) {
		this.spisakStudenata.remove(index);
	}
	
}
