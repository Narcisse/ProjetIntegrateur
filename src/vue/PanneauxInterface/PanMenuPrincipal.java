package vue.PanneauxInterface;

/**
 * Menu principal fait par carte de panneaux
 *
 */

import controleur.DonneesUtiles;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import vue.PanneauxMenus.PanOptions;
import vue.UnePartie;

public class PanMenuPrincipal extends JFrame {

    // Données membres
    // Noms des cartes
    public final static String CARTE_MENU_PRINCIPALE = "Carte avec les boutons de menu",
            CARTE_OPTIONS_JEU = "Carte avec les options du jeu",
            CARTE_TUTORIEL = "Carte avec les tutoriaux du jeu";

    // Panneau avec un layout de cartes
    // Chaques cartes ajoutée pourra être appeler pour revenir sur le "Dessus"
    private CardLayout myCardLayout = new CardLayout();
    private JPanel cartesDaffichageMenu = new JPanel(myCardLayout);

    // Crédit du début (carte 1)
    // Un panneau avec le vidéo d'intro ici
    // image de fond
    private Image fondDecran = new ImageIcon("images\\fond.jpg").getImage();

    // Panneau du menu principal (carte 2)
    private PanMainMenu carteMenuPrincipal = new PanMainMenu(fondDecran, myCardLayout, this);

    // La campagne elle ouvrira une fenetre à part et fermera celle-ci
    private UnePartie campagneSolo = new UnePartie();

    // Panneau multiJoueur (carte 3)
    // à venir
    // Panneau d'options (carte 4)
    private PanOptions carteDesOptionsDuJeu = new PanOptions(DonneesUtiles.fondDecran, myCardLayout);

    // Panneau de tutotiel, qui devra également être fait sur un frame de cardLayout (carte 5)
    PanTutoriel carteDesTutoriels = new PanTutoriel(DonneesUtiles.fondDecran, myCardLayout);

    // Panneau de crédit du jeu (carte 6)
    // à venir
    // Constructeur de la fenetre principale
    public PanMenuPrincipal() {
        super();
        this.setSize(DonneesUtiles.largeurEcran, DonneesUtiles.hauteurEcran);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        initListeners();
    }

    // Méthodes spécifiques
    public void initComponents() {
        // ajouter les cartes au panneau qui est en cardLayout
        cartesDaffichageMenu.add(carteMenuPrincipal, CARTE_MENU_PRINCIPALE);
        cartesDaffichageMenu.add(carteDesOptionsDuJeu, CARTE_OPTIONS_JEU);
        cartesDaffichageMenu.add(carteDesTutoriels, CARTE_TUTORIEL);
        // ajouter le panneau qui contient les cartes à la fenetre
        add(cartesDaffichageMenu);
    }

    public void initListeners() {

    }
}
