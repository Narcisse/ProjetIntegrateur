package vue.Jeu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class StateHandler extends StateBasedGame{
    // *************************************************************************
    // Constructeur

    public StateHandler(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        addState(new MenuPrincipal());
        addState(new Game());
        addState(new EndGameState(null));
    }
}
