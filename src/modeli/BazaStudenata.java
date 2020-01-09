package modeli;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import modeli.Student.Status;
import tabele.StudentiJTable;




public class BazaStudenata {

	private static BazaStudenata instance = null;

	public static BazaStudenata getInstance() {
		if(instance == null) {
			instance = new BazaStudenata();
		}
		return instance;
	}
	
	private List<Student> studenti;
	private List<String> kolone;
	private File file;
	
	private BazaStudenata() {
		
		this.studenti = new ArrayList<Student>();
	    this.file = new File("studenti.txt");
	    if(file.length() != 0)
	    	initStudente(); 

		this.kolone = new ArrayList<String>();
		this.kolone.add("Indeks");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Godina upisa");
		this.kolone.add("Godina studija");	
		this.kolone.add("Datum rodjenja");
		this.kolone.add("Prosecna ocena");
		this.kolone.add("Status");
		
	}
	
	@SuppressWarnings("unchecked")
	private void initStudente() {
			
		ArrayList<?> listaStudenti = null;
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			listaStudenti = (ArrayList<Object>) ois.readObject();
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if(studenti != null) {
			for(Object s : listaStudenti)
				this.studenti.add((Student) s);
		}
		
	}
	
	public void saveStudente() {
		 file = new File("studenti.txt");
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(studenti);
			oos.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

	public List<String> getKolone() {
		return kolone;
	}

	public void setKolone(List<String> kolone) {
		this.kolone = kolone;
	}
	
	//broj koliko kolona ima
	public int getColumnCount() {
		return 8;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	
	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Student student = this.studenti.get(row);
		switch (column) {
		case 0:
			return student.getBrIndeksa();
		case 1:
			return student.getIme();
		case 2:
			return student.getPrezime();
		case 3:
			return Integer.toString(student.getGodinaUpisa());
		case 4:
			return Integer.toString(student.getTrenutnaGodinaStudija());
		case 5:
			return student.getDatumRodjenja().toString();
		case 6:
			return Double.toString(student.getProsecnaOcena());
		case 7:
			return student.getStatus().toString();	
		default:
			return null;
		}
	}
	
	
	public void popunjavanjeListePredmeta() {
		for(int j = 0;j<BazaStudenata.getInstance().getStudenti().size();j++) {	
			List<String> listaPredmeta = new ArrayList<String>();
			for(int i = 0;i<BazaPredmeta.getInstance().getPredmeti().size();i++) {
				if(Integer.parseInt(BazaStudenata.getInstance().getValueAt(j, 4))==BazaPredmeta.getInstance().getPredmeti().get(i).getGodinaIzvodjenjaPredmeta()){
						listaPredmeta.add(BazaPredmeta.getInstance().getValueAt(i, 0).toString());
						
						
					}
			}
			BazaStudenata.getInstance().getStudenti().get(j).setSpisakPredmeta(listaPredmeta);
		}
	}

//metoda da dodavanje studenta u Bazu	
	public void dodajStudenta(Student s) {
		this.studenti.add(s);
		this.popunjavanjeListePredmeta();
		BazaPredmeta.getInstance().popunjavanjeListeStudenata();
	}

//metoda za brisanje iz baze	
	public void izbrisiStudenta(String brIndeksa) {				
		for (Student s : studenti) {
			if (s.getBrIndeksa().equals(brIndeksa)) {
				studenti.remove(s);
				break;
			}
		}
	}	
	
//motoda za izmenu studenta u bazi
	public void izmeniStudenta(String ime, String prezime, Date datumRodjenja, String adresa, String brojTelefona, String email,
			String brIndeksa, int godinaUpisa, int trenutnaGodinaStudija, double prosecnaOcena,
			List<String> spisakPredmeta, Status status) {		
		
		Student s = BazaStudenata.getInstance().getRow(StudentiJTable.selektovanaVrsta);

		s.setIme(ime);
		s.setPrezime(prezime);
		s.setAdresa(adresa);
		s.setBrojTelefona(brojTelefona);
		s.setBrIndeksa(brIndeksa);
		s.setDatumRodjenja(datumRodjenja);
		s.setEmail(email);
		s.setGodinaUpisa(godinaUpisa);
		s.setTrenutnaGodinaStudija(trenutnaGodinaStudija);
		s.setStatus(status);
		s.setProsecnaOcena(prosecnaOcena);
		s.setSpisakPredmeta(spisakPredmeta);
		
}
	
	public void dodajPredmetStudentu(String sifra,int rowSelectedIndex) {
		  BazaStudenata.getInstance().getStudenti().get(rowSelectedIndex).dodajPredmetStudentu(sifra);
	}
	
	public void obrisiPredmetStudentu(int index,int rowSelectedIndex) {
		  BazaStudenata.getInstance().getStudenti().get(rowSelectedIndex).obrisiPredmetStudentu(index);
	}
	
}
