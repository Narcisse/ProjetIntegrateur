package vue.PanneauxInterface;

/**
 * Paneau Categorie qui place les components relatifs aux instructions du panel
 */
import controleur.DonneesUtiles;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        initListener();
    }

    //initialisation des Données membres
    public void initDonnees() {
        //Ajout d'un bouton de retour au menu Tutoriel
        btnRetour = new JButton("Retour au menu tutoriel");
        btnRetour.setBounds(DonneesUtiles.largeurEcran /2 - 100,
                DonneesUtiles.hauteurEcran - 30, 200, 25);
        this.add(btnRetour);
        //Place les Strings par rapport au nombre d'image dans la liste
        if (laCategorie.getlstImageSize() == 2) {
            layoutPourDeuxImages();
        } else if (laCategorie.getlstImageSize() == 3) {
            layoutPourTroisImages();
        } else {
        }
    }
    
    //Layout si il y a 2 images dans la liste
    public void layoutPourDeuxImages() {
        //setLayout(null) pour pouvoir utiliser la methode setBounds(x, y, width, height)
        this.setLayout(null);
        try {
            //Information de la premiere partie de la categorie
            lbInformation = new JLabel(laCategorie.getString(1));
            lbInformation.setBounds(DonneesUtiles.largeurEcran / 2,
                    200, 500, 200);
            this.add(lbInformation);

            //Information de la deuxieme partie de la categorie
            lbInformation = new JLabel(laCategorie.getString(2));
            lbInformation.setBounds(DonneesUtiles.largeurEcran / 2,
                    400, 500, 200);
            this.add(lbInformation);
        } catch (Exception e) {
        }
    }

    //Layout si il y a 3 images dans la liste
    public void layoutPourTroisImages() {
        //setLayout(null) pour pouvoir utiliser la methode setBounds(x, y, width, height)
        this.setLayout(null);
        try {
            //Information de la première partie de la categorie
            lbInformation = new JLabel(laCategorie.getString(1));
            lbInformation.setBounds(DonneesUtiles.largeurEcran / 2,
                    DonneesUtiles.largeurEcran / 14, 500, 200);
            this.add(lbInformation);

            //Information de la deuxième partie de la categorie
            lbInformation = new JLabel(laCategorie.getString(2));
            lbInformation.setBounds(DonneesUtiles.largeurEcran / 2,
                    3 * (DonneesUtiles.largeurEcran / 14) + 10, 500, 200);
            this.add(lbInformation);

            //Information de la troisième partie de la categorie
            lbInformation = new JLabel(laCategorie.getString(3));
            lbInformation.setBounds(DonneesUtiles.largeurEcran / 2,
                    5 * (DonneesUtiles.largeurEcran / 14) + 20, 500, 200);
            this.add(lbInformation);
        } catch (Exception e) {
        }
    }

    //Initialisation des Listeners
    public void initListener() {
        btnRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                cLayout.show(getParent(), PanMenuPrincipal.CARTE_TUTORIEL);
            }
        });
    }

    //Methode painComponent qui ajoute les images et le titre
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Ajout de l'image de fond
        g.drawImage(img, 0, 0, null);

        //Puisque les images sont dans un ArrayList j'ai throw l'exception e.
        //Il se peut que nous ayons des erreurs du type NullPointerException
        try {
            //Place les images par rapport au nombre d'image dans la liste
            if (laCategorie.getlstImageSize() == 2) {
                //Ajouts des images
                g.drawImage(laCategorie.getImage(0).getImage(), 50,
                        DonneesUtiles.largeurEcran / 9, this);
                g.drawImage(laCategorie.getImage(1).getImage(),
                        50, 3 * (DonneesUtiles.largeurEcran / 9), this);
            } else if (laCategorie.getlstImageSize() == 3) {
                g.drawImage(laCategorie.getImage(0).getImage(),
                        50, DonneesUtiles.largeurEcran / 14, this);
                g.drawImage(laCategorie.getImage(1).getImage(),
                        50, 3 * (DonneesUtiles.largeurEcran / 14) + 10, this);
                g.drawImage(laCategorie.getImage(2).getImage(),
                        50, 5 * (DonneesUtiles.largeurEcran / 14) + 20, this);
            }
            //Le titre de la categorie
            g.setFont(new Font("Helvetica", Font.PLAIN, 30));
            g.drawString(laCategorie.getString(0), DonneesUtiles.largeurEcran / 2 - 100,
                    DonneesUtiles.hauteurEcran/18);
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
