package modeli;

import java.util.ArrayList;
import java.util.List;




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
	
	private BazaStudenata() {
		
	
		initStudente();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Indeks");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Godina upisa");
		this.kolone.add("Godina studija");	
		this.kolone.add("Status");
		this.kolone.add("Adresa");
		this.kolone.add("Datum rodjenja");
		
	}
	
	@SuppressWarnings("deprecation")
	private void initStudente() {
		
		this.studenti = new ArrayList<Student>();
		studenti.add(new Student("Nemanja","Jevtic",new java.sql.Date(98,9,11),"Mali Zvornik","RA131-2017",2017, 3, Status.B));
		studenti.add(new Student("Maja","Tomic",new java.sql.Date(98,9,13),"Novi Sad Vojvode Supljikca 19","RA155-2017",2017, 3, Status.B));
		studenti.add(new Student("Ignjat","Gacinovic",new java.sql.Date(98,4,14),"Kraljevo Petra Kocica 14a","RA133-2015",2015, 4, Status.S));
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
			return student.getStatus().toString();
		case 6:
			return student.getAdresa();
		case 7:
			return student.getDatumRodjenja().toString();
		default:
			return null;
		}
	}
	
	
}
