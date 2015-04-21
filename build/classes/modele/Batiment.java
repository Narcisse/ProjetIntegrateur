package modele;

/**
 *
 * @author JESUS
 */
public abstract class Batiment extends Element{
    //Donnée 
    //Attributs
    //Element de construction
    //L'attribut boisNecessaire définit le nombre necessaire de bois pour construir le batiment
    private int boisNecessaire;
    // Constructeur
    public Batiment(){
        
    }

    //Accesseurs 
    public int getBoisNecessaire() {
        return this.boisNecessaire;
    }

    //Mutateurs
    public void setBoisNecessaire(int unBoisNecessaire) {
        this.boisNecessaire = unBoisNecessaire;
    }
}
