/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author usager
 */
public class Batiment {
    //Donnée 
    //Attributs

    private String nom;
    private int vie, boisNecessaire, orNecessaire, positionX, positionY;

    //Donnée constructeur
    public Batiment(int uneVie, int unBoisNecessaire, int unOrNecessaire, int unePositionX, int unePositionY) {
        setVie(uneVie);
        setBoisNecessaire(unBoisNecessaire);
        setOrNecessaire(unOrNecessaire);
        setPositionX(unePositionX);
        setPositionY(unePositionY);
    }

    //Accesseurs 
    public String getNom() {
        return this.nom;
    }

    public int getVie() {
        return this.vie;
    }

    public int getBoisNecessaire() {
        return this.boisNecessaire;
    }

    public int getOrNecessaire() {
        return this.orNecessaire;
    }

    public int getPositionX() {
        return this.positionX;
    }

    public int getPositionY() {
        return this.positionY;
    }

    //Mutateurs
    public void setVie(int uneVie) {
        this.vie = uneVie;
    }

    public void setBoisNecessaire(int unBoisNecessaire) {
        this.boisNecessaire = unBoisNecessaire;
    }

    public void setOrNecessaire(int unOrNecessaire) {
        this.orNecessaire = unOrNecessaire;
    }

    public void setPositionX(int unePositionX) {
        this.positionX = unePositionX;
    }

    public void setPositionY(int unePositionY) {
        this.positionY = unePositionY;
    }

}
