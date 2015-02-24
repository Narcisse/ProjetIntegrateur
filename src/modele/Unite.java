/*
* @author : 
* Classe modele Unite est le modèle pour tout les class qui seront des unitée
* 
*/

package modele;

public abstract class Unite{

    // Donnee membres
    // Attribut
    private String nom;
    private int vie;
    private int dps;
    private int orNecessaire;
    private int nourritureNecessaire;

    // Methodes specifiques
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
}
