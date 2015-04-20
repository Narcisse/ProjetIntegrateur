/*
 * Classe controlleur de la souris toute les actions qui utilise la souris devront être fait dans cette classe
 */
package controleur;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.Entrepot;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Cursor;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.opengl.CursorLoader;
import vue.Jeu.Carte;
import vue.Jeu.Joueur;
import vue.Jeu.Batiment;
import vue.Jeu.Game;

/**
 *
 * @author Élodie
 */
public class ControlleurSouris implements MouseListener {

    //Variables utilisées avec dans la classe controlleur de la souris
    //Le container du jeu
    private GameContainer container;
    //La camera
    private Camera camera;
    // La carte
    private Carte cartePrincipale;
    // Entrepot
    private Entrepot entrepot;
    //Utilisé pour savoir a quelle endroit la souris est cliqué
    private int xPressed = 0, yPressed = 0, indic = 0;
    //Le delta est la difference entre la position initiale de la souris et la position finale
    private int deltaX = 0, deltaY = 0;
    //ArrayList de personnage selectionné
    private ArrayList personnages = new ArrayList();
    private ArrayList lstSelection = new ArrayList();
    private ArrayList batiments = new ArrayList();
    //event
    private Input input;
    //Rectangle contruit par la souris
    private Rectangle rect;
    //Curseur
    private Cursor curseur;
    private boolean rectEstConstruit = false, mouseReleased = false;

    public ControlleurSouris(Game unePlanche) {
        this.personnages = unePlanche.getPersonnages();
        this.container = unePlanche.getContainer();
        this.camera = unePlanche.getCamera();
        this.cartePrincipale = unePlanche.getCartePrincipale();
        this.entrepot = unePlanche.getEntrepot();
        this.batiments = unePlanche.getBatiments();
        input = container.getInput();
    }

