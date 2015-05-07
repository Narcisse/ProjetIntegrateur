package vue.GameSates;

import controleur.Informateur;
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
public class HighScoreState extends BasicGameState {

    // *************************************************************************
    // Donnee membres

    public static final int ID = 4;
    private String infoPartie;
    private StateBasedGame game;
    public boolean victoire;
    private GameContainer container;
    private Image background;
    private Image imgDefaite;

    // *************************************************************************
    // Constructeur

    public HighScoreState(String infoPartie) {
        this.infoPartie = infoPartie;
    }

    @Override
    public int getID() {
        return this.ID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.container = gc;
        this.game = sbg;
        this.background = new Image("images/fond.jpg");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

        background.draw(0, 0, gc.getWidth(), gc.getHeight());

        g.setColor(Color.white);
        int x = Informateur.largeurEcran / 2;
        int y = Informateur.hauteurEcran / 2;
        g.drawString("1. Retour", x, y);
        g.drawString("2. Menu principal", x, y + 40);
        g.drawString("3. Quitter", x, y + 80);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {

    }

    public void keyReleased(int key, char c) {
        switch (key) {
            case Input.KEY_1:
                game.enterState(MenuPrincipal.ID);
                break;
        }
    }
}