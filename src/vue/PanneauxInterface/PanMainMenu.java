package vue.PanneauxInterface;

/**
 * Fait partie du CardLayout du menu Carte no.1 , affiche les bouton du menu
 */
import controleur.DonneesUtiles;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import vue.UnePartie;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class PanMainMenu extends JPanel {

    private JButton btnMulti, btnSingle, btnCredits, btnOptions, btnQuit, btnTutoriel;
    private JPanel panMainMenu;
    private URL url;
    private AudioClip sound;
    private CardLayout cLayout;
    private Image img;
    private JFrame frame;
    private ImageIcon swap2;
    private Image swap;

    public PanMainMenu(Image img, CardLayout cLayout, JFrame uneFrame) {

        //Données Membres
        super();
        swap = img.getScaledInstance(DonneesUtiles.largeurEcran, DonneesUtiles.hauteurEcran, Image.SCALE_SMOOTH);
        swap2 = new ImageIcon(swap);
        this.img = swap;
        this.cLayout = cLayout;
        this.frame = uneFrame;
        initComponents();
        initListeners();

    }

    // initialisations
    public void initComponents() {
        panMainMenu = new JPanel(new GridLayout(6, 1, 0, 30));
        btnMulti = new JButton("Multijoueur");
        btnSingle = new JButton("Campagne");
        btnCredits = new JButton("Crédits");
        btnOptions = new JButton("Options");
        btnQuit = new JButton("Quitter");
        btnTutoriel = new JButton("Tutoriel");

        btnQuit.setPreferredSize(new Dimension(100, 100));
        btnMulti.setPreferredSize(new Dimension(100, 100));
        btnCredits.setPreferredSize(new Dimension(100, 100));
        btnOptions.setPreferredSize(new Dimension(100, 100));
        btnSingle.setPreferredSize(new Dimension(100, 100));
        btnTutoriel.setPreferredSize(new Dimension(100, 100));

        panMainMenu.add(btnSingle);
        panMainMenu.add(btnMulti);
        panMainMenu.add(btnOptions);
        panMainMenu.add(btnTutoriel);
        panMainMenu.add(btnCredits);
        panMainMenu.add(btnQuit);

        panMainMenu.setBackground(new Color(0, 0, 0, 0));
        add(panMainMenu, BorderLayout.CENTER);
        add(new JLabel(), BorderLayout.WEST);
        add(new JLabel(), BorderLayout.EAST);
        add(new JLabel(), BorderLayout.NORTH);
        add(new JLabel(), BorderLayout.SOUTH);
        jouerEnBoucle();
    }

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

    public void initListeners() {
        //Ecouteur
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

        btnMulti.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Version à venir...");

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

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

}
