/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Mauricio
 * La classe Elements est une classe mere qui regroupe les element en commun des 
 * classes Unite et Batiment
 */
public abstract class Element {
    //L'attribut nom est les nom pour chaque element du jeu
    private String nom;
    //Attribut vie est la cantite de vie total que l'element possede
    private int vie;
    //Attributs qui permentent de definir le cout pour construir l'élément
    private int orNecessaire;
    
    //Accesseurs 
    public String getNom() {
        return this.nom;
    }

    public int getVie() {
        return this.vie;
    }

    public int getOrNecessaire() {
        return this.orNecessaire;
    }
    
    //Mutateurs
    public void setNom(String unNom){
        this.nom = unNom;
    }
    
    public void setVie(int uneVie) {
        this.vie = uneVie;
    }

    public void setOrNecessaire(int unOrNecessaire) {
        this.orNecessaire = unOrNecessaire;
    }
    
    //Méthode spécifique
    // Redefini la classe toString(), retourne une brève description de l'unité
    public abstract String toString();

}
