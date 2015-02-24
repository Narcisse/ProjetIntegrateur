/*
* Classe modele paysan extends Unite
* Méthode spécifique : toString(), deplacement(int x, int y), 
* Classe model pour le paysan, unite de base à l'interieure du jeu
*/

package modele;

import controleur.DonneesUtiles;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author Loic Modifier par Christo
 */
public class Paysan extends Unite {

    //**************************************************************************
    // Donnees membres
    private final String nom = "Paysan";
    public static final String BOUTON_PAYSAN_ATTAQUER = "attaquer";
    public static final String BOUTON_PAYSAN_ARRETER = "Arreter";
    public static final String BOUTON_PAYSAN_RECOLTER = "Recolter";

    //**************************************************************************
    // Constructeur
    public Paysan() {
        super();
		initComponents();
    }

    //**************************************************************************
    // Méthodes spécifiques
    
    // Redefini la classe toString(), retourne une brève description de l'unité
    public String toString() {
        return ("Une unite de base qui permet" + "\n"
                + " la récolte de ressource et le combat");
    }
	
    // Initialisation des données
    public void initComponents() {
		setVie(100);
        setDps(10);
        setOrNecessaire(50);
        setNourritureNecessaire(5);
    }
}
