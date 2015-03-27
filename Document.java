import java.util.GregorianCalendar;

public abstract class Document {

	private Emprunt emprunt;
	private String titre;
	private String auteur;
	private GregorianCalendar dateParution;
	private int référence;
	
	
	
	
	public Document(String titre, String auteur, GregorianCalendar dateParution) {
		this.titre = titre;
		this.auteur = auteur;
		this.dateParution = dateParution;

	}
	

	
	
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

	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public GregorianCalendar getDateParution() {
		return dateParution;
	}
	public void setDateParution(GregorianCalendar dateParution) {
		this.dateParution = dateParution;
	}
	public int getRéférence() {
		return référence;
	}
	public void setRéférence(int référence) {
		this.référence = référence;
	}
	
	
	

}