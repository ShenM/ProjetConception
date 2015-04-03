
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class AjouterDocUI extends JPanel{
    
    private JTextField champTitre;
    private JTextField champAuteur;
    private JTextField champDate;
    private JTextField champGenre;
    private JButton button;
    
    public AjouterDocUI() {
        initUIComponents();
    }
    
    private void initUIComponents() {      

        this.setLayout(new GridLayout(2, 3));
        //this.setLayout(new GridBagLayout());
        this.add(new JLabel("Ajouter un document"));
        this.add(new JLabel(""));
        
        //In initialization code:
        //Create the radio buttons.
        JRadioButton livreButton = new JRadioButton("Livre");
        livreButton.setActionCommand("Livre");
        livreButton.setSelected(true);

        JRadioButton filmButton = new JRadioButton("Film");
        filmButton.setActionCommand("Film");

        JRadioButton logicielButton = new JRadioButton("Logiciel");
        logicielButton.setActionCommand("Logiciel");

        JRadioButton musiqueButton = new JRadioButton("Musique");
        musiqueButton.setActionCommand("Musique");

        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(livreButton);
        group.add(filmButton);
        group.add(logicielButton);
        group.add(musiqueButton);

        this.add(livreButton);
        this.add(filmButton);
        this.add(logicielButton);
        this.add(musiqueButton);
        
        this.add(new JLabel("Titre :"));
        champTitre = new JTextField(30);
        this.add(champTitre);
        
        this.add(new JLabel("Auteur :"));
        champAuteur = new JTextField(30);
        this.add(champAuteur);
        
        this.add(new JLabel("Date :"));
        champDate = new JTextField(30);
        this.add(champDate);
                
        this.add(new JLabel("Genre :"));
        champGenre = new JTextField(30);
        this.add(champGenre);
        
        button = new JButton("Valider");
        this.add(button);
        
  
    }
    
}
