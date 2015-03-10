package vue.PanneauxInterface;

import controleur.Camera;
import controleur.ControlleurPersonnage;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import vue.Jeu.Carte;
import vue.Jeu.Joueur;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class PlancheDeJeu extends BasicGame {

    // *************************************************************************
    // Donnees membres

    private GameContainer container;
    private Carte cartePrincipale;
    // Personnage
    private Joueur personnage;
    // Controlleurs (ecouteurs)
    ControlleurPersonnage ecoPerso;
    // Camera
    private Camera camera;

    // *************************************************************************
    // Constructeur
    public PlancheDeJeu() {
        super("WindowGame");
        cartePrincipale = new Carte();
        personnage = new Joueur(cartePrincipale);
        ecoPerso = new ControlleurPersonnage(personnage);
        camera = new Camera(personnage);
    }

    // *************************************************************************
    // Constructeur
    public void init(GameContainer container) throws SlickException {
        // Jeu et carte
        this.container = container;
        this.cartePrincipale.init();
        // Personnage
        this.personnage.init();
        // Ecouteur
        container.getInput().addKeyListener(ecoPerso);
    }

    public void render(GameContainer container, Graphics g) throws SlickException {
        this.camera.place(container, g);
        this.cartePrincipale.renderArrierePlan();
        this.personnage.render(g);
        this.cartePrincipale.renderAvantPlan();
    }

    public void update(GameContainer container, int delta) throws SlickException {
        this.personnage.update(delta);
        this.camera.update(container);
    }

    // *************************************************************************
    // Ecouteurs
    

    // *************************************************************************
    // Main
    public static void main(String[] args) throws SlickException {
        new AppGameContainer(new PlancheDeJeu(), 800, 800, false).start();
    }
}
