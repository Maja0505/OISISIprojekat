package modeli;

import java.util.Date;
import java.util.List;

public class Profesor {
	private String ime;
	private String prezime;
	private Date datum_rodjenja;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String email;
	private String adresaKancelarije;
	private String brojLicneKarte;
	private String titula;
	private String zvanje;
	private List<String> spisakPredmeta;
	public Profesor(String ime, String prezime, Date datum_rodjenja, String adresaStanivanja, String kontaktTelefon,
			String email, String adresaKancelarije, String brojLicneKarte, String titula, String zvanje,
			List<String> spisakPredmeta) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datum_rodjenja = datum_rodjenja;
		this.adresaStanovanja = adresaStanivanja;
		this.kontaktTelefon = kontaktTelefon;
		this.email = email;
		this.adresaKancelarije = adresaKancelarije;
		this.brojLicneKarte = brojLicneKarte;
		this.titula = titula;
		this.zvanje = zvanje;
		this.spisakPredmeta = spisakPredmeta;
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
	public Date getDatum_rodjenja() {
		return datum_rodjenja;
	}
	public void setDatum_rodjenja(Date datum_rodjenja) {
		this.datum_rodjenja = datum_rodjenja;
	}
	public String getAdresaStanivanja() {
		return adresaStanovanja;
	}
	public void setAdresaStanivanja(String adresaStanivanja) {
		this.adresaStanovanja = adresaStanivanja;
	}
	public String getKontaktTelefon() {
		return kontaktTelefon;
	}
	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresaKancelarije() {
		return adresaKancelarije;
	}
	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}
	public String getBrojLicneKarte() {
		return brojLicneKarte;
	}
	public void setBrojLicneKarte(String brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
	}
	public String getTitula() {
		return titula;
	}
	public void setTitula(String titula) {
		this.titula = titula;
	}
	public String getZvanje() {
		return zvanje;
	}
	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}
	public List<String> getSpisakPredmeta() {
		return spisakPredmeta;
	}
	public void setSpisakPredmeta(List<String> spisakPredmeta) {
		this.spisakPredmeta = spisakPredmeta;
	}
	

	
	
}
