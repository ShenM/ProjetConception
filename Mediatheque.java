
import java.util.HashMap;

public class Mediatheque {
	
	private HashMap<Integer,Document> documents;
	private HashMap<Integer,Abonné> abonnes;
	private HashMap<Integer,Emprunt> emprunts;
	
	private int nbMaxDocLocation;

	public Mediatheque(int nbMax){
		documents = new HashMap<Integer,Document>();
		abonnes = new HashMap<Integer,Abonné>();
		emprunts = new HashMap<Integer,Emprunt>();
		setNbMaxDoc(nbMax);
	}
	public HashMap<Integer, Emprunt> getEmprunts() {
		return emprunts;
	}
	public void setEmprunts(HashMap<Integer, Emprunt> emprunts) {
		this.emprunts = emprunts;
	}
	public int getNbMaxDoc() {
		return nbMaxDocLocation;
	}
	public void setNbMaxDoc(int nbMaxDoc) {
		this.nbMaxDocLocation = nbMaxDoc;
	}
	public void addDocument(Document doc) {
		documents.put(doc.getRéférence(),doc);
	}
	public HashMap<Integer,Document> getDocuments() {
		return documents;
	}
	public void setDocuments(HashMap<Integer,Document> documents) {
		this.documents = documents;
	}
	public HashMap<Integer,Abonné> getAbonnes() {
		return abonnes;
	}
	public void setAbonnes(HashMap<Integer,Abonné> abonnes) {
		this.abonnes = abonnes;
	}
	public void deleteDocument(Integer ref) {
		documents.remove(ref);
	}

	public void addAbonne(Abonné abo) {
		abonnes.put(abo.getNumAbonne(), abo);
		abo.setNumAbonne(getAbonnes().size()+1);
	}
	public void deleteAbonne(Integer numAbo) {
		abonnes.remove(numAbo);
	}
	public Abonné getAbo(int numAbo){
		return getAbonnes().get(numAbo);
	}
	
	public void emprunter(Document doc, Abonné abo ){
		Emprunt emprunt = new Emprunt(doc,abo);
		doc.setEmprunt(emprunt);
		abo.addEmprunt(emprunt);
	}
	
	public void retirerEmprunt(Document doc){
		doc.getEmprunt().getAbo().setEmprunts(null);
		doc.getEmprunt().setAbo(null);
		doc.setEmprunt(null);
	}
	

}