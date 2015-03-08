package vue.PanneauxInterface;

import controleur.DonneesUtiles;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
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
    private JButton btnBut, btnRessources, btnMovement, btnBatiment, btnEnnemi,
            btnRetour;
    private JPanel panTutoriel;
    private JFrame frame;
    private Categorie categorie;
    private CardLayout cLayout;
    private Image img;

    //Constructeur
    public PanTutoriel(Image img, CardLayout cLayout) {
        super();
        //Image de fond
        Image swap = img.getScaledInstance(DonneesUtiles.largeurEcran,
                DonneesUtiles.hauteurEcran, Image.SCALE_SMOOTH);
        ImageIcon swap2 = new ImageIcon(swap);
        this.img = swap;
        //CardLayout
        this.cLayout = cLayout;
        this.setBackground(new Color(0, 0, 0, 0));
        //Ajout des méthodes
        initComponents();
        initListener();
    }

    //initialisation des Données membres
    public void initComponents() {
        panTutoriel = new JPanel(new GridLayout(6, 1, 10, 55));
        btnBut = new JButton("Objectif");
        btnRessources = new JButton("Ressources");
        btnMovement = new JButton("Mouvement");
        btnBatiment = new JButton("Batiment");
        btnEnnemi = new JButton("Ennemi");
        btnRetour = new JButton("Retour");

        this.add(btnBut);
        this.add(btnRessources);
        this.add(btnMovement);
        this.add(btnBatiment);
        this.add(btnEnnemi);
        this.add(btnRetour);
        this.setBackground(new Color(0, 0, 0, 0));
    }

    //initialisation des ActionListener
    public void initListener() {
        btnBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                cLayout.show(getParent(), PanMenuPrincipal.CARTE_OBJECTIF);
                revalidate();
            }
        });

        btnRessources.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Tutoriel décrivant le principe des ressources");
            }
        });

        btnMovement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Tutoriel décrivant comment se déplacer dans le jeu");
            }
        });

        btnBatiment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Tutoriel décrivant le principe des batiments");
            }
        });

        btnEnnemi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Tutoriel décrivant le principe des ennemis");
            }
        });

        btnRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                cLayout.show(getParent(), PanMenuPrincipal.CARTE_MENU_PRINCIPALE);
            }
        });
    }

    //Ajout des composants graphiques
    public void paintComponent(Graphics g) {
        //Ajout de l'image de fond
        g.drawImage(img, 0, 0, null);
    }
}
