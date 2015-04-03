/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author freyssil
 */
public class AjouterMusiqueUI extends JPanel{
    private JTextField champTitre;
    private JTextField champAuteur;
    private JTextField champRef;
    private JTextField champDate;
    private JTextField champGenre;
    private JButton button;
    
    public AjouterMusiqueUI() {
        initUIComponents();
    }
    
    private void initUIComponents() {   
        this.setLayout(new GridLayout(6, 2));
        
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
