package modeli;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;



public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public	enum Status {B,S};
	
	private String ime;
	private String prezime;
	private Date datumRodjenja;
	private String adresa;
	private String brojTelefona;
	private String email;
	private String brIndeksa;
	private Date godinaUpisa;
	private int trenutnaGodinaStudija;
	private double prosecnaOcena;
	private List<String> spisakPredmeta;
	private Status status;
	

	public Student() {
		super();
	}
	
	public Student(String ime, String prezime, Date datumRodjenja, String adresa, String brojTelefona, String email,
			String brIndeksa, Date godinaUpisa, int trenutnaGodinaStudija, double prosecnaOcena,
			List<String> spisakPredmeta, Status status) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
		this.email = email;
		this.brIndeksa = brIndeksa;
		this.godinaUpisa = godinaUpisa;
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
		this.prosecnaOcena = prosecnaOcena;
		this.spisakPredmeta = spisakPredmeta;
		this.setStatus(status);
	}

	


	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBrIndeksa() {
		return brIndeksa;
	}

	public void setBrIndeksa(String brIndeksa) {
		this.brIndeksa = brIndeksa;
	}

	public Date getGodinaUpisa() {
		return godinaUpisa;
	}

	public void setGodinaUpisa(Date godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}

	public int getTrenutnaGodinaStudija() {
		return trenutnaGodinaStudija;
	}

	public void setTrenutnaGodinaStudija(int trenutnaGodinaStudija) {
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
	}

	public double getProsecnaOcena() {
		return prosecnaOcena;
	}

	public void setProsecnaOcena(double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}

	public List<String> getSpisakPredmeta() {
		return spisakPredmeta;
	}

	public void setSpisakPredmeta(List<String> spisakPredmeta) {
		this.spisakPredmeta = spisakPredmeta;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	};
	
	public void dodajPredmetStudentu(String sifra) {
		this.spisakPredmeta.add(sifra);
	}
	
	public void obrisiPredmetStudentu(int index) {
		this.spisakPredmeta.remove(index);
	}
	
	
}
