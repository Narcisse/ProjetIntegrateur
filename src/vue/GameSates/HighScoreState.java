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
public class HighScoreState extends BasicGameState {

    // *************************************************************************
    // Donnee membres

    public static final int ID = 4;
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
        this.background = new Image("data/UI/FondEcran.png");
        this.highScoreListe=new ArrayList<String>();
        try{
            highScoreFile = new BufferedReader(new FileReader("HighScores//HighScore.txt"));
            while ((uneLigne = highScoreFile.readLine())!= null) {
                highScoreListe.add(uneLigne+"");
            }
            highScoreListe2 = new ArrayList<Integer>(highScoreListe.size()); 
            for (String myInt : highScoreListe) 
            { 
              highScoreListe2.add(Integer.valueOf(myInt)); 
            }
                Collections.sort(highScoreListe2);
                Collections.reverse(highScoreListe2);
                highScoreFile.close();
            } catch (IOException ex) {
                Logger.getLogger(HighScoreState.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        for (int i = 0; i < highScoreListe2.size(); i++) {
            chainString+=(i+1)+". "+highScoreListe2.get(i)+"\n";     
        }
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

        background.draw(0, 0, gc.getWidth(), gc.getHeight());

        g.setColor(Color.white);
        int x = Informateur.largeurEcran / 2;
        int y = Informateur.hauteurEcran / 2;
        g.drawString("R. Retour", x, y);
        g.drawString("E. Effacer", x, y+40);
        g.drawString(chainString, x, y+80);                 
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {

    }

    public void keyReleased(int key, char c) {
        switch (key) {
            case Input.KEY_R:
                game.enterState(MenuPrincipal.ID);
                break;
            case Input.KEY_E:
        {
            try {
                highScoreEffacer = new BufferedWriter(new FileWriter("HighScores//HighScore.txt"));
            } catch (IOException ex) {
                Logger.getLogger(HighScoreState.class.getName()).log(Level.SEVERE, null, ex);
            }try {
                highScoreEffacer.flush();
            } catch (IOException ex) {
                Logger.getLogger(HighScoreState.class.getName()).log(Level.SEVERE, null, ex);
            }try {
                highScoreEffacer.close();
            } catch (IOException ex) {
                Logger.getLogger(HighScoreState.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
                break;
        }
    }
}