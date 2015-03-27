public class Application {
    
    private static Mediatheque mediatheque;
    private static Controleur controleur;
    
    public static void main(String[] args){ 
        
        mediatheque = new Mediatheque(5);
        controleur = new Controleur(mediatheque);
        
        FenetreUI fen = new FenetreUI(controleur);
    }
}
