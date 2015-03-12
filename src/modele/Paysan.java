/*
* Classe modele paysan extends Unite
* Méthode spécifique : toString(), deplacement(int x, int y), 
* Classe model pour le paysan, unite de base à l'interieure du jeu
*/

package modele;

/**
 * @author Loic Modifier par Christo
 */
public class Paysan extends Unite {

    //**************************************************************************
    // Donnees membres
    public static final String BOUTON_PAYSAN_ATTAQUER = "attaquer";
    public static final String BOUTON_PAYSAN_ARRETER = "Arreter";
    public static final String BOUTON_PAYSAN_RECOLTER = "Recolter";

    //**************************************************************************
    // Constructeur
    public Paysan() {
        initComponents();
    }

    //**************************************************************************
    // Méthodes spécifiques
    
    // Redefini la classe toString(), retourne une brève description de l'unité
    public String toString() {
        return ("Une unite de base qui permet" + "\n"
                + " la récolte de ressource et le combat");
    }
	
    // Initialisation des données
    public void initComponents() {
        super.setDps(10);
        super.setNourritureNecessaire(5);
    }
}
