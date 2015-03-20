package vue.PanneauxInterface;

import controleur.Camera;
import controleur.ControlleurPersonnage;
import controleur.Informateur;
import java.awt.Point;
import java.util.ArrayList;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
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
    // Controlleurs (ecouteurs)
    private ControlleurPersonnage ecoPerso, ecoPerso2;
    // Camera
    private Camera camera;
    //Utilisé pour savoir a quelle endroit la souris est cliqué
    private int xPressed = 0, yPressed = 0;
    //Le delta de la position initiale de la souris et de sa position finale
    private int deltaX = 0, deltaY = 0;
    //Rectangle contruit par la souris
    private Rectangle rect;
    private boolean rectEstConstruit = false, mouseReleased = false;
    //ArrayList de personnage selectionné
    private ArrayList personnages = new ArrayList();
    private ArrayList lstSelection = new ArrayList();
    private ArrayList ecouteursPersonnages = new ArrayList();
    //event
    private Input input;

    // *************************************************************************
    // Constructeur
    public PlancheDeJeu() {
        super("WindowGame");
        cartePrincipale = new Carte();
        personnages.add(new Joueur(cartePrincipale));
        personnages.add(new Joueur(cartePrincipale));

        camera = new Camera(cartePrincipale);
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
        for (Object j : personnages) {
            Joueur unJoueur = (Joueur) j;
            unJoueur.init();
            unJoueur.setX(container.getWidth() / 2 + 50 * personnages.indexOf(j));
            unJoueur.setY(container.getHeight() / 2 + 50 * personnages.indexOf(j));
        }
        // Ecouteur
        for (int i = 0; i < personnages.size(); i++) {
            container.getInput().addMouseListener(new ControlleurPersonnage((Joueur) personnages.get(i), container, camera));
        }
    }

    //Methode qui rennder la frame
    public void render(GameContainer container, Graphics g) throws SlickException {
        this.camera.place(container, g);
        this.cartePrincipale.renderArrierePlan();
        for (Object j : personnages) {
            Joueur unJoueur = (Joueur) j;
            unJoueur.render(g);
        }
        this.cartePrincipale.renderAvantPlan();
        g.setColor(Color.yellow);
        g.drawOval(Informateur.getMousePosition(camera, container).x, Informateur.getMousePosition(camera, container).y, 10, 10);
        if (rect != null) {
            g.setColor(new Color(255, 255, 255, 100));
            g.drawRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
            //Déconstruit le rectangle apres le relachement de la souris
            if (rectEstConstruit && mouseReleased) {
                //Temporaire, j'ai rien trouvé de mieux
                rect.setSize(0, 0);
                //reset les boolean apres le relachement de la souris
                rectEstConstruit = false;
                mouseReleased = false;
            }
        }
    }

    //Methode qui actualise la frame (selon le fps)
    public void update(GameContainer container, int delta) throws SlickException {
        for (Object j : personnages) {
            Joueur unJoueur = (Joueur) j;
            unJoueur.update(delta);
            //this.personnage.update(delta);
            this.camera.update(container);

            //Event
            input = container.getInput();

            this.camera.update(container);
        }
    }
    //*****************************************************************
