package vue.PanneauxInterface;

import controleur.Camera;
import controleur.ControlleurPersonnage;
import controleur.Informateur;
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
    // Personnage
    private Joueur personnage;
    private Joueur personnage2;
    // Controlleurs (ecouteurs)
    ControlleurPersonnage ecoPerso, ecoPerso2;
    // Camera
    private Camera camera;
    // Curseur
    int xCurseur = -1000, yCurseur = -1000;
    //Utilisé pour savoir a quelle endroit la souris est cliqué
    int xPressed = 0, yPressed = 0;
    //Le delta de la position initiale de la souris et de sa position finale
    int deltaX = 0, deltaY = 0;
    //Rectangle contruit par la souris
    private Rectangle rect;
    private boolean rectEstConstruit = false, mouseReleased = false;
    //ArrayList de personnage selectionné
    private ArrayList personnages = new ArrayList();
    private ArrayList lstSelection = new ArrayList();
    private ArrayList ecouteursPersonnages = new ArrayList();

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
            container.getInput().addMouseListener(new ControlleurPersonnage((Joueur) personnages.get(i), container));
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
        g.setColor(new Color(255, 255, 255, 100));
        g.drawOval(this.camera.getX(), this.camera.getY(), 10, 10);
        int w = container.getWidth() / 6;
        g.drawLine(this.camera.getX() + w, 0, this.camera.getX() + w, 3200);
        g.drawLine(this.camera.getX() - w, 0, this.camera.getX() - w, 3200);
        
        int h = container.getHeight() / 6;
        g.drawLine(0, this.camera.getY() - h, 3200, this.camera.getY() - h);
        g.drawLine(0, this.camera.getY() + h, 3200, this.camera.getY() + h);
    }

    //Methode qui actualise la frame (selon le fps)
    public void update(GameContainer container, int delta) throws SlickException {
        for (Object j : personnages) {
            Joueur unJoueur = (Joueur) j;
            unJoueur.update(delta);
        }
        this.camera.update(container);
    }

    //*****************************************************************
    //Methode qui trouve la position de la souris au moment où on clique
    public void mousePressed(int button, int x, int y) {
        if (button == 0) {
            lstSelection.clear();
            for (Object j:personnages){
                Joueur unJoueur = (Joueur)j;
                unJoueur.selection(false);
            }
            // La camera est toujours au centre de l'ecran et donc en ajoutant son
            // x - la moitier de l'ecran on arrive a fixer la position en x de la
            // souris lors de la mise a jour de la camera.
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

        //position en temps réel
        float newxDrag = (int) (newx + (camera.getX() - container.getWidth() / 2));
        float newyDrag = (int) (newy + (camera.getX() - container.getWidth() / 2));

        //set le rectangle grace aux variables calculées dans la methode
        rect = new Rectangle(xPressed, yPressed, deltaX, deltaY);
        rectEstConstruit = true;

        //Si les personnages se trouvent dans le rectangle construit il sont ajoutés à la liste
        //y2,x2 sont les bornes exterieure de l'image du personnage
        for (Object j : personnages) {
            Joueur unJoueur = (Joueur) j;
            //HautGauche vers BasDroit
            if (deltaX > 1 && deltaY > 1) {
                if (rect.getX() <= unJoueur.getX() && unJoueur.getX()-32 <= newxDrag
                        && rect.getY() <= unJoueur.getY() && unJoueur.getY()-56 <= newyDrag) {
                //Ajoute à la liste mais trop (c'est peut-etre pas grave though) -> 
                    //On devrait faire un boolean dans joueur qui vien canceler l'ajout s'il n'est pas en mouvement?
                    if (!Informateur.estDejaLa(lstSelection, unJoueur)) {
                        unJoueur.selection(true);
                        lstSelection.add(unJoueur);
                    }
                    System.out.println(lstSelection.size());
                    System.out.println("Selectionné1");
                }
            } //BasDroit vers HautGauche
            else if (deltaX < 1 && deltaY < 1) {
                if (rect.getX() >= unJoueur.getX()-32 && unJoueur.getX() >= newxDrag
                        && rect.getY() >= unJoueur.getY()-56 && unJoueur.getY() >= newyDrag) {
                    if (!Informateur.estDejaLa(lstSelection, unJoueur)) {
                        unJoueur.selection(true);
                        lstSelection.add(unJoueur);
                    }
                    System.out.println("Selectionné2");
                }
            } //HautDroit vers BasGauche
            else if (deltaX < 1 && deltaY > 1) {
                if (rect.getX() >= unJoueur.getX()-32 && unJoueur.getX() >= newxDrag
                        && rect.getY() <= unJoueur.getY() && unJoueur.getY()-56 <= newyDrag) {
                    if (!Informateur.estDejaLa(lstSelection, unJoueur)) {
                        unJoueur.selection(true);
                        lstSelection.add(unJoueur);
                    }
                    System.out.println("Selectionné3");
                }
            } //BasGauche vers HautDroit
            else if (deltaX > 1 && deltaY < 1) {
                if (rect.getX() <= unJoueur.getX() && unJoueur.getX()-32 <= newxDrag
                        && rect.getY() >= unJoueur.getY()-56 && unJoueur.getY() >= newyDrag) {
                    if (!Informateur.estDejaLa(lstSelection, unJoueur)) {
                        unJoueur.selection(true);
                        lstSelection.add(unJoueur);
                    }
                    System.out.println("Selectionné4");
                }
            }
            System.out.println(lstSelection.size());
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
    public void mouseMoved(int oldx, int oldy, int newx, int newy){
        testLog();
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
