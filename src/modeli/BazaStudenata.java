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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.");
		switch (column) {
		case 0:
			return student.getBrIndeksa();
		case 1:
			return student.getIme();
		case 2:
			return student.getPrezime();
		case 3:
			return sdf.format(student.getGodinaUpisa());
		case 4:
			return Integer.toString(student.getTrenutnaGodinaStudija());
		case 5:
			return sdf.format(student.getDatumRodjenja());
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
		List<String> listaPredmeta = new ArrayList<String>();
		
		//this.popunjavanjeListePredmeta();
		//kod dodavanja novog studenta potrebno je SAMO tom studentu dodati sve predmete gde su njegova trenutna godina studija i godina izvodjenja predmeta jednake 
		int broj = -1;
		for(int j = 0;j<BazaStudenata.getInstance().getStudenti().size();j++) {	
			if(s.getBrIndeksa().equals(BazaStudenata.getInstance().getStudenti().get(j).getBrIndeksa())) {	
				for(int i = 0;i<BazaPredmeta.getInstance().getPredmeti().size();i++) {
					if(Integer.parseInt(BazaStudenata.getInstance().getValueAt(j, 4))==BazaPredmeta.getInstance().getPredmeti().get(i).getGodinaIzvodjenjaPredmeta()){
							listaPredmeta.add(BazaPredmeta.getInstance().getValueAt(i, 0).toString());
						}
				}
				broj = j;
				break;
			}
		}
		BazaStudenata.getInstance().getStudenti().get(broj).setSpisakPredmeta(listaPredmeta);
		
		//BazaPredmeta.getInstance().popunjavanjeListeStudenata();
		
		//U predmetima kod spiska studenta potrebno je dodati studenta kog unosimo , na sve predmete cija je godina izvodjenja jednaka sa njegovom trenutnom godinom studija
		for(int j = 0;j<BazaPredmeta.getInstance().getPredmeti().size();j++) {	
				if(Integer.parseInt(BazaStudenata.getInstance().getValueAt(broj, 4))==BazaPredmeta.getInstance().getPredmeti().get(j).getGodinaIzvodjenjaPredmeta()){
						BazaPredmeta.getInstance().getPredmeti().get(j).getSpisakStudenata().add(BazaStudenata.getInstance().getValueAt(broj, 0).toString() + "," + BazaStudenata.getInstance().getStudenti().get(broj).getIme() + " " + BazaStudenata.getInstance().getStudenti().get(broj).getPrezime());
				}
		}
			
			
	}

//metoda za brisanje iz baze	
	public void izbrisiStudenta(String brIndeksa) {	
		String brisanje =  null;
		for (Student s : studenti) {
			if (s.getBrIndeksa().equals(brIndeksa)) {
				brisanje = s.getBrIndeksa() + "," + s.getIme() + " " + s.getPrezime();
				studenti.remove(s);
				break;
			}
		}
		
		//BazaPredmeta.getInstance().popunjavanjeListeStudenata();
		//Kada obrisemo studenta potrebno je da ga obrisemo sa svih predmeta koje je on slusao
		for(int j = 0;j<BazaPredmeta.getInstance().getPredmeti().size();j++) {	
			for(int i = 0; i < BazaPredmeta.getInstance().getPredmeti().get(j).getSpisakStudenata().size();i++) {
					if(brisanje.equals(BazaPredmeta.getInstance().getPredmeti().get(j).getSpisakStudenata().get(i))){
							BazaPredmeta.getInstance().getPredmeti().get(j).getSpisakStudenata().remove(i);
							break;
						}
			}
	}
		
	}	
	
