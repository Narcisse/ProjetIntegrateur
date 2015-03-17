package vue.Jeu;

import org.lwjgl.util.Rectangle;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class Joueur {

    // *************************************************************************
    // Donnee membre
    private float x = 300, y = 300;
    private float xDest = 300, yDest = 300;
    private float vitesse = 0.3f;
    private int direction = 0;
    private boolean moving = false;
    private Animation[] animations = new Animation[8];
    private boolean onStair = false;
    private boolean isSelected = true;
    private Rectangle rectInteraction;
    private Carte carte;

    // *************************************************************************
    // Constructeur
    public Joueur(Carte uneCarte) {
        this.carte = uneCarte;
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
                if (x <= xDest) {
                    this.x += 1;
                } else {
                    this.x -= 1;
            }

                if (y >= yDest) {
                    this.y -= 1;
                } else {
                    this.y += 1;
        }
                
                if (y == yDest && x == xDest){
                    this.moving = false;
    }
                System.out.println(x);
                System.out.println(y);
            }
        } else {
            this.moving = false;
        }
    }

    private float getFuturX(int delta) {
        float futurX = this.x;
        switch (this.direction) {
            case 1:
                futurX = this.x - vitesse * delta;
                break;
            case 3:
                futurX = this.x + vitesse * delta;
                break;
        }
        return futurX;
    }

    private float getFuturY(int delta) {
        float futurY = this.y;
        switch (this.direction) {
            case 0:
                futurY = this.y - vitesse * delta;
                break;
            case 2:
                futurY = this.y + vitesse * delta;
                break;
            case 1:
                if (this.onStair) {
                    futurY = this.y + vitesse * delta;
                }
                break;
            case 3:
                if (this.onStair) {
                    futurY = this.y - vitesse * delta;
                }
                break;
        }
        return futurY;
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
}
