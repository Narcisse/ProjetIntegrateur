package controleur;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
//import org.lwjgl.util.Point;
//import java.time.*;
//import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import vue.ElementsPrincipauxDuJeu.Carte;
import vue.ElementsPrincipauxDuJeu.Joueur;
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

    public static Point getMousePosition(Camera uneCamera, GameContainer container) {
        Input input = container.getInput();
        int mouseX = ((int) (input.getMouseX() + (uneCamera.getX() - container.getWidth() / 2)));
        int mouseY = ((int) (input.getMouseY() + (uneCamera.getY() - container.getHeight() / 2)));
        return new Point(mouseX, mouseY);
    }

    public static  int[] getRandomCoordinates(Carte uneCarte) {
        int x = 0;
        int y = 0;

        int hauteurCarte = 700;//uneCarte.getMapDimension().getHeight();
        int largeurCarte = 1200;//uneCarte.getMapDimension().getWidth();

        Random generator = new Random();

        x = 0 + generator.nextInt(largeurCarte);
        y = 0 + generator.nextInt(hauteurCarte);

        while (uneCarte.isCollision(x, y) == true) {
            x = 0 + generator.nextInt(largeurCarte);
            y = 0 + generator.nextInt(hauteurCarte);
            
            System.out.println("NOPE");
        }
        
        int[] t= new int[2];
        t[0]=x; t[1]= y;
        return  t;
    }

}
