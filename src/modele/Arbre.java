package modele;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Christo
 */
public class Arbre extends ElementDecor {
    // *************************************************************************
    // Donnees membre
    private String fichierImageAvant = "images\\sprite\\arbre1.png";
    private Image imgAvant = new ImageIcon(fichierImageAvant).getImage();
    private String fichierImageApres = "images\\sprite\\piskelSouche.png";
    private Image imgApres = new ImageIcon(fichierImageApres).getImage();
    private Arbre cetArbre;
    // *************************************************************************
    // Constructeur
    public Arbre() {
        super(Ressource.BOIS, 10);
        initComponents();
    }

    // *************************************************************************
    // Methodes specifiques
    public void initComponents(){
        super.setImageAvantClick(imgAvant);
        super.setImageApresClick(imgApres);
        super.setImagePeinturer(imgAvant);
        cetArbre = this;
    }
    public void paintComponent(Graphics g) {
        //On choisit une couleur de fond pour le rectangle
        g.setColor(new Color(0, 0, 0, 0));
        //On le dessine de sorte qu'il occupe toute la surface
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.drawImage(super.getImage(), 0, 0, null);
    }
    
}