//motoda za izmenu studenta u bazi
	public void izmeniStudenta(String ime, String prezime, Date datumRodjenja, String adresa, String brojTelefona, String email,
			String brIndeksa, Date godinaUpisa, int trenutnaGodinaStudija, double prosecnaOcena,
			List<String> spisakPredmeta, Status status) {		
		
		int selektovanaVrsta = MainFrame.getInstance().getTabelaStudenata().getRowSorter().convertRowIndexToModel(StudentiJTable.selektovanaVrsta);
		Student s = BazaStudenata.getInstance().getRow(selektovanaVrsta);
		
		String stariIndeks = s.getBrIndeksa();
		String staroIme = s.getIme();
		String staroPrezime = s.getPrezime();
		int staraGodina = s.getTrenutnaGodinaStudija();
		
		String stariStudnent = stariIndeks + "," + staroIme + " " + staroPrezime;
		
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
		
		//this.popunjavanjeListePredmeta();
		
		//Ukoliko se godina studija promeni potrebno je zameniti stari spisak predmeta sa novim spiskom predmeta koji se izvode na godini koju smo izmenili
		if(staraGodina != s.getTrenutnaGodinaStudija()) {
			List<String> listaPredmeta = new ArrayList<String>();
			for(int i = 0; i < BazaPredmeta.getInstance().getPredmeti().size();i++) {
				if(s.getTrenutnaGodinaStudija() == BazaPredmeta.getInstance().getPredmeti().get(i).getGodinaIzvodjenjaPredmeta()) {
					listaPredmeta.add( BazaPredmeta.getInstance().getPredmeti().get(i).getSifraPredmeta());
				}
			}
			
			//Brisemo studenta iz svih predmeta sa stare godine studija
			for(int i = 0; i < BazaPredmeta.getInstance().getPredmeti().size();i++) {
				for(int j = 0; j < s.getSpisakPredmeta().size();j++) {
					if(s.getSpisakPredmeta().get(j).equals(BazaPredmeta.getInstance().getPredmeti().get(i).getSifraPredmeta())) {
						BazaPredmeta.getInstance().getPredmeti().get(i).getSpisakStudenata().remove(stariStudnent);
					}
				}		
			}
			
			//postavljamo novu listu predmeta
			s.setSpisakPredmeta(listaPredmeta);
			
			//Dodajemo studenta na predmete koji se izvode na promenjenoj godini studija
			for(int i = 0;i < s.getSpisakPredmeta().size();i++) {
				for(int j = 0; j < BazaPredmeta.getInstance().getPredmeti().size();j++) {
					if(s.getSpisakPredmeta().get(i).equals(BazaPredmeta.getInstance().getPredmeti().get(j).getSifraPredmeta())) {
						String noviStudent = s.getBrIndeksa() + "," + s.getIme() + " " + s.getPrezime();
						BazaPredmeta.getInstance().getPredmeti().get(j).getSpisakStudenata().add(noviStudent);
					}
				}
			}
		
		
		}
		
		else {
		
		
		
		//BazaPredmeta.getInstance().popunjavanjeListeStudenata();
		
		//Ukoliko godina ne promeni a promeni se  ime ili prezime ili indeks tada se menjaju stari podaci  koji se nalaze u spisku studenata u Predmetima sa novim  
		if(!stariIndeks.equals(s.getBrIndeksa()) || !staroIme.equals(s.getIme()) || !staroPrezime.equals(s.getPrezime())) {
			for(int i = 0; i < BazaPredmeta.getInstance().getPredmeti().size();i++) {
				if(s.getTrenutnaGodinaStudija() == BazaPredmeta.getInstance().getPredmeti().get(i).getGodinaIzvodjenjaPredmeta()) {
					for(int j = 0; j < BazaPredmeta.getInstance().getPredmeti().get(i).getSpisakStudenata().size();j++) {
						if(stariStudnent.equals(BazaPredmeta.getInstance().getPredmeti().get(i).getSpisakStudenata().get(j))) {
							String noviStudent = s.getBrIndeksa() + "," + s.getIme() + " " + s.getPrezime();
							BazaPredmeta.getInstance().getPredmeti().get(i).getSpisakStudenata().set(j, noviStudent);
							break;
							}
						}
					}
				}
			}
		}
		
}
	
	public void dodajPredmetStudentu(String sifra,int rowSelectedIndex) {
		  BazaStudenata.getInstance().getStudenti().get(rowSelectedIndex).dodajPredmetStudentu(sifra);
	}
	
	public void obrisiPredmetStudentu(int index,int rowSelectedIndex) {
		  BazaStudenata.getInstance().getStudenti().get(rowSelectedIndex).obrisiPredmetStudentu(index);
	}
	
}
