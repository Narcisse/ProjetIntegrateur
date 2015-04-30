package vue.GameSates;

import java.awt.Desktop;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import menu.buttons.FontButton;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class MenuPrincipal extends BasicGameState {

    // *************************************************************************
    // Code necessaire
    public static final int ID = 0;

    private StateBasedGame game;
    private Image background;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        game = sbg;
        this.background = new Image("images/fond.jpg");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        background.draw(0, 0, gc.getWidth(), gc.getHeight());
        g.setColor(Color.white);
        g.drawString("Higher or Lower", 50, 10);

        g.drawString("1. Play Game", 50, 100);
        g.drawString("2. High Scores", 50, 120);
        g.drawString("3. Tutoriel", 50, 140);
        g.drawString("4. Quit", 50, 160);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
    }

    public void keyReleased(int key, char c) {
        switch (key) {
            case Input.KEY_1:
                game.enterState(Game.ID);
                break;
            case Input.KEY_2:
                // TODO: Implement later
                break;
            case Input.KEY_3:
                URI uri = new File("ressources/TexteTutoriel/PageHtml/Menu.htm").toURI();
                try {
                    Desktop.getDesktop().browse(uri);
                } catch (IOException ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case Input.KEY_4:
                System.exit(0);
                break;
            default:
                break;
        }
    }
}