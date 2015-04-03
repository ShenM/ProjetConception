

import java.util.GregorianCalendar;

import javax.swing.JFrame;

public class Controleur {
	

	private Mediatheque mediatheque;
	private JFrame currentView;
	
	public Controleur(Mediatheque mediatheque){
		this.mediatheque=mediatheque;
        currentView = new Emprunter(this);
	}
	public void ajouterFilm(String titre, String auteur, GregorianCalendar dateParution, GenreFilm genre  ) {
		int ref =100000+getMediatheque().getDocuments().size()+1;
		Films film = new Films(titre,auteur,dateParution,genre);
		film.setRéférence(ref);
		getMediatheque().addDocument(film);
		
	}
	public void ajouterMusique(String titre, String auteur, GregorianCalendar dateParution, GenreMusical genre  ) {
		int ref =200000+getMediatheque().getDocuments().size()+1;
		Musique musique = new Musique(titre,auteur,dateParution,genre);
		musique.setRéférence(ref);
		getMediatheque().addDocument(musique);
		
	}
	public void ajouterLivre(String titre, String auteur, GregorianCalendar dateParution, GenreLitteraire genre, int numISBN  ) {
		int ref =300000+getMediatheque().getDocuments().size()+1;
		Livre livre = new Livre(titre,auteur,dateParution,numISBN,genre);
		livre.setRéférence(ref);
		getMediatheque().addDocument(livre);
		
	}
	public void ajouterLogiciel(String titre, String auteur, GregorianCalendar dateParution, GenreLogiciel genre  ) {
		int ref =400000+getMediatheque().getDocuments().size()+1;
		Logiciel logiciel = new Logiciel(titre,auteur,dateParution,genre);
		logiciel.setRéférence(ref);
		getMediatheque().addDocument(logiciel);
		
	}
	
	
///////////////////////// TEMPORAIRE ////////////////////////////
	public void supprimerDocument(int ref) {
		// TODO - implement Controleur.supprimerDocument
		throw new UnsupportedOperationException();
	}
////////////////////////////////////////////////////////////////


	public void emprunterDocument(int ref, int numAbonne) {
		Document doc = getMediatheque().getDocuments().get(ref);
		Abonné abo = getAbo(numAbonne);
			if (doc==null){
				
				System.out.println("Ce document n'est pas référencié.");
			} else {
				if(doc.getEmprunt()!=null){
					Emprunter f = (Emprunter) currentView;
					f.dejaEmprunte();
					System.out.println("Ce document est déjà emrpunté");
				} else {
					// NOTIFY / UPDATE OBSERVATEUR
					Emprunt emprunt = new Emprunt(doc,abo);
					doc.setEmprunt(emprunt);
					abo.addEmprunt(emprunt);
				}
	
			}
	}
	
	public Abonné getAbo(int numAbo){
		return getMediatheque().getAbonnes().get(numAbo);
	}
	
	public boolean empruntPossible(Abonné abo){
		if (abo.getEmprunts().size()>=getMediatheque().getNbMaxDoc()){
				return false;
		} else {
				//INTERRACTION VUE
				return true;
		}
	}
	
	

	
	public void libererDocument(int ref) {
		Document doc = mediatheque.getDocuments().get(ref);
		if (doc==null){
			System.out.println("Ce document n'est pas référencié.");
		} else {
			if (doc.getEmprunt()==null){
				System.out.println("Ce document n'est pas emprunté.");
			} else {
				doc.getEmprunt().getAbo().setEmprunts(null);
				doc.getEmprunt().setAbo(null);
				doc.setEmprunt(null);
			}
		}	
	}

	public Abonné inscrireAbonnee(String nom, String prenom) {
		Abonné abo = new Abonné(nom, prenom);
		getMediatheque().addAbonne(abo);	
		return abo;
	}
	public void addNumAbonne(Abonné abo){
		abo.setNumAbonne(getMediatheque().getAbonnes().size());
	}
	
	public Mediatheque getMediatheque() {
		return mediatheque;
	}
	public void setMediatheque(Mediatheque mediatheque) {
		this.mediatheque = mediatheque;
	}
	
	
	public void ajouterAbonné(){
		this.currentView = new AjouterAbo(this);
	}

}