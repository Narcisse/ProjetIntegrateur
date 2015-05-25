package vue.GameSates;

import controleur.Informateur;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class CreditState extends BasicGameState {

    // *************************************************************************
    // Donnee membres

    public static final int ID = 6;
    private String infoPartie;
    private StateBasedGame game;
    public boolean victoire;
    private GameContainer container;
    private Image background;
    private BufferedReader highScoreFile;
    private BufferedWriter highScoreEffacer;
    private ArrayList<String> highScoreListe;
    private String uneLigne="",chainString="";
    private  ArrayList<Integer> highScoreListe2;           
    // *************************************************************************
    // Constructeur

    public CreditState(String infoPartie) {
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
        this.background = new Image("data/UI/credit.png");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

        background.draw(0, 0, gc.getWidth(), gc.getHeight());

        g.setColor(Color.white);
        int x = Informateur.largeurEcran / 2;
        int y = Informateur.hauteurEcran / 2+350;
        g.drawString("R. Retour", x, y);                
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {

    }

    public void keyReleased(int key, char c) {
        switch (key) {
            case Input.KEY_R:
                game.enterState(MenuPrincipal.ID);
                break;
            
        }
    }
}