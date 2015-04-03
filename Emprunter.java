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


public class Emprunter extends Fenetre implements Observer {

	private JPanel contentPane;
	private JTextField txtEmprunter;
	private JTextField textReference;
	private	JList list; 



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
		final Emprunter f = this;
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
        getContentPane().add(getMenu(), BorderLayout.NORTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
	}
	
	
	
	
	
	
	@Override
	public void update(Observable o, Object arg) {
		Abonné abo =getControleur().getAbo(Integer.valueOf(txtEmprunter.getText()));
		DefaultListModel model = new DefaultListModel();
		  for (Emprunt emp : abo.getEmprunts()){
			  model.addElement(emp.getDoc().getTitre());
		  }
		 list.setModel(model);
	}
	
	
	public void dejaEmprunte(){
		JFrame popup = new JFrame();
		popup.setSize(400, 150);
		popup.setTitle("Erreur");
		popup.setLayout(new BorderLayout());
		popup.add(new JLabel("Ce document a déjà été emprunté."), BorderLayout.NORTH);
		JButton b = new JButton("Ok");
		
		b.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  popup.dispose();
	    	  
	      }
	    });
		popup.add(b,BorderLayout.SOUTH);
		popup.setVisible(true);
	}
	
}
	

	
