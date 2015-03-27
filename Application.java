
import java.util.GregorianCalendar;

public class Application {
    
    private static Mediatheque mediatheque;
    private static Controleur controleur;
    
    public static void main(String[] args){ 
        
        mediatheque = new Mediatheque(5);
        controleur = new Controleur(mediatheque);
        
        controleur.inscrireAbonnee("Mesrobian", "Shen");
        
        controleur.ajouterMusique("Swaggy", "Shen", new GregorianCalendar(2015, 01, 12), GenreMusical.electro);
        
        
    }
}
