import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class AjouterAbo extends Fenetre implements Observer {
	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField textField;
	private JLabel lblNumAbo;


	public AjouterAbo(Controleur controleur) {
			super(controleur);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 600, 600);
			contentPane = new JPanel();
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			
			this.setTitle("Application médiathèque");
			
	        
	        JLabel lblAjouterUnAbonn = new JLabel("Ajouter un abonné");
	        lblAjouterUnAbonn.setBounds(227, 60, 152, 48);
	        contentPane.add(lblAjouterUnAbonn);
	        
	        txtNom = new JTextField();
	        txtNom.setBounds(305, 166, 114, 19);
	        contentPane.add(txtNom);
	        txtNom.setColumns(10);
	        
	        JLabel lblNom = new JLabel("Nom :");
	        lblNom.setBounds(154, 159, 123, 33);
	        contentPane.add(lblNom);
	        
	        JLabel lblNewLabel = new JLabel("Prénom");
	        lblNewLabel.setBounds(154, 237, 70, 15);
	        contentPane.add(lblNewLabel);
	        
	        textField = new JTextField();
	        textField.setBounds(305, 235, 114, 19);
	        contentPane.add(textField);
	        textField.setColumns(10);
	        
	        JButton btnValider = new JButton("Valider");
	        btnValider.setBounds(236, 416, 117, 25);
	        contentPane.add(btnValider);
	        final AjouterAbo ajou= this;
	        btnValider.addActionListener(new ActionListener()
		    {
		      public void actionPerformed(ActionEvent e)
		      {
		    	  Abonné abo = controleur.inscrireAbonnee(txtNom.getText(), textField.getText());
		    	  abo.addObserver(ajou);
		    	  getControleur().addNumAbonne(abo);

		      }});
	        
	        
	        lblNumAbo = new JLabel("");
	        lblNumAbo.setBounds(100, 339, 400, 15);
	        contentPane.add(lblNumAbo);
	        
	        
	        this.setTitle("Application médiathèque");
			getContentPane().setLayout(new BorderLayout());
	        getContentPane().add(getMenu(), BorderLayout.NORTH);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setVisible(true);
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		Abonné abo = (Abonné) o;
		lblNumAbo.setText("Le numéro d'abonné de "+ abo.getPrenom() + " " + abo.getNom() + " est le "+ abo.getNumAbonne()+".");
	}
}
