package vue.Jeu;
import controleur.Camera;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Cursor;
import org.lwjgl.util.Rectangle;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.opengl.CursorLoader;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class Objet {

    // *************************************************************************
    // Donnee membre
    private Cursor curseur;
    private int x,y,indic;
    private boolean isSelected = false;
    private Rectangle rectInteraction;
    private Carte carte;
    private Image batiment;
    private GameContainer container;//=new GameContainer();

    // *************************************************************************
    // Constructeur
    public Objet(Carte uneCarte) {
        this.carte = uneCarte;
    }

    // *************************************************************************
    // Initialisation
    public void init() throws SlickException {
        batiment =new Image("data/sprites/objet/TownHall.png",true);
        batiment.setRotation(180f);
        this.rectInteraction = new Rectangle();
        this.rectInteraction.setHeight(64);
        this.rectInteraction.setWidth(64);
    }
    // *************************************************************************
    // Affichage
    public void render(Graphics g) throws SlickException {
        if(x==0&&y==0){
        }else{
        g.drawImage(batiment,x,y);
        rectInteraction.setX(x);
        rectInteraction.setY(y);
        if(isSelected){
            g.drawRect(rectInteraction.getX(), rectInteraction.getY(), rectInteraction.getWidth(), rectInteraction.getHeight());
        }
        }
    }
      
    
    // *************************************************************************
    // Methodes specifiques
    public void selection(){
        if(isSelected){
            isSelected = false;
        } else{
            isSelected = true;
        }
    }
    public void notSelection(){
        isSelected=false;
    }
    
    // *************************************************************************
    // Accesseurs et mutateurs
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    
    public boolean isSelected(){
        return this.isSelected;
    }


    public Rectangle getRectangle(){
        return this.rectInteraction;
    }
}
