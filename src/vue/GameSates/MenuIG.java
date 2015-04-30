package vue.GameSates;

import controleur.Camera;
import controleur.Informateur;
import java.awt.Point;
import org.newdawn.slick.*;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;


/**
 *
 * @author usager
 */
public class MenuIG extends AbstractComponent implements MouseListener{

    private Image cadre,bouton;
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
        cadre = new Image("images\\background250x375.png");
        bouton = new Image("images\\jbutton\\piskelButtonVide.png");
        input = container.getInput();
        j = new Graphics();
    }

    public void render(Graphics g) {
        g.setColor(Color.black);
        //Cadre
        g.drawImage(this.cadre, this.camera.getX() - (cadre.getWidth() / 2), this.camera.getY() - (this.cadre.getHeight() / 2));
        //bouton Retour
        g.drawImage(bouton, this.camera.getX() - (cadre.getWidth() / 2) + 65, this.camera.getY() - (this.cadre.getHeight() / 2) + 20);
        g.drawString("Retour", this.camera.getX() - (cadre.getWidth() / 2) + 95, this.camera.getY() - (this.cadre.getHeight() / 2) + 70);
        //bouton Aide
        g.drawImage(bouton, this.camera.getX() - (cadre.getWidth() / 2) + 65, this.camera.getY() - (this.cadre.getHeight() / 2) + 100);
        g.drawString("Aide", this.camera.getX() - (cadre.getWidth() / 2) + 105, this.camera.getY() - (this.cadre.getHeight() / 2) + 150);
        //bouton Menu
        g.drawImage(bouton, this.camera.getX() - (cadre.getWidth() / 2) + 65, this.camera.getY() - (this.cadre.getHeight() / 2) + 180);
        g.drawString("Menu", this.camera.getX() - (cadre.getWidth() / 2) + 105, this.camera.getY() - (this.cadre.getHeight() / 2) + 230);
        //Bouton Quitter
        g.drawImage(bouton, this.camera.getX() - (cadre.getWidth() / 2) + 65, this.camera.getY() - (this.cadre.getHeight() / 2) + 260);
        g.drawString("Quitter", this.camera.getX() - (cadre.getWidth() / 2) + 95, this.camera.getY() - (this.cadre.getHeight() / 2) + 310); 
    }

   
    @Override
    public void mouseWheelMoved(int i) {
    }

    @Override
    public void mouseClicked(int i, int i1, int i2, int i3) {
    }

    @Override
    public void mousePressed(int button, int i1, int i2) {
        int imageHeight = this.bouton.getHeight();
        int imageWidth = this.bouton.getWidth();
        
        Rectangle imageRetour = new Rectangle(this.camera.getX() - (cadre.getWidth() / 2) + 65, this.camera.getY() - (this.cadre.getHeight() / 2) + 20, imageWidth, imageHeight);
        Rectangle imageAide = new Rectangle(this.camera.getX() - (cadre.getWidth() / 2) + 65, this.camera.getY() - (this.cadre.getHeight() / 2) + 100, imageWidth, imageHeight);
        Rectangle imageMenu = new Rectangle(this.camera.getX() - (cadre.getWidth() / 2) + 65, this.camera.getY() - (this.cadre.getHeight() / 2) + 180, imageWidth, imageHeight);
        Rectangle imageQuitter = new Rectangle(this.camera.getX() - (cadre.getWidth() / 2) + 65, this.camera.getY() - (this.cadre.getHeight() / 2) + 260, imageWidth, imageHeight);

        
        Point mousePos = Informateur.getMousePosition(camera, container);
        
        //Écouteur bouton Retour
        //Écouteur bouton Aide
        //Écouteur bouton Menu
        
        //Écouteur bouton Quitter
        if (button == 0 && imageQuitter.contains(mousePos.x, mousePos.y)){
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
