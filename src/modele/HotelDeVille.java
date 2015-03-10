/*
 * Classe modèle : HotelDeVille extend la classe batiment
 * Methode specifique : genererPaysan().
 * 
 */
package modele;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author OlivierSSD
 */
//Classe hotel de ville extends batiment
public class HotelDeVille extends Batiment {

    //Données
    public static final String BOUTON_HOTELVILLE_PAYSAN = "paysan";
    public static final String BOUTON_HOTELVILLE_CANCEL = "annuler";
    private ArrayList<JButton> btnHotel;

    //Constructeur
    public HotelDeVille(int vie, int boisNecessaire, int orNecessaire) {
        //Défintion des donné de la classe mère
        super.setNom("Hotel de Ville");
        super.setVie(vie);
        super.setBoisNecessaire(boisNecessaire);
        super.setOrNecessaire(orNecessaire);
        // initialisation
        // composants graphiques
        
        //Bouton paysan doit genererPaysan()
        btnHotel = new ArrayList<>();
        JButton btnPaysan = new JButton("Paysan");
        btnPaysan.setName(BOUTON_HOTELVILLE_PAYSAN);
        btnHotel.add(btnPaysan);
        
        //Bouton annuler doit annuler l'action précédente si elle n'est pas deja terminée.
        JButton btnAnnuler = new JButton("annuler");
        btnAnnuler.setName(BOUTON_HOTELVILLE_CANCEL);
        btnHotel.add(btnAnnuler);
    }

    //Accesseurs
    public ArrayList<JButton> getBoutonsActions() {
        return this.btnHotel;
    }


    //Méthode
    // Redefini la classe toString(), retourne une brève description de l'hotel de ville
    public String toString() {
        return ("Un batiment de base qui permet" + "\n"
                + " la création d'unité de bases");
    }
    
    //Générer un paysan
    public void genererPaysan() {
        Paysan newPaysan = new Paysan();
    }

    //Test 
    public static void main(String[] args) {
        HotelDeVille unHotelDeVille = new HotelDeVille(50, 100, 20);
        JOptionPane.showMessageDialog(null,
                "Nom du bâtiment: " + unHotelDeVille.getNom() + "\n"
                + "Bois necessaire: " + unHotelDeVille.getBoisNecessaire() + "\n"
                + "Or necessaire: " + unHotelDeVille.getOrNecessaire() + "\n"
                + "Fin du test..."
        );
    }
}
