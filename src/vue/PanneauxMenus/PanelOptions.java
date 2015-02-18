package vue.PanneauxMenus;

/**
 * Loic Grant-Steinhardt
 *
 */

import controleur.DonneesUtiles;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import vue.PanneauxInterface.PanMenuPrincipal;

public class PanelOptions extends PanelElder {

    private JButton bSon, bVideo, bControl, bOK;
    private JPanel panOptions;
    private JLabel labSpace;
    private CardLayout cLayout;
    private Image img;

    public PanelOptions(Image img, CardLayout cLayout) {
        super();
        Image swap = img.getScaledInstance(DonneesUtiles.largeurEcran, DonneesUtiles.hauteurEcran, Image.SCALE_SMOOTH);
        ImageIcon swap2 = new ImageIcon(swap);
        this.img = swap;
        this.cLayout = cLayout;
        this.setBackground(new Color(0, 0, 0, 0));
        initComponents();
        initListeners();
    }

    public PanelOptions() {
        super();
        initComponents();
        initListeners();
    }

    // Methodes spécifiques

    public void initComponents() {
        panOptions = new JPanel(new GridLayout(5, 1, 10, 10));
        panOptions.setBackground(new Color(0, 0, 0, 0));

        bSon = new JButton("Son");
        bVideo = new JButton("Video");
        bControl = new JButton("Jouabilite");
        bOK = new JButton("OK");
        labSpace = new JLabel("   ");

        panOptions.add(bControl);
        panOptions.add(bSon);
        panOptions.add(bVideo);
        panOptions.add(labSpace);
        panOptions.add(bOK);

        add(panOptions);
    }

    public void initListeners() {
        bOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                cLayout.show(getParent(), PanMenuPrincipal.CARTE_MENU_PRINCIPALE);
            }
        });

        bSon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Option de Son");

            }
        });

        bVideo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Option de Video");

            }
        });

        bControl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Option de Jouabilite");

            }
        });
    }

    // Mutateurs
   
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}
