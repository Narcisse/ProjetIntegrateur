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
    public HotelDeVille() {
        // initialisation
        /*La classe hotel de ville appelle la classe batiment qui
         *elle même appelle la classe Element où se trouve l'attribut nom, vie, orNecessaire.
         *L'attribut boisNecessaire se trouve dans la classe Batiment.*/
        super.setNom("Hotel de Ville");
        super.setVie(50);
        super.setBoisNecessaire(100);
        super.setOrNecessaire(20);
        
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
        HotelDeVille unHotelDeVille = new HotelDeVille();
    }
}
