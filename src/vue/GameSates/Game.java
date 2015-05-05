package vue.GameSates;

import controleur.Camera;
import controleur.ControlleurEnnemi;
import controleur.ControlleurPersonnage;
import controleur.ControlleurSouris;
import controleur.Informateur;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import modele.Entrepot;
import org.lwjgl.util.Point;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import vue.Attributs.Attribut;
import vue.Attributs.Soulier;
import vue.Hud.Hud;
import vue.ElementsPrincipauxDuJeu.Batiment;
import vue.ElementsPrincipauxDuJeu.Carte;
import vue.ElementsPrincipauxDuJeu.Ennemi;
import vue.ElementsPrincipauxDuJeu.Joueur;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class Game extends BasicGameState {

    // *************************************************************************
    // Donnees membres
    private GameContainer container;
    private Carte cartePrincipale;
    private StateBasedGame game;
    // Controlleurs (ecouteurs)
    private ControlleurSouris ecoSouris;
    // Camera
    private Camera camera;
    //Score
    private int score;
    // Entrepot
    private Entrepot entrepot;
    //ArrayList de personnage selectionné
    private ArrayList personnages = new ArrayList();
    private ArrayList ennemis = new ArrayList();
    private ArrayList batiments = new ArrayList();
    private ArrayList attributs = new ArrayList();
    // Planche de jeu
    private Game cettePlanche;
    // Hud
    private Hud hud;
    //Menu In game
    private MenuIG menuIG;
    //Condition pour afficher menu
    private boolean escapePressed = false;
    // ID
    public static int ID = 1, condi = 1, tempsDeJeu = 0,tempsEnnemi=0,highScore=0;
    private float distance = 0;
    private Ennemi nEnnemi;
    //MenuPrincipal
    private MenuPrincipal menuP;
    //private Music musicOut;
    private Random aleatoire = new Random();


    // *************************************************************************
    // Constructeur
    public Game() {
        super();
        cartePrincipale = new Carte();
        personnages.add(new Joueur(cartePrincipale));
        ennemis.add(new Ennemi(cartePrincipale));
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

    public Carte getCartePrincipale() {
        return this.cartePrincipale;
    }

    public Entrepot getEntrepot() {
        return this.entrepot;
    }

    public Hud getHud() {
        return this.hud;
    }

    public ArrayList getBatiments() {
        return this.batiments;
    }

    public void ajouterBatiment(Batiment unBatiment) {
        this.batiments.add(unBatiment);
    }
    
    public void setScore(int unScore){
        score = unScore;
    }
    
    public int getScore(){
        return score;
    }

    // *************************************************************************
    @Override
    public int getID() {
        return this.ID;
    }

    @Override
    public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
        // Jeu et carte
        this.container = container;
        this.game = sbg;
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
        for (Object e : ennemis) {
            Ennemi unEnnemi = (Ennemi) e;
            unEnnemi.init();
            unEnnemi.setX(container.getWidth() / 2 + 250 * ennemis.indexOf(e + "" + 1));
            unEnnemi.setY(container.getHeight() / 2 + 250 * ennemis.indexOf(e));
        }
        //this.batiment.init();
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
        //attributs.add(new Soulier(cartePrincipale));
        menuP = new MenuPrincipal();
        //musicOut = new Music("Sons/MusicOut.ogg");
    }

    @Override
    public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
        this.camera.place(container, g);
        this.cartePrincipale.renderArrierePlan();
        //this.batiment.render(g);
        for (Object j : personnages) {
            Joueur unJoueur = (Joueur) j;
            unJoueur.render(g);
        }
        for (Object e : ennemis) {
            Ennemi unEnnemi = (Ennemi) e;
            unEnnemi.render(g);
        }
        for (Object a : attributs) {
            Attribut unAttribut = (Attribut) a;
            unAttribut.render(g, cartePrincipale);
        }
        this.cartePrincipale.renderAvantPlan();
        g.setColor(Color.yellow);
        g.drawOval(Informateur.getMousePosition(camera, container).x, Informateur.getMousePosition(camera, container).y, 10, 10);
        ecoSouris.render(container, g);
        this.hud.render(g);

        if (container.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
            escapePressed = !escapePressed;
        }
        if (escapePressed == true) {
            this.menuIG.render(g);
        }

        for (Object b : batiments) {
            Batiment unBatiment = (Batiment) b;
            unBatiment.render(g);
        }
    }

    @Override
    public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
        for (Object j : personnages) {
            Joueur unJoueur = (Joueur) j;
            unJoueur.update(delta);
            this.camera.update(container);

            for (Object e : ennemis) {
                Ennemi unEnnemi = (Ennemi) e;
                unEnnemi.update(delta, unJoueur, personnages);
                //this.personnage.update(delta);
                this.camera.update(container);
                //this.camera.update(container);
            }
        }
        if (personnages.size() > 1) {
            for (int i = 0; i < personnages.size(); i++) {
                Joueur unPersonnage, premierPersonnage; //On crée 2 objets personnages (Paysans)
                unPersonnage = (Joueur) personnages.get(i); //unPersonnage représente les autres paysan
                premierPersonnage = (Joueur) personnages.get(0); //premierPersonnage représente le premier paysan
                if (premierPersonnage.getxDest() == unPersonnage.getxDest() //Si leur destination (x,y) est la meme, ils vont arreter avant de se rencontrer
                        && premierPersonnage.getyDest() == unPersonnage.getyDest()
                        && unPersonnage.getX() < premierPersonnage.getX()) {
                    unPersonnage.setxDest((int) premierPersonnage.getxDest() - 50 * i); //Si les autres paysans sont a gauche du premier paysan, ils s'arretent a gauche
                } else if (premierPersonnage.getxDest() == unPersonnage.getxDest()
                        && premierPersonnage.getyDest() == unPersonnage.getyDest()
                        && unPersonnage.getX() > premierPersonnage.getX()) {
                    unPersonnage.setxDest((int) premierPersonnage.getxDest() + 50 * i); //Si les autres paysans sont a droite du premier paysan, ils s'arretent a droite
                }
            }
        }

        for (Object b : batiments) {
            Batiment unBatiment = (Batiment) b;
            this.camera.update(container);
            unBatiment.update(this.camera.getX(), this.camera.getY());

        }

        if (tempsDeJeu <= tempsEnnemi+10 && tempsDeJeu >= tempsEnnemi-10) {
            int randomX = aleatoire.nextInt(1001);//chiffre aléatoire entre 0 et 1000
            int randomY = aleatoire.nextInt(1001);//chiffre aléatoire entre 0 et 1000
            nEnnemi = new Ennemi(cartePrincipale);
            nEnnemi.init();
            nEnnemi.setX(randomX);
            nEnnemi.setY(randomY);
            ennemis.add(nEnnemi);
            tempsEnnemi=tempsDeJeu+5000;
        }
        
        tempsDeJeu += delta;

        if (!personnages.isEmpty() && !ennemis.isEmpty()) {
            for (Object e : ennemis) {
                Ennemi unEnnemi = (Ennemi) e;
                for (int i = 0; i < personnages.size(); i++) {
                    Joueur unJoueur = (Joueur) personnages.get(i);
                    boolean contient = personnages.contains(unEnnemi);
                    Point ennemiPos;
                    ennemiPos = new Point((int) unEnnemi.getX(), (int) unEnnemi.getY());
                    Point joueurPos = new Point((int) unJoueur.getX(), (int) unJoueur.getY());
                    if (unEnnemi.distancePoint(ennemiPos, joueurPos) <= 30) {
                        System.out.println("Joueur :" + unJoueur.getHP());
                        unEnnemi.attaque(unJoueur, tempsDeJeu);
                    }
                    if (unJoueur.getHP() <= 0) {
                        personnages.remove(unJoueur);
                    }
                }
            }
        }
        victoire(ennemis, batiments);
        defaite(personnages, batiments);
        }
    
    public void victoire(ArrayList ennemis, ArrayList batiments) {
        if (ennemis.isEmpty() && batiments.isEmpty()) {
            // game.addState(new EndGameState(null));
            // musicOut.play();
            game.enterState(EndGameState.ID);           
        }
    }

    public void defaite(ArrayList personnages, ArrayList batiments) {
        if (personnages.isEmpty()) {
            // musicOut.play();
            game.enterState(EndGameState.ID);
        }
    }

    public void keyReleased(int key, char c) {
        switch (key) {
            case Input.KEY_D:
                game.enterState(EndGameState.ID);
                break;
            case Input.KEY_A:
                if (!personnages.isEmpty() && !ennemis.isEmpty()) {
                    for (Object j : personnages) {
                        Joueur unPaysan = (Joueur) j;
                        for (int i = 0; i < ennemis.size(); i++) {
                            Ennemi unEnnemi = (Ennemi) ennemis.get(i);
                            boolean contient = ennemis.contains(unEnnemi);
                            Point paysanPos;
                            paysanPos = new Point((int) unPaysan.getX(), (int) unPaysan.getY());
                            Point ennemiPos = new Point((int) unEnnemi.getX(), (int) unEnnemi.getY());
                            if (unPaysan.isSelected() && unPaysan.distancePoint(paysanPos, ennemiPos) <= 30) {
                                unPaysan.attaque(unEnnemi, tempsDeJeu);
                                System.out.println("Vie restante Ennemi: " + unEnnemi.getHP());
                            }
                            if (unEnnemi.getHP() <= 0) {
                                cettePlanche.setScore(cettePlanche.getScore()+100);
                                ennemis.remove(unEnnemi);
                            }
                        }
                    }
                }
        }
    }
}
