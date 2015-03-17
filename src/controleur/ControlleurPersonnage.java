<<<<<<< HEAD
package controleur;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.MouseListener;
import vue.Jeu.Joueur;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class ControlleurPersonnage implements KeyListener, MouseListener {

    // *************************************************************************
    // Donnee membres
    private Joueur personnage;
    private GameContainer container;

    // *************************************************************************
    // Constructeur
    public ControlleurPersonnage(Joueur unJoueur, GameContainer container) {
        this.personnage = unJoueur;
        this.container = container;
    }

    // *************************************************************************
    // Methodes implementes
    @Override
    public void keyPressed(int key, char c) {
        if (personnage.isSelected()) {
            switch (key) {
                case Input.KEY_UP:
                    this.personnage.setDirection(0);
                    this.personnage.setMoving(true);
                    break;
                case Input.KEY_LEFT:
                    this.personnage.setDirection(1);
                    this.personnage.setMoving(true);
                    break;
                case Input.KEY_DOWN:
                    this.personnage.setDirection(2);
                    this.personnage.setMoving(true);
                    break;
                case Input.KEY_RIGHT:
                    this.personnage.setDirection(3);
                    this.personnage.setMoving(true);
                    break;
            }
        }
    }

    @Override
    public void keyReleased(int key, char c) {
        this.personnage.setMoving(false);
    }

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
            if (this.personnage.getX() < x) {
                this.personnage.setDirection(3);
                this.personnage.setMoving(true);
                this.personnage.setxDest(x);
            }
            if (this.personnage.getX() > x){
                this.personnage.setDirection(1);
                this.personnage.setMoving(true);
                this.personnage.setxDest(x);
            }
            if (this.personnage.getY() > y){
                this.personnage.setDirection(0);
                this.personnage.setMoving(true);
                this.personnage.setyDest(y);
            }
            if (this.personnage.getY() < y){
                this.personnage.setDirection(2);
                this.personnage.setMoving(true);
                this.personnage.setyDest(y);
            }
            System.out.println("Dest x: " + x);
            System.out.println("Dest y: " + y);
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
=======
package controleur;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.geom.Rectangle;
import vue.Jeu.Joueur;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class ControlleurPersonnage implements KeyListener, MouseListener {

    // *************************************************************************
    // Donnee membres
    private GameContainer container;
    private Joueur personnage;

    // *************************************************************************
    // Constructeur
    public ControlleurPersonnage(Joueur unJoueur, GameContainer container) {
        this.personnage = unJoueur;
        this.container = container;
    }

    // *************************************************************************
    // Methodes implementes
    @Override
    public void keyPressed(int key, char c) {
        if (personnage.isSelected()) {
            switch (key) {
                case Input.KEY_UP:
                    this.personnage.setDirection(0);
                    this.personnage.setMoving(true);
                    break;
                case Input.KEY_LEFT:
                    this.personnage.setDirection(1);
                    this.personnage.setMoving(true);
                    break;
                case Input.KEY_DOWN:
                    this.personnage.setDirection(2);
                    this.personnage.setMoving(true);
                    break;
                case Input.KEY_RIGHT:
                    this.personnage.setDirection(3);
                    this.personnage.setMoving(true);
                    break;
            }
        }
    }

    @Override
    public void keyReleased(int key, char c) {
        this.personnage.setMoving(false);
    }

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
    public void mousePressed(int i, int i1, int i2) {       
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
>>>>>>> origin/master
