
/*Cette classe sert à ajouter les différents pannels dans un même frame lorsque
 la partie commence. Elle crée l'interface utilisée lors d'une partie (Lorsque nous somme en
 train de jouer)*/
package vue;

import controleur.Informateur;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.*;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import vue.Jeu.StateHandler;
import vue.PanneauxInterface.*;

/**
 *
 * @author Christo
 */
public class UnePartie extends JFrame {

    //Constructeur
    public UnePartie() throws SlickException {
        this.setTitle("Chantier en construction...");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        int hauteurEcran = Toolkit.getDefaultToolkit().getScreenSize().height;
        int largeurEcran = Toolkit.getDefaultToolkit().getScreenSize().width;
        this.setSize(largeurEcran, hauteurEcran);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setUndecorated(true);
        // initialisations
        // Donnees membres

        // graphique
        initComponents();
        // evenementielles
        initListeners();

    }

    //Initialisation
    public void initComponents() throws SlickException {
        try {
            AppGameContainer container = new AppGameContainer(new StateHandler("Jeu"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public void initListeners() {

    }

    // Zone de test
    public static void main(String[] args) throws SlickException {
        UnePartie test = new UnePartie();
        test.setVisible(true);
    }
}
