package vue.Tests;

import controleur.DonneesUtiles;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import modele.ElementDecor;
import modele.Vache;

/**
 *
 * @author Guillaume Cette classe est le chantier du déplacement des unités, ce
 * sera une frame dans laquelle j'essairai de déplacer un paysan à l'aide des
 * flèches et des touches awsd
 */
public class MouvementVache extends JFrame implements Runnable {

    // Données membres
    /*
     Je vais créer une liste pour tous les paysans
     Comme ça je vais pouvoir appliquer mes algorithmes
     de collision sur toute la liste de façon simple et
     rapide!
     */
    private ArrayList<ElementDecor> vaches = new ArrayList<ElementDecor>();
    // Un panneau pour bien contrôler le positionnement
    private JPanel panMouvements = new JPanel(new GridLayout(1, 1));
    // Une vache
    private Vache vacheUltime;
    private boolean mouvement1, mouvement2, mouvement3, running;
    private int compteurGaucheDroite = 0, compteurBasHaut = 0;
    private boolean horizontalPlein, verticalPlein;

    // *************************************************************************
    // Constructeurs
    public MouvementVache() {
        super();
        initComponents();
        //initListeners();
        mouvementRandom();
        initFrame();
        start();
    }

    // *************************************************************************
    // Méthodes spécifiques
    public void initFrame() {
        this.setUndecorated(true);
        this.setBackground(DonneesUtiles.invisibilityCloak);
        this.setTitle("The void");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(DonneesUtiles.largeurEcran, DonneesUtiles.hauteurEcran);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
    }

    public void initComponents() {
        /*Je vais ajouter des paysans dans le panneau panMouvements pour
         observer le comportement des méthodes que j'ai développer dans la
         classe paysan
         */
        vacheUltime = new Vache();
        // On doit définir manuellement les coordonnées du paysans
        vacheUltime.setPositionX(DonneesUtiles.largeurEcran / 2);
        vacheUltime.setPositionY(DonneesUtiles.hauteurEcran / 2);
        vaches.add(vacheUltime);
        this.setContentPane(vacheUltime);
    }

    //Mouvement de la vache (aléatoirement)
    public void run() {
        while (running) {
            int valeurDeplacement = 4;
            double mathRandom;
            mathRandom = Math.random();

            //Droite
            if (mathRandom * 100 >= 75 && compteurGaucheDroite <= 8) {
                if (compteurGaucheDroite == 8) {
                    horizontalPlein = false;
                } else {
                    vacheUltime.deplacement(valeurDeplacement, 0);
                    vacheUltime.repaint();
                    Sleep(200);
                    compteurGaucheDroite++;
                }
            } //Gauche
            else if ((mathRandom * 100 < 50 || mathRandom * 100 >= 25)
                    && compteurGaucheDroite >= -8 && horizontalPlein == false) {
                if (compteurGaucheDroite == -8) {
                    horizontalPlein = true;
                }
                vacheUltime.deplacement(-valeurDeplacement, 0);
                vacheUltime.repaint();
                Sleep(200);
                compteurGaucheDroite--;
            } //Bas
            else if ((mathRandom * 100 < 75 || mathRandom * 100 >= 50) && compteurBasHaut <= 8 && verticalPlein) {
                if (compteurBasHaut == 8) {
                    verticalPlein = false;
                } else {
                    vacheUltime.deplacement(0, valeurDeplacement);
                    vacheUltime.repaint();
                    Sleep(200);
                    compteurBasHaut++;
                }
            } //Haut
            else if (mathRandom * 100 < 25 && compteurBasHaut >= -8 ) {
                if (compteurBasHaut == -8) {
                    verticalPlein = true;
                } else {
                    vacheUltime.deplacement(0, -valeurDeplacement);
                    vacheUltime.repaint();
                    Sleep(200);
                    compteurBasHaut--;
                }
            }

            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }

    public synchronized void start() {
        running = true;
        new Thread(this).start();
    }

    public void Sleep(int i) {
        if (vacheUltime.compteur < 2) {
            //changer l'image de vache
            vacheUltime.compteur++;
        } else {
            vacheUltime.compteur = 0;
        }

        try {
            Thread.sleep(i);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void mouvementRandom() {
        int valeurDeplacement = 7;
        double mathRandom = Math.random();
        if (mathRandom * 100 >= 75) {
            vacheUltime.deplacement(valeurDeplacement, 0);

        }
    }

    // *************************************************************************
    // Zone de test
    public static void main(String[] args) {
        new MouvementVache();
    }

}
