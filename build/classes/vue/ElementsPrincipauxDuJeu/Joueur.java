package vue.ElementsPrincipauxDuJeu;

import java.util.ArrayList;
import modele.Paysan;
import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class Joueur extends Paysan{

    // *************************************************************************
    // Donnee membre    
    private float x = 300, y = 300;
    private float xDest = 300, yDest = 300;
    
    private int direction = 0;
    private boolean moving = false;
    private Animation[] animations = new Animation[8];
    private boolean onStair = false;
    private boolean isSelected = false;
    private Rectangle rectInteraction;
    private Carte carte;
    private Image imageBatiment;
    private Paysan paysan;
    //temps écouler entre chaque attaque en miliseconde (le personnage attaque instantanément)
    private int tempsAttaque = 0;
    //temps minimum de la nouvelle attaque
    private int nouvelleAttaque = 0;

    // *************************************************************************
    // Constructeur
    public Joueur(Carte uneCarte) {
        super();
        this.carte = uneCarte;
        this.paysan = new Paysan();
        setVitesse(2.0f);
        setDps(15);
    }

    // *************************************************************************
    // Initialisation
    public void init() throws SlickException {
        String file = "data/sprites/people/characters_sheet.png";
        SpriteSheet spriteSheet = new SpriteSheet(file, 64, 64);
        this.animations[0] = loadAnimation(spriteSheet, 0, 1, 0);
        this.animations[1] = loadAnimation(spriteSheet, 0, 1, 1);
        this.animations[2] = loadAnimation(spriteSheet, 0, 1, 2);
        this.animations[3] = loadAnimation(spriteSheet, 0, 1, 3);
        this.animations[4] = loadAnimation(spriteSheet, 1, 9, 0);
        this.animations[5] = loadAnimation(spriteSheet, 1, 9, 1);
        this.animations[6] = loadAnimation(spriteSheet, 1, 9, 2);
        this.animations[7] = loadAnimation(spriteSheet, 1, 9, 3);
        this.rectInteraction = new Rectangle();
        this.rectInteraction.setHeight(64);
        this.rectInteraction.setWidth(64);
    }

    private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
        Animation animation = new Animation();
        for (int x = startX; x < endX; x++) {
            animation.addFrame(spriteSheet.getSprite(x, y), 100);
        }
        return animation;
    }

    // *************************************************************************
    // Affichage
    public void render(Graphics g) throws SlickException {
        g.setColor(new Color(0, 0, 0, .5f));
        rectInteraction.setX((int) this.x - 32);
        rectInteraction.setY((int) this.y - 56);
        if (isSelected) {
            g.drawRect(rectInteraction.getX(), rectInteraction.getY(), rectInteraction.getWidth(), rectInteraction.getHeight());
        }
        g.fillOval(x - 16, y - 8, 32, 16);
        g.drawOval(x - 150, y - 150, 300 , 300);
        g.drawAnimation(animations[direction + (moving ? 4 : 0)], x - 32, y - 60);
    }

    // *************************************************************************
    // Methodes specifiques
    public boolean selection(boolean laValeur) {
        isSelected = laValeur;
        return isSelected;
    }

    // *************************************************************************
    // Methodes de mise a jour
    public void update(int delta) {
        if (this.moving && (this.x <= this.xDest || this.x >= this.xDest || this.y >= this.yDest || this.y <= this.yDest)) {
            float futurX = getFuturX(delta);
            float futurY = getFuturY(delta);
            boolean collision = this.carte.isCollision(futurX, futurY);
            if (collision) {
                this.moving = false;
            } else {
                if (x < xDest) {
                    this.x += (int) 1 * getVitesse();
                } else if (x > xDest) {
                    this.x -= (int) 1 * getVitesse();

                } else if (x == xDest && y < yDest) {
                    this.setDirection(2);
                } else if (x == xDest && y > yDest) {
                    this.setDirection(0);
                }

                if (y < yDest) {

                    this.y += (int) 1 * getVitesse();
                } else if (y > yDest) {
                    this.y -= (int) 1 * getVitesse();

                } else if (y == yDest && x < xDest) {
                    this.setDirection(3);
                } else if (y == yDest && x > xDest) {
                    this.setDirection(1);
                }

                if (y == yDest && x == xDest) {
                    this.moving = false;
                }
            }
        } else {
            this.moving = false;
        }
    }

    private float getFuturX(int delta) {
        float futurX = this.x;
        switch (this.direction) {
            case 1:
                futurX = this.x - getVitesse() * delta;
                break;
            case 3:
                futurX = this.x + getVitesse() * delta;
                break;
        }
        return futurX;
    }

    private float getFuturY(int delta) {
        float futurY = this.y;
        switch (this.direction) {
            case 0:
                futurY = this.y - getVitesse() * delta;
                break;
            case 2:
                futurY = this.y + getVitesse() * delta;
                break;
            case 1:
                if (this.onStair) {
                    futurY = this.y + getVitesse() * delta;
                }
                break;
            case 3:
                if (this.onStair) {
                    futurY = this.y - getVitesse() * delta;
                }
                break;
        }
        return futurY;
    }

    public Joueur getCloser(ArrayList listePersonnage, Ennemi unEnnemi) {
        int distanceActuelle = Integer.MAX_VALUE;
        Joueur unJoueur, joueurProche = null;
        for (Object j : listePersonnage) {
            unJoueur = (Joueur) j;
            Point joueur = new Point((int) unJoueur.getX(), (int) unJoueur.getY());
            Point ennemi = new Point((int) unEnnemi.getX(), (int) unEnnemi.getY());
            if (distancePoint(joueur, ennemi) < distanceActuelle) {
                distanceActuelle = distancePoint(joueur, ennemi);
                joueurProche = unJoueur;
            }

        }
        return joueurProche;
    }

    public int distancePoint(Point un, Point deux) {
        return (int) Math.sqrt(Math.pow(deux.getY() - un.getY(), 2) + Math.pow(deux.getX() - un.getX(), 2));
    }

    // *************************************************************************
    // Accesseurs et mutateurs
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setxDest(int x) {
        this.xDest = x;
    }

    public float getxDest() {
        return this.xDest;
    }

    public float getyDest() {
        return this.yDest;
    }
    public float getArmure() {
        return 0;
    }
    public float getVieMax() {
        return 0;
    }
    public float getArmureMax() {
        return 0;
    }
    

    public void setyDest(int y) {
        this.yDest = y;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public boolean isOnStair() {
        return onStair;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setOnStair(boolean onStair) {
        this.onStair = onStair;
    }

    public Rectangle getRectangle() {
        return this.rectInteraction;
    }

    

    //méthode qui prend en paramètre un joueur, une quantité de point d'attaque et le temps de jeu
    // la méthode enlève des points de vies (le montant de amoutOfHp) si le temps es plus grand que la nouvelle attaque.
    // Redéfinit le temps pour la prochaine attaque.
    public void attaque(Ennemi unEnnemi, int tempsJeu) {
        if (tempsJeu > nouvelleAttaque) {
            unEnnemi.removeHP(getDps());
            this.setNouvelleAttaque(tempsJeu);
        }
    }
    
    

    //La méthode rédéfinit le temps de la prochaine attaque
    public void setNouvelleAttaque(int tempsJeu) {
        this.nouvelleAttaque = tempsJeu + this.tempsAttaque;
    }

    public void augmenterArmure() {
        this.paysan.augmenterArmure();
    }

    public void boostVitesse(float unBoost) {
        vitesse += unBoost;
    }

    public void valeursParDefault(){
        vitesse = 1.0f;
        setDps(20);
    }
}
