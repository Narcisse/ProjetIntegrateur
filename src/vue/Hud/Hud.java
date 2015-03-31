package vue.Hud;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class Hud implements MouseListener{
    private static final int P_BAR_X = 10;
    private static final int P_BAR_Y = 10;

    private Image playerbars;

    public void init() throws SlickException {
        this.playerbars = new Image("data/Hud/barreVie.png");
    }

    public void render(Graphics g) {
        g.resetTransform();
        g.drawImage(this.playerbars, P_BAR_X, P_BAR_Y);
        g.drawRect(600, 650, 30, 40);
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
        /*Bouton pour sortir de la frame (pour le moment le bouton va de la 
        * position x= 20 a 60 et y = 20 a 65.
        */
        if ((button == 0) && (i1>20 && i1<60) && (i2>20 && i2<65)){
            System.exit(0);
        }
        //System.out.println("PosX : "+i1 + " ; PaosY: "+ i2);
        
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
}
