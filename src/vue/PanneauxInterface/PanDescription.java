/*Ce pannel est présent en bas de l'écran au centre. Il contient la description de
 ce qui est sélectionné (le toString de l'élément sélectionné)*/
package vue.PanneauxInterface;

import vue.ElementsVisuels.ElementDecorVue;
import vue.ElementsVisuels.UniteVue;
import vue.ElementsVisuels.BatimentVue;
import modele.*;
/**
 *
 * @author usager
 */
import javax.swing.*;
import java.awt.*;

//Pannel du bas pour la description de l'unité
public class PanDescription extends JPanel {

    //Variables
    private JLabel lblNom, lblPaysan, lblInformation;
    private int frameHauteur, frameLargeur;
    private GridBagConstraints constraints;
    private Font monFont;
    private UniteVue unite;
    private BatimentVue batiment;
    private ElementDecorVue decor;
    private String test;

    //Constructeur
    public PanDescription(UniteVue uneUnite) {
        init();
        this.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        Contrainte(1, 0, 1, 0, 1, 1, GridBagConstraints.WEST);
        this.add(lblNom, constraints);
        Contrainte(1, 0, 1, 2, 1, 1, GridBagConstraints.WEST);
        this.add(lblInformation, constraints);

        lblNom.setFont(monFont);

        lblInformation.setFont(monFont);
        unite = uneUnite;
        batiment = null;
        decor = null;
    }

    public PanDescription(BatimentVue unBatiment) {
        init();
        this.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();

        Contrainte(1, 0, 1, 0, 1, 1, GridBagConstraints.WEST);
        this.add(lblNom, constraints);

        Contrainte(1, 0, 1, 2, 1, 1, GridBagConstraints.WEST);
        this.add(lblInformation, constraints);

        /*Contrainte(0, 0, 1, 0, 1, 1, GridBagConstraints.CENTER);
         this.add(lblPaysan, constraints);*/
        lblNom.setFont(monFont);
        //lblPaysan.setFont(monFont);
        lblInformation.setFont(monFont);
        batiment = unBatiment;
        unite = null;
        decor = null;
    }

    public PanDescription(ElementDecorVue unDecor) {
        init();
        this.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();

        Contrainte(1, 0, 1, 0, 1, 1, GridBagConstraints.WEST);
        this.add(lblNom, constraints);

        Contrainte(1, 0, 1, 2, 1, 1, GridBagConstraints.WEST);
        this.add(lblInformation, constraints);

        /*Contrainte(0, 0, 1, 0, 1, 1, GridBagConstraints.CENTER);
         this.add(lblPaysan, constraints);*/
        lblNom.setFont(monFont);
        //lblPaysan.setFont(monFont);
        lblInformation.setFont(monFont);
        decor = unDecor;
        unite = null;
        batiment = null;
    }

    public PanDescription() {
        init();
        this.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();

        Contrainte(1, 0, 1, 0, 1, 1, GridBagConstraints.WEST);
        this.add(lblNom, constraints);

        Contrainte(1, 0, 1, 2, 1, 1, GridBagConstraints.WEST);
        this.add(lblInformation, constraints);

        /*Contrainte(0, 0, 1, 0, 1, 1, GridBagConstraints.CENTER);
         this.add(lblPaysan, constraints);*/
        lblNom.setFont(monFont);
        //lblPaysan.setFont(monFont);
        lblInformation.setFont(monFont);
        unite = null;
        batiment = null;
        decor = null;
    }

    //Initialisation
    public void init() {
        frameHauteur = this.getHeight();
        frameLargeur = this.getWidth();
        lblNom = new JLabel("Nom: ");
        lblInformation = new JLabel("Information: ");
        monFont = new Font("Arial", Font.BOLD, 15);
    }

    @Override
    //Dessine/Écrit les données par rapport à l'élément sélectionné dans le pannel
    public void paint(Graphics g) {
        init();
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;

        g2D.setFont(new Font("Arial", Font.BOLD, 15));
        if (unite != null) {
//            g2D.drawString(unite.getNom(), 120, 90);
            //          g2D.drawString(unite.toString(), 120, 130);
        } else if (batiment != null) {
            g2D.drawString(batiment.getNom(), 120, 90); //dessine le nom du bâtiment
            g2D.drawString(batiment.toString(), 120, 130); //dessine la description
        } else if (decor != null) {
            g2D.drawString(decor.getRessource(), 120, 90);
            g2D.drawString(decor.toString(), 120, 130);
        }

    }

    //Méthode pour utiliser le gridbaglayout
    public void Contrainte(double weightx, double weighty, int gridx, int gridy, int gridwith, int gridheight, int gridAnchor) {
        constraints.weightx = weightx;
        constraints.weighty = weighty;
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.gridwidth = gridwith;
        constraints.gridheight = gridheight;
        constraints.fill = GridBagConstraints.NONE;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.anchor = gridAnchor;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new PanDescription());
        frame.setSize(500, 250);
        frame.setVisible(true);
    }
}
