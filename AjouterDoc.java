import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;


public class AjouterDoc extends Fenetre {

	private JPanel contentPane;
	private JTextField textTitre;
	private JTextField textAuteur;
	private JTextField textDate;
	private JTextField textISBN;
	private JLabel msg;

	public AjouterDoc(Controleur controleur) {
		super(controleur);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ajouter un document");
		lblNewLabel.setBounds(213, 43, 154, 50);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnLivre = new JRadioButton("Livre");
		rdbtnLivre.setBounds(88, 161, 71, 23);
		contentPane.add(rdbtnLivre);
		
		JRadioButton rdbtnFilm = new JRadioButton("Film");
		rdbtnFilm.setBounds(420, 161, 71, 23);
		contentPane.add(rdbtnFilm);
		
		JRadioButton rdbtnMusique = new JRadioButton("Musique");
		rdbtnMusique.setBounds(306, 161, 88, 23);
		contentPane.add(rdbtnMusique);
		
		JRadioButton rdbtnLogiciel = new JRadioButton("Logiciel");
		rdbtnLogiciel.setBounds(193, 161, 88, 23);
		contentPane.add(rdbtnLogiciel);
		
		
	     //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(rdbtnLivre);
        group.add(rdbtnFilm);
        group.add(rdbtnMusique);
        group.add(rdbtnLogiciel);
        getContentPane().add(rdbtnLivre);
        getContentPane().add(rdbtnFilm);
        getContentPane().add(rdbtnMusique);
        getContentPane().add(rdbtnLogiciel);
        
       
		
		JLabel lblNewLabel_1 = new JLabel("Type de document :");
		lblNewLabel_1.setBounds(78, 114, 154, 50);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTitre = new JLabel("Titre :");
		lblTitre.setBounds(78, 211, 71, 40);
		contentPane.add(lblTitre);
		
		textTitre = new JTextField();
		textTitre.setBounds(237, 222, 130, 19);
		contentPane.add(textTitre);
		textTitre.setColumns(10);
		
		JLabel lblAutreurs = new JLabel("Auteur(s) :");
		lblAutreurs.setBounds(78, 254, 163, 30);
		contentPane.add(lblAutreurs);
		
		textAuteur = new JTextField();
		textAuteur.setColumns(10);
		textAuteur.setBounds(237, 260, 130, 19);
		contentPane.add(textAuteur);
		
		JLabel lblNewLabel_2 = new JLabel("Date (jj/mm/aaaa) :");
		lblNewLabel_2.setBounds(78, 294, 200, 30);
		contentPane.add(lblNewLabel_2);
		
		textDate = new JTextField();
		textDate.setColumns(10);
		textDate.setBounds(237, 300, 130, 19);
		contentPane.add(textDate);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(237, 336, 130, 19);
		contentPane.add(comboBox);
		
		JLabel lblGenre = new JLabel("Genre :");
		lblGenre.setBounds(78, 323, 88, 44);
		contentPane.add(lblGenre);
		
		JLabel lblNumroIsbn = new JLabel("Numéro ISBN :");
		lblNumroIsbn.setBounds(78, 370, 119, 30);
		contentPane.add(lblNumroIsbn);
		
		textISBN = new JTextField();
		textISBN.setColumns(10);
		textISBN.setBounds(237, 376, 130, 19);
		contentPane.add(textISBN);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(225, 472, 117, 25);
		contentPane.add(btnValider);
		
		msg = new JLabel(" ");
		msg.setBounds(80, 419, 430, 30);
		contentPane.add(msg);
		
		
		
		
		
		
		 rdbtnLivre.setSelected(true);
		 DefaultComboBoxModel d = new DefaultComboBoxModel(GenreLitteraire.values());
     	 comboBox.setModel(d);
		 
		 
		 
	        rdbtnLivre.addActionListener(new ActionListener(){
	            @Override
	            public void actionPerformed(ActionEvent e){
	            	DefaultComboBoxModel d = new DefaultComboBoxModel(GenreLitteraire.values());
	            	comboBox.setModel(d);
	            	textISBN.setEditable(true);
	            	textISBN.setEnabled(true);
	            	lblNumroIsbn.setEnabled(true);
	            	
	            }});
	        rdbtnFilm.addActionListener(new ActionListener(){
	            @Override
	            public void actionPerformed(ActionEvent e){
	            	DefaultComboBoxModel d = new DefaultComboBoxModel(GenreFilm.values());
	            	comboBox.setModel(d);
	            	textISBN.setEditable(false);
	            	textISBN.setEnabled(false);
	            	lblNumroIsbn.setEnabled(false);
	            }});
	        rdbtnLogiciel.addActionListener(new ActionListener(){
	            @Override
	            public void actionPerformed(ActionEvent e){
	            	DefaultComboBoxModel d = new DefaultComboBoxModel(GenreLogiciel.values());
	            	comboBox.setModel(d);
	            	textISBN.setEditable(false);
	            	textISBN.setEnabled(false);
	            	lblNumroIsbn.setEnabled(false);
	            }});
	        rdbtnMusique.addActionListener(new ActionListener(){
	            @Override
	            public void actionPerformed(ActionEvent e){
	            	DefaultComboBoxModel d = new DefaultComboBoxModel(GenreMusical.values());
	            	comboBox.setModel(d);
	            	textISBN.setEditable(false);
	            	textISBN.setEnabled(false);
	            	lblNumroIsbn.setEnabled(false);
	            }});
			
	        
	        
	        final AjouterDoc a = this;
	        
	        btnValider.addActionListener(new ActionListener(){
	            @Override
	            public void actionPerformed(ActionEvent e){
	            	String titre = textTitre.getText();
	            	String auteur = textAuteur.getText();
	            	String[] parts = textDate.getText().split("/");
	            	if (!titre.equals("")&&!auteur.equals("")&&!textDate.getText().equals("")){
	            		GregorianCalendar date = new GregorianCalendar(Integer.valueOf(parts[2]),Integer.valueOf(parts[1]), Integer.valueOf(parts[0]));
	            		if (rdbtnFilm.isSelected()){
		            		Films f = getControleur().ajouterFilm(titre, auteur, date, GenreFilm.values()[comboBox.getSelectedIndex()]);
		            		msg.setText("Le document a été ajouté et a pour référence : " + f.getRéférence()+"." );
	            		} else if(rdbtnLivre.isSelected()){
		            		int numISBN = Integer.valueOf(textISBN.getText());
		            		if (!textISBN.getText().equals("")){
		            		Livre l = getControleur().ajouterLivre(titre, auteur, date, GenreLitteraire.values()[comboBox.getSelectedIndex()], numISBN);
		            		msg.setText("Le document a été ajouté et a pour référence : " + l.getRéférence()+"." );
		            		}
		            	} else if (rdbtnLogiciel.isSelected()){
		            		Logiciel log = getControleur().ajouterLogiciel(titre, auteur, date, GenreLogiciel.values()[comboBox.getSelectedIndex()]);
		            		msg.setText("Le document a été ajouté et a pour référence : " + log.getRéférence()+"." );	
		            	} else if (rdbtnMusique.isSelected()){
		            		Musique m = getControleur().ajouterMusique(titre, auteur, date, GenreMusical.values()[comboBox.getSelectedIndex()]);
		            		msg.setText("Le document a été ajouté et a pour référence : " + m.getRéférence()+"." );
		            	}
	            		
	            	
	            	} else {
	            		msg.setText("Veuillez remplir tout les champs.");
	            	}
	            	
	            }});
		
	
		
		
		
		this.setTitle("Application médiathèque");
		getContentPane().setLayout(new BorderLayout());
        getContentPane().add(getMenu(), BorderLayout.NORTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
	}

	

}
