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
public class Paysan {

    //**************************************************************************
    // Donnees membres
    public static final String BOUTON_PAYSAN_ATTAQUER = "attaquer";
    public static final String BOUTON_PAYSAN_ARRETER = "Arreter";
    public static final String BOUTON_PAYSAN_RECOLTER = "Recolter";
    //Objet attribut 
    private Attribut attributActif;
    private double armure = 0.0;
    private final double augmentationArmure = 0.5;
    private double dps;
    //Attribut vie est la cantite de vie total que l'element possede
    private int vie;

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
        setVie(150);
        setDps(10);
        attributActif = null;
    }
}

//Accesseur
    public Attribut getAttributActif() {
        return attributActif;
    }
    public int getVie() {
        return this.vie;
    }
    public double getDps(){
        return this.dps;
    }
//Muttateur
    public void setAttributActif(Attribut nouveauAttribut){
        this.attributActif = nouveauAttribut;
    }
    public void setVie(int uneVie) {
        this.vie = uneVie;
    }
    public void setDps(double dps) {
        this.dps = dps;
    }
