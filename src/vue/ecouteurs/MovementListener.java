package vue.ecouteurs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import vue.ElementsVisuels.UniteVue;

/**
 *
 * @author Hubris
 */
public class MovementListener implements KeyListener {
    // *************************************************************************
    // Donnees membres
    private UniteVue patientZero;
    private int valeurDeplacement = 7;
    // *************************************************************************
    // Constructeurs
    public MovementListener(UniteVue uneUnite){
        this.patientZero = uneUnite;
    }
    
    // *************************************************************************
    // Écouteurs
    @Override
    public void keyPressed(KeyEvent e) {
        // Test avec deux touches
        if ((e.getModifiers() == KeyEvent.VK_DOWN) && (e.getKeyCode() == KeyEvent.VK_RIGHT)) {
            patientZero.deplacement(valeurDeplacement, valeurDeplacement);
            patientZero.repaint();
        }
        // Déplacement de un vers la droite
        if (e.getKeyCode() == KeyEvent.VK_RIGHT
                || e.getKeyChar() == 'd') {
            patientZero.deplacement(valeurDeplacement, 0);
            patientZero.repaint();
        }
        // Déplacement de un vers la gauche
        if (e.getKeyCode() == KeyEvent.VK_LEFT
                || e.getKeyChar() == 'a') {
            patientZero.deplacement(-valeurDeplacement, 0);
            patientZero.repaint();
        }
        // Déplacement de un vers le haut
        if (e.getKeyCode() == KeyEvent.VK_UP
                || e.getKeyChar() == 'w') {
            patientZero.deplacement(0, -valeurDeplacement);
            patientZero.repaint();
        }
        // Déplacement de un vers le bas
        if (e.getKeyCode() == KeyEvent.VK_DOWN
                || e.getKeyChar() == 's') {
            patientZero.deplacement(0, valeurDeplacement);
            patientZero.repaint();
        }
            // Déplacements en diagonale
        // à venir...
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
