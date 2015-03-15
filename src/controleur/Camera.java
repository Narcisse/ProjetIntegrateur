package controleur;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import vue.Jeu.Joueur;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class Camera {

    // *************************************************************************
    // Donnee membre
    private Joueur personnage;
    private float xCamera, yCamera;

    // *************************************************************************
    // Constructeur
    public Camera(Joueur unJoueur) {
        this.personnage = unJoueur;
        this.xCamera = personnage.getX();
        this.yCamera = personnage.getY();
    }

    // *************************************************************************
    // Methodes d'affichage
    public void place(GameContainer container, Graphics g) {
        g.translate(container.getWidth() / 2 - (int) this.xCamera, container.getHeight() / 2 - (int) this.yCamera);
        //g.translate( -personnage.getX() - 80 + container.getWidth() / 2, -personnage.getY() - 80 + container.getHeight() / 2);
       
    }

    // *************************************************************************
    // Mise a jour de la camera
    public void update(GameContainer container) {
        int w = container.getWidth() / 4;
        if (this.personnage.getX() > this.xCamera + w) {
            this.xCamera = this.personnage.getX() - w;
        } else if (this.personnage.getX() < this.xCamera - w) {
            this.xCamera = this.personnage.getX() + w;
        }
        int h = container.getHeight() / 4;
        if (this.personnage.getY() > this.yCamera + h) {
            this.yCamera = this.personnage.getY() - h;
        } else if (this.personnage.getY() < this.yCamera - h) {
            this.yCamera = this.personnage.getY() + h;
        }
        // Redefinition des coordonnees de la camera si elle depasse de la map
        if (xCamera - container.getWidth()/2 < 0){
            xCamera = container.getWidth()/2;
        }
        if (yCamera - container.getHeight()/2 <0){
            yCamera = container.getHeight()/2;
        }
        if (xCamera + container.getWidth()/2 > 3200){
            xCamera = 3200 - container.getWidth()/2;
        }
        if (yCamera + container.getHeight()/2 > 3200){
            yCamera = 3200 - container.getHeight()/2;
        }
        
    }
    
    public float getX(){
        return xCamera;
    }
    
    public float getY(){
        return yCamera;
    }
}
