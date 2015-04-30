package vue.Attributs;

import controleur.Informateur;
import java.awt.Point;
import java.util.ArrayList;
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
public class Armure extends Attribut{
    // *************************************************************************
    // Données membres
    private Image image;
    
    // *************************************************************************
    // Constructeur
    public Armure() throws SlickException{
        this.image = new Image("data/sprites/objet/Armure.png");
    }
    
    @Override
    public void render(Graphics g, Carte uneCarte) throws SlickException {
        Point coordinates = Informateur.getRandomCoordinates(uneCarte);
        g.drawImage(image, coordinates.x, coordinates.y);
    }

    @Override
    public void action() {
    }

    @Override
    public void action(Joueur unJoueur) {
    }

    @Override
    public void action(Ennemi unEnnemi) {
    }

    @Override
    public void action(ArrayList uneListe) {
    }
    
}
