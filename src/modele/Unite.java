package modele;

import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Unite extends JLabel{
    // Donnee membres
    // Attribut

    private String nom;
    private int vie;
    private int dps;
    private int orNecessaire;
    private int nourritureNecessaire;
    private int positionX;
    private int positionY;

    // Constructeur
    public Unite() {
        super();
    }

    // Methodes specifiques
    public abstract void deplacement(int x, int y);

    public abstract String toString();
    // Mutateurs
    public void setVie(int unMontant) {
        this.vie = unMontant;
    }
    public void setDps(int unMontant) {
        this.dps = unMontant;
    }
    public void setOrNecessaire(int unMontant) {
        this.orNecessaire = unMontant;
    }
    public void setNourritureNecessaire(int unMontant) {
        this.nourritureNecessaire = unMontant;
    }
    public void setPositionX(int uneValeur) {
        this.positionX = uneValeur;
    }
    public void setPositionY(int uneValeur) {
        this.positionY = uneValeur;
    }

    // Accesseurs
    public String getNom() {
        return this.nom;
    }
    public int getVie() {
        return this.vie;
    }
    public int getDps() {
        return this.dps;
    }
    public int getOrNecessaire() {
        return this.orNecessaire;
    }
    public int getNourritureNecessaire() {
        return this.nourritureNecessaire;
    }
    public int getPositionX() {
        return this.positionX;
    }
    public int getPositionY() {
        return this.positionY;
    }

}
