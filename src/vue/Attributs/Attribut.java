package vue.Attributs;

import controleur.Informateur;
import java.awt.Point;
import java.util.ArrayList;
import modele.Paysan;
import org.lwjgl.util.Rectangle;
import org.newdawn.slick.Animation;
import static org.newdawn.slick.Color.white;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import vue.ElementsPrincipauxDuJeu.Carte;
import vue.ElementsPrincipauxDuJeu.Ennemi;
import vue.ElementsPrincipauxDuJeu.Joueur;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public abstract class Attribut {
    private Image imageAttribut = null;
    private int[] coordinates;
    private int height = 50;
    private int width = 50;
    // *************************************************************************
    // Constructeur
    public Attribut(Carte uneCarte) {
        coordinates = Informateur.getRandomCoordinates(uneCarte);
    }

    // *************************************************************************
    // Affichage
    public void render(Graphics g, Carte uneCarte) throws SlickException{
        imageAttribut.draw(coordinates[0], coordinates[1], width, height, white);
    }
    
    public void faireActions(Joueur unJoueur, Ennemi unEnnemi, ArrayList uneListe){
        action();
        action(unJoueur);
        action(unEnnemi);
        action(uneListe);
    }
    
    public abstract void action();

    public abstract void action(Joueur unJoueur);

    public abstract void action(Ennemi unEnnemi);

    public abstract void action(ArrayList uneListe);
    
    // *************************************************************************
    // Accesseurs mutateurs
    public Image getImage(){
        return this.imageAttribut;
    }
    
    public void setImage(Image uneImageAttribut){
        this.imageAttribut = uneImageAttribut;
    }
    
    public Rectangle getRectangle(){
        return new Rectangle(coordinates[0], coordinates[1], width, height);
    }
    
    public String toString(){
        return this.getClass().getSimpleName();
    }
}
