package vue.Hud;

import controleur.Camera;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class Hud extends AbstractComponent implements MouseListener{
    
    private Image paneauAction;
    public static int positionXPaneauAction, positionYPaneauAction;
    public static int tailleImagePaneauAction;
    // Position 
    private static final int P_BAR_X = 10;
    private static final int P_BAR_Y = 10;

    // Composants du Hud
    // Haut
    private Image playerbars; // Test seulement
    private Image ressourcesBar; // Doit etre fait **
    private Image menuBar; // Doit etre fait **
    // Bas
    private Image actionBar; // Doit etre fait **
    private Image miniMap; // Doit etre fait **
    private Image informationBar; // Doit etre fait **

    // Ressources extérieures
    private Camera camera;
    private GameContainer container;

    // Rectangles correspondants aux différents composants
    // Haut
    private Rectangle barreDeVie;
    private Rectangle barreRessource;
    private Rectangle barreMenu;

    // Bas
    private Rectangle barreAction;
    private Rectangle barreMiniMap;
    private Rectangle barreInformations;

    public Hud(GUIContext container, Camera uneCamera, GameContainer unContainer) throws SlickException {
        super(container);
        this.container = unContainer;
        this.camera = uneCamera;
        init();
    }

    public void init() throws SlickException {
        this.playerbars = new Image("images//jbutton//buttonVide.png");
        this.paneauAction = new Image("images//romanStone.jpg");
    }
    
    public void render(Graphics g) {
        int imageHeight = this.playerbars.getHeight();
        int imageWidth = this.playerbars.getWidth();
        
        g.resetTransform();
        //PANEAU ACTION JOUEUR 
        int hauteurFrameY= container.getHeight();
        int largeurFrameX= container.getWidth();
        int tailleImageX = largeurFrameX/4;
        int tailleImageY = hauteurFrameY/4;
        if(tailleImageX < tailleImageY){
            tailleImagePaneauAction = tailleImageX;
        }else{
            tailleImagePaneauAction = tailleImageY;
        }  
        positionXPaneauAction = largeurFrameX - tailleImagePaneauAction - 10;
        positionYPaneauAction = hauteurFrameY - tailleImagePaneauAction - 10;
        
        paneauAction.draw(positionXPaneauAction, positionYPaneauAction, tailleImagePaneauAction, tailleImagePaneauAction);
       /* 
        //BOUTON QUITTER
        g.drawImage(this.playerbars, P_BAR_X, P_BAR_Y);
        //String "Quitter sur le bouton en au à gauche
        g.setColor(Color.green);
        g.drawString("Quitter", P_BAR_X+20, P_BAR_Y+imageHeight/2);
        */
    }
    
    
    // *************************************************************************
    // Ecouteurs

    @Override
    public void mouseWheelMoved(int i) {
    }

    @Override
    public void mouseClicked(int i, int i1, int i2, int i3) {
    }

    @Override
    public void mousePressed(int button, int i1, int i2) {
        /*int imageHeight = this.playerbars.getHeight();
        int imageWidth = this.playerbars.getWidth();
        
        Rectangle image = new Rectangle(P_BAR_X, P_BAR_Y, imageWidth, imageHeight);
        
        if (button == 0 && image.contains(i1, i2)){
            System.exit(0);
        }*/
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
    public void render(GUIContext guic, Graphics grphcs) throws SlickException {
    }

    @Override
    public void setLocation(int i, int i1) {
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }
}
