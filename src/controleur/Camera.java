package controleur;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import vue.Jeu.Carte;
import vue.Jeu.Joueur;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class Camera {

    // *************************************************************************
    // Donnee membre
    private Carte cartePrincipale;
    private float xCamera, yCamera;

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
        g.translate(container.getWidth() / 2 - (int) this.xCamera, container.getHeight() / 2 - (int) this.yCamera);
    }

    // *************************************************************************
    // Mise a jour de la camera
    public void update(GameContainer container) {
        int mouseX = (int) (Mouse.getX() + (this.xCamera - container.getWidth() / 2));
        int mouseY = (int) (Mouse.getY() + (this.yCamera - container.getHeight() / 2));
        int w = container.getWidth() / 6;
        if (mouseX > this.xCamera + w) {
            this.xCamera = mouseX - w;
        } else if (mouseX < this.xCamera - w) {
            this.xCamera = mouseX + w;
        }
        
        int h = container.getHeight() / 6;
        if (mouseY <= this.yCamera - h) {
            this.yCamera = mouseY + h;
        } else if (mouseY >= this.yCamera + h) {
            this.yCamera = mouseY - h;
        }
        // Redefinition des coordonnees de la camera si elle depasse de la map
        if (xCamera - container.getWidth()/2 < 0){
            xCamera = container.getWidth()/2;
        }
        if (yCamera - container.getHeight()/2 <0){
            yCamera = container.getHeight()/2;
        }
        if (xCamera + container.getWidth()/2 > cartePrincipale.getMapDimension().getWidth()){
            xCamera = 3200 - container.getWidth()/2;
        }
        if (yCamera + container.getHeight()/2 > cartePrincipale.getMapDimension().getHeight()){
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
