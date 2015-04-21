package vue.ElementsVisuels;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author OlivierSSD
 */
//Classe hotel de ville extends batiment
public class HotelDeVilleVue extends BatimentVue {

    //Données
    private Image imgHotelVille = new ImageIcon("images\\chat.jpg").getImage();
    private String nom = "Hotel de Ville";
    public static final String BOUTON_HOTELVILLE_PAYSAN = "paysan";
    public static final String BOUTON_HOTELVILLE_CANCEL = "annuler";
    private ArrayList<JButton> btnHotel;

//Constructeur
    public HotelDeVilleVue(int vie, int boisNecessaire, int orNecessaire, int positionX, int positionY) {
        //Importation des données du bâtiment
        super(vie, boisNecessaire, orNecessaire, positionX, positionY);
        initComponents();
        initListeners();
    }
    // Méthodes spécifiques
    public void initComponents(){
        btnHotel = new ArrayList<>();
        JButton btnPaysan = new JButton("Paysan");
        btnPaysan.setName(BOUTON_HOTELVILLE_PAYSAN);
        btnHotel.add(btnPaysan);
        JButton btnAnnuler = new JButton("annuler");
        btnAnnuler.setName(BOUTON_HOTELVILLE_CANCEL);
        btnHotel.add(btnAnnuler);
    }
    public void initListeners(){
        EcouteurHotelVille ecoPaysan = new EcouteurHotelVille();
        addMouseListener(ecoPaysan);
    }
    //Accesseurs
    public String getNom() {
        return this.nom;
    }

    public ArrayList<JButton> getBoutonsActions() {
        return this.btnHotel;
    }
    //**************************************************************************
    // Écouteurs
    public class EcouteurHotelVille extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            PaysanVue unPaysan = new PaysanVue();
        }        
    }
}
