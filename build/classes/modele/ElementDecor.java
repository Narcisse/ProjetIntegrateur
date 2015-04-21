package modele;

/**
 *
 * @author Christo
 */
public abstract class ElementDecor{

    // Donnee membres
    private String ressource;
    private int quantiteDansLelement;
    
    // Constructeur
    public ElementDecor(String ressource, int quantite){
        
    }

    // Accesseurs
    public String getRessource() {
        return this.ressource;
    }

    public int getQuantite() {
        return this.quantiteDansLelement;
    }

    // Mutateurs
    public void setQuantite(int uneQuantite) {
        this.quantiteDansLelement = uneQuantite;
    }
	
    // Methode specifique
    // La methode retire 20 ressource d'or a chaque appel de la méthode
    // Si la quantite de la ressource = 0 elle lance Exception("Fonds insufisants")
    public void retirerQuantite() throws Exception {
        if (getQuantite() > 0) {
            this.quantiteDansLelement -= this.quantiteDansLelement;
        } else {
            throw new Exception();
        }
    }
}
