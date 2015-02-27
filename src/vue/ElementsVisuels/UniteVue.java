package vue.ElementsVisuels;


import javax.swing.JLabel;

public abstract class UniteVue extends JLabel{
    // Donnee membres
    // Attribut

    private String nom;
    private int vie;
    private int dps;
    private int orNecessaire;
    private int nourritureNecessaire;
    private int positionX;
    private int positionY;
    private boolean selectionner = false;

    // Constructeur
    public UniteVue() {
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
    public void setSelectionner(boolean selectionner){
        this.selectionner = selectionner;
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
    public boolean getSelectionner(){
        return this.selectionner;
    }

    
}
