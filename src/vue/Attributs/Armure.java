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
    // Constructeur
    public Armure(Carte uneCarte) throws SlickException{
        super(uneCarte);
        super.setImage(new Image("data/sprites/objet/Armure.png"));
    }

    @Override
    public void action() {
    }

    @Override
    public void action(Joueur unJoueur) {
        unJoueur.augmenterArmure();
    }

    @Override
    public void action(Ennemi unEnnemi) {
    }

    @Override
    public void action(ArrayList uneListe) {
    }
    
}
