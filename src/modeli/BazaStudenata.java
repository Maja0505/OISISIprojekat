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
		
	}
	
	@SuppressWarnings("deprecation")
	private void initStudente() {
		
		this.studenti = new ArrayList<Student>();
		List<String> listaPredmeta = new ArrayList<String>();
		
		studenti.add(new Student("Nemanja", "Jevtic", new java.sql.Date(98,9,13), "Mali Zvornik", "+381645656946", "njevtic998@gmail.com", "RA131-2017", 2017, 3, 8.96, listaPredmeta, Status.B));
		studenti.add(new Student("Maja","Tomic",new java.sql.Date(98,9,13),"Novi Sad Vojvode Supljikca 19","+38164555511","majatomic0212@gmail.com","RA155-2017",2017, 3,9.5,listaPredmeta, Status.B));
		studenti.add(new Student("Ignjat","Gacinovic",new java.sql.Date(98,4,14),"Kraljevo Petra Kocica 14a","+38164522511","ignjaBatica022@gmail.com","RA155-2017",2015, 4,7.89,listaPredmeta,Status.S));
	
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
		return 6;
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
	
	
}
