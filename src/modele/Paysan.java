package modele;

import controleur.DonneesUtiles;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * Loic Modifier par Christo 31 Janvier: ajout des commentaires pour la doc
 * Modification des mutateurs (ajout d'arguments) Ajout d'une zone de test pour
 * voir si tout fonctionnait Je déclare ce code fermé pour la v1
 */
public class Paysan extends Unite {

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
    public Paysan() {
        super();
        setVie(100);
        setDps(10);
        setOrNecessaire(50);
        setNourritureNecessaire(5);
        this.setBackground(DonneesUtiles.invisibilityCloak);
        initListeners();
    }

    //**************************************************************************
    // Méthodes spécifiques
    public String toString() {
        return ("Une unite de base qui permet" + "\n"
                + " la récolte de ressource et le combat");
    }

    public void deplacement(int x, int y) {
        this.setLocation(this.getLocation().x + x, this.getLocation().y + y);
        this.repaint();
    }
    public void initListeners(){
        EcouteurPaysan ecoPaysan = new EcouteurPaysan();
        addMouseListener(ecoPaysan);
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