//Methode qui trouve la position de la souris au moment où on clique

    public void mousePressed(int button, int x, int y) {
        // La camera est toujours au centre de l'ecran et donc en ajoutant son
        // x - la moitier de l'ecran on arrive a fixer la position en x de la
        // souris lors de la mise a jour de la camera.
        if (button == 0) {
            xPressed = (int) (x + (camera.getX() - container.getWidth() / 2));
            yPressed = (int) (y + (camera.getY() - container.getHeight() / 2));
            lstSelection.clear();
            //Clear la liste si on click gauche, cancel la selection
            for (Object j : personnages) {
                Joueur unJoueur = (Joueur) j;
                unJoueur.selection(false);
                //Permet de selectionner un personnage en cliquant sur lui
                if (unJoueur.getX() <= xPressed && unJoueur.getX() - 150 >= xPressed
                        && unJoueur.getY() <= yPressed && unJoueur.getY() - 56 >= yPressed) {
                    unJoueur.selection(true);
                }
            }
            Point mousePos = Informateur.getMousePosition(camera, container);
            cartePrincipale.isArbre(mousePos.x, mousePos.y);
        }
    }

    //Methode qui calcule la nouvelle position de la souris lorsqu'elle est cliqué
    public void mouseDragged(int oldx, int oldy, int newx, int newy) {
        if (input.isMouseButtonDown(0)) {
            //newx/newy sont les positions en temps réels de la souris lorsque cliqué
            //xPressed/yPressed est le clique initiale de la souris
            deltaX = (int) ((newx - xPressed) + (camera.getX() - container.getWidth() / 2));
            deltaY = (int) ((newy - yPressed) + (camera.getY() - container.getHeight() / 2));

            //position de la souris en temps réel
            float newxDrag = (int) (newx + (camera.getX() - container.getWidth() / 2));
            float newyDrag = (int) (newy + (camera.getY() - container.getHeight() / 2));

            //set le rectangle grace aux variables calculées dans la methode
            rect = new Rectangle(xPressed, yPressed, deltaX, deltaY);
            rectEstConstruit = true;

            //Si les personnages se trouvent dans le rectangle construit ils sont ajoutés à la liste
            for (Object j : personnages) {
                Joueur unJoueur = (Joueur) j;
                //HautGauche vers BasDroit
                System.out.println(deltaX +" : "+ deltaY);
                System.out.println(rect.getY() +" : "+ unJoueur.getY() +" : "+ 
                        (unJoueur.getY() - 56) +" : "+  newyDrag);
                if (deltaX > 1 && deltaY > 1) {
                    if (rect.getX() <= unJoueur.getX() && unJoueur.getX() - 32 <= newxDrag
                            && rect.getY() <= unJoueur.getY() && unJoueur.getY() - 56 <= newyDrag) {
                        if (!Informateur.estDejaLa(lstSelection, unJoueur)) {
                            unJoueur.selection(true);
                            lstSelection.add(unJoueur);
                        }
                    }
                } //BasDroit vers HautGauche
                else if (deltaX < 1 && deltaY < 1) {
                    if (rect.getX() >= unJoueur.getX() - 32 && unJoueur.getX() >= newxDrag
                            && rect.getY() >= unJoueur.getY() - 56 && unJoueur.getY() >= newyDrag) {
                        if (!Informateur.estDejaLa(lstSelection, unJoueur)) {
                            unJoueur.selection(true);
                            lstSelection.add(unJoueur);
                        }
                    }
                } //HautDroit vers BasGauche
                else if (deltaX < 1 && deltaY > 1) {
                    if (rect.getX() >= unJoueur.getX() - 32 && unJoueur.getX() >= newxDrag
                            && rect.getY() <= unJoueur.getY() && unJoueur.getY() - 56 <= newyDrag) {
                        if (!Informateur.estDejaLa(lstSelection, unJoueur)) {
                            unJoueur.selection(true);
                            lstSelection.add(unJoueur);
                        }
                    }
                } //BasGauche vers HautDroit
                else if (deltaX > 1 && deltaY < 1) {
                    if (rect.getX() <= unJoueur.getX() && unJoueur.getX() - 32 <= newxDrag
                            && rect.getY() >= unJoueur.getY() - 56 && unJoueur.getY() >= newyDrag) {
                        if (!Informateur.estDejaLa(lstSelection, unJoueur)) {
                            unJoueur.selection(true);
                            lstSelection.add(unJoueur);
                        }
                    }
                }
            }
        }
    }

    //Méthode qui prend le relachement de la souris comme event
    public void mouseReleased(int button, int x, int y) {

        //mouseReleased est true seulement si le rectangle est contruit
        //Donc si la mouseDragged a été appeler
        if (rectEstConstruit) {
            mouseReleased = true;
        }
    }

    @Override
    public void mouseMoved(int oldx, int oldy, int newx, int newy) {
        
    }
    //*****************************************************************

    public void testLog() {
        System.out.println("xCurseur: " + Mouse.getX());
        System.out.println("yCurseur: " + Mouse.getY());
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