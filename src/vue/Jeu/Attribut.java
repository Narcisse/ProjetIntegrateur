package vue.Jeu;

import java.util.ArrayList;
import modele.Paysan;
import org.lwjgl.util.Rectangle;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public abstract class Attribut {

    // *************************************************************************
    // Main
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    // *************************************************************************
    // Constructeur

    public Attribut() {
    }

    // *************************************************************************
    // Affichage
    public abstract void render(Graphics g) throws SlickException;

    public abstract void action();

    public abstract void action(Joueur unJoueur);

    public abstract void action(Ennemi unEnnemi);

    public abstract void action(ArrayList uneListe);
}
