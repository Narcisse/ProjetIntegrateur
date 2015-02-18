package vue.PanneauxInterface;

/**
 * Générateur de map en 2D dans un panneau à partir d'un fichier texte
 * 1=dalles, 2=arbres, 6=eau, 7=roches
 * Créer les maps dans \\ressources\\fichierTexte\\
 */

import controleur.DonneesUtiles;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javafx.beans.binding.SetExpression;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanJeux extends JPanel {

    // Données membres
    int nombreDeRangees;
    int nombreDeColonnes;
    int plancheDeJeu[][];
    String mapChoisie = "map2.txt";

    // Constructeur
    public PanJeux() {
        super();
        // initialisations
        // Données membres
        initMap();
        // Graphique
        initComposants();
    }
    // Méthodes spécifiques
    // initialisations
    // Donnee membre

    public void initMap() {

        // Lecture d'un fichier map
        BufferedReader reader = null;
        try {
            // Test pour la version 1 avec le fichier Map1.txt
            reader = new BufferedReader(new FileReader(new File("ressources\\fichierTexte\\" + mapChoisie)));
            nombreDeRangees = Integer.valueOf(reader.readLine());
            nombreDeColonnes = Integer.valueOf(reader.readLine());
            plancheDeJeu = new int[nombreDeRangees][nombreDeColonnes];
            for (int i = 0; i < nombreDeRangees; i++) {
                String uneLigne = reader.readLine();
                for (int j = 0; j < nombreDeColonnes; j++) {
                    plancheDeJeu[i][j] = Character.getNumericValue(uneLigne.charAt(j));
                }
            }
        } catch (Exception ex) {

        } finally {
            try {
                reader.close();
            } catch (IOException ioEx) {
                System.out.println("Erreur dans la fermeture du fichier");
            }
        }
    }

    // Graphiques
    public void initComposants() {
        this.setLayout(new GridLayout(nombreDeRangees, nombreDeColonnes));
        for (int i = 0; i < nombreDeRangees; i++) {
            for (int j = 0; j < nombreDeColonnes; j++) {
                if (plancheDeJeu[i][j] == 0) {
                    this.add(new JLabel(new ImageIcon("images\\romanStone.jpg")));
                } else if (plancheDeJeu[i][j] == 1) {
                    this.add(new JLabel(new ImageIcon("images\\forestTree.png")));
                } else if (plancheDeJeu[i][j] == 2) {
                    this.add(new JLabel());
                } else if (plancheDeJeu[i][j] == 3) {
                    this.add(new JLabel());
                } else if (plancheDeJeu[i][j] == 4) {
                    this.add(new JLabel());
                } else if (plancheDeJeu[i][j] == 5) {
                    this.add(new JLabel());
                } else if (plancheDeJeu[i][j] == 6) {
                    this.add(new JLabel(new ImageIcon("images\\waterTexture.gif")));
                } else if (plancheDeJeu[i][j] == 7) {
                    this.add(new JLabel(new ImageIcon("images\\rocks.png")));
                } else {
                    this.add(new JLabel());
                }
            }
        }
    }

    // Zone de test
    public static void main(String[] args) {
        JFrame frame = new JFrame("TEST SITE");
        frame.add(new PanJeux());
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(DonneesUtiles.largeurEcran, DonneesUtiles.hauteurEcran);
        frame.setVisible(true);
    }

}
