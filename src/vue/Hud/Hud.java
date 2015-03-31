package vue.Hud;

import controleur.Camera;
import controleur.Informateur;
import java.awt.Point;
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
    private static final int P_BAR_X = 10;
    private static final int P_BAR_Y = 10;

    private Image playerbars;
    private Camera camera;
    private GameContainer container;

    public Hud(GUIContext container, Camera uneCamera, GameContainer unContainer) {
        super(container);
        this.container = unContainer;
        this.camera = uneCamera;
    }

    public void init() throws SlickException {
        this.playerbars = new Image("data/Hud/barreVie.png");
    }

    public void render(Graphics g) {
        g.resetTransform();
        g.drawImage(this.playerbars, P_BAR_X, P_BAR_Y);
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
        int imageHeight = this.playerbars.getHeight();
        int imageWidth = this.playerbars.getWidth();
        
        Rectangle image = new Rectangle(P_BAR_X, P_BAR_Y, imageWidth, imageHeight);
        
        Point mousePos = Informateur.getMousePosition(camera, container);
        
        if (button == 0 && image.contains(mousePos.x, mousePos.y)){
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
