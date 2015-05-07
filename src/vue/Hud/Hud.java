package vue.Hud;

import controleur.Camera;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;
import vue.ElementsPrincipauxDuJeu.Joueur;
import vue.GameSates.Game;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class Hud extends AbstractComponent {

    //Objets
    private Joueur joueur;
    private Game game;

    // Composants du Hud
    private Image barreVie;
    private Image actionBar;
    private Image attributImg;

    // Ressources extérieures
    private Camera camera;
    private GameContainer container;

    //Variables pour barreVie
    private final int P_BAR_X = 10;
    private final int P_BAR_Y = 10;
    private final int BAR_X = 84 + P_BAR_X;
    private final int LIFE_BAR_Y = 4 + P_BAR_Y;
    private final int ARMOR_BAR_Y = 24 + P_BAR_Y;
    private final int BAR_WIDTH = 80;
    private final int BAR_HEIGHT = 16;
    private final Color LIFE_COLOR = new Color(255, 0, 0);

    public Hud(GUIContext container, Camera uneCamera, GameContainer unContainer, Joueur joueur) throws SlickException {
        super(container);
        this.container = unContainer;
        this.camera = uneCamera;
        this.joueur = joueur;
        init();
    }

    public void init() throws SlickException {
        this.barreVie = new Image("data//Hud//barreVie.png");
        this.game = new Game();
    }

    public void render(Graphics g) {
        //cette méthode empeche ce qui est dessiné de bouger dans l'écran  
        g.resetTransform();

       //On dessine la barre de vie en rouge et on la draw à l'endroit voulu
        g.setColor(LIFE_COLOR);
        //On remplit la barre

        g.fillRect(BAR_X, LIFE_BAR_Y, (float) (joueur.getHP() / 100.0) * BAR_WIDTH - 40, BAR_HEIGHT);

        g.fillRect(BAR_X , LIFE_BAR_Y, (float)(joueur.getVie() / joueur.getVieMax()) * BAR_WIDTH, BAR_HEIGHT);
        //Barre d'armure
        g.setColor(Color.blue);
        g.fillRect(BAR_X ,ARMOR_BAR_Y, (float)(joueur.getArmure() / joueur.getArmureMax()) * BAR_WIDTH , BAR_HEIGHT);
        //On dessine la barre de vie

        g.drawImage(this.barreVie, P_BAR_X, P_BAR_Y);
        if (joueur.getAttributActif() != null) {
            g.drawImage(this.joueur.getAttributActif().getImage().getScaledCopy(40, 40), 22, 20);
        }
        g.setColor(new Color(255, 255, 255));
        g.drawString("Score : " + game.getScore(), 1315, 15);
    }

    // *************************************************************************
    // Ecouteurs
    public void setImageAttribut(Image attributImg) {
        this.attributImg = attributImg;
    }

    @Override
    public void setInput(Input input) {
    }

    @Override
    public boolean isAcceptingInput() {
        return true;
    }

    @Override
    public void inputEnded() {
    }

    @Override
    public void inputStarted() {
    }

    @Override
    public void render(GUIContext guic, Graphics grphcs) throws SlickException {
    }

    @Override
    public void setLocation(int i, int i1) {
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }
}
