package vue.PanneauxInterface;

import controleur.Camera;
import controleur.ControlleurPersonnage;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Transform;
import vue.Jeu.Carte;
import vue.Jeu.Joueur;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class PlancheDeJeu extends BasicGame {

    // *************************************************************************
    // Donnees membres
    private GameContainer container;
    private Carte cartePrincipale;
    // Personnage
    private Joueur personnage;
    // Controlleurs (ecouteurs)
    ControlleurPersonnage ecoPerso;
    // Camera
    private Camera camera;
    // Curseur
    int xCurseur = -1000;
    int yCurseur = -1000;
    //Utilisé pour savoir a quelle endroit la souris est cliqué
    int xPressed = 0;
    int yPressed = 0;
    //Le delta de la position initiale de la souris et de sa position finale
    int deltaX = 0;
    int deltaY = 0;
    //Rectangle contruit par la souris
    private Rectangle rect;
    //ArrayList de personnage selectionné
    private ArrayList lstSelection = new ArrayList();

    // *************************************************************************
    // Constructeur
    public PlancheDeJeu() {
        super("WindowGame");
        cartePrincipale = new Carte();
        personnage = new Joueur(cartePrincipale);

        camera = new Camera(personnage, cartePrincipale);
    }

    // *************************************************************************
    // Methodes specifiques
    public void init(GameContainer container) throws SlickException {
        // Jeu et carte
        this.container = container;
        //Image curseur = new Image("images/curseur.png", true);
        //this.container.setMouseCursor(curseur, 0, 0);
        this.cartePrincipale.init();
        // Personnage
        this.personnage.init();
        this.personnage.setX(container.getWidth() / 2);
        this.personnage.setY(container.getHeight() / 2);
        // Ecouteur
        ecoPerso = new ControlleurPersonnage(personnage, container);
        container.getInput().addKeyListener(ecoPerso);
        container.getInput().addMouseListener(ecoPerso);
    }

    //Methode qui rennder la frame
    public void render(GameContainer container, Graphics g) throws SlickException {
        this.camera.place(container, g);
        this.cartePrincipale.renderArrierePlan();
        this.personnage.render(g);
        this.cartePrincipale.renderAvantPlan();
        if (rect != null) {
            g.setColor(new Color(255, 255, 255, 100));
            g.drawRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
        }
    }

    //Methode qui actualise la frame (selon le fps)
    public void update(GameContainer container, int delta) throws SlickException {
        this.personnage.update(delta);
        this.camera.update(container);

        Input input = container.getInput();

        // La camera est toujours au centre de l'ecran et donc en ajoutant son
        // x - la moitier de l'ecran on arrive a fixer la position en x de la
        // souris lors de la mise a jour de la camera.
        xCurseur = (int) (input.getMouseX() + (camera.getX() - container.getWidth() / 2));
        yCurseur = (int) (input.getMouseY() + (camera.getY() - container.getHeight() / 2));

        int x = (int) personnage.getX();
        int y = (int) personnage.getY();

        int x2 = x - 32;
        int y2 = y - 56;

        if (input.isMousePressed(0)) {
            // testLog();
            // Condition sur le curseur s'il est sur le personnage
            if ((xCurseur >= x2 && xCurseur <= (x2 + 64)) && (yCurseur >= y2 && yCurseur <= (y2 + 64))) {
                personnage.selection();
            }
        }
    }

    //*****************************************************************
    //Methode qui trouve la position de la souris au moment où on clique
    public void mousePressed(int button, int x, int y) {
        if (button == 0) {
            xPressed = (int) (x + (camera.getX() - container.getWidth() / 2));
            yPressed = (int) (y + (camera.getY() - container.getHeight() / 2));
        }
    }

    //Methode qui calcule la nouvelle position de la souris lorsqu'elle est cliqué
    public void mouseDragged(int oldx, int oldy, int newx, int newy) {

        //newx/newy sont les positions en temps réels de la souris lorsque cliqué
        //xPressed/yPressed est le clique initiale de la souris
        deltaX = (int) ((newx - xPressed) + (camera.getX() - container.getWidth() / 2));
        deltaY = (int) ((newy - yPressed) + (camera.getY() - container.getHeight() / 2));

        //set le rectangle grace aux variables calculées dans la methode
        rect = new Rectangle(xPressed, yPressed, deltaX, deltaY);

        //Si les personnages se trouvent dans le rectangle construit il sont ajoutés à la liste
        //HautGauche vers BasDroit
        if (deltaX > 1 && deltaY > 1) {
            if (rect.getX() <= personnage.getX() && rect.getY() <= personnage.getY()) {
                //Ajoute à la liste mais trop (c'est peut-etre pas grave though) -> 
                //On devrait faire un boolean dans joueur qui vien canceler l'ajout s'il n'est pas en mouvement?
                lstSelection.add(personnage);
                System.out.println(lstSelection.size());
            }
        } //BasDroit vers HautGauche
        else if (deltaX < 1 && deltaY < 1) {
            if (rect.getX() >= personnage.getX() && rect.getY() >= personnage.getY()) {
                personnage.selection();
            }
        } //HautDroit vers BasGauche
        else if (deltaX < 1 && deltaY > 1) {
            if (rect.getX() >= personnage.getX() && rect.getY() <= personnage.getY()) {
                personnage.selection();
            }
        } //BasGauche vers HautDroit
        else if (deltaX > 1 && deltaY < 1) {
            if (rect.getX() <= personnage.getX() && rect.getY() >= personnage.getY()) {
                personnage.selection();
            }
        }
    }
    //*****************************************************************

    public void testLog() {
        System.out.println("x2: " + ((int) personnage.getX() - 32));
        System.out.println("y2: " + ((int) personnage.getY() - 56));
        System.out.println("xCurseur: " + xCurseur);
        System.out.println("yCurseur: " + yCurseur);
        System.out.println("xCamera: " + camera.getX());
        System.out.println("yCamera: " + camera.getY());
        System.out.println("Container width: " + container.getWidth());
        System.out.println("Container height " + container.getHeight());
        System.out.println("Map width " + this.cartePrincipale.getMapDimension().getWidth());
        System.out.println("Map height " + this.cartePrincipale.getMapDimension().getHeight());
    }

    // *************************************************************************
    // Main
    public static void main(String[] args) throws SlickException {
        new AppGameContainer(new PlancheDeJeu(), 800, 800, false).start();
    }
}
