
/*Cette classe sert à ajouter les différents pannels dans un même frame lorsque
 la partie commence. Elle crée l'interface utilisée lors d'une partie (Lorsque nous somme en
 train de jouer)*/
package vue;

import java.awt.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import vue.ElementsVisuels.*;
import vue.PanneauxInterface.*;

/**
 *
 * @author Christo
 */
public class UnePartie extends JFrame {
    //Donnes membre
    //Curseur
    private Toolkit tk = Toolkit.getDefaultToolkit();
    private Cursor curseur;
    private ImageIcon imageCurseur1;
    
    
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
        // Apparence du curseur
        imageCurseur1 = new ImageIcon("images\\curseur.png");
        Image imageCurseur2 = imageCurseur1.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        //Curseur
        curseur = tk.createCustomCursor(imageCurseur2, new Point(1, 1), "Pointeur");
        setCursor(curseur);
        
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
        PaysanVue unPaysan = new PaysanVue();
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
