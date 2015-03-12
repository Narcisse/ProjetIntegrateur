package vue.PanneauxInterface;

import controleur.Camera;
import controleur.ControlleurPersonnage;
import controleur.Informateur;
import java.awt.MouseInfo;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import vue.Jeu.Carte;
import vue.Jeu.Joueur;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class PlancheDeJeu extends BasicGame{

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
    // Curseur rect
    Rectangle rect;
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
        Image curseur = new Image("images/curseur.png", true);
        this.container.setMouseCursor(curseur, 0, 0);
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
        g.setColor(Color.yellow);
        rect = new Rectangle(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y, 20, 20);
        g.drawRect(rect.getX(), rect.getY() , 20, 20);
        this.cartePrincipale.renderAvantPlan();
    }

    public void update(GameContainer container, int delta) throws SlickException {
        this.personnage.update(delta);
        this.camera.update(container);
        
        int w = container.getWidth() / 4;
        if (this.personnage.getX() > rect.getX() + w) {
            rect.setX(this.personnage.getX() - w);
        } else if (this.personnage.getX() < rect.getX() - w) {
            rect.setX(this.personnage.getX() + w);
        }
        int h = container.getHeight() / 4;
        if (this.personnage.getY() > rect.getY() + h) {
            rect.setY(this.personnage.getY() - h);
        } else if (this.personnage.getY() < rect.getY() - h) {
            rect.setY(this.personnage.getY() - h);
        }
    }

    // *************************************************************************
    // Ecouteurs

    // *************************************************************************
    // Main
    public static void main(String[] args) throws SlickException {
        new AppGameContainer(new PlancheDeJeu(), 800, 800, false).start();
    }
}
