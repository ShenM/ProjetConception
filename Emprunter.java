import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;



public class Emprunter extends Fenetre implements Observer {

	private JPanel contentPane;
	private JTextField txtEmprunter;
	private JTextField textReference;
	private	JList list; 
	private JLabel lblText;
	private JLabel lblRfrence;


	/**
	 * Create the frame.
	 */
	public Emprunter(Controleur controleur) {
		super(controleur);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		txtEmprunter = new JTextField();
		txtEmprunter.setBounds(249, 93, 195, 19);
		contentPane.add(txtEmprunter);
		txtEmprunter.setColumns(10);
		
		JButton btnEmprunter = new JButton("Emprunter");
		btnEmprunter.setEnabled(false);
		btnEmprunter.setBounds(230, 513, 117, 25);
		
		btnEmprunter.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  try{
	    		  	Abonné abo = controleur.getAbo(Integer.valueOf(txtEmprunter.getText()));
	    			 controleur.emprunterDocument(Integer.valueOf(textReference.getText()), Integer.valueOf(txtEmprunter.getText()));
	    			  if (!controleur.empruntPossible(abo)){ 
	    				  lblText.setText("Nombre maximum d'emprunt atteint.");
	    				  lblRfrence.setEnabled(false);
		    			  btnEmprunter.setEnabled(false);
		    			  textReference.setEnabled(false);
		    			  textReference.setEditable(false);
	    				  
	    			  }
	    			  
	    		  
	    	  }catch(Exception ex){
	    		  lblText.setText("Référence invalide.");
	    		  textReference.setText("");
	    	  }
	    	  

	      }});
		
		contentPane.add(btnEmprunter);
		
		JLabel lblNumroDabonn = new JLabel("Numéro d'abonné :");
		lblNumroDabonn.setBounds(58, 95, 135, 15);
		contentPane.add(lblNumroDabonn);
		

		
		JLabel lblListeDesEmprunts = new JLabel("Liste des emprunts :");
		lblListeDesEmprunts.setEnabled(false);
		lblListeDesEmprunts.setBounds(58, 222, 146, 15);
		contentPane.add(lblListeDesEmprunts);
		
		list = new JList();
		list.setEnabled(false);
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setBounds(249, 220, 196, 162);
		contentPane.add(list);
		
		lblRfrence = new JLabel("Référence :");
		lblRfrence.setEnabled(false);
		lblRfrence.setBounds(58, 397, 182, 25);
		contentPane.add(lblRfrence);
		
		textReference = new JTextField();
		textReference.setEnabled(false);
		textReference.setEditable(false);
		textReference.setBounds(249, 397, 195, 25);
		contentPane.add(textReference, BorderLayout.SOUTH);
		textReference.setColumns(10);
		
		JLabel msgAbo = new JLabel(" ");
		msgAbo.setBounds(166, 129, 261, 25);
		contentPane.add(msgAbo);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(230, 166, 117, 25);
		final Emprunter f = this;
		btnValider.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  Abonné abo;
	    	  try{
	    	  abo =controleur.getAbo(Integer.valueOf(txtEmprunter.getText()));
	    	  
	    	  
	    	  if (abo !=null ){
	    		  msgAbo.setText("");
	    		  abo.addObserver(f);    	 
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
	    		  msgAbo.setText("Numéro d'abonné introuvable.");
	    		  lblListeDesEmprunts.setEnabled(false);
	    		  list.setEnabled(false);
	    	  }
	    	  
	    	  }catch(Exception ex){
	    		  txtEmprunter.setText("");
	    		  msgAbo.setText("Numéro d'abonné introuvable.");
	    		  lblListeDesEmprunts.setEnabled(false);
	    		  list.setEnabled(false);	    	  
	    	  }
	      }
	    });
		contentPane.add(btnValider);
		
		JLabel lblEmprunterUnDocument = new JLabel("Emprunter un document");
		lblEmprunterUnDocument.setBounds(196, 12, 200, 50);
		contentPane.add(lblEmprunterUnDocument);
		
		lblText = new JLabel("");
		lblText.setBounds(98, 442, 346, 50);
		contentPane.add(lblText);
		
		
		
		this.setTitle("Application médiathèque");
		getContentPane().setLayout(new BorderLayout());
        getContentPane().add(getMenu(), BorderLayout.NORTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
	}
	
	
	
	
	
	
	@Override
	public void update(Observable o, Object arg) {
		Abonné abo = getControleur().getAbo(Integer.valueOf(txtEmprunter.getText()));
		DefaultListModel model = new DefaultListModel();
		  for (Emprunt emp : abo.getEmprunts()){
			  model.addElement(emp.getDoc().getTitre());
		  }
		 list.setModel(model);
		 lblText.setText("Le document a bien été emprunté.");
	}
	
	
	public void dejaEmprunte(){
		lblText.setText("Ce document a déjà été emprunté.");
	}
	
	public void pasRéférencé(){
		lblText.setText("Ce document n'est pas référencé.");
	}
	
}
	

	
