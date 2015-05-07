package vue.Attributs;

import vue.Attributs.Attribut;
import java.util.ArrayList;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import vue.ElementsPrincipauxDuJeu.Carte;
import vue.ElementsPrincipauxDuJeu.Ennemi;
import vue.ElementsPrincipauxDuJeu.Joueur;


/**
 *
 * @author Guillaume
 */

public class Vie extends Attribut {
    double rare;
    int augmenteVie = 25;

    public Vie(Carte uneCarte) throws SlickException {
        super(uneCarte);
        super.setImage(new Image("data/sprites/objet/Vie.png", false, Image.FILTER_NEAREST));
    }

    public void action() {
    }

    public void action(Joueur unJoueur) {
        unJoueur.addHP(augmenteVie);
    }

    public void action(Ennemi unEnnemi) {
    }

    public void action(ArrayList uneListe) {
    }

}
