
import java.util.HashMap;

public class Mediatheque {
	
	private HashMap<Integer,Document> documents;
	private HashMap<Integer,Abonné> abonnes;

	
	private int nbMaxDocLocation;

	public Mediatheque(int nbMax){
		documents = new HashMap<Integer,Document>();
		abonnes = new HashMap<Integer,Abonné>();

		setNbMaxDoc(nbMax);
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
	}
	public void deleteAbonne(Integer numAbo) {
		abonnes.remove(numAbo);
	}
	

}