package modeli;

import java.util.ArrayList;
import java.util.List;

public class BazaProfesora {
	private static BazaProfesora instance = null;

	public static BazaProfesora getInstance() {
		if(instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}
	
	private List<Profesor> Profesori;
	private List<String> kolone;
	
	private BazaProfesora() {
		
	
		initProfesori();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Datum rodjenja");

	
		
		
		
	}
	
	@SuppressWarnings({ "deprecation" })
	private void initProfesori() {
		
		this.Profesori = new ArrayList<Profesor>();
		List<String> listaPredmeta = new ArrayList<String>();
		
		Profesori.add(new Profesor("Mila","Stojakovic",new java.sql.Date(60,9,9),"Novi Sad","	021/485-2304","	mila@uns.ac.rs","FTN,Kabinet 604","0909601234","DR.","Redovni profesor",listaPredmeta));
		Profesori.add(new Profesor("Ivan","Lukovic",new java.sql.Date(60,9,9),"Novi Sad","021/485-2445","	ivan@uns.ac.rs","Radnicka 9,JUG-216","0909601235","DR.","Redovni profesor",listaPredmeta));
		
	
}

	public List<Profesor> getProfesori() {
		return Profesori;
	}

	public void setProfesori(List<Profesor> Profesori) {
		this.Profesori = Profesori;
	}

	public List<String> getKolone() {
		return kolone;
	}

	public void setKolone(List<String> kolone) {
		this.kolone = kolone;
	}
	
	//broj koliko kolona ima
	public int getColumnCount() {
		return 3;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	
	public Profesor getRow(int rowIndex) {
		return this.Profesori.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Profesor Profesor = this.Profesori.get(row);
		switch (column) {
		case 0:
			return Profesor.getIme();
		case 1:
			return Profesor.getPrezime();
		case 2:
			return Profesor.getDatum_rodjenja().toString();	
		default:
			return null;
		}
	}
	
	public void popunjavanjeListePredmeta() {
		for(int j = 0;j<BazaProfesora.getInstance().getProfesori().size();j++) {	
			List<String> listaPredmeta = new ArrayList<String>();
			for(int i = 0;i<BazaPredmeta.getInstance().getPredmeti().size();i++) {
				if(BazaProfesora.getInstance().getValueAt(j, 0).concat(" ").concat(BazaProfesora.getInstance().getValueAt(j, 1)).equals(BazaPredmeta.getInstance().getPredmeti().get(i).getPredmetniProfesor())){
						listaPredmeta.add(BazaPredmeta.getInstance().getValueAt(i, 0).toString());
						
					}
			}
			
			BazaProfesora.getInstance().getProfesori().get(j).setSpisakPredmeta(listaPredmeta);
		}
	}
	

}
