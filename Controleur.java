

import java.util.GregorianCalendar;


public class Controleur {
	

	private Mediatheque mediatheque;
	private Fenetre currentView;
	
	public Controleur(){
		this.mediatheque=new Mediatheque(5);
        currentView = new Emprunter(this);
	}
	public Films ajouterFilm(String titre, String auteur, GregorianCalendar dateParution, GenreFilm genre  ) {
		int ref = 100000+getMediatheque().getDocuments().size()+1;
		Films film = new Films(titre,auteur,dateParution,genre);
		film.setRéférence(ref);
		getMediatheque().addDocument(film);
		return film;
		
	}
	public Musique ajouterMusique(String titre, String auteur, GregorianCalendar dateParution, GenreMusical genre  ) {
		int ref = 200000+getMediatheque().getDocuments().size()+1;
		Musique musique = new Musique(titre,auteur,dateParution,genre);
		musique.setRéférence(ref);
		getMediatheque().addDocument(musique);
		return musique;
		
	}
	public Livre ajouterLivre(String titre, String auteur, GregorianCalendar dateParution, GenreLitteraire genre, int numISBN  ) {
		int ref = 300000+getMediatheque().getDocuments().size()+1;
		Livre livre = new Livre(titre,auteur,dateParution,numISBN,genre);
		livre.setRéférence(ref);
		getMediatheque().addDocument(livre);
		return livre;
		
	}
	public Logiciel ajouterLogiciel(String titre, String auteur, GregorianCalendar dateParution, GenreLogiciel genre  ) {
		int ref = 400000+getMediatheque().getDocuments().size()+1;
		Logiciel logiciel = new Logiciel(titre,auteur,dateParution,genre);
		logiciel.setRéférence(ref);
		getMediatheque().addDocument(logiciel);
		return logiciel;
		
	}


	public void emprunterDocument(int ref, int numAbonne) {
		Document doc = getMediatheque().getDocuments().get(ref);
		Abonné abo = getAbo(numAbonne);
		Emprunter f = (Emprunter) currentView;
			if (doc==null){
				f.pasRéférencé();
				
			} else {
				if(doc.getEmprunt()!=null){
					
					f.dejaEmprunte();

				} else {
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

				return true;
		}
	}
	
	

	//Pas eu le temps de faire l'interface
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
		////////////////////////////////////////
	public void inscrireAbonnee(Abonné abo) {
		abo.setNumAbonne(getMediatheque().getAbonnes().size()+1);
		getMediatheque().addAbonne(abo);	
		
	}
	public Abonné creerAbonne(String nom, String prenom){
		Abonné abo = new Abonné(nom, prenom);
		return abo;
	}
	
	public Mediatheque getMediatheque() {
		return mediatheque;
	}
	public void setMediatheque(Mediatheque mediatheque) {
		this.mediatheque = mediatheque;
	}
	
	
	public void goToAjouterAbonné(){
		this.currentView.dispose();
		this.currentView = new AjouterAbo(this);
	}
	
	public void goToAjouterDoc(){
		this.currentView.dispose();
		this.currentView = new AjouterDoc(this);
	}
	
	public void goToEmprunterDoc(){
		this.currentView.dispose();
		this.currentView = new Emprunter(this);
	}

}