/*
 * La classe modèle de l'entrepot, construit avec les ressources disponibles au départ.
 * Elle emmagasine les ressources recoltées et vérifie si les ressources sont disponibles
 * à la construction des unités ou des batiments.
 */
package modele;

/**
 *
 * @author Guillaume
 */
public class Entrepot {
    
    //Variables ressources du jeu
    private int bois, nourriture, or;
    
    //Constructeur des ressources de depart
    public Entrepot(int leBois, int laNourriture, int lOr){
        setBois(leBois);
        setNourriture(laNourriture);
        setOr(lOr);
    }
    
    //Getter
    public int getBois(){return this.bois;}
    public int getNourriture(){return this.nourriture;}
    public int getOr(){return this.or;}
    
    //Setter
    public void setBois(int leBois){this.bois = leBois;}
    public void setNourriture(int laNourriture){this.nourriture = laNourriture;}
    public void setOr(int lOr){this.or = lOr;}
    
    
    //Methodes specifiques
    //toString
    public String toString(){return "Nombre de bois : "+ getBois() +'\n'+
            "Nombre de nourriture : "+ getNourriture() +'\n'+ 
            "Nombre d'or : "+ getOr();}
    
    //Methode verification, si il y a assez de ressources pour accomplir la tâche: return true
    //Verification avec l'or et la nourriture: pour les unités
    public boolean verificationOrNourriture(int lOr, int laNourriture){
        if(getOr() < lOr || getNourriture() < laNourriture){return false;}
        else{return true;}
    }
    
    //Verification avec l'or et le bois: pour les batiments
    public boolean verificationOrBois(int lOr, int leBois){
        if(getOr() < lOr || getBois() < leBois){return false;}
        else{return true;}
    }
    
    //Verification avec l'or, le bois et la nourriture: pour construction spéciale
    public boolean verificationOrBoisNourriture(int lOr, int leBois, int laNourriture){
        if(getOr() < lOr || getBois() < leBois ||  getNourriture() < nourriture){return false;}
        else{return true;}
    }
    
    //Ajout des ressources à l'entrepot apres la recolte ca pourrait etre utilisé
    //avec l'objet entrepot. ex: Entrepot.setRessource(getRessource() + laRecolte);
    //Bois
    public void ajoutBois(int laRecolte){setBois(getBois() + laRecolte);}
    
    //Nourriture
    public void ajoutNourriture(int laRecolte){setNourriture(getNourriture()+ laRecolte);}
    
    //Or
    public void ajoutOr(int laRecolte){setOr(getOr() + laRecolte);}
}
