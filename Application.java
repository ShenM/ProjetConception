
import java.util.GregorianCalendar;

public class Application {
    
    private static Mediatheque mediatheque;
    private static Controleur controleur;
    private static Fenetre fenetre;
    
    public static void main(String[] args){ 
        
        mediatheque = new Mediatheque(5);
        controleur = new Controleur(mediatheque);

        
        controleur.inscrireAbonnee("Mesrobian", "Shen");
        int i;
        i=controleur.getMediatheque().getAbonnes().get(1).getNumAbonne();
        
      

        controleur.ajouterMusique("Swaggy", "Shen", new GregorianCalendar(2015, 01, 12), GenreMusical.electro);
        controleur.ajouterMusique("Swag", "Shen", new GregorianCalendar(2015, 01, 12), GenreMusical.electro);
        controleur.ajouterMusique("Swa", "Shen", new GregorianCalendar(2015, 01, 12), GenreMusical.electro);
        controleur.ajouterMusique("Sw", "Shen", new GregorianCalendar(2015, 01, 12), GenreMusical.electro);
        controleur.ajouterMusique("S", "Shen", new GregorianCalendar(2015, 01, 12), GenreMusical.electro);
        int a = controleur.getMediatheque().getDocuments().get(200001).getRéférence();


        
        System.out.println("ref : " + a);
        System.out.println("numabo : " + i);
        
    }
}
