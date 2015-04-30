package vue.Jeu;

import java.util.ArrayList;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import vue.Attributs.Attribut;
import vue.ElementsPrincipauxDuJeu.Ennemi;
import vue.ElementsPrincipauxDuJeu.Joueur;

/**
 *
 * @author usager
 */
public class Baril extends Attribut {

    private Image imgAttribut;
    private double rare;
    private int dommage = 50;

    public Baril() throws SlickException {
        super.setImage(new Image("data/sprites/objet/Baril.png"));
    }

    public void action() {
    }

    public void action(Joueur unJoueur) {
    }

    public void action(Ennemi unEnnemi) {
        unEnnemi.removeHP(dommage);
    }

    public void action(ArrayList uneListe) {
    }
}
