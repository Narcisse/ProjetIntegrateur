package controleur;

import java.awt.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.ResourceLoader;
import vue.Attributs.*;
import vue.ElementsPrincipauxDuJeu.Carte;
import vue.ElementsPrincipauxDuJeu.Joueur;
import vue.GameSates.Game;
import vue.Jeu.Baril;


/*
 *	Christo
 *	Une classe qui peut être utilisée pour accéder à diverses informations
 *	comme la date et l'heure, la dimension de l'écran etc.
 */

public class Informateur {

    //**************************************************************************
    // Donnees d'informations generales sur le programme

    public static final Color voileSombre = new Color(0f, 0f, 0f, 0.8f);
    public static Image fondDecran = new ImageIcon("images\\fond.jpg").getImage();
    public static int largeurEcran = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int hauteurEcran = Toolkit.getDefaultToolkit().getScreenSize().height;
    public static Color invisibilityCloak = new Color(0, 0, 0, 0);
    public static int positionCurseurX = MouseInfo.getPointerInfo().getLocation().x;
    public static int positionCurseurY = MouseInfo.getPointerInfo().getLocation().y;

    // Donnees utiles aux traitements
    //private LocalTime leTemps;
    //private LocalDate laDate;
    public static boolean estDejaLa(ArrayList<Joueur> uneListe, Joueur unPerso) {
        boolean estPresent = false;
        for (int i = 0; i < uneListe.size(); i++) {
            if (uneListe.get(i).getX() == unPerso.getX() && uneListe.get(i).getY() == unPerso.getY()) {
                estPresent = true;
                break;
            }
        }
        return estPresent;
    }
    
    public static ArrayList getToutAttributs(Carte uneCarte){
        ArrayList uneListe = new ArrayList();
        try {
            uneListe.add(new Soulier(uneCarte));
            uneListe.add(new Nuke(uneCarte));
            uneListe.add(new Vie(uneCarte));
            uneListe.add(new Epee(uneCarte));
            uneListe.add(new Baril(uneCarte));
            uneListe.add(new Armure(uneCarte));
        } catch (SlickException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return uneListe;
    }
    
    public static Point getMousePosition(Camera uneCamera, GameContainer container) {
        Input input = container.getInput();
        int mouseX = ((int) (input.getMouseX() + (uneCamera.getX() - container.getWidth() / 2)));
        int mouseY = ((int) (input.getMouseY() + (uneCamera.getY() - container.getHeight() / 2)));
        return new Point(mouseX, mouseY);
    }
    
    public static void enterNewState(int StateID, GameContainer container, StateBasedGame game) {
        /*
        try {
            game.getCurrentState().leave(container, game);
        } catch (SlickException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            game.getState(StateID).enter(container, game);
        } catch (SlickException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        game.enterState(StateID);
    }

    public static  int[] getRandomCoordinates(Carte uneCarte) {
        int x = 0;
        int y = 0;

        int hauteurCarte = uneCarte.getMapDimension().getHeight();
        int largeurCarte = uneCarte.getMapDimension().getWidth();

        Random generator = new Random();

        x = 0 + generator.nextInt(largeurCarte);
        y = 0 + generator.nextInt(hauteurCarte);

        while (uneCarte.isCollision(x, y)) {
            x = 0 + generator.nextInt(largeurCarte);
            y = 0 + generator.nextInt(hauteurCarte);
            
            System.out.println("NOPE");
        }
        
        int[] t= new int[2];
        t[0]=x; t[1]= y;
        return  t;
    }
    
    public static TrueTypeFont getFont(){
        Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
        TrueTypeFont font = new TrueTypeFont(awtFont, false);
        TrueTypeFont font2 = null;

        // load font from a .ttf file
        try {
            InputStream inputStream = ResourceLoader.getResourceAsStream("data/fonts/roboto.ttf");

            Font awtFont2 = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            awtFont2 = awtFont2.deriveFont(20f); // set font size
            font2 = new TrueTypeFont(awtFont2, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return font2;
    }

}
