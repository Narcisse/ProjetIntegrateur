package vue.ElementsVisuels;

import controleur.DonneesUtiles;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * Loic Modifier par Christo 31 Janvier
 */
public class PaysanVue extends UniteVue {

    //**************************************************************************
    // Donnees membres
    // image de paysan

    private Image imgPaysan = new ImageIcon("images\\sprite\\paysan.png").getImage();
    private final String nom = "Paysan";
    private ArrayList<JButton> btnPaysan;
    public static final String BOUTON_PAYSAN_ATTAQUER = "attaquer";
    public static final String BOUTON_PAYSAN_ARRETER = "Arreter";
    public static final String BOUTON_PAYSAN_RECOLTER = "Recolter";

    //**************************************************************************
    // Constructeur
    public PaysanVue() {
        super();
        initComponents();
        initListeners();
    }

    //**************************************************************************
    // Méthodes spécifiques
    public void initComponents(){
        setVie(100);
        setDps(10);
        setOrNecessaire(50);
        setNourritureNecessaire(5);
        this.setBackground(DonneesUtiles.invisibilityCloak);
    }
    public void initListeners(){
        EcouteurPaysan ecoPaysan = new EcouteurPaysan();
        addMouseListener(ecoPaysan);
    }
    public String toString() {
        return ("Une unite de base qui permet" + "\n"
                + " la récolte de ressource et le combat");
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
        g.drawImage(imgPaysan, 0, 0, null);
    }
    //**************************************************************************
    // Accesseurs

    public ArrayList<JButton> getBoutonsActions() {
        return this.btnPaysan;
    }

    //**************************************************************************
    // Mutateurs
    
    //**************************************************************************
    // Écouteurs
    public class EcouteurPaysan extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Touches moi pas!");
        }        
    }
}
