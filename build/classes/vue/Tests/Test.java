package vue.Tests;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import vue.ElementsVisuels.ArbreVue;
import vue.ElementsVisuels.ElementDecorVue;
import vue.ElementsVisuels.MineOrVue;
import vue.ElementsVisuels.PaysanVue;
import modele.Ressource;
import modele.Nourriture;

/**
 *
 * @author Christo
 */
/*
public class Test extends JFrame {
    // Donnees membres
    // Composants graphiques

    private JPanel panCentreBoutons, panBasOptions, panHautStatus;
    private ArrayList<JButton> boutons;
    private JLabel lblOr, lblNourriture, lblBois;
    private int bois;
    private int nourriture;
    private int or;
    private ElementDecorVue unArbre = new ArbreVue();
    private Vache uneVache = new Vache();
    private ElementDecorVue uneMineOr = new MineOrVue();

    // Constructeur

    public Test() {
        this.setTitle("Chantier en construction...");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
            // initialisations
        // Donnees membres
        bois = 100;
        nourriture = 100;
        or = 100;
        // graphique
        initComponents();
        // evenementielles
        initListeners();
    }

    public void initComponents() {
        // Boutons
        boutons = new ArrayList<>();
        boutons.add(new JButton("Paysan"));
        boutons.add(new JButton("Arbre"));
        boutons.add(new JButton("Vache"));
        boutons.add(new JButton("Mine"));
        // NORTH
        panHautStatus = new JPanel(new GridLayout(1, 3));
        this.add(panHautStatus, BorderLayout.NORTH);
        lblOr = new JLabel("Or: " + or);
        panHautStatus.add(lblOr);
        lblBois = new JLabel("Bois: " + bois);
        panHautStatus.add(lblBois);
        lblNourriture = new JLabel("Nourriture: " + nourriture);
        panHautStatus.add(lblNourriture);
        // CENTER
        panCentreBoutons = new JPanel(new GridLayout(3, 3));
        this.add(panCentreBoutons, BorderLayout.CENTER);
        for (int i = 0; i < boutons.size(); i++) {
            panCentreBoutons.add(boutons.get(i));
        }
        for (int i = 0; i < (9 - boutons.size()); i++) {
            panCentreBoutons.add(new JButton());
        }

    }

    public void initListeners() {
        boutons.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaysanVue unPaysan = new PaysanVue();
                JOptionPane.showMessageDialog(null,
                        "Nom de l'unité: " + unPaysan.getNom() + "\n"
                        + "Or necessaire: " + unPaysan.getOrNecessaire() + "\n"
                        + "Nouriture necessaire: " + unPaysan.getNourritureNecessaire() + "\n"
                        + "Position: " + unPaysan.getPositionX() + "(x), "
                        + unPaysan.getPositionY() + "(y)" + "\n"
                        + "Fin du test..."
                );
            }
        });
        boutons.get(1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajouterRessource(unArbre.getRessource(), unArbre.getQuantite());
            }
        });
        boutons.get(2).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajouterRessource(uneVache.getRessource(), uneVache.getQuantite());
            }
        });
        boutons.get(3).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    uneMineOr.retirerQuantite();
                    ajouterRessource(uneMineOr.getRessource(), MineOrVue.quantiteRetirer);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });
    }

    public void ajouterRessource(String uneRessource, int uneQuantite) {
        if (uneRessource.equals(Ressource.BOIS)) {
            bois += uneQuantite;
            changerLesLabels(bois, or, nourriture);
        }
        if (uneRessource.equals(Ressource.OR)) {
            or += uneQuantite;
            changerLesLabels(bois, or, nourriture);
        }
        if (uneRessource.equals(Ressource.NOURRITURE)) {
            nourriture += uneQuantite;
            changerLesLabels(bois, or, nourriture);
        }
    }

    public void changerLesLabels(int bois, int or, int Nourriture) {
        lblOr.setText("Or: " + or);
        lblBois.setText("Bois: " + bois);
        lblNourriture.setText("Nourriture: " + nourriture);
    }

    // Zone de test

    public static void main(String[] args) {
        Test uneFenetre = new Test();
        uneFenetre.setVisible(true);
    }
}
*/