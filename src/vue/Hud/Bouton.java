/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.Hud;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Mauris
 * 
 * Cette classe est juste la partie graphique lorsque l'on creer un bouton.
 * Ce n'est pas une classe ecouteur ni mouseListener, juste graphique.
 * 
 */
public class Bouton {
    //Donnees membres
    
    //Constructeur
    public Bouton(){
       
    }
    //Accesseurs
    
    //Modificateurs
    
    //Methodes specifiques
    //Affichage
    public void render(Graphics g) throws SlickException {
        
    }
    
    //Dessine le bouton avec une image
    public void dessinerBouton(Graphics g, int posX, int posY, int tailleRect, Image uneImage){
            uneImage.draw(posX, posY, tailleRect, tailleRect);
    }
}
