/*
 * Classe modele paysan extends Unite
 * Méthode spécifique : toString(), deplacement(int x, int y), 
 * Classe model pour le paysan, unite de base à l'interieure du jeu
 */
package modele;

import vue.Attributs.Attribut;

/**
 * @author Loic Modifier par Christo
 */
public class Paysan extends Unite {

    //**************************************************************************
    // Donnees membres
    public static final String BOUTON_PAYSAN_ATTAQUER = "attaquer";
    public static final String BOUTON_PAYSAN_ARRETER = "Arreter";
    public static final String BOUTON_PAYSAN_RECOLTER = "Recolter";
    //Objet attribut 
    private Attribut attributActif;
    private double armure = 0.0;
    private final double augmentationArmure = 0.5;

    //**************************************************************************
    // Constructeur
    public Paysan() {
        //Initialisation des attributs du paysant
        initComponents();
    }

    //**************************************************************************
    // Méthodes spécifiques
    // Redefini la classe toString(), retourne une brève description de l'unité
    public String toString() {
        return ("Une unite de base qui permet" + "\n"
                + " la récolte de ressource et le combat");
    }
    
    public void augmenterArmure(){
        this.armure += augmentationArmure;
    }

    // Initialisation des données
    public void initComponents() {
        /*Les attributs dps nourritureNecessaire sont initialiser dans la classe Unite. 
         *Les attributs nom, vie, orNecessaire et */
        super.setNom("Paysant");
        super.setVie(150);
        super.setOrNecessaire(5);
        super.setDps(10);
        super.setNourritureNecessaire(10);
        attributActif = null;
    }
}

//Accesseur
    public Attribut getAttributActif() {
        return attributActif;
    }
    //Muttateur
    public void setAttributActif(Attribut nouveauAttribut){
        this.attributActif = nouveauAttribut;
    }
