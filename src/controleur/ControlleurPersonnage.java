package controleur;

import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import vue.Jeu.Joueur;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class ControlleurPersonnage implements KeyListener{
    // *************************************************************************
    // Donnee membres
    private Joueur personnage;
    
    // *************************************************************************
    // Constructeur
    public ControlleurPersonnage(Joueur unJoueur){
        this.personnage = unJoueur;
    }
    
    // *************************************************************************
    // Methodes implementes

    @Override
    public void keyPressed(int key, char c) {
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
}
