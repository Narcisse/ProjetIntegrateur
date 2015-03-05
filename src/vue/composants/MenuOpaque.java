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
       this.setSize(DonneesUtiles.largeurEcran, DonneesUtiles.hauteurEcran);
        this.setUndecorated(true);
        this.setLayout(null);
        int panelX = ((this.getWidth() - unPanneau.getWidth() - this.getInsets().left - this.getInsets().right) / 2);
        int panelY = ((this.getHeight() - unPanneau.getHeight() - this.getInsets().top - this.getInsets().bottom) / 2);
        unPanneau.setBounds(panelX,panelY,unPanneau.getWidth(),unPanneau.getHeight());
        this.setBackground(new Color(0f, 0f, 0f, 0.8f));
        unPanneau.setBackground(new Color(0f, 0f, 0f, 0f));
        this.add(unPanneau);
        this.setVisible(true);
        
    }
    
}
