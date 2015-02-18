/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    public HotelDeVille(int vie,int boisNecessaire,int orNecessaire,int positionX,int positionY) {
        //Importation des données du bâtiment
       super(vie,boisNecessaire,orNecessaire,positionX,positionY);
       // initialisation
            // composants graphiques
                btnHotel = new ArrayList<>();
                    JButton btnPaysan = new JButton("Paysan");
                    btnPaysan.setName(BOUTON_HOTELVILLE_PAYSAN);
                    btnHotel.add(btnPaysan);
                    JButton btnAnnuler = new JButton("annuler");
                    btnAnnuler.setName(BOUTON_HOTELVILLE_CANCEL);
                    btnHotel.add(btnAnnuler);
    }

    //Accesseurs
    public String getNom() {return this.nom;}
    public int getVie() {return super.getVie();}
    public int getBoisNecessaire() {return super.getBoisNecessaire();}
    public int getOrNecessaire() {return super.getOrNecessaire();}
    public int getPositionX() {return super.getPositionX();}
    public int getPositionY() {return super.getPositionY();}
    public ArrayList<JButton> getBoutonsActions() {return this.btnHotel;}
    
    //Mutateurs
    public void setVie(int unMontant){super.setVie(unMontant);}
    public void setOrNecessaire(int unMontant){super.setOrNecessaire(unMontant);}
    public void setPositionX(int uneValeurX){super.setPositionX(uneValeurX);}
    public void setPositionY(int uneValeurY){super.setPositionY(uneValeurY);}

    //Méthode
    
    //Générer un paysan
       public void genererPaysan() {
        Paysan newPaysan = new Paysan();
    }
    
    
    //Test 
    public static void main(String[] args) {
        HotelDeVille unHotelDeVille = new HotelDeVille(50,100,20,0,0);
        JOptionPane.showMessageDialog(null,
                "Nom du bâtiment: " + unHotelDeVille.getNom() + "\n"
                + "Bois necessaire: "+ unHotelDeVille.getBoisNecessaire() + "\n"
                + "Or necessaire: " + unHotelDeVille.getOrNecessaire() + "\n"
                + "Position: " + unHotelDeVille.getPositionX() + "(x), "
                + unHotelDeVille.getPositionY() + "(y)" + "\n"
                + "Fin du test..."
        );
    }
}
