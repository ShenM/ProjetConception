import java.util.ArrayList;
import java.util.Date;

public abstract class Document {

	private Emprunt emprunt;
	private String titre;
	private ArrayList<String> auteur;
	private Date dateParution;
	private int référence;
	
	
	
	
	public Document(String titre, ArrayList<String> auteur,
			Date dateParution) {
		this.titre = titre;
		this.auteur = auteur;
		this.dateParution = dateParution;

	}
	
	public abstract int getDureeEmprunt();
	
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Emprunt getEmprunt() {
		return emprunt;
	}

	public void setEmprunt(Emprunt emprunt) {
		this.emprunt = emprunt;
	}

	public ArrayList<String> getAuteur() {
		return auteur;
	}
	public void setAuteur(ArrayList<String> auteur) {
		this.auteur = auteur;
	}
	public Date getDateParution() {
		return dateParution;
	}
	public void setDateParution(Date dateParution) {
		this.dateParution = dateParution;
	}
	public int getRéférence() {
		return référence;
	}
	public void setRéférence(int référence) {
		this.référence = référence;
	}
	
	
	

}