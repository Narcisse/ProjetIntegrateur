package vue.ElementsPrincipauxDuJeu;
import controleur.Camera;
import controleur.Informateur;
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
import vue.Hud.Hud;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class Batiment {

    // *************************************************************************
    // Donnee membre
    private Cursor curseur;
    private int x,y, indic, tailleImage;
    private float visuelX, visuelY;
    private boolean isSelected = false;
    private Rectangle rectInteraction;
    private Carte carte;
    private Image batiment;
    private GameContainer container;
    private Animation imagePaysant;

    // *************************************************************************
    // Constructeur
    public Batiment(Carte uneCarte, GameContainer unContainer, int constructionX, int constructionY) throws SlickException {
        this.carte = uneCarte;
        this.container = unContainer;
        this.setX(constructionX);
        this.setY(constructionY);
        this.init();
    }
    
    public Batiment(Carte uneCarte) {
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
        
        //Chargement de l'image pour le bouton du paysant
        tailleImage = vue.Hud.Hud.tailleImagePaneauAction/3;
        imagePaysant = new Animation();
        String filePaysant = "data/sprites/people/characters_sheet.png";
        SpriteSheet uneSpriteSheet = new SpriteSheet(filePaysant, tailleImage, tailleImage);
        imagePaysant = loadAnimation(uneSpriteSheet, 1, 2);
    }
    // *************************************************************************
    // Affichage
    public void render(Graphics g) throws SlickException {
        g.drawImage(batiment,visuelX, visuelY);
        rectInteraction.setX((int)visuelX);
        rectInteraction.setY((int)visuelY);
        //render des elements graphiques quand le batiment est selectionné.
        if(this.isSelected()){
            //Render du rectangle qui entoure le batiment quand il est séléctionné.
            g.drawRect(rectInteraction.getX(), rectInteraction.getY(), rectInteraction.getWidth(), rectInteraction.getHeight());
            
            //Render du bouton paysant.
            int i = 0, j = 0;
            int positionX = vue.Hud.Hud.positionXPaneauAction + tailleImage*i;
            int positionY= vue.Hud.Hud.positionYPaneauAction + tailleImage*j;
            g.drawAnimation(imagePaysant, positionX, positionY);
        }
    }
    
    //Mise à jour
    public void update(float cameraX, float cameraY) {
        this.setVisuelX(cameraX);
        this.setVisuelY(cameraY);
    }
    
    // *************************************************************************
    // Methodes specifiques
    
    private Animation loadAnimation(SpriteSheet spriteSheet, int positionAnimationX, int positionAnimationY) {
        Animation animation = new Animation();
        animation.addFrame(spriteSheet.getSprite(positionAnimationX, positionAnimationY), 100);
        return animation;
    }
    
    //Acualisation visuel pour la camera en X
    public void setVisuelX(float cameraX){
        visuelX = x - cameraX + container.getScreenWidth()/2;
    }
    
    //Acualisation visuel pour la camera en Y
    public void setVisuelY(float cameraY){
        visuelY = y - cameraY + container.getHeight()/2;
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
    
    public void setSelection(boolean VF){
        isSelected = VF;
    }
    
    public void setContainer(GameContainer unContainer){
        this.container = unContainer;
    }
    
    public boolean isSelected(){
        return this.isSelected;
    }

    public Rectangle getRectangle(){
        return this.rectInteraction;
    }
    
}
