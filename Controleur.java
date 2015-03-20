import java.util.ArrayList;
import java.util.Date;

public class Controleur {
	

	private Mediatheque mediatheque;
	
	public Controleur(Mediatheque mediatheque){
		this.mediatheque=mediatheque;
	}
	public void ajouterFilm(String titre, ArrayList<String> auteur, Date dateParution, GenreFilm genre  ) {
		int ref =100000+mediatheque.getDocuments().size();
		Films film = new Films(titre,auteur,dateParution,genre);
		mediatheque.addDocument(film);
		film.setRéférence(ref);
	}
	public void ajouterMusique(String titre, ArrayList<String> auteur, Date dateParution, GenreMusical genre  ) {
		int ref =200000+mediatheque.getDocuments().size();
		Musique musique = new Musique(titre,auteur,dateParution,genre);
		mediatheque.addDocument(musique);
		musique.setRéférence(ref);
	}
	public void ajouterLivre(String titre, ArrayList<String> auteur, Date dateParution, GenreLitteraire genre, int numISBN  ) {
		int ref =300000+mediatheque.getDocuments().size();
		Livre livre = new Livre(titre,auteur,dateParution,numISBN,genre);
		mediatheque.addDocument(livre);
		livre.setRéférence(ref);
	}
	public void ajouterLogiciel(String titre, ArrayList<String> auteur, Date dateParution, GenreLogiciel genre  ) {
		int ref =400000+mediatheque.getDocuments().size();
		Logiciel logiciel = new Logiciel(titre,auteur,dateParution,genre);
		mediatheque.addDocument(logiciel);
		logiciel.setRéférence(ref);
	}
	
	
///////////////////////// TEMPORAIRE ////////////////////////////
	public void supprimerDocument(int ref) {
		// TODO - implement Controleur.supprimerDocument
		throw new UnsupportedOperationException();
	}
////////////////////////////////////////////////////////////////

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
			if (doc.getEmprunt()==null){
				System.out.println("Ce document n'est pas emprunté.");
			} else {
				doc.getEmprunt().getAbo().setEmprunts(null);
				doc.getEmprunt().setAbo(null);
				doc.setEmprunt(null);
			}
		}	
	}

	public void inscrireAbonnee(String nom, String prenom) {
		mediatheque.addAbonne(new Abonné(nom, prenom));
		
	}
	public Mediatheque getMediatheque() {
		return mediatheque;
	}
	public void setMediatheque(Mediatheque mediatheque) {
		this.mediatheque = mediatheque;
	}
	

}