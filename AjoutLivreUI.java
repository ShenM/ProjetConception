
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import sun.awt.VariableGridLayout;


public class AjoutLivreUI extends JPanel {
    
    private JTextField champTitre;
    private JTextField champAuteur;
    private JTextField champDate;
    private JTextField champReference;
    private JTextField champGenre;
    private JButton button;
    
    public AjoutLivreUI() {
        initUIComponents();
    }

    private void initUIComponents() {   
        this.setLayout(new VariableGridLayout(6, 2));
        
        this.add(new JLabel("Titre :"));
        champTitre = new JTextField(30);
        this.add(champTitre);
        
        this.add(new JLabel("Auteur :"));
        champAuteur = new JTextField(30);
        this.add(champAuteur);
        
        this.add(new JLabel("Date :"));
        champDate = new JTextField(30);
        this.add(champDate);
        
        this.add(new JLabel("Reference :"));
        champReference = new JTextField(30);
        this.add(champReference);
        
        this.add(new JLabel("Genre :"));
        champGenre = new JTextField(30);
        this.add(champGenre);
        
        button = new JButton("Valider");
        this.add(button);
    }
    
}
