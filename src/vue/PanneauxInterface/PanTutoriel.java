package vue.PanneauxInterface;

import controleur.DonneesUtiles;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import modele.Categorie;

/**
 *
 * @author OlivierSSD & Guillaume Paneau Tutoriel qui fait afficher les
 * categorie General du tutoriel. Les actionsListener créés un objet de type
 * Categorie (classe modele) pour etre utilisé dans panelCategorie.
 *
 */
public class PanTutoriel extends JPanel {

    //Données membres
    private JButton btnBut, btnMovement, btnRessources, btnRetour;
    private JPanel panTutoriel;
    private JFrame frame;
    private Categorie categorie;
    private CardLayout cLayout;
    private Image img;

    //Constructeur
    public PanTutoriel(Image img, CardLayout cLayout) {
        super();
        Image swap = img.getScaledInstance(DonneesUtiles.largeurEcran, DonneesUtiles.hauteurEcran, Image.SCALE_SMOOTH);
        ImageIcon swap2 = new ImageIcon(swap);
        this.img = swap;
        this.cLayout = cLayout;
        this.setBackground(new Color(0, 0, 0, 0));
        initComponents();
        initListener();
    }

    //initialisation des Données membres
    public void initComponents() {
        panTutoriel = new JPanel(new GridLayout(4, 1, 10, 55));
        btnBut = new JButton("Objectif");
        btnMovement = new JButton("Mouvement");
        btnRessources = new JButton("Ressources/Unités");
        btnRetour = new JButton("Retour");

        panTutoriel.add(btnBut);
        panTutoriel.add(btnMovement);
        panTutoriel.add(btnRessources);
        panTutoriel.add(btnRetour);
        panTutoriel.setBackground(new Color(0, 0, 0, 0));
        add(panTutoriel);
    }

    //initialisation des ActionListener
    public void initListener() {
        btnBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                //Ajoute un img afin de le passer en parametre du constructeur
                ImageIcon img = new ImageIcon("images\\chat.jpg");
                categorie = new Categorie(img, img, "chat chat", "gijsd;lgkhjsdlkghds", "gijsd;lgkhjsdlkghds");
                //créer un panelCategorie avec l'objet créé
                
            }
        });
        btnMovement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Tutoriel décrivant comment se déplacer dans le jeu");
            }
        });
        btnRessources.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Tutoriel décrivant le principe de ressources et d'unité");
            }
        });
        btnRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                cLayout.show(getParent(), PanMenuPrincipal.CARTE_MENU_PRINCIPALE);
            }
        });
    }
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}
