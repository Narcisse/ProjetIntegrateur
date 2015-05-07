package vue.composants;

/**
 *
 * @author Olivier
 */
import controleur.Informateur;
import javax.swing.*;
import java.awt.*;

public class Bouton extends JLabel {
    
    private String texte;
    private final ImageIcon img = new ImageIcon("images//jbutton//piskelButtonVide.png");
    
    public Bouton(String txt){
        super(txt);
        setFont(new Font("Arial", Font.BOLD, 14));
        setIcon(img);
        setHorizontalTextPosition(CENTER);
        setBackground(Informateur.invisibilityCloak);
    }
}

