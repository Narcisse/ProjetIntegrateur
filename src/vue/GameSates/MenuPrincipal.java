package vue.GameSates;

import controleur.Informateur;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.openal.AL;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
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
    private Image[] leGif;
    private Animation rainingMen;
    private Music musicIntro, musicIG;
    private GameContainer container;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.game = sbg;
        
        this.background = new Image("data/UI/FondEcran.png"); 
        leGif = new Image[23];
        for(int i = 0; i < 23; i++){
            int j = i+1;
            String leString = ("data/UI/gif/sprite_"+j+".png");
            Image img = new Image(leString);
            leGif[i]=img;
        }
        rainingMen = new Animation(leGif, 60);
        
        //musicIntro = new Music("Sons/MusicIntro.wav");
        //musicIG = new Music("Sons/MusicIn.wav");
        
       /* musicIntro.play();
        if (!musicIntro.playing()) {
            musicIntro.loop();
        }*/
        
        this.container = gc;
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        background.draw(0, 0, gc.getWidth(), gc.getHeight());
        rainingMen.draw(0, 0, gc.getWidth(), gc.getHeight());
        g.setColor(Color.white);
        g.setFont(Informateur.getFont());
        g.drawString("Higher or Lower", 50, 10);

        g.drawString("1. Play Game", 50, 100);
        g.drawString("2. High Scores", 50, 120);
        g.drawString("3. Tutoriel", 50, 140);
        g.drawString("4. Crédits", 50, 160);
        g.drawString("5. Quit", 50, 180);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        
    }

    public void keyReleased(int key, char c) {
        switch (key) {
            case Input.KEY_1:
                game.enterState(Game.ID);
               // musicIntro.stop();
                //musicIG.loop();
                break;
            case Input.KEY_2:
                Informateur.enterNewState(HighScoreState.ID, container, game);
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
                Informateur.enterNewState(CreditState.ID, container, game);
                break;
            case Input.KEY_5:
                AL.destroy();
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public Music getMusicIG() {
        return musicIG;
    }
}
