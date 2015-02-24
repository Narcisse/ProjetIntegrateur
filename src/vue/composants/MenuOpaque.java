/*
 * Affiche chaque panneau donné en parametre dans une frame transparente.
 * 
 */
package vue.composants;

import controleur.DonneesUtiles;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Loic
 */

public class MenuOpaque extends JFrame {
    //Données Membres
    private JPanel unPanneau;
    
    
    public MenuOpaque(JPanel unPanneau){
        super();
        initComponents(unPanneau);
        
    }
    
    public void initComponents(JPanel unPanneau){
        JFrame frame=new JFrame();
        frame.setSize(DonneesUtiles.largeurEcran, DonneesUtiles.hauteurEcran);
        frame.setUndecorated(true);
        frame.setLayout(new BorderLayout());
        frame.setBackground(new Color(0f, 0f, 0f, 0.8f));
        unPanneau.setBackground(new Color(0,0,0,0));
        unPanneau.setOpaque(false);
        frame.add(unPanneau);
        frame.setVisible(true);
        
    }
    
}
