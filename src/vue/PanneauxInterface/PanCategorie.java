package vue.PanneauxInterface;

/**
 * Paneau Categorie qui place les components relatifs aux instructions du panel
 */
import controleur.DonneesUtiles;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import modele.Categorie;

public class PanCategorie extends JPanel {

    //Données membres
    private JButton btnRetour;
    private JLabel lbInformation;
    private Image img;
    private CardLayout cLayout;
    private Categorie laCategorie;

    //Constructeur
    public PanCategorie(Image img, CardLayout cLayout, Categorie categorie) {
        super();
        //Image de fond
        Image swap = img.getScaledInstance(DonneesUtiles.largeurEcran, DonneesUtiles.hauteurEcran, Image.SCALE_SMOOTH);
        ImageIcon swap2 = new ImageIcon(swap);
        this.img = swap;
        //CardLayout
        this.cLayout = cLayout;
        //Categorie(ArrayList<String>, ArraayList<ImageIcon>)
        this.laCategorie = categorie;
        initDonnees();
    }

    //initialisation des Données membres
    public void initDonnees() {
        //setLayout(null) pour pouvoir utiliser la methode setBounds(x, y, width, height)
        this.setLayout(null);
        try {
            //Ajout d'un bouton de retour au menu Tutoriel
            btnRetour = new JButton("Retour au menu tutoriel");
            btnRetour.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 100,
                    Toolkit.getDefaultToolkit().getScreenSize().height - 100, 200, 25);
            this.add(btnRetour);

            //Information de la premiere partie de la categorie
            lbInformation = new JLabel(laCategorie.getString(1));
            lbInformation.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width / 2,
                    200, 500, 200);
            this.add(lbInformation);

            //Information de la deuxieme partie de la categorie
            lbInformation = new JLabel(laCategorie.getString(2));
            lbInformation.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width / 2,
                    400, 500, 200);
            this.add(lbInformation);
        } catch (Exception e) {
        }
    }

    //Methode painComponent qui ajoute les images et le titre
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Ajout de l'image de fond
        g.drawImage(img, 0, 0, null);

        //Puisque les images sont dans un ArrayList j'ai throw l'exception e.
        //Il se peut que nous ayons des erreurs du type NullPointerException
        try {
            //Ajouts des images
            g.drawImage(laCategorie.getImage(0).getImage(), 50, 200, this);
            g.drawImage(laCategorie.getImage(1).getImage(), 50, 450, this);
            g.setFont(new Font("Helvetica", Font.PLAIN, 30));

            //Le titre de la categorie
            g.drawString(laCategorie.getString(0), Toolkit.getDefaultToolkit().
                    getScreenSize().width / 2 - 100, getHeight() / 8);
            repaint();
        } catch (Exception e) {
        }
    }

    //Test
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        ImageIcon img = new ImageIcon("images\\chat.jpg");
        ArrayList<ImageIcon> lstImage = new ArrayList<ImageIcon>();
        lstImage.add(img);
        lstImage.add(img);

        ArrayList<String> lstString = new ArrayList<String>();
        lstString.add("TITRODELTUTORIALAMIGO");
        lstString.add("JAJAJMUIESPECIAL");
        lstString.add("JAJAJMUIESPECIAL");

        //Categorie categorie = new Categorie(lstString, lstImage);
        //PanCategorie panel = new PanCategorie(null, null, categorie);
        //frame.add(panel);
        frame.setSize(1000, 750);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
