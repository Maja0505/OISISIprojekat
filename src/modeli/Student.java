package modeli;

import java.sql.Date;
import java.util.List;

enum Status {B,S};

public class Student {

	private String ime;
	private String prezime;
	private Date datumRodjenja;
	private String adresa;
	private String brojTelefona;
	private String email;
	private String brIndeksa;
	private int godinaUpisa;
	private int trenutnaGodinaStudija;
	private double prosecnaOcena;
	private List<String> spisakPredmeta;
	private Status status;
	


	public Student(String ime, String prezime, Date datumRodjenja, String adresa, String brojTelefona, String email,
			String brIndeksa, int godinaUpisa, int trenutnaGodinaStudija, double prosecnaOcena,
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

	
	
	public Student(String ime, String prezime, String brIndeksa, int godinaUpisa, int trenutnaGodinaStudija,
			Status status) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.brIndeksa = brIndeksa;
		this.godinaUpisa = godinaUpisa;
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
		this.status = status;
	}



	public Student(String ime, String prezime, Date datumRodjenja, String adresa, String brIndeksa, int godinaUpisa,
			int trenutnaGodinaStudija, Status status) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresa = adresa;
		this.brIndeksa = brIndeksa;
		this.godinaUpisa = godinaUpisa;
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
		this.status = status;
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

	public int getGodinaUpisa() {
		return godinaUpisa;
	}

	public void setGodinaUpisa(int godinaUpisa) {
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
	
	
	
	
	
}
