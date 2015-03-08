package modele;

/**
 *
 * @author JESUS
 */
public abstract class Batiment {
    //Donnée 
    //Attributs

    private String nom;
    //Element de construction
    private int vie, boisNecessaire, orNecessaire;
    
    // Constructeur
    public Batiment(int vie, int bois, int or){
        
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
}
