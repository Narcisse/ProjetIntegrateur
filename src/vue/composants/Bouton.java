/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vue.composants;

/**
 *
 * @author Olivier
 */
import javax.swing.*;
import java.awt.*;

public class Bouton extends JButton {
    
    private String texte;
    private final ImageIcon img = new ImageIcon("images//jbutton//piskelButtonVide.png");;
    
    public Bouton(String txt){
        super(txt);
        this.setFont(new Font("Arial", Font.BOLD, 14));
        this.setIcon(img);
        //On affiche le texte au centre du bouton
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        //On cache le border
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        //On fixe la taille maximale et minimal à la taille de l'icône
        this.setPreferredSize(new Dimension(img.getIconWidth(),img.getIconHeight()));
        this.setMaximumSize(new Dimension(img.getIconWidth(), img.getIconWidth()));
        this.setMinimumSize(new Dimension(img.getIconWidth(), img.getIconWidth()));
    }  
}

