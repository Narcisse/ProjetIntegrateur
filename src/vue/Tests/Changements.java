package vue.Tests;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import vue.ElementsVisuels.ArbreVue;
import vue.ElementsVisuels.ElementDecorVue;

/**
 *
 * @author Christo
 */
public class Changements extends JFrame{
    // Données membres
    /*
     Je vais creer des elements de decor pour tester des interactions
     */
    private ArbreVue elementZero;
    private JPanel panChangements;

    // *************************************************************************
    // Constructeurs
    public Changements() {
        super();
        initComponents();
        initListeners();
        initFrame();
    }

    // *************************************************************************
    // Méthodes spécifiques
    public void initFrame() {
        this.setUndecorated(false);
        this.setTitle("The void");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
    }

    public void initComponents() {
        // Definir un panneau contenant
        panChangements = new JPanel(new GridLayout(1, 1));
        /*Je vais ajouter des éléments de décor dans le panneau panChangements
         pour observer le comportement des méthodes que j'ai développer dans la
         classe élément de décor et ses classes filles
         */
        elementZero = new ArbreVue();
        // On doit définir manuellement les coordonnées du paysans
        elementZero.setLocation(0, 0);
        this.setContentPane(elementZero);
    }
    public void initListeners(){
        elementZero.addMouseListener(new EcouteurInteraction());
    }
    // *************************************************************************
    // Classes écouteurs
    public class EcouteurInteraction extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            ElementDecorVue unElement = (ElementDecorVue)e.getSource();
            Image imageApresClick = unElement.getImageApresClick();
            unElement.setImagePeinturer(imageApresClick);
            unElement.repaint();
        }        
    }
    // *************************************************************************
    // Zone de test
    public static void main(String[] args) {
        new Changements();
    }
}
