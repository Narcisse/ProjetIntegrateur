/*
* @author : 
* Classe modele Unite est le modèle pour tout les class qui seront des unitée
* 
*/

package modele;

public abstract class Unite extends Element{

    // Donnee membres
    // Attribut
    private int dps;
    private int nourritureNecessaire;

	
    // Mutateurs
    public void setDps(int unMontant) {
        this.dps = unMontant;
    }
    public void setNourritureNecessaire(int unMontant) {
        this.nourritureNecessaire = unMontant;
    }

    // Accesseurs
    public int getDps() {
        return this.dps;
    }

    public int getNourritureNecessaire() {
        return this.nourritureNecessaire;
    }
}
