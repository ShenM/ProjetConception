import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Fenetre extends JFrame{
    private JMenuItem [] menuDocument;
    private JMenuItem [] menuAbonne;
    private Controleur controleur;
    private JMenuBar barreMenu;
    
    
    
    
 public Fenetre(Controleur c){
    this.controleur=c;
	//initialise les paramètres de l'objet
    menuDocument = new JMenuItem[6];
    menuAbonne = new JMenuItem[3];
    
    //lance l'initialisation des menus
    barreMenu = new JMenuBar();
    barreMenu.add(initMenuDocument());
    barreMenu.add(initMenuAbonne());
    getContentPane().add(barreMenu, BorderLayout.NORTH);
    

 }

private JMenu initMenuDocument() {
    JMenu menu;
            
    menu = new JMenu("Document");
          
    menuDocument[0] = new JMenuItem("Rechercher");
    menuDocument[0].setEnabled(false);
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
                controleur.goToAjouterDoc();
            }
        }
    );
    menu.add(menuDocument[1]);
    
    menuDocument[2] = new JMenuItem("Supprimer");
    menuDocument[2].setEnabled(false);
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
                controleur.goToEmprunterDoc();
            }
        }
    );
    menu.add(menuDocument[3]);
    
    menuDocument[4] = new JMenuItem("Rendre");
    menuDocument[4].setEnabled(false);
    menuDocument[4].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //controleur.enregistrer();
            }
        }
    );
    menu.add(menuDocument[4]);
    
    menuDocument[5] = new JMenuItem("Reserver");
    menuDocument[5].setEnabled(false);
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
    menuAbonne[0].setEnabled(false);
    menuAbonne[0].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //controleur.enregistrer();
            }
        }
    );
    menu.add(menuAbonne[0]);
    
    menuAbonne[1] = new JMenuItem("Ajouter");
    menuAbonne[1].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.goToAjouterAbonné();
            }
        }
    );
    menu.add(menuAbonne[1]);
    
    menuAbonne[2] = new JMenuItem("Supprimer");
    menuAbonne[2].setEnabled(false);
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


public Controleur getControleur(){
	return this.controleur;
}

public JMenuBar getMenu(){
 return this.barreMenu;
}
}


