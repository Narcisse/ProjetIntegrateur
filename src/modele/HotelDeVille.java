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
    private String nom = "Hotel de Ville";
    public static final String BOUTON_HOTELVILLE_PAYSAN = "paysan";
    public static final String BOUTON_HOTELVILLE_CANCEL = "annuler";
    private ArrayList<JButton> btnHotel;

    //Constructeur
    public HotelDeVille(int vie, int boisNecessaire, int orNecessaire) {
        //Importation des données du bâtiment
        super(vie, boisNecessaire, orNecessaire);
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
    public String getNom() {
        return this.nom;
    }

    public int getVie() {
        return super.getVie();
    }

    public int getBoisNecessaire() {
        return super.getBoisNecessaire();
    }

    public int getOrNecessaire() {
        return super.getOrNecessaire();
    }


    public ArrayList<JButton> getBoutonsActions() {
        return this.btnHotel;
    }

    //Mutateurs
    public void setVie(int unMontant) {
        super.setVie(unMontant);
    }

    public void setOrNecessaire(int unMontant) {
        super.setOrNecessaire(unMontant);
    }


    //Méthode
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
