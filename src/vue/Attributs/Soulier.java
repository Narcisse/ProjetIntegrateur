package vue.Attributs;

import vue.Attributs.Attribut;
import java.util.ArrayList;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import vue.ElementsPrincipauxDuJeu.Ennemi;
import vue.ElementsPrincipauxDuJeu.Joueur;
import vue.ElementsPrincipauxDuJeu.Joueur;

public class Soulier extends Attribut {

    Image imgAttribut;
    double rare;
    float boostVitesse = 1;

    public Soulier() throws SlickException {
        this.imgAttribut = new Image("data/sprites/objet/Soulier.png");
    }

    public void action() {
    }

    public void action(Joueur unJoueur) {
        unJoueur.setVitesse(unJoueur.getVitesse() + boostVitesse);
    }

    public void action(Ennemi unEnnemi) {
    }

    public void action(ArrayList uneListe) {
    }

    @Override
    public void render(Graphics g) throws SlickException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
