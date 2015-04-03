
import java.util.GregorianCalendar;

public class Application {
    
    private static Mediatheque mediatheque;
    private static Controleur controleur;
    private static Emprunter fenetre;
    
    public static void main(String[] args){ 
        
        mediatheque = new Mediatheque(5);
        controleur = new Controleur(mediatheque);
    }
}
