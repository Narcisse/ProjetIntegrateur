package vue.Attributs;

import controleur.Informateur;
import java.awt.Point;
import java.util.ArrayList;
import modele.Paysan;
import org.lwjgl.util.Rectangle;
import org.newdawn.slick.Animation;
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
    // *************************************************************************
    // Constructeur
    public Attribut() {
    }

    // *************************************************************************
    // Affichage
    public void render(Graphics g, Carte uneCarte) throws SlickException{
        Point coordinates = Informateur.getRandomCoordinates(uneCarte);
        g.drawImage(imageAttribut, coordinates.x, coordinates.y);
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
}