    public void render(GameContainer container, Graphics g) throws SlickException {
        if (rect != null) {
            g.setColor(new Color(255, 255, 255, 100));
            g.drawRect(getRectX(), getRectY(), getRectWidth(), getRectHeight());
            //Déconstruit le rectangle apres le relachement de la souris
            if (rectEstConstruit && mouseReleased) {
                //Temporaire, j'ai rien trouvé de mieux
                rect.setSize(0, 0);
                //reset les boolean apres le relachement de la souris
                rectEstConstruit = false;
                mouseReleased = false;
            }
        }
        if (input.isKeyPressed(Input.KEY_SPACE)) {
            try {
                //Curseur
                curseur = (CursorLoader.get()).getCursor("data/sprites/objet/TownHall.png", 0, 0);
            } catch (IOException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LWJGLException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                container.setMouseCursor(curseur, 0, 0);
            } catch (SlickException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
            indic = 1;
        }
    }

    @Override
    public void mouseWheelMoved(int i) {
        //N'est pas utilisé
    }

    @Override
    //À utiliser seulement pour les double click de la souris
    public void mouseClicked(int i, int i1, int i2, int i3) {
    }

    @Override
    //À utiliser pour les simple click
    //Button est le bouton de la souris: bouton de gauche = 0, bouton de droit = 1.
    //X représente la position de event.getX(), y représente la position de event.getY().
    public void mousePressed(int button, int x, int y) {

        xPressed = (int) (x + (camera.getX() - container.getWidth() / 2));
        yPressed = (int) (y + (camera.getY() - container.getHeight() / 2));
        // La camera est toujours au centre de l'ecran et donc en ajoutant son
        // x - la moitier de l'ecran on arrive a fixer la position en x de la
        // souris lors de la mise a jour de la camera.
        if (button == 0) {
            lstSelection.clear();

            //Construit l'hotel de ville 
            if (indic == 1) {
                try {
                    Batiment unBatiment = new Batiment(cartePrincipale, container, xPressed, yPressed);
                    container.setDefaultMouseCursor();
                    batiments.add(unBatiment);
                    indic = 0;
                } catch (SlickException eSlick) {
                    System.out.println("Erreur de chargement de l'image du batiment!");
                }
            }

            //Clear la liste si on click gauche, cancel la selection
            for (Object j : personnages) {
                Joueur unJoueur = (Joueur) j;
                unJoueur.selection(false);

                //Permet de selectionner un personnage en cliquant sur lui
                if (unJoueur.getX() >= xPressed && (unJoueur.getX() - 150.0) <= xPressed
                        && unJoueur.getY() >= yPressed && (unJoueur.getY() - 56.0) <= yPressed) {
                    unJoueur.selection(true);
                }

            }
            // changer .isArbre par une methode .isRessource pour une meilleure
            // gestion
            Point mousePos = Informateur.getMousePosition(camera, container);
            if (cartePrincipale.isArbre(mousePos.x, mousePos.y)) {
                recolte(cartePrincipale, entrepot, mousePos);
                System.out.print("recolte is called");
            }
            /*if (cartePrincipale.isOr(mousePos.x, mousePos.y)) {
             recolte(cartePrincipale, entrepot, mousePos);
             }
             if (cartePrincipale.isFood(mousePos.x, mousePos.y)) {
             recolte(cartePrincipale, entrepot, mousePos);
             }*/

            //Sélectionne le batiment
            for (Object b : batiments) {
                Batiment unBatiment = (Batiment) b;
                if ((xPressed >= unBatiment.getX() && xPressed <= (unBatiment.getX() + 64)) && (yPressed >= unBatiment.getY() && yPressed <= (unBatiment.getY() + 64))) {
                    unBatiment.setSelection(true);
                } else {
                    if (x < vue.Hud.Hud.positionXPaneauAction || y < vue.Hud.Hud.positionYPaneauAction) {
                        unBatiment.setSelection(false);
                    }
                }

                //Bouton creer Paysant dans l'hotel de ville
                if (unBatiment.isSelected() && x > (vue.Hud.Hud.positionXPaneauAction) && x < (vue.Hud.Hud.positionXPaneauAction + vue.Hud.Hud.tailleImagePaneauAction)
                        && y > vue.Hud.Hud.positionYPaneauAction && y < (vue.Hud.Hud.positionYPaneauAction + vue.Hud.Hud.positionYPaneauAction)) {
                    Joueur unPaysant;
                    unPaysant = new Joueur(cartePrincipale);
                    try {
                        unPaysant.init();
                    } catch (SlickException exPaysant) {
                        System.out.println("Problème avec le chargement de l'image du paysant!");
                    }
                    personnages.add(unPaysant);
                    input.addMouseListener(new ControlleurPersonnage(unPaysant, container, camera));

                }
            }
        }

        if (button == 1) {
            if (indic == 1) {
                container.setDefaultMouseCursor();
                indic = 0;
            }
        }
    }
    
    public void recolte(Carte uneCarte, Entrepot unEntrepot, Point unPointSouris) {

        if (uneCarte.isArbre(unPointSouris.x, unPointSouris.y)) {
            unEntrepot.ajoutBois(10);
            System.out.print("recolte ajoute 10");
        }
        /*if (cartePrincipale.isOr(unPointSouris.x, unPointSouris.y)) {
         unEntrepot.ajoutOr(10);
         }

         if (cartePrincipale.isFood(unPointSouris.x, unPointSouris.y)) {
         unEntrepot.ajoutNourriture(10);
         }*/
    }

    @Override
    //Relachement du bouton de la souris
    public void mouseReleased(int i, int i1, int i2) {
        //mouseReleased est true seulement si le rectangle est contruit
        //Donc si la mouseDragged a été appeler
        if (rectEstConstruit) {
            mouseReleased = true;
        }
    }

    @Override
    //Mouvement de la souris sans click
    public void mouseMoved(int i, int i1, int i2, int i3) {
    }

    @Override
    //Lorsque le boutton est click et que nous bougeons la souris
    public void mouseDragged(int oldx, int oldy, int newx, int newy) {
        personnages.clear();
        //input.isMouseButtonDown(0) représente le bouton de gauche
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

    @Override
    //??
    public void setInput(Input input) {
    }

    @Override
    //??
    public boolean isAcceptingInput() {
        return true;
    }

    @Override
    //??
    public void inputEnded() {
    }

    @Override
    //??
    public void inputStarted() {
    }

    public float getRectX() {
        return rect.getX();
    }

    public float getRectY() {
        return rect.getY();
    }

    public float getRectWidth() {
        return rect.getWidth();
    }

    public float getRectHeight() {
        return rect.getHeight();
    }
}
