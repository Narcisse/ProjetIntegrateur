package controleur;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Christo
 */
public class DonneesUtiles {

    public static int largeurEcran = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int hauteurEcran = Toolkit.getDefaultToolkit().getScreenSize().height;
    public static Image fondDecran = new ImageIcon("images\\fond.jpg").getImage();
    public static Color invisibilityCloak = new Color(0, 0, 0, 0);

    public static Dimension placerUnPanneauAuMilieu(JPanel unPanneau, int demiLargeur, int demiHauteur) {
        return new Dimension((DonneesUtiles.largeurEcran / 2) - demiLargeur, (DonneesUtiles.hauteurEcran / 2) + demiHauteur);
    }
}
