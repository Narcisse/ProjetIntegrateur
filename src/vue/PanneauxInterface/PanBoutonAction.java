/*Pannel situé en bas à droite de l'écran (3x3) contenant plusieurs boutons permettant 
la création d'unités,bâtiments,etc dépendament de ce qui est sélectionné avec la
souris*/
package vue.PanneauxInterface;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import vue.ElementsVisuels.HotelDeVilleVue;
import vue.ElementsVisuels.PaysanVue;
import vue.ecouteurs.EcouteurBoutonsHotelVille;
import vue.ecouteurs.EcouteurBoutonsPaysan;

/**
 *
 * @author Guillaume Classe du panneau d'action
 */
public class PanBoutonAction extends JPanel {

    //Donnée membre
    private ImageIcon bois;
    private JButton btnVide;
    private ArrayList<JButton> uneListe;
    private EcouteurBoutonsPaysan eco;

    //Constructeur
    public PanBoutonAction(ArrayList<JButton> uneListe, EcouteurBoutonsPaysan eco) {
        this.uneListe = uneListe;
        this.eco = eco;
        initComponents();
    }

    public PanBoutonAction() {
        this.uneListe = null;
        this.eco = null;
        initComponents();
    }

    // initialisations
    public void initComponents() {
        //Button = this.boutonAction;
        setLayout(new GridLayout(3, 3));
        bois = new ImageIcon("slider_fond-bois.jpg");
        if (eco != null && uneListe != null) {
            //Boucle qui ajoute l'image correspondant a la 'i' de la boucle for
            for (int i = 0; i < uneListe.size(); i++) {

                /*String numero = i + "";
                 //Image correspondant à la case 'i'
                 ImageIcon shiba = new ImageIcon("ImageAction\\Action" + numero + ".png");
                 Image imageShiba = shiba.getImage();
                 //Resize l'image afin de ne pas grossir les boutons
                 Image newimg = imageShiba.getScaledInstance(30, 45, java.awt.Image.SCALE_SMOOTH);
                 shiba = new ImageIcon(newimg);
                 boutonAction = new JButton(shiba);
                 boutonAction.setBackground(Color.BLACK);
                 panel.add(boutonAction);*/
                JButton btnSwap = uneListe.get(i);
                btnSwap.addActionListener(eco);
                this.add(btnSwap);
            }
            //Boucle qui ajoute des boutons vide si la class en parametre contient moins d'action que 9
            if (uneListe.size() < 9) {
                int btnVide = (9 - uneListe.size());
                for (int j = 0; j < btnVide; j++) {
                    this.btnVide = new JButton();
                    this.btnVide.setBackground(Color.BLACK);
                    this.btnVide.setEnabled(false);

                    this.add(this.btnVide);
                }
            }
        } else {
            for (int j = 0; j < 9; j++) {
                this.btnVide = new JButton();
                this.btnVide.setBackground(Color.BLACK);
                this.btnVide.setEnabled(false);

                this.add(this.btnVide);
            }
        }
    }

    //Main pour tester la class
    public static void main(String[] args) {
        PaysanVue unPaysan = new PaysanVue();
        EcouteurBoutonsPaysan ecoPaysan = new EcouteurBoutonsPaysan();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println(unPaysan.getBoutonsActions() + "");
        frame.add(new PanBoutonAction(unPaysan.getBoutonsActions(), ecoPaysan));
        frame.setSize(250, 245);
        frame.setVisible(true);
    }
}
