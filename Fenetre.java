import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JMenu;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;



////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////FAIRE LE NOTIFY !!!!!!!!!!! ////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////


public class Fenetre extends JFrame implements Observer {

	private JPanel contentPane;
	private JTextField txtEmprunter;
	private JTextField textReference;
	private	JList list; 

    private JMenuItem [] menuDocument;
    private JMenuItem [] menuAbonne;
    private JMenuItem [] menuHelp;
    private Controleur controleur;
    private JMenuBar barreMenu;
    private AjouterDocUI ajouterDocUI;
    private EmprunterUI empruntUI;

	/**
	 * Create the frame.
	 */
	public Fenetre(Controleur controleur) {
		this.controleur=controleur;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
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
        getContentPane().add(barreMenu, BorderLayout.NORTH);
		
		
		
		
		txtEmprunter = new JTextField();
		txtEmprunter.setBounds(249, 93, 195, 19);
		contentPane.add(txtEmprunter);
		txtEmprunter.setColumns(10);
		
		JButton btnEmprunter = new JButton("Emprunter");
		btnEmprunter.setEnabled(false);
		btnEmprunter.setBounds(230, 481, 117, 25);
		
		btnEmprunter.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {

	    	  controleur.emprunterDocument(Integer.valueOf(textReference.getText()), Integer.valueOf(txtEmprunter.getText()));

	      }});
		
		contentPane.add(btnEmprunter);
		
		JLabel lblNumroDabonn = new JLabel("Numéro d'abonné :");
		lblNumroDabonn.setBounds(58, 95, 135, 15);
		contentPane.add(lblNumroDabonn);
		

		
		JLabel lblListeDesEmprunts = new JLabel("Liste des emprunts :");
		lblListeDesEmprunts.setEnabled(false);
		lblListeDesEmprunts.setBounds(58, 190, 146, 15);
		contentPane.add(lblListeDesEmprunts);
		
		list = new JList();
		list.setEnabled(false);
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setBounds(249, 188, 196, 162);
		contentPane.add(list);
		
		JLabel lblRfrence = new JLabel("Référence :");
		lblRfrence.setEnabled(false);
		lblRfrence.setBounds(58, 423, 182, 25);
		contentPane.add(lblRfrence);
		
		textReference = new JTextField();
		textReference.setEnabled(false);
		textReference.setEditable(false);
		textReference.setBounds(249, 423, 195, 25);
		contentPane.add(textReference);
		textReference.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(230, 134, 117, 25);
		final Fenetre f = this;
		btnValider.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  Abonné abo;
	    	  abo =controleur.getAbo(Integer.valueOf(txtEmprunter.getText()));
	    	  abo.addObserver(f);
	    	  if (abo !=null ){
	    		  lblListeDesEmprunts.setEnabled(true);
	    		  
	    		  DefaultListModel model = new DefaultListModel();
	    		  for (Emprunt emp : abo.getEmprunts()){
	    			  model.addElement(emp.getDoc().getTitre());
	    		  }
	    		  list.setModel(model);
	    		  list.setEnabled(true);
	    		  txtEmprunter.setEditable(false);
	    		  
	    		  if (controleur.empruntPossible(abo)){
	    			  lblRfrence.setEnabled(true);
	    			  btnEmprunter.setEnabled(true);
	    			  textReference.setEnabled(true);
	    			  textReference.setEditable(true);
	    			  
	    		  }
	    	  } else {
	    		  txtEmprunter.setText("");
	    		  lblListeDesEmprunts.setEnabled(false);
	    		  list.setEnabled(false);
	    	  }
	      }
	    });
		contentPane.add(btnValider);
		
		
		this.setTitle("Application médiathèque");
		getContentPane().setLayout(new BorderLayout());
        getContentPane().add(barreMenu, BorderLayout.NORTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
	}
	
	
	
	
	
	
	@Override
	public void update(Observable o, Object arg) {
		Abonné abo =controleur.getAbo(Integer.valueOf(txtEmprunter.getText()));
		DefaultListModel model = new DefaultListModel();
		  for (Emprunt emp : abo.getEmprunts()){
			  model.addElement(emp.getDoc().getTitre());
		  }
		 list.setModel(model);
	}
	
	
	public void dejaEmprunte(){
		JFrame popup = new JFrame();
		popup.setSize(200, 100);
		popup.setTitle("Erreur");
		popup.add(new JLabel("Ce document a déjà été emprunté."));
		JButton b = new JButton("Ok");
		b.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  popup.dispose();
	    	  
	      }
	    });
		popup.add(b);
		popup.setVisible(true);
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
