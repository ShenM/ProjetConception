
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import sun.awt.VariableGridLayout;


public class AjouterDocUI extends JPanel{
    
    private JTabbedPane tabs; 
    private AjoutLivreUI livreUI;
//    private AjoutFilmUI filmUI;
//    private AjoutLogicielUI logicielUI;
//    private AjoutMusiqueUI musiqueUI;
    
    private JPanel filmUI;
    private JPanel logicielUI;
    private JPanel musiqueUI;
    
    public AjouterDocUI() {
        initUIComponents();
    }
    
    private void initUIComponents() {      

        this.setLayout(new VariableGridLayout(10, 2));
        this.add(new JLabel("Ajouter un document"));
        this.add(new JLabel(""));
        
        tabs = new JTabbedPane();
        tabs.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
           // controleur.tabChanged(tabs.getSelectedIndex());
          }
        });
              
        tabs.addTab("Livre", livreUI);
        tabs.addTab("Film", filmUI);
        tabs.addTab("Logiciel", logicielUI);
        tabs.addTab("Musique", musiqueUI);
        this.add(tabs);
    }
    
}
