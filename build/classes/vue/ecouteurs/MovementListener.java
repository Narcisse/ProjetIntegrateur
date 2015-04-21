package vue.ecouteurs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import vue.ElementsVisuels.UniteVue;

/**
 *
 * @author Hubris
 */
public class MovementListener implements KeyListener {

    // *************************************************************************
    // Donnees membres
    private int valeurDeplacement = 7;
    private ArrayList<UniteVue> paysans;

    // *************************************************************************
    // Constructeurs
    public MovementListener(ArrayList<UniteVue> paysans) {
        this.paysans = paysans;
    }

    
    // *************************************************************************
    // Écouteurs
    @Override
    public void keyPressed(KeyEvent e) {
        for (UniteVue u : paysans) {
            if (u.getSelectionner() == true) {
                // Déplacement de un vers la droite
                if (e.getKeyCode() == KeyEvent.VK_RIGHT
                        || e.getKeyChar() == 'd') {
                    u.deplacement(valeurDeplacement, 0);
                    u.repaint();
                }
                // Déplacement de un vers la gauche
                if (e.getKeyCode() == KeyEvent.VK_LEFT
                        || e.getKeyChar() == 'a') {
                    u.deplacement(-valeurDeplacement, 0);
                    u.repaint();
                }
                // Déplacement de un vers le haut
                if (e.getKeyCode() == KeyEvent.VK_UP
                        || e.getKeyChar() == 'w') {
                    u.deplacement(0, -valeurDeplacement);
                    u.repaint();
                }
                // Déplacement de un vers le bas
                if (e.getKeyCode() == KeyEvent.VK_DOWN
                        || e.getKeyChar() == 's') {
                    u.deplacement(0, valeurDeplacement);
                    u.repaint();
                }
            // Déplacements en diagonale
                // à venir...
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
