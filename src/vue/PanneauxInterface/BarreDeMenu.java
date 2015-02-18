/*Cette classe crée la barre de menu présente lorsqu'on joue une partie ainsi que ses boutons.
Elle gère également le menu lorsque l'on clique sur le bouton Menu*/
package vue.PanneauxInterface;

/**
 * Loic Grant-Steinhardt
 *
 */
import vue.PanneauxMenus.PanelGoal;
import vue.PanneauxMenus.PanelMenu;
import vue.PanneauxMenus.PanelStats;
import vue.PanneauxMenus.PanelLog;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import vue.PanneauxMenus.PanelHelp;
import vue.PanneauxMenus.PanelTips;
import vue.refonte.BoitesDialogue;

public class BarreDeMenu extends JPanel {

    //Déclaration de variables
    private JButton btnMenu, btnStats, btnLog, btnGoal;
    private JPanel barreMenu, panRessources;
    private JLabel labBois, labOr, labNourriture;
    private ImageIcon imageOr1, imageOr4, imageBois1, imageBois4, imageNourriture1, imageNourriture4;

    //Constructeur
    public BarreDeMenu() {
        super();
        setLayout(new BorderLayout());
        initComponents();
        initListeners();
    }

    // initialisations
    public void initComponents() {
        barreMenu = new JPanel(new FlowLayout(0, 0, 0));
        panRessources = new JPanel(new FlowLayout(0, 80, 0));
        // Couleur
        btnMenu = new JButton("<html>MENU (<font color='blue'>Esc</font>)</html>");
        barreMenu.add(btnMenu);
        btnStats = new JButton("<html>STATISTIQUES (<font color='blue'>F1</font>)</html>");
        barreMenu.add(btnStats);
        btnLog = new JButton("<html>MESSAGES (<font color='blue'>F2</font>)</html>");  //Carnet de Bord?
        barreMenu.add(btnLog);
        btnGoal = new JButton("<html>OBJECTIFS (<font color='blue'>F3</font>)</html>");
        barreMenu.add(btnGoal);
        labOr = new JLabel("Or : ");
        labBois = new JLabel("Bois : ");
        labNourriture = new JLabel("Nourriture : ");

        //Grosseur image
        //Ajout de l'icone de nourriture à la barre de menu
        imageNourriture1 = new ImageIcon("images\\Icone\\nourriture.png");
        Image imageNourriture2 = imageNourriture1.getImage();
        Image imageNourriture3 = imageNourriture2.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        imageNourriture4 = new ImageIcon(imageNourriture3);

        //Ajout de l'icone du Bois à la barre de menu
        imageBois1 = new ImageIcon("images\\Icone\\bois.jpg");
        Image imageBois2 = imageBois1.getImage();
        Image imageBois3 = imageBois2.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        imageBois4 = new ImageIcon(imageBois3);

        //Ajout de l'icone de l'or à la barre de menu
        imageOr1 = new ImageIcon("images\\Icone\\or.jpg");
        Image imageOr2 = imageOr1.getImage();
        Image imageOr3 = imageOr2.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        imageOr4 = new ImageIcon(imageOr3);

        //Ajout des icone aux JLabel
        labOr.setIcon(imageOr4);
        labBois.setIcon(imageBois4);
        labNourriture.setIcon(imageNourriture4);

        //Ajout des Label au pannel
        panRessources.add(labOr);
        panRessources.add(labBois);
        panRessources.add(labNourriture);

        add(barreMenu, BorderLayout.NORTH);
        add(barreMenu, BorderLayout.WEST);
        add(panRessources, BorderLayout.NORTH);
        add(panRessources, BorderLayout.EAST);
    }

    //Classe anonyme d'ActionListener
    public void initListeners() {
        //Écouteur pour le bouton Menu
        btnMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                nouveauDialogue(new PanelMenu(), "Menu", 300, 400);
            }
        });

        //Écouteur pour le bouton Statistiques (Stats)
        btnStats.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                nouveauDialogue(new PanelStats(), "Stats", 450, 250);
            }
        });

        //Écouteur pour le bouton Message
        btnLog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                nouveauDialogue(new PanelLog(), "Log", 400, 250);
            }
        });

        //Écouteur pour le bouton Objectif
        btnGoal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                nouveauDialogue(new PanelGoal(), "Goal", 450, 250);
            }
        });

        //Ajout des Listener aux boutons
        EcouteurUniversel ecoUni = new EcouteurUniversel();
        btnMenu.addKeyListener(ecoUni);
        btnStats.addKeyListener(ecoUni);
        btnLog.addKeyListener(ecoUni);
        btnGoal.addKeyListener(ecoUni);
        labBois.addKeyListener(ecoUni);
        labOr.addKeyListener(ecoUni);
        labNourriture.addKeyListener(ecoUni);
        barreMenu.addKeyListener(ecoUni);
        panRessources.addKeyListener(ecoUni);
    }

    //
    public class EcouteurUniversel implements KeyListener {

        public void keyPressed(KeyEvent e) {
        }
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                nouveauDialogue(new PanelMenu(), "Menu", 300, 400);
            }
            if (e.getKeyCode() == KeyEvent.VK_P) {
                nouveauDialogue(new PanelMenu(), "Menu", 300, 400);
            }
            if (e.getKeyCode() == KeyEvent.VK_F1) {
                nouveauDialogue(new PanelStats(), "Stats", 450, 250);
            }
            if (e.getKeyCode() == KeyEvent.VK_F2) {
                nouveauDialogue(new PanelLog(), "Log", 400, 250);
            }
            if (e.getKeyCode() == KeyEvent.VK_F3) {
                nouveauDialogue(new PanelGoal(), "Goal", 450, 250);
            }
        }

        public void keyTyped(KeyEvent e) {
        }
    }

    // Methodes specifiques
    public void nouveauDialogue(JPanel unPanneau, String unTitre, int largeur, int hauteur) {
        new BoitesDialogue(unPanneau, unTitre, largeur, hauteur);
    }

    //MAIN POUR TESTER
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1200, 600);
        frame.add(new BarreDeMenu());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
