package vue.PanneauxMenus;

/**
 * Loic Grant-Steinhardt
 */

import controleur.DonneesUtiles;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.text.*;
import javax.swing.GroupLayout.*;
import javax.swing.border.*;

public class PanelTips extends PanelElder {

    private JTextArea textTips;
    private JPanel panHaut, panBas, panTips;
    private JButton bOK, bPrev, bNext;
    private ArrayList<String> listeAstuces;
    private int astuceActuelle;

    // Constructeur
    public PanelTips(JFrame laFrameQuiLeContient) {
        super();
        initComponents();
        initListeners();
        setFrameContainer(laFrameQuiLeContient);
    }

    public PanelTips() {
        super();
        initComponents();
        initListeners();
    }

    // Methodes spécifiques

    public void initComponents() {
        Dimension positions = DonneesUtiles.placerUnPanneauAuMilieu(this, this.getWidth() / 2, this.getHeight() / 2);
        this.setLocation(positions.height, positions.width);
        panTips = new JPanel(new GridLayout(2, 1, 10, 10));
        panHaut = new JPanel(new GridLayout(1, 1, 10, 10));
        panBas = new JPanel();
        Border noir = BorderFactory.createLineBorder(Color.black);
        Border titre = BorderFactory.createTitledBorder(noir, "Tips");
        panTips.setBorder(titre);
        textTips = new JTextArea();
        textTips.setColumns(30);
        textTips.setLineWrap(true);
        textTips.setRows(5);
        textTips.setWrapStyleWord(true);
        textTips.setEditable(false);
        astuceActuelle = 0;
        listeAstuces = new ArrayList<String>();
        panHaut.add(textTips);
        bPrev = new JButton("Precedent");
        bOK = new JButton("     OK     ");
        bNext = new JButton("Suivant");
        panBas.add(bPrev);
        panBas.add(bOK);
        panBas.add(bNext);
        panTips.add(panHaut);
        panTips.add(panBas);
        add(panTips);
        //Remplir la liste d'astuces        
        String uneLigne;
        BufferedReader entree;
        try {
            entree = new BufferedReader(new FileReader("ressources\\fichierTexte\\Tips.txt"));
            while ((uneLigne = entree.readLine()) != null) {
                listeAstuces.add(uneLigne);
                entree.readLine();
            }

            entree.close();
        } catch (IOException a) {
            JOptionPane.showMessageDialog(null, "Erreur");
        }
        textTips.setText(listeAstuces.get(0));
    }

    public void initListeners() {
        bOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                laFrameQuiLeContient.dispose();
            }
        });

        bNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    textTips.setText(listeAstuces.get(astuceActuelle + 1));
                    astuceActuelle += 1;
                } catch (IndexOutOfBoundsException ioobEx) {
                    astuceActuelle = 0;
                    textTips.setText(listeAstuces.get(astuceActuelle));
                }
            }
        });

        bPrev.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    textTips.setText(listeAstuces.get(astuceActuelle - 1));
                    astuceActuelle -= 1;
                } catch (IndexOutOfBoundsException ioobEx) {
                    astuceActuelle = listeAstuces.size() - 1;
                    textTips.setText(listeAstuces.get(astuceActuelle));
                }
            }
        });
    }

    // Mutateurs

    public void setFrameContainer(JFrame uneFrame) {
        super.laFrameQuiLeContient = uneFrame;
    }

    public JFrame getFrameContainer() {
        return super.laFrameQuiLeContient;
    }

    //MAIN POUR TESTER

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new PanelTips(frame));
        frame.setSize(400, 250);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

    }

}
