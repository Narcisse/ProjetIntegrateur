package controleur;

import java.awt.Point;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import vue.ElementsPrincipauxDuJeu.Joueur;

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
        if (button == 1) {
            Point mousPos = Informateur.getMousePosition(camera, container);
            if (this.personnage.getX() < mousPos.x) {
                this.personnage.setDirection(3);
                this.personnage.setMoving(true);
                this.personnage.setxDest(mousPos.x);
            }
            if (this.personnage.getX() > mousPos.x){
                this.personnage.setDirection(1);
                this.personnage.setMoving(true);
                this.personnage.setxDest(mousPos.x);
            }
            if (this.personnage.getY() > mousPos.y){
                this.personnage.setDirection(0);
                this.personnage.setMoving(true);
                this.personnage.setyDest(mousPos.y);
            }
            if (this.personnage.getY() < mousPos.y){
                this.personnage.setDirection(2);
                this.personnage.setMoving(true);
                this.personnage.setyDest(mousPos.y);
            }
            
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
