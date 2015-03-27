
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import sun.awt.VariableGridLayout;


public class EmprunterUI extends JPanel {
    
    private JTextField numAbo;
    private JTextArea listeEmprunts;
    private JTextField reference;
    
    public EmprunterUI() {
        initUIComponents();
    }
    
    private void initUIComponents() {      

        this.setLayout(new VariableGridLayout(10, 2));
        this.add(new JLabel("Emprunter"));
        this.add(new JLabel(""));
        
        this.add(new JLabel("Numéro d'abonné :"));
        numAbo = new JTextField(30);
        this.add(numAbo);
    }
    
    public void afficherListeEmprunts(){
        //Après un check du controleur pour valider le numAbo, il demande l'affichage par cette fonction
        
        this.add(new JLabel("Liste des emprunts de l'abonné :"));
        listeEmprunts = new JTextArea(5,20);
        this.add(listeEmprunts);
    }
    
    public void afficherEmprunter(){
        //si la liste des emprunts de l'abonné numAbo est < 5 alors le controleur demande l'affichage par cette fonction
        
        this.add(new JLabel("Référence du document :"));
        reference = new JTextField(30);
        this.add(reference);
    }
}
