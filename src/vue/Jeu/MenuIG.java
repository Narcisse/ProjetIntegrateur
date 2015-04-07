package vue.Jeu;

import controleur.Camera;
import org.newdawn.slick.*;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.Input;


/**
 *
 * @author usager
 */
public class MenuIG extends AbstractComponent {

    private Image cadre;
    private Camera camera;
    private GameContainer container;
    private Input input;
    private Graphics j;

    public MenuIG(GUIContext container, Camera uneCamera, GameContainer unContainer) throws SlickException {
        super(container);
        this.container = unContainer;
        this.camera = uneCamera;
    }

    public void init() throws SlickException {
        cadre = new Image("images\\cadrepiskel.png");
        input = container.getInput();
        j = new Graphics();
    }

    public void render(Graphics g) {
        //g.resetTransform();
        g.drawImage(this.cadre, this.camera.getX() - (cadre.getWidth() / 2), this.camera.getY() - (this.cadre.getHeight() / 2));
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
    public int getHeight() {
        return this.cadre.getHeight();
    }

    @Override
    public int getWidth() {
        return this.cadre.getWidth();
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public void setLocation(int i, int i1) {
    }

    @Override
    public void render(GUIContext guic, Graphics grphcs) throws SlickException {
    }
}
