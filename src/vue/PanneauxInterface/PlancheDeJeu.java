package vue.PanneauxInterface;

import controleur.Camera;
import controleur.ControlleurPersonnage;
import controleur.ControlleurSouris;
import controleur.Informateur;
import java.util.ArrayList;
import modele.Entrepot;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import vue.Hud.Hud;
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
    private ControlleurSouris ecoSouris;
    // Camera
    private Camera camera;
    // Entrepot
    private Entrepot entrepot;
    //ArrayList de personnage selectionné
    private ArrayList personnages = new ArrayList();
    // Planche de jeu
    private PlancheDeJeu cettePlanche;
    // Hud
    private Hud hud;

    // *************************************************************************
    // Constructeur
    public PlancheDeJeu() {
        super("WindowGame");
        cartePrincipale = new Carte();
        personnages.add(new Joueur(cartePrincipale));
        personnages.add(new Joueur(cartePrincipale));
        cettePlanche = this;
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
        // entrepot
        int nombreDeRessourceInitial = Entrepot.valeurInitiale;
        entrepot = new Entrepot();
        entrepot.setBois(nombreDeRessourceInitial);
        entrepot.setNourriture(nombreDeRessourceInitial);
        entrepot.setOr(nombreDeRessourceInitial);
        // Hud
        hud = new Hud();
        hud.init();
        //ajouter le hud comme un mouseListener a la planche du jeu.
        container.getInput().addMouseListener(hud);
        // Ecouteur
        for (int i = 0; i < personnages.size(); i++) {
            container.getInput().addMouseListener(new ControlleurPersonnage((Joueur) personnages.get(i), container, camera));
        }
        ecoSouris = new ControlleurSouris(cettePlanche);
        container.getInput().addMouseListener(ecoSouris);
        
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
        ecoSouris.render(container, g);
        this.hud.render(g);
    }

    //Methode qui actualise la frame (selon le fps)
    public void update(GameContainer container, int delta) throws SlickException {
        for (Object j : personnages) {
            Joueur unJoueur = (Joueur) j;
            unJoueur.update(delta);
            //this.personnage.update(delta);
            this.camera.update(container);

            //this.camera.update(container);
        }
    }

    // *************************************************************************
    // Accesseur \ Mutateur
    public GameContainer getContainer() {
        return this.container;
    }

    public Camera getCamera() {
        return this.camera;
    }

    public ArrayList<Joueur> getPersonnages() {
        return this.personnages;
    }

    public Carte getCartePrincipale() {
        return this.cartePrincipale;
    }

    public Entrepot getEntrepot() {
        return this.entrepot;
    }

    // *************************************************************************
    // Main

    public static void main(String[] args) throws SlickException {
        new AppGameContainer(new PlancheDeJeu(), 800, 800, false).start();
    }
}
