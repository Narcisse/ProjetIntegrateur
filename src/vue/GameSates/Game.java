package vue.GameSates;

import controleur.Camera;
import controleur.ControlleurEnnemi;
import controleur.ControlleurPersonnage;
import controleur.Informateur;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import vue.Attributs.*;
import vue.Hud.Hud;
import vue.ElementsPrincipauxDuJeu.Carte;
import vue.ElementsPrincipauxDuJeu.Ennemi;
import vue.ElementsPrincipauxDuJeu.Joueur;
import vue.Jeu.Baril;

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
    // Camera
    private Camera camera;
    //Score
    private int score;
    //ArrayList de personnage selectionné
    private ArrayList personnages = new ArrayList();
    private ArrayList ennemis = new ArrayList();
    private ArrayList attributs = new ArrayList();
    private ArrayList attPossibles = new ArrayList();

    private static int default_bullet_delay = 10000;

    private static int timer = 0;
    // Planche de jeu
    private Game cettePlanche;
    // Hud
    private Hud hud;
    //Menu In game
    private MenuIG menuIG;
    //Condition pour afficher menu
    private boolean escapePressed = false;
    // ID
    public static int ID = 1, condi = 1, tempsDeJeu = 0, tempsEnnemi = 0, highScore = 0;
    private float distance = 0;
    private Ennemi nEnnemi;
    //MenuPrincipal
    private MenuPrincipal menuP;
    //private Music musicOut;
    private BufferedWriter highScoreFile;

    // *************************************************************************
    // Constructeur
    public Game() {
        super();
        cartePrincipale = new Carte();
        cettePlanche = this;
        camera = new Camera(cartePrincipale);
        personnages.add(new Joueur(cartePrincipale));
        ennemis.add(new Ennemi(cartePrincipale));
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

    public Hud getHud() {
        return this.hud;
    }

    public void setScore(int unScore) {
        score = unScore;
    }

    public int getScore() {
        return score;
    }

    // *************************************************************************
    @Override
    public int getID() {
        return this.ID;
    }

    @Override
    public void enter(GameContainer gc, StateBasedGame sg) throws SlickException {

        // Image curseur = new Image("images/curseur.png", true);
        // this.container.setMouseCursor(curseur, 0, 0);
        cettePlanche.setScore(0);
        camera = new Camera(cartePrincipale);
        this.cartePrincipale.init();

        personnages = new ArrayList();
        ennemis = new ArrayList();
        attributs = new ArrayList();

        personnages.add(new Joueur(cartePrincipale));
        ennemis.add(new Ennemi(cartePrincipale));
                
        //Image curseur = new Image("images/curseur.png", true);
        //this.container.setMouseCursor(curseur, 0, 0);
        essentials(container, sg);
    }

    @Override
    public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
        // Jeu et carte
        this.container = container;
        this.game = sbg;
        essentials(container, sbg);
        //musicOut = new Music("Sons/MusicOut.ogg");
    }

    public void essentials(GameContainer container, StateBasedGame sbg) throws SlickException {
        //Image curseur = new Image("images/curseur.png", true);
        //this.container.setMouseCursor(curseur, 0, 0);
        this.cartePrincipale.init();
        attPossibles = Informateur.getToutAttributs(cartePrincipale);
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
        // Hud
        hud = new Hud(container, camera, container,(Joueur)personnages.get(0));
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
        menuIG = new MenuIG(container, camera, container);
        menuIG.init();
        menuP = new MenuPrincipal();
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
        if (!personnages.isEmpty()) {
            aquerirAttribut((Joueur) personnages.get(0), attributs);
        }
        this.cartePrincipale.renderAvantPlan();
        this.hud.render(g);

        if (container.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
            escapePressed = !escapePressed;
        }
        if (escapePressed == true) {
            this.menuIG.render(g);
        }
    }

    @Override
    public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
        // Delai avant de faire apparaitre un attribut;
        timer -= delta;
        if (timer <= 0) {
            Random generator = new Random();
            int attributChoisit = generator.nextInt(attPossibles.size());
            attributs.add(attPossibles.get(attributChoisit));
            timer = default_bullet_delay;  // Reset the timer
        }
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

        if (tempsDeJeu >= tempsEnnemi) {
            int[] coordonees;
            coordonees = Informateur.getRandomCoordinates(cartePrincipale);
            nEnnemi = new Ennemi(cartePrincipale);
            nEnnemi.init();
            nEnnemi.setX(coordonees[0]);
            nEnnemi.setY(coordonees[1]);
            ennemis.add(nEnnemi);
            tempsEnnemi = tempsDeJeu + 5000;
        }

        tempsDeJeu += delta;

        if (!personnages.isEmpty() && !ennemis.isEmpty()) {
            for (Object e : ennemis) {
                Ennemi unEnnemi = (Ennemi) e;
                for (int i = 0; i < personnages.size(); i++) {
                    Joueur unJoueur = (Joueur) personnages.get(i);
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
        defaite(personnages);
    }

    public void defaite(ArrayList personnages){
        if (personnages.isEmpty()) {
            Informateur.enterNewState(EndGameState.ID, container, game);           
            try {
                highScoreFile = new BufferedWriter(new FileWriter("HighScores//HighScore.txt",true));
            } catch (IOException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                highScoreFile.write(cettePlanche.getScore()+"");
                highScoreFile.newLine();
            } catch (IOException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                highScoreFile.close();
            } catch (IOException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    public void aquerirAttribut(Joueur unPaysan, ArrayList listeAttributs) {
        if (!listeAttributs.isEmpty()) {
            for (int i = 0; i < listeAttributs.size(); i++) {
                Attribut unAttribut = (Attribut) listeAttributs.get(i);
                Rectangle espaceOccupeAttribut = unAttribut.getRectangle();
                Rectangle espaceOccupePaysan = unPaysan.getRectangle();

                if (espaceOccupePaysan.intersects(espaceOccupeAttribut)) {
                    unPaysan.setAttributActif(unAttribut);
                    unAttribut.faireActions(unPaysan, null, ennemis);
                    attributs.remove(unAttribut);
                    System.out.println("Attribut acquis: " + unAttribut.toString());
                }
            }
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
                            Point paysanPos;
                            paysanPos = new Point((int) unPaysan.getX(), (int) unPaysan.getY());
                            Point ennemiPos = new Point((int) unEnnemi.getX(), (int) unEnnemi.getY());
                            if (unPaysan.isSelected() && unPaysan.distancePoint(paysanPos, ennemiPos) <= 30) {
                                unPaysan.attaque(unEnnemi, tempsDeJeu);
                                System.out.println("Vie restante Ennemi: " + unEnnemi.getHP());
                            }
                            if (unEnnemi.getHP() <= 0) {
                                cettePlanche.setScore(cettePlanche.getScore() + 100);
                                ennemis.remove(unEnnemi);
                            }
                        }
                    }
                }
        }
    }
}
