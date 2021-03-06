package controleur;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import vue.ElementsPrincipauxDuJeu.Carte;
import vue.ElementsPrincipauxDuJeu.Joueur;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class Camera {

    // *************************************************************************
    // Donnee membre
    private Carte cartePrincipale;
    private float xCamera, yCamera;
    //event
    private Input input;
    private Joueur unJoueur;

    // *************************************************************************
    // Constructeur
    public Camera(Carte uneCarte) {
        this.cartePrincipale = uneCarte;
        this.xCamera = 400;
        this.yCamera = 400;
    }

    // *************************************************************************
    // Methodes d'affichage
    public void place(GameContainer container, Graphics g) {
        g.translate(container.getWidth() / 2 - (int) this.xCamera,
                container.getHeight() / 2 - (int) this.yCamera);
    }

    // *************************************************************************
    // Mise a jour de la camera
    public void update(GameContainer container, Joueur unJoueur) {
        //Event input du container
        input = container.getInput();

        //Update la position de la camera si elle se déplace vers le bord de la frame
        int mouseX = (int) (Mouse.getX() + (this.xCamera - container.getWidth() / 2));
        int mouseY = (int) (Mouse.getY() + (this.yCamera - container.getHeight() / 2));

        this.xCamera = unJoueur.getX();
        this.yCamera = unJoueur.getY();
        // Redefinition des coordonnees de la camera si elle depasse de la map
        if (xCamera - container.getWidth() / 2 < 0) {
            xCamera = container.getWidth() / 2;
        }
        if (yCamera - container.getHeight() / 2 < 0) {
            yCamera = container.getHeight() / 2;
        }
        if (xCamera + container.getWidth() / 2 > cartePrincipale.getMapDimension().getWidth()) {
            xCamera = cartePrincipale.getMapDimension().getWidth() - container.getWidth() / 2;
        }
        if (yCamera + container.getHeight() / 2 > cartePrincipale.getMapDimension().getHeight()) {
            yCamera = cartePrincipale.getMapDimension().getHeight() - container.getHeight() / 2;
        }

    }

    public float getX() {
        return xCamera;
    }

    public float getY() {
        return yCamera;
    }
}
