import java.util.ArrayList;
import java.util.Date;

public class Controleur {
	

	private Mediatheque mediatheque;
	
	public Controleur(Mediatheque mediatheque){
		this.mediatheque=mediatheque;
	}
	public void ajouterDocument(String titre, ArrayList<String> auteurs, Date dateParution) {
		
	}

	public void supprimerDocument(int ref) {
		// TODO - implement Controleur.supprimerDocument
		throw new UnsupportedOperationException();
	}


	public void emprunterDocument(int ref, int numAbonne) {
		Document doc = mediatheque.getDocuments().get(ref);
		Abonné abo = mediatheque.getAbonnes().get(numAbonne);
		if (doc==null){
			System.out.println("Ce document n'est pas référencié.");
		} else if (abo==null){
			System.out.println("Cet abonné n'existe pas.");
		} else {
			if(doc.getEmprunt()!=null){
				System.out.println("Ce document est déjà emrpunté");
			} else if(abo.getEmprunts().size()>=mediatheque.getNbMaxDoc()) {
				System.out.println("Vous avez déjà trop de documents empruntés");
			} else {
				Emprunt emprunt = new Emprunt(mediatheque.getEmprunts().size()+1,doc,abo);
				doc.setEmprunt(emprunt);
				abo.addEmprunt(emprunt);
			}
		}	
	}

	public void consulterDocument(int ref) {

	}
	
	public void libererDocument(int ref) {
		Document doc = mediatheque.getDocuments().get(ref);
		if (doc==null){
			System.out.println("Ce document n'est pas référencié.");
		} else {
			
				doc.getEmprunt().setAbo(null);
				doc.setEmprunt(null);
				
				///////////////////////////////////////////////////////////
				/////////////////////// A FINIR ///////////////////////////
				///////////////////////////////////////////////////////////
				
			
		}	
	}
/*	
	public Document findDoc(int ref){
		boolean trouve = false;
		int i = 0;
		while (!trouve){
			if(mediatheque.getDocuments().get(i).getRéférence()==ref){
				trouve=true;
			}
			i++;
		}
		if (trouve){
			return mediatheque.getDocuments().get(i-1);
		} else {
			return null;
		}
	}
	
	public Abonné findAbo(int numAbo){
		boolean trouve = false;
		int i = 0;
		while (!trouve){
			if(mediatheque.getAbonnes().get(i).getNumAbonne()==numAbo){
				trouve=true;
			}
			i++;
		}
		if (trouve){
			return mediatheque.getAbonnes().get(i-1);
		} else {
			return null;
		}
	}
*/
	public void inscrireAbonnee(String nom, String prenom) {
		
	}
	public Mediatheque getMediatheque() {
		return mediatheque;
	}
	public void setMediatheque(Mediatheque mediatheque) {
		this.mediatheque = mediatheque;
	}
	

}