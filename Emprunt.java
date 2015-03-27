import java.util.Date;


public class Emprunt {
	private int numEmprunt;
	private Date dateEmprunt;
	private Document doc;
	private Abonné abo;
	

	public Emprunt(int numEmprunt, Document doc, Abonné abo) {
		this.numEmprunt = numEmprunt;
		this.abo=abo;
		this.doc = doc;
		Date actuelle = new Date();
		dateEmprunt = actuelle;
	}

	public int getNumEmprunt() {
		return numEmprunt;
	}

	public void setNumEmprunt(int numEmprunt) {
		this.numEmprunt = numEmprunt;
	}

	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public Document getDoc() {
		return doc;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
	}

	public Abonné getAbo() {
		return abo;
	}

	public void setAbo(Abonné abo) {
		this.abo = abo;
	}

	
	
	
}
