package vue.GameSates;

import controleur.Informateur;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
    private ArrayList<String> highScoreListe;
    private int espace=40;
    private String uneLigne="",score1,score2,score3,score4,score5;
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
                highScoreFile.close();
            } catch (IOException ex) {
                Logger.getLogger(HighScoreState.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        for (int i = 0; i < highScoreListe.size(); i++) {
            score1=highScoreListe.get(0);
            score2=highScoreListe.get(1);
            score3=highScoreListe.get(2);
            score4=highScoreListe.get(3);
            score5=highScoreListe.get(4);       
        } 
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

        background.draw(0, 0, gc.getWidth(), gc.getHeight());

        g.setColor(Color.white);
        int x = Informateur.largeurEcran / 2;
        int y = Informateur.hauteurEcran / 2;
        g.drawString("1. Retour", x, y);
        g.drawString("1. "+score1, x, y+40);
        g.drawString("2. "+score2, x, y+80);
        g.drawString("3. "+score3, x, y+120);
        g.drawString("4. "+score4, x, y+160);
        g.drawString("5. "+score5, x, y+200);
        
               
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