import java.util.*;

public class Abonné {

	private ArrayList<Emprunt> emprunts;
	private int numAbonne;
	private String nom;
	private String prenom;

	
	public Abonné(String nom, String prenom){
		emprunts = new ArrayList<Emprunt>(1);
		setNom(nom);
		setPrenom(prenom);
	}

	public ArrayList<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(ArrayList<Emprunt> docEmpruntes) {
		this.emprunts = docEmpruntes;
	}
	public void addEmprunt(Emprunt emprunt){
		emprunts.add(emprunt);
	}
	
	public void removeEmprunts(Emprunt emprunt){
		emprunts.remove(emprunt);
	}

	public int getNumAbonne() {
		return numAbonne;
	}

	public void setNumAbonne(int numAbonne) {
		this.numAbonne = numAbonne;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}