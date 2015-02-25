package vue.PanneauxInterface;

/**
 * Menu principal fait par carte de panneaux
 *
 */
import controleur.DonneesUtiles;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import modele.Categorie;
import vue.PanneauxMenus.PanOptions;
import vue.UnePartie;

public class PanMenuPrincipal extends JFrame {

    //Curseur

    private Toolkit tk = Toolkit.getDefaultToolkit();
    private Cursor curseur;
    private ImageIcon imageCurseur1;
    private Categorie laCategorie;

    // Données membres
    // Noms des cartes
    public final static String CARTE_MENU_PRINCIPALE = "Carte avec les boutons de menu",
            CARTE_OPTIONS_JEU = "Carte avec les options du jeu",
            CARTE_TUTORIEL = "Carte avec les tutoriaux du jeu",
            CARTE_CATEGORIE = "Carte des categories";

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
    PanCategorie carteDesObjectifs = new PanCategorie(fondDecran, myCardLayout, laCategorie);

    // Panneau de crédit du jeu (carte 6)
    // à venir
    // Constructeur de la fenetre principale
    public PanMenuPrincipal() {
        super();
        //Icone du jeu
        Image icone = Toolkit.getDefaultToolkit().getImage("images\\Icone\\piskelLogo.png");
        icone = icone.getScaledInstance(2000, 2000, 0);
        this.setIconImage(icone);

        this.setSize(DonneesUtiles.largeurEcran, DonneesUtiles.hauteurEcran);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        initListeners();
        initObjectif();
    }

    // Méthodes spécifiques
    public void initComponents() {
        // Apparence du curseur
        imageCurseur1 = new ImageIcon("images\\curseur.png");
        Image imageCurseur2 = imageCurseur1.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        //Curseur
        curseur = tk.createCustomCursor(imageCurseur2, new Point(1, 1), "Pointeur");
        setCursor(curseur);

        // ajouter les cartes au panneau qui est en cardLayout
        cartesDaffichageMenu.add(carteMenuPrincipal, CARTE_MENU_PRINCIPALE);
        cartesDaffichageMenu.add(carteDesOptionsDuJeu, CARTE_OPTIONS_JEU);
        cartesDaffichageMenu.add(carteDesTutoriels, CARTE_TUTORIEL);
        cartesDaffichageMenu.add(carteDesObjectifs, CARTE_CATEGORIE);
        // ajouter le panneau qui contient les cartes à la fenetre
        add(cartesDaffichageMenu);
    }

    public void initObjectif() {       
        ImageIcon lesImages = new ImageIcon("images\\chat.jpg");
        ArrayList<ImageIcon> lstImage = new ArrayList<ImageIcon>();
        lstImage.add(lesImages);
        lstImage.add(lesImages);

        ArrayList<String> lstString = new ArrayList<String>();
        lstString.add("TITRODELTUTORIALAMIGO");
        lstString.add("JAJAJMUIESPECIAL");
        lstString.add("JAJAJMUIESPECIAL");

        laCategorie = new Categorie(lstString, lstImage);
    }

    public void initListeners() {

    }
}
