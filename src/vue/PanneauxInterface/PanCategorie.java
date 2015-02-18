package vue.PanneauxInterface;

/**
 * Paneau Categorie qui place les components relatifs aux instructions du
 * tutoriel 2 imageIcon, 2 String d'instruction , 1 titre. Accédé par
 * l'actionListener contenue dans panelTutoriel
 */

import java.awt.*;
import javax.swing.*;
import modele.Categorie;

public class PanCategorie extends JPanel {

    //Données membres
    private JButton btnRetour;
    private JLabel lbInformation;
    private Categorie laCategorie;
    private JFrame frame;
    private JPanel panel;

    //Constructeur
    public PanCategorie(Categorie categorie, JFrame leFondEcran) {
        laCategorie = categorie;
        this.frame = leFondEcran;
        initDonnees();
    }

    //initialisation des Données membres
    public void initDonnees() {

        panel = this;
        //setLayout(null) pour pouvoir utiliser la methode setBounds(x, y, width, height)
        this.setLayout(null);

        btnRetour = new JButton("Retour au menu tutoriel");
        btnRetour.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 100,
                Toolkit.getDefaultToolkit().getScreenSize().height - 100, 200, 25);
        this.add(btnRetour);

        //Information de la premiere partie de la categorie
        lbInformation = new JLabel(laCategorie.getInfoTutoriel());
        lbInformation.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width / 2,
                200, 500, 200);
        this.add(lbInformation);

        //Information de la deuxieme partie de la categorie
        lbInformation = new JLabel(laCategorie.getInfoTutoriel2());
        lbInformation.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width / 2,
                400, 500, 200);
        this.add(lbInformation);

        frame.add(this);
    }

    //Methode painComponent qui ajoute les images et le titre
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        //Ajouts des images
        g.drawImage(laCategorie.getImgDuTutoriel().getImage(), 50, 200, this);
        g.drawImage(laCategorie.getImgDuTutoriel2().getImage(), 50, 450, this);
        g.setFont(new Font("Helvetica", Font.PLAIN, 30));

        //Le titre de la categorie
        g.drawString(laCategorie.getTitreCategorie(), Toolkit.getDefaultToolkit().
                getScreenSize().width / 2 - 100, getHeight() / 8);
        repaint();
    }

    //Test
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        ImageIcon img = new ImageIcon("images\\chat.jpg");
        Categorie categorieTest = new Categorie(img, img, "Voici les informations de "
                + "cette categorie du tutoriel", "Voici le titre de la categorie", "Voici le titre de la categorie");
        //frame.add(new PanelCategorie(categorieTest));
        frame.setSize(1000, 750);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
