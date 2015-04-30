package vue.composants;

import controleur.Informateur;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 * @author Christo
 * Classe de JDialog perso pour afficher de faÃ§on plus clean les
 * panneaux de menu dans le jeu
 */
public class BoitesDialogue extends JDialog{
    public BoitesDialogue(JPanel unPanneau, String unTitre, int largeur, int hauteur){
        super();
        setModal(true);
        setTitle(unTitre);
        setContentPane(unPanneau);
        setSize(largeur, hauteur);
        setUndecorated(true);
        setBackground(Informateur.invisibilityCloak);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
