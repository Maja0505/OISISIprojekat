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
	    this.file = new File("testprimeri/studenti.txt");
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
		 file = new File("testprimeri/studenti.txt");
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
	
	


//metoda da dodavanje studenta u Bazu	
	public void dodajStudenta(Student s) {
		this.studenti.add(s);
	}

//metoda za brisanje iz baze	
	public void izbrisiStudenta(String brIndeksa) {	
		String brisanje =  null;
		for (Student s : studenti) {
			if (s.getBrIndeksa().equals(brIndeksa)) {
				brisanje = s.getBrIndeksa() + "," + s.getIme() + " " + s.getPrezime(); //pamtimo koji se student brise da bi ga izbrisali sa svih predmeta
				studenti.remove(s);
				break;
			}
		}
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
		
//Ukoliko se promeni godina studija postaviti spisak predmeta inicijalno na praznu listu		
		if(staraGodina != s.getTrenutnaGodinaStudija()) {
			s.setSpisakPredmeta(new ArrayList<String>()); //dodajemo praznu listu
//Potrebno je izbrisati studenta sa svih predmeta koje je on slusao ako je promenio godinu			
			for(int i = 0; i < BazaPredmeta.getInstance().getPredmeti().size();i++) {
					for(int j = 0; j < BazaPredmeta.getInstance().getPredmeti().get(i).getSpisakStudenata().size();j++) {
						if(stariStudnent.equals(BazaPredmeta.getInstance().getPredmeti().get(i).getSpisakStudenata().get(j))) {
							BazaPredmeta.getInstance().getPredmeti().get(i).getSpisakStudenata().remove(j);
					}
				}
				
			}
		}else {
//Ukoliko se promeni ime ili prezime ili indeks potrebno je te podatke promeniti i u Predmetima u spisku studenata			
			if(!stariIndeks.equals(s.getBrIndeksa()) || !staroIme.equals(s.getIme()) || !staroPrezime.equals(s.getPrezime())) {
				for(int i = 0; i < BazaPredmeta.getInstance().getPredmeti().size();i++) {
						for(int j = 0; j < BazaPredmeta.getInstance().getPredmeti().get(i).getSpisakStudenata().size();j++) {
							if(stariStudnent.equals(BazaPredmeta.getInstance().getPredmeti().get(i).getSpisakStudenata().get(j))) {
								String noviStudent = s.getBrIndeksa() + "," + s.getIme() + " " + s.getPrezime();
								BazaPredmeta.getInstance().getPredmeti().get(i).getSpisakStudenata().set(j, noviStudent);
								break;
								}
						}
					}
				}
//Ako godina ostaje nepromenjena postaviti listu na onu staru			
				s.setSpisakPredmeta(spisakPredmeta);
		}

		
}
	
	public void dodajPredmetStudentu(String sifra,int rowSelectedIndex) {
		  BazaStudenata.getInstance().getStudenti().get(rowSelectedIndex).dodajPredmetStudentu(sifra);
	}
	
	public void obrisiPredmetStudentu(int index,int rowSelectedIndex) {
		  BazaStudenata.getInstance().getStudenti().get(rowSelectedIndex).obrisiPredmetStudentu(index);
	}
	
}
