package vue.ElementsVisuels;

import controleur.DonneesUtiles;
import java.awt.*;
import javax.swing.*;
import modele.Ressource;

/**
 *
 * @author Christo & Guigui
 */
public class VacheVue extends ElementDecorVue {
    
    private Image[] tabVache = new Image[3];
    private Image imgVache1 = new ImageIcon("images\\sprite\\vache1.png").getImage();
    private Image imgVache2 = new ImageIcon("images\\sprite\\vache2.png").getImage();
    private Image imgVache3 = new ImageIcon("images\\sprite\\vache3.png").getImage();
    public static int compteur = 0;
    // Constructeur

    public VacheVue() {
        super(Ressource.NOURRITURE, 10);
        this.setBackground(DonneesUtiles.invisibilityCloak);
        tabVache[0] = imgVache1;
        tabVache[1] = imgVache2;
        tabVache[2] = imgVache3;
    }
    
    public void deplacement(int x, int y) {
        this.setLocation(this.getLocation().x + x, this.getLocation().y + y);
        this.repaint();
    }
    
    public void paintComponent(Graphics g) {
        //On choisit une couleur de fond pour le rectangle
        g.setColor(new Color(0, 0, 0, 0));
        //On le dessine de sorte qu'il occupe toute la surface
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.drawImage(tabVache[compteur], DonneesUtiles.largeurEcran/2, DonneesUtiles.hauteurEcran/2, null);
    }
    
    public Image getTabVache(int i){
        return tabVache[i];
    }
}
