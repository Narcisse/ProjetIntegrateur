package controleur;

import java.awt.Point;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import vue.Jeu.Joueur;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class ControlleurPersonnage implements MouseListener {

    // *************************************************************************
    // Donnee membres
    private Joueur personnage;
    private GameContainer container;
    private Camera camera;

    // *************************************************************************
    // Constructeur
    public ControlleurPersonnage(Joueur unJoueur, GameContainer container, Camera uneCamera) {
        this.personnage = unJoueur;
        this.container = container;
        this.camera = uneCamera;
    }

    // *************************************************************************
    // Methodes implementes
    @Override
    public void setInput(Input input) {

    }

    @Override
    public boolean isAcceptingInput() {
        return true;
    }

    @Override
    public void inputEnded() {

    }

    @Override
    public void inputStarted() {

    }

    @Override
    public void mouseWheelMoved(int i) {
    }

    @Override
    public void mouseClicked(int i, int i1, int i2, int i3) {
    }

    @Override
    public void mousePressed(int button, int x, int y) {
        if (button == 1 && personnage.isSelected()) {
            Point mousePos = Informateur.getMousePosition(camera, container);
            if (this.personnage.getX() < x) {
                this.personnage.setDirection(3);
                this.personnage.setMoving(true);
                this.personnage.setxDest(mousePos.x);
            }
            if (this.personnage.getX() > x){
                this.personnage.setDirection(1);
                this.personnage.setMoving(true);
                this.personnage.setxDest(mousePos.x);
            }
            if (this.personnage.getY() > y){
                this.personnage.setDirection(0);
                this.personnage.setMoving(true);
                this.personnage.setyDest(mousePos.y);
            }
            if (this.personnage.getY() < y){
                this.personnage.setDirection(2);
                this.personnage.setMoving(true);
                this.personnage.setyDest(mousePos.y);
            }
            System.out.println("Dest x: " + mousePos.x);
            System.out.println("Dest y: " + mousePos.y);
        }
    }

    @Override
    public void mouseReleased(int i, int i1, int i2) {
    }

    @Override
    public void mouseMoved(int i, int i1, int i2, int i3) {
    }

    @Override
    public void mouseDragged(int i, int i1, int i2, int i3) {
    }
}
