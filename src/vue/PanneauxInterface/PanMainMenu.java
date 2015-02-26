package vue.PanneauxInterface;

import controleur.DonneesUtiles;
import controleur.Informateur;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import vue.PanneauxInterface.PanMenuPrincipal;
import vue.UnePartie;
import vue.composants.Bouton;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class PanMainMenu extends JPanel{
    // *************************************************************************
    // Donnees membres
    private Bouton btnSingle, btnCredits, btnOptions, btnQuit, btnTutoriel;
    private Image img;
    private ImageIcon swap2;
    private Image swap;
    private JLabel panNorth, panWest, panEast, panSouth;
    private JPanel panCenter;
    private URL url;
    private AudioClip sound;
    private JFrame frame;
    private CardLayout cLayout;
    
    
    // *************************************************************************
    // Constructeur
    public PanMainMenu(Image img, CardLayout cLayout, JFrame uneFrame){
        super();
        initComponents(img, cLayout, uneFrame);
        initListeners();
    }
    
    
    // *************************************************************************
    // Methodes specifiques
    public void initComponents(Image img, CardLayout cLayout, JFrame uneFrame){
        // Initialiser l'image pour la paint en background
        swap = img.getScaledInstance(DonneesUtiles.largeurEcran, DonneesUtiles.hauteurEcran, Image.SCALE_SMOOTH);
        swap2 = new ImageIcon(swap);
        this.img = swap;
        this.cLayout = cLayout;
        this.frame = uneFrame;
        // Construire les panneaux de remplissage
        panNorth = new JLabel();
        
        panWest = new JLabel();
        
        GridBagConstraints cons = new GridBagConstraints();
        panCenter = new JPanel(new GridBagLayout());
        panCenter.setBackground(Informateur.voileSombre);
        panCenter.setBorder(BorderFactory.createLineBorder(Color.darkGray, 5, true));
        btnSingle = new Bouton("Campagne");
        btnCredits = new Bouton("Crédits");
        btnOptions = new Bouton("Options");
        btnQuit = new Bouton("Quitter");
        btnTutoriel = new Bouton("Tutoriel");
        changerContrainte(cons, 0, 0, 1, 1);
        panCenter.add(btnSingle, cons);
        changerContrainte(cons, 0, 1, 1, 1);
        panCenter.add(btnOptions, cons);
        changerContrainte(cons, 0, 2, 1, 1);
        panCenter.add(btnTutoriel, cons);
        changerContrainte(cons, 0, 3, 1, 1);
        panCenter.add(btnCredits, cons);
        changerContrainte(cons, 0, 4, 1, 1);
        panCenter.add(btnQuit, cons);
        
        panEast = new JLabel();
        
        panSouth = new JLabel();
        // Construire le gridbagLayout x,y,wx,wy
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        changerContrainte(c, 0, 0, 6, 1);
        add(panNorth, c);
        changerContrainte(c, 0, 1, 1, 3);
        add(panWest, c);
        changerContrainte(c, 1, 1, 4, 3);
        add(panCenter, c);
        changerContrainte(c, 5, 1, 1, 3);
        add(panEast, c);
        changerContrainte(c, 0, 4, 6, 1);
        add(panSouth, c);
        jouerEnBoucle();
    }
    public void initListeners(){
        btnSingle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                arreter();
                frame.dispose();
                UnePartie partie = new UnePartie();
                partie.setVisible(true);
            }
        });
        btnTutoriel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                cLayout.show(getParent(), PanMenuPrincipal.CARTE_TUTORIEL);
            }
        });
        btnCredits.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Affiche les crédits");

            }
        });
        btnOptions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                cLayout.show(getParent(), PanMenuPrincipal.CARTE_OPTIONS_JEU);
            }
        });
        btnQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                int option = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment quitter?", "Quitter?",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }

            }
        });
    }
    public void changerContrainte(GridBagConstraints c, int gridx, int gridy, int gridHeight, int gridwidth){
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridheight = gridHeight;
        c.gridwidth = gridwidth;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(5, 10, 5, 10);
    }
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
    
    
    // *************************************************************************
    // Joueur de Sons
    public void jouer() {
        url = this.getClass().getClassLoader().getResource("sons//MainMusic.wav");
        sound = Applet.newAudioClip(url);
        sound.play();
    }
    public void jouerEnBoucle() {
        url = this.getClass().getClassLoader().getResource("sons//MainMusic.wav");
        sound = Applet.newAudioClip(url);
        sound.loop();
    }
    public void arreter() {
        sound.stop();
    }
    
    
    // *************************************************************************
    // Main
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(1,1));
        frame.add(new PanMainMenu(Informateur.fondDecran, null, frame));
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    
}
