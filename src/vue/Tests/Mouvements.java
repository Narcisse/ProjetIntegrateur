package vue.Tests;

import controleur.DonneesUtiles;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import vue.ElementsVisuels.Paysan;
import vue.ElementsVisuels.Unite;

/**
 *
 * @author Christo Cette classe est le chantier du déplacement des unités, ce
 * sera une frame dans laquelle j'essairai de déplacer un paysan à l'aide des
 * flèches et des touches awsd
 */
public class Mouvements extends JFrame {

    // Données membres
    /*
     Je vais créer une liste pour tous les paysans
     Comme ça je vais pouvoir appliquer mes algorithmes
     de collision sur toute la liste de façon simple et
     rapide!
     */
    private ArrayList<Unite> paysans = new ArrayList<Unite>();
    // Un panneau pour bien contrôler le positionnement
    private JPanel panMouvements = new JPanel(new GridLayout(1, 1));
    // Un paysan
    private Paysan patientZero;

    // *************************************************************************
    // Constructeurs
    public Mouvements() {
        super();
        initComponents();
        initListeners();
        initFrame();
    }

    // *************************************************************************
    // Méthodes spécifiques
    public void initFrame() {
        this.setUndecorated(true);
        this.setBackground(DonneesUtiles.invisibilityCloak);
        this.setTitle("The void");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(DonneesUtiles.largeurEcran, DonneesUtiles.hauteurEcran);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
    }

    public void initComponents() {
        /*Je vais ajouter des paysans dans le panneau panMouvements pour
         observer le comportement des méthodes que j'ai développer dans la
         classe paysan
         */
        patientZero = new Paysan();
        // On doit définir manuellement les coordonnées du paysans
        patientZero.setPositionX(0);
        patientZero.setPositionY(0);
        paysans.add(patientZero);
        this.setContentPane(patientZero);
    }

    public void initListeners() {
        // Déclaration d'un écouteur pour les touches directionnelles
        EcouteurTouchesDirectionnelles ecoDirections =
        new EcouteurTouchesDirectionnelles();
        
        // Ajout de l'écouteur au panneau de test
        getContentPane().addKeyListener(ecoDirections);
        this.addKeyListener(ecoDirections);
    }

    // *************************************************************************
    // Classes écouteurs
    public class EcouteurTouchesDirectionnelles implements KeyListener {
        int valeurDeplacement = 7;
        @Override
        public void keyPressed(KeyEvent e) {
            // Déplacement de un vers la droite
            if (e.getKeyCode() == KeyEvent.VK_RIGHT
                    || e.getKeyChar() == 'd') {
                patientZero.deplacement(valeurDeplacement, 0);
                patientZero.repaint();
            }
            // Déplacement de un vers la gauche
            if (e.getKeyCode() == KeyEvent.VK_LEFT
                    || e.getKeyChar() == 'a') {
                patientZero.deplacement(-valeurDeplacement, 0);
                patientZero.repaint();
            }
            // Déplacement de un vers le haut
            if (e.getKeyCode() == KeyEvent.VK_UP
                    || e.getKeyChar() == 'w') {
                patientZero.deplacement(0, -valeurDeplacement);
                patientZero.repaint();
            }
            // Déplacement de un vers le bas
            if (e.getKeyCode() == KeyEvent.VK_DOWN
                    || e.getKeyChar() == 's') {
                patientZero.deplacement(0, valeurDeplacement);
                patientZero.repaint();
            }
            // Déplacements en diagonale
                // à venir...
        }
        @Override
        public void keyReleased(KeyEvent e) {
            
        }
        @Override
        public void keyTyped(KeyEvent e) {

        }

    }
    // *************************************************************************
    // Zone de test
    public static void main(String[] args) {
        new Mouvements();
    }
    
}
