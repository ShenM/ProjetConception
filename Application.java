
import java.util.GregorianCalendar;

public class Application {
    
    private static Mediatheque mediatheque;
    private static Controleur controleur;
    private static Emprunter fenetre;
    
    public static void main(String[] args){ 
        
        mediatheque = new Mediatheque(5);
        controleur = new Controleur(mediatheque);

        
      
        
      

        controleur.ajouterMusique("Swaggy", "Shen", new GregorianCalendar(2015, 01, 12), GenreMusical.electro);
        controleur.ajouterMusique("Swag", "Shen", new GregorianCalendar(2015, 01, 12), GenreMusical.electro);
        controleur.ajouterMusique("Swa", "Shen", new GregorianCalendar(2015, 01, 12), GenreMusical.electro);
        controleur.ajouterMusique("Sw", "Shen", new GregorianCalendar(2015, 01, 12), GenreMusical.electro);
        controleur.ajouterMusique("S", "Shen", new GregorianCalendar(2015, 01, 12), GenreMusical.electro);
        int a = controleur.getMediatheque().getDocuments().get(200001).getRéférence();


        
        System.out.println("ref : " + a);
        
    }
}
