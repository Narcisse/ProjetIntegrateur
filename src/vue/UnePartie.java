
/*Cette classe sert à ajouter les différents pannels dans un même frame lorsque
 la partie commence. Elle crée l'interface utilisée lors d'une partie (Lorsque nous somme en
 train de jouer)*/
package vue;

import vue.PanneauxInterface.BarreDeMenu;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import vue.ElementsVisuels.Paysan;
import vue.PanneauxInterface.PanBoutonAction;
import vue.PanneauxInterface.PanDescription;
import vue.PanneauxInterface.PanJeux;

/**
 *
 * @author Christo
 */
public class UnePartie extends JFrame {

    //Constructeur
    public UnePartie() {
        this.setTitle("Chantier en construction...");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        int hauteurEcran = Toolkit.getDefaultToolkit().getScreenSize().height;
        int largeurEcran = Toolkit.getDefaultToolkit().getScreenSize().width;
        this.setSize(largeurEcran, hauteurEcran);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setUndecorated(true);
        // initialisations
        // Donnees membres

        // graphique
        initComponents();
        // evenementielles
        initListeners();

    }

    //Initialisation
    public void initComponents() {
        BarreDeMenu panStatut = new BarreDeMenu(); //Ajoute une barre de menu à la fenêtre
        add(panStatut, BorderLayout.NORTH);
        PanJeux panJeux = new PanJeux(); //Importe la carte créée par la classe panJeu
        add(panJeux, BorderLayout.CENTER);
        JPanel panJoueur = new JPanel(new GridLayout(1, 3));  // panneau du bas de l'écran contenant la mini-map, le panDescription et le panBoutonAction
        add(panJoueur, BorderLayout.SOUTH);
        // mini map
        panJoueur.add(new JLabel(new ImageIcon("images\\mini.jpg")));
        // centre d'informations
        //exemple avec un paysan
        Paysan unPaysan = new Paysan();
        panJoueur.add(new PanDescription(unPaysan)); //Création du panDescription figurant la description d'un paysan
        // centre d'actions
        panJoueur.add(new PanBoutonAction());
    }

    public void initListeners() {

    }

    // Zone de test
    public static void main(String[] args) {
        UnePartie test = new UnePartie();
        test.setVisible(true);
    }
}
