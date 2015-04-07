package vue.Hud;

import controleur.Camera;
import controleur.Informateur;
import java.awt.Point;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.*;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class Hud extends AbstractComponent implements MouseListener {

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

    // Le Hud
    private Hud unHud;

    public Hud(GUIContext container, Camera uneCamera, GameContainer unContainer) throws SlickException {
        super(container);
        this.container = unContainer;
        this.camera = uneCamera;
        init();
    }

    public void init() throws SlickException {
        // Initialisation des images
        this.playerbars = new Image("data/Hud/barreVie.png");
    }

    public void render(Graphics g) {
        g.resetTransform();
        g.drawImage(this.playerbars, P_BAR_X, P_BAR_Y);
        // Implementer pour tous les rectangles (avec un tableau peut-etre
        // et une boucle for)
        int imageHeight = this.playerbars.getHeight();
        int imageWidth = this.playerbars.getWidth();
        // Utilisation des rectangles pour suivre le deplacement de la camera
        // et offrir une facon simple de detecter le clic
        Rectangle unRectangle = creerRectangles(playerbars);
        // Mise a jour des rectangles
        barreDeVie = unRectangle;        
    }
    
    public Rectangle creerRectangles(Image uneImage){
        int imageHeight = uneImage.getHeight();
        int imageWidth = uneImage.getWidth();
        // Utilisation des rectangles pour suivre le deplacement de la camera
        // et offrir une facon simple de detecter le clic
        // Mise a jour des rectangles
        return new Rectangle(camera.getX() - container.getWidth() / 2 + 10, camera.getY() - container.getHeight() / 2, imageWidth, imageHeight);
    }
    // *************************************************************************
    // Accesseurs mutateurs
    public Rectangle getBarreDeVie() {
        return barreDeVie;
    }

    public Camera getCamera() {
        return camera;
    }

    public GameContainer getContainer() {
        return container;
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
        Point mousePos = Informateur.getMousePosition(camera, container);
        // Action si la souris clique sur la barre de vie
        if (button == 0 && barreDeVie.contains(mousePos.x, mousePos.y)) {
            System.exit(0);
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
