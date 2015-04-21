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
import modele.Entrepot;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class Hud extends AbstractComponent implements MouseListener {

    private Image paneauAction;
    public static int positionXPaneauAction, positionYPaneauAction;
    public static int tailleImagePaneauAction;

    // Composants du Hud
    private Image imgBois; // image bois
    private Image imgOr; //  image Or
    private Image imgNourriture; // image nourriture
    // Bas
    private Image actionBar; // Doit etre fait **
    private Image miniMap; // Doit etre fait **
    private Image informationBar; // Doit etre fait **

    // Ressources extérieures
    private Camera camera;
    private GameContainer container;

    private Entrepot banque;

    public Hud(GUIContext container, Camera uneCamera, GameContainer unContainer) throws SlickException {
        super(container);
        this.container = unContainer;
        this.camera = uneCamera;
        init();
    }

    public void init() throws SlickException {
        banque = new Entrepot(50, 40, 30);
        this.imgNourriture = new Image("images//Icone//hamIcon.png");
        this.imgOr = new Image("images//Icone//goldicon.png");
        this.imgBois = new Image("images//Icone//bois.png");
        this.paneauAction = new Image("images//romanStone.jpg");
    }

    public void render(Graphics g) {
        //cette méthode empeche ce qui est dessiné de bouger dans l'écran  
        g.resetTransform();
        //PANEAU ACTION JOUEUR 
        int hauteurFrameY = container.getHeight();
        int largeurFrameX = container.getWidth();
        int tailleImageX = largeurFrameX / 4;
        int tailleImageY = hauteurFrameY / 4;
        if (tailleImageX < tailleImageY) {
            tailleImagePaneauAction = tailleImageX;
        } else {
            tailleImagePaneauAction = tailleImageY;
        }
        positionXPaneauAction = largeurFrameX - tailleImagePaneauAction - 10;
        positionYPaneauAction = hauteurFrameY - tailleImagePaneauAction - 10;

        paneauAction.draw(positionXPaneauAction, positionYPaneauAction, tailleImagePaneauAction, tailleImagePaneauAction);

        //On dessine l'icone de l'or avec  sa quantité
        //  g.drawImage(imgOr, 20, 20);
        g.drawString(": " + banque.getOr(), 60, 24);
        //On dessine l'icone de nourriture avec  sa quantité
        //g.drawImage(imgNourriture, 120, 20);
        g.drawString(": " + banque.getNourriture(), 160, 24);
        //On dessine l'icone de bois avec  sa quantité
        //  g.drawImage(imgBois, 220, 20);
        g.drawString(": " + banque.getBois(), 260, 24);
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

