package vue.Attributs;

import vue.Attributs.Attribut;
import java.util.ArrayList;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import vue.ElementsPrincipauxDuJeu.Carte;
import vue.ElementsPrincipauxDuJeu.Ennemi;
import vue.ElementsPrincipauxDuJeu.Joueur;

public class Soulier extends Attribut {
    double rare;
    float boostVitesse = 0.5f;

    public Soulier(Carte uneCarte) throws SlickException {
        super(uneCarte);
        super.setImage(new Image("data/sprites/objet/Soulier.png", false, Image.FILTER_NEAREST));
    }

    public void action() {
    }

    public void action(Joueur unJoueur) {
        unJoueur.boostVitesse(boostVitesse);
    }

    public void action(Ennemi unEnnemi) {
    }

    public void action(ArrayList uneListe) {
    }

}
