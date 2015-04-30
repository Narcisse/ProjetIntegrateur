package vue.Jeu;

import java.util.ArrayList;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import vue.Jeu.Ennemi;

public class Nuke extends Attribut {

    Image imgAttribut;
    double rare;

    public Nuke() throws SlickException {
        this.imgAttribut = new Image("data/sprites/objet/Nuke.png");
    }

    public void action() {
    }

    public void action(Joueur unJoueur) {
    }

    public void action(Ennemi unEnnemi) {
        unEnnemi.removeHP(unEnnemi.getHP());
    }

    public void action(ArrayList uneListe) {
    }

    @Override
    public void render(Graphics g) throws SlickException {
    }

}
