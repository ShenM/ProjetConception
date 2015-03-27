

import java.util.GregorianCalendar;

public class Controleur {
	

	private Mediatheque mediatheque;
	
	public Controleur(Mediatheque mediatheque){
		this.mediatheque=mediatheque;
	}
	public void ajouterFilm(String titre, String auteur, GregorianCalendar dateParution, GenreFilm genre  ) {
		int ref =100000+getMediatheque().getDocuments().size()+1;
		Films film = new Films(titre,auteur,dateParution,genre);
		getMediatheque().addDocument(film);
		film.setRéférence(ref);
	}
	public void ajouterMusique(String titre, String auteur, GregorianCalendar dateParution, GenreMusical genre  ) {
		int ref =200000+getMediatheque().getDocuments().size()+1;
		Musique musique = new Musique(titre,auteur,dateParution,genre);
		getMediatheque().addDocument(musique);
		musique.setRéférence(ref);
	}
	public void ajouterLivre(String titre, String auteur, GregorianCalendar dateParution, GenreLitteraire genre, int numISBN  ) {
		int ref =300000+getMediatheque().getDocuments().size()+1;
		Livre livre = new Livre(titre,auteur,dateParution,numISBN,genre);
		getMediatheque().addDocument(livre);
		livre.setRéférence(ref);
	}
	public void ajouterLogiciel(String titre, String auteur, GregorianCalendar dateParution, GenreLogiciel genre  ) {
		int ref =400000+getMediatheque().getDocuments().size()+1;
		Logiciel logiciel = new Logiciel(titre,auteur,dateParution,genre);
		getMediatheque().addDocument(logiciel);
		logiciel.setRéférence(ref);
	}
	
	
///////////////////////// TEMPORAIRE ////////////////////////////
	public void supprimerDocument(int ref) {
		// TODO - implement Controleur.supprimerDocument
		throw new UnsupportedOperationException();
	}
////////////////////////////////////////////////////////////////


	public void emprunterDocument(int ref, int numAbonne) {
		Document doc = getMediatheque().getDocuments().get(ref);
		Abonné abo = getMediatheque().getAbo(numAbonne);
			if (doc==null){
				//INTERRACTION VUE
				System.out.println("Ce document n'est pas référencié.");
			} else {
				if(doc.getEmprunt()!=null){
					//INTERRACTION VUE
					System.out.println("Ce document est déjà emrpunté");
				} else {
					// NOTIFY / UPDATE OBSERVATEUR
					getMediatheque().emprunter(doc, abo);
					
				}
	
			}
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
				getMediatheque().retirerEmprunt(doc);
			}
		}	
	}

	public void inscrireAbonnee(String nom, String prenom) {
		Abonné abo = new Abonné(nom, prenom);
		getMediatheque().addAbonne(abo);	
	}
	
	public Mediatheque getMediatheque() {
		return mediatheque;
	}
	public void setMediatheque(Mediatheque mediatheque) {
		this.mediatheque = mediatheque;
	}
	

}