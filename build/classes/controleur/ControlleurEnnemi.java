package controleur;

import java.awt.Point;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import vue.ElementsPrincipauxDuJeu.Ennemi;
import vue.ElementsPrincipauxDuJeu.Joueur;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class ControlleurEnnemi implements MouseListener {

    // *************************************************************************
    // Donnee membres
    private Ennemi ennemi;
    private GameContainer container;
    private Camera camera;

    // *************************************************************************
    // Constructeur
    public ControlleurEnnemi(Ennemi unEnnemi, GameContainer container, Camera uneCamera) {
        this.ennemi = unEnnemi;
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
        if (button == 0) {
            Point mousPos = Informateur.getMousePosition(camera, container);
            if (ennemi.getRectangle().contains(mousPos.x, mousPos.y)){
                ennemi.removeHP(10);
                System.out.println(ennemi.getHP());
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
