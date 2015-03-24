
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FenetreUI extends JFrame{

    private JMenuItem [] menuDocument;
    private JMenuItem [] menuAbonne;
    private JMenuItem [] menuHelp;
    private Controleur controleur;
    private JMenuBar barreMenu;
    
    public FenetreUI(Controleur controleur) {
        
        //initialise les paramètres de l'objet
        menuDocument = new JMenuItem[6];
        menuAbonne = new JMenuItem[3];
        menuHelp = new JMenuItem[1];
        this.controleur = controleur;
        
        //lance l'initialisation des menus
        barreMenu = new JMenuBar();
        barreMenu.add(initMenuDocument());
        barreMenu.add(initMenuAbonne());
        barreMenu.add(initMenuHelp());
        
        //paramétrage et affichage de la fenetre
        this.setTitle("Application médiathèque");
        this.setSize(1000, 850);
        this.setLayout(new BorderLayout());
        this.add(barreMenu, BorderLayout.NORTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    private JMenu initMenuDocument() {
        JMenu menu;
                
        menu = new JMenu("Document");
              
        menuDocument[0] = new JMenuItem("Rechercher");
        menuDocument[0].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    //controleur.enregistrer();
                }
            }
        );
        menu.add(menuDocument[0]);
        
        menuDocument[1] = new JMenuItem("Ajouter");
        menuDocument[1].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    //controleur.enregistrer();
                }
            }
        );
        menu.add(menuDocument[1]);
        
        menuDocument[2] = new JMenuItem("Supprimer");
        menuDocument[2].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    //controleur.enregistrer();
                }
            }
        );
        menu.add(menuDocument[2]);
        
        menuDocument[3] = new JMenuItem("Emprunter");
        menuDocument[3].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    //controleur.enregistrer();
                }
            }
        );
        menu.add(menuDocument[3]);
        
        menuDocument[4] = new JMenuItem("Rendre");
        menuDocument[4].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    //controleur.enregistrer();
                }
            }
        );
        menu.add(menuDocument[4]);
        
        menuDocument[5] = new JMenuItem("Reserver");
        menuDocument[5].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    //controleur.enregistrer();
                }
            }
        );
        menu.add(menuDocument[5]);
        
        return menu;
    }
    
    private JMenu initMenuAbonne() {
        JMenu menu;
                
        menu = new JMenu("Abonne");
              
        menuAbonne[0] = new JMenuItem("Rechercher");
        menuAbonne[0].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    //controleur.enregistrer();
                }
            }
        );
        menu.add(menuAbonne[0]);
        
        menuAbonne[1] = new JMenuItem("Abonner");
        menuAbonne[1].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    //controleur.enregistrer();
                }
            }
        );
        menu.add(menuAbonne[1]);
        
        menuAbonne[2] = new JMenuItem("Desabonner");
        menuAbonne[2].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    //controleur.enregistrer();
                }
            }
        );
        menu.add(menuAbonne[2]);
        
        return menu;
    }
    
    private JMenu initMenuHelp() {
        JMenu menu;
                
        menu = new JMenu("Help");
              
        menuHelp[0] = new JMenuItem("Quitter");
        menuHelp[0].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    //controleur.enregistrer();
                }
            }
        );
        menu.add(menuHelp[0]);
        
        return menu;
    }
}
