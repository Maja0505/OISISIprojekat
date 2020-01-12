package modeli;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import gui.MainFrame;
import tabele.ProfesoriJTable;

public class BazaProfesora {
	private static BazaProfesora instance = null;

	public static BazaProfesora getInstance() {
		if (instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}

	private List<Profesor> profesori;
	private List<String> kolone;
	private File file;

	private BazaProfesora() {
		this.profesori = new ArrayList<Profesor>();
		this.file = new File("testprimeri/profesori.txt");
		if (file.length() != 0)
			initProfesori();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Datum rodjenja");

	}

	@SuppressWarnings({ "unchecked" })
	private void initProfesori() {

		ArrayList<?> listaProfesora = null;

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			listaProfesora = (ArrayList<Object>) ois.readObject();
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		if (profesori != null) {
			for (Object p : listaProfesora)
				this.profesori.add((Profesor) p);
		}

	}

	public void saveProfesore() {
		file = new File("testprimeri/profesori.txt");
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(profesori);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(List<Profesor> profesori) {
		this.profesori = profesori;
	}

	public List<String> getKolone() {
		return kolone;
	}

	public void setKolone(List<String> kolone) {
		this.kolone = kolone;
	}

	// broj koliko kolona ima
	public int getColumnCount() {
		return 3;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Profesor profesor = this.profesori.get(row);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.");
		switch (column) {
		case 0:
			return profesor.getIme();
		case 1:
			return profesor.getPrezime();
		case 2:
			return sdf.format(profesor.getDatum_rodjenja());
		default:
			return null;
		}
	}


	public void izbrisiProfesora(String id) { // brise iz baze
		for (Profesor p : profesori) {
			if (p.getBrojLicneKarte().equals(id)) {
				String profesor = p.getBrojLicneKarte() + "," + p.getIme() + " " + p.getPrezime();
				for(int i = 0; i < BazaPredmeta.getInstance().getPredmeti().size(); i++) {
					if(profesor.equals(BazaPredmeta.getInstance().getPredmeti().get(i).getPredmetniProfesor())) {
						BazaPredmeta.getInstance().getPredmeti().get(i).setPredmetniProfesor("NEMA PROFESORA");
					}
				}
				profesori.remove(p);

				break;
			}
		}
	}

//metoda da dodavanje profesora u bazu	
	public void dodajProfesora(Profesor p) {
		this.profesori.add(p);
	}

//metoda za imenu profesora u bazi		
	public void izmeniProfesora(String ime, String prezime, Date datum_rodjenja, String adresaStanivanja,
			String kontaktTelefon, String email, String adresaKancelarije, String brojLicneKarte, String titula,
			String zvanje, List<String> spisakPredmeta) {

		int selektovanaVrsta = MainFrame.getInstance().getTabelaProfesora().getRowSorter().convertRowIndexToModel(ProfesoriJTable.selektovanaVrsta);
		Profesor p = BazaProfesora.getInstance().getRow(selektovanaVrsta);
		String staraLicna = p.getBrojLicneKarte();
		String staroIme = p.getIme();
		String staroPrezime = p.getPrezime();

		p.setIme(ime);
		p.setPrezime(prezime);
		p.setDatum_rodjenja(datum_rodjenja);
		p.setAdresaStanivanja(adresaStanivanja);
		p.setKontaktTelefon(kontaktTelefon);
		p.setEmail(email);
		p.setAdresaKancelarije(adresaKancelarije);
		p.setBrojLicneKarte(brojLicneKarte);
		p.setTitula(titula);
		p.setZvanje(zvanje);
		p.setSpisakPredmeta(spisakPredmeta);

//Ukoliko se promeni licna karta ili ime ili prezime profesora potrebno je i kod Predmeta u polju predmetniProfesor zameniti stare podatke sa novim		
	if (!staraLicna.equals(p.getBrojLicneKarte()) || !staroIme.equals(p.getIme()) || !staroPrezime.equals(p.getPrezime())) {
		for (int i = 0; i < BazaPredmeta.getInstance().getPredmeti().size(); i++) {
					if( BazaPredmeta.getInstance().getPredmeti().get(i).getPredmetniProfesor().contains(",")) {
						String[] temp = BazaPredmeta.getInstance().getPredmeti().get(i).getPredmetniProfesor().split(",");
						String lk = temp[0];
						if (staraLicna.equals(lk)) {
							BazaPredmeta.getInstance().getPredmeti().get(i).setPredmetniProfesor(p.getBrojLicneKarte() + "," + p.getIme() + " " + p.getPrezime());
						}
					}
				}
			}
	}

	public void dodajPredmetProfesoru(String sifraPredmeta, int rowSelectedIndex) {
		boolean postoji = false;
		for (int i = 0; i < this.profesori.get(rowSelectedIndex).getSpisakPredmeta().size(); i++) {
			if (this.profesori.get(rowSelectedIndex).getSpisakPredmeta().get(i).equals(sifraPredmeta)) {
				postoji = true;
			}

		}
		if (postoji == false) {
			this.profesori.get(rowSelectedIndex).getSpisakPredmeta().add(sifraPredmeta);
		}
	}

	public void izbrisiPredmet(int predmetKojiSeBrise, int row) {

		this.profesori.get(row).getSpisakPredmeta().remove(predmetKojiSeBrise);

	}

}
