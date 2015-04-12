package vue.Jeu;

import controleur.Camera;
import controleur.ControlleurEnnemi;
import controleur.ControlleurPersonnage;
import controleur.ControlleurSouris;
import controleur.Informateur;
import java.util.ArrayList;
import modele.Entrepot;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import vue.Hud.Hud;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class Game extends BasicGameState {

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
    private ArrayList ennemis = new ArrayList();
    // Planche de jeu
    private Game cettePlanche;
    // Hud
    private Hud hud;
    //Batiment
    private Objet batiment;
    //Menu In game
    private MenuIG menuIG;
    //Condition pour afficher menu
    private boolean escapePressed= false;
    // ID
    public static final int ID = 1;
    private float distance=0;

    // *************************************************************************
    // Constructeur
    public Game() {
        super();
        cartePrincipale = new Carte();
        personnages.add(new Joueur(cartePrincipale));
        ennemis.add(new Ennemi(cartePrincipale));
        batiment= new Objet(cartePrincipale);
        cettePlanche = this;
        camera = new Camera(cartePrincipale);
    }

    // *************************************************************************
    // Methodes specifiques

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
    
    public Objet getBatiment() {
        return this.batiment;
    }

    public Carte getCartePrincipale() {
        return this.cartePrincipale;
    }

    public Entrepot getEntrepot() {
        return this.entrepot;
    }
    
    public Hud getHud(){
        return this.hud;
    }

    // *************************************************************************
    // Main

    public static void main(String[] args) throws SlickException {
    }

    @Override
    public int getID() {
        return this.ID;
    }

    @Override
    public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
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
        for (Object e : ennemis){
            Ennemi unEnnemi = (Ennemi) e;
            unEnnemi.init();
            unEnnemi.setX(500);
            unEnnemi.setY(500);
        }
        this.batiment.init();
        // entrepot
        int nombreDeRessourceInitial = Entrepot.valeurInitiale;
        entrepot = new Entrepot();
        entrepot.setBois(nombreDeRessourceInitial);
        entrepot.setNourriture(nombreDeRessourceInitial);
        entrepot.setOr(nombreDeRessourceInitial);
        // Hud
        hud = new Hud(container, camera, container);
        hud.init();
        //ajouter le hud comme un mouseListener a la planche du jeu.
        container.getInput().addMouseListener(hud);
        // Ecouteur
        for (int i = 0; i < personnages.size(); i++) {
            container.getInput().addMouseListener(new ControlleurPersonnage((Joueur) personnages.get(i), container, camera));
        }
        for (int i = 0; i < ennemis.size(); i++) {
            container.getInput().addMouseListener(new ControlleurEnnemi((Ennemi) ennemis.get(i), container, camera));
        }
        ecoSouris = new ControlleurSouris(cettePlanche);
        container.getInput().addMouseListener(ecoSouris);
        menuIG = new MenuIG(container, camera, container);
        menuIG.init();
    }

    @Override
    public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
        this.camera.place(container, g);
        this.cartePrincipale.renderArrierePlan();
        this.batiment.render(g);
        for (Object j : personnages) {
            Joueur unJoueur = (Joueur) j;
            unJoueur.render(g);
        }
        for (Object e : ennemis) {
            Ennemi unEnnemi = (Ennemi) e;
            unEnnemi.render(g);
        }
        this.cartePrincipale.renderAvantPlan();
        g.setColor(Color.yellow);
        g.drawOval(Informateur.getMousePosition(camera, container).x, Informateur.getMousePosition(camera, container).y, 10, 10);
        ecoSouris.render(container, g);
        this.hud.render(g);
        
        if (container.getInput().isKeyPressed(Input.KEY_ESCAPE)){
            escapePressed = !escapePressed;   
        }
        if(escapePressed == true){
            this.menuIG.render(g);   
        }
    }

    @Override
    public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
        for (Object j : personnages) {
            Joueur unJoueur = (Joueur) j;
            unJoueur.update(delta);
            //this.personnage.update(delta);
            this.camera.update(container);

            //this.camera.update(container);
        
        for (Object e : ennemis) {
            Ennemi unEnnemi = (Ennemi) e;
            unEnnemi.update(delta,unJoueur);
            //this.personnage.update(delta);
            this.camera.update(container);

            //this.camera.update(container);
           
        }
        }
    }
}

