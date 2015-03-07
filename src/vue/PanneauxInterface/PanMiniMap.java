package vue.PanneauxInterface;

/**
 * Panneau dans le jeux qui affiche des informations
 * La mini carte, etc...
 * Change d'information avec un raccourci
 * Situé en bas à gauche du jeu
 */

import java.awt.*;
import javax.swing.*;

public class PanMiniMap extends JPanel {

    //Donnees membres
    private Image img_miniMap;
    private JTextArea txtArea_message;
    private int largeur, hauteur;

    //Constructeur
    public PanMiniMap(Image uneImage) {
        // cherche l'image du logo et la met dans la variable img_logo
        img_miniMap = uneImage;

    }
    
    // Zone de texte dans le milieu du panneau
    public PanMiniMap(JTextArea unJTxtArea) {
        setLayout(new BorderLayout());
        txtArea_message = unJTxtArea;
        this.add(txtArea_message, BorderLayout.CENTER);
    }

    //methode paintComponent 
    public void paintComponent(Graphics g) {
        if (img_miniMap != null) {
            largeur = this.getWidth();
            hauteur = this.getHeight();
            g.drawImage(img_miniMap, 0, 0, largeur, hauteur, this);
        }

    }

    //Methodes spécifiques
    //Classe test
    public static void main(String[] args) {
        Toolkit unToolkit = java.awt.Toolkit.getDefaultToolkit();
        Image uneImage = unToolkit.getImage("image//Logo.png");
            //creer un Pan_MiniMap avec une image
        //JPanel unpan = new Pan_MiniMap(uneImage);

        //creer une Pan_MiniMap avec un JTextArea
        JPanel unpan = new PanMiniMap(new JTextArea("test"));

        JFrame uneFrame = new JFrame();
        uneFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        uneFrame.setSize(500, 500);

        uneFrame.add(unpan);
        uneFrame.setVisible(true);
    }
}
