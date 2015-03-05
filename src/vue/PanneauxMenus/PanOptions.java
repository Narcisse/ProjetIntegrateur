package vue.PanneauxMenus;

/**
 * Loic Grant-Steinhardt
 * ReCommenté par Christo Mondor
 */

import controleur.DonneesUtiles;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import vue.PanneauxInterface.PanMenuPrincipal;

public class PanOptions extends PanElder {

    private JButton bSon, bVideo, bControl, bOK;
    private JPanel panOptions;
    private JLabel labSpace;
    private JPanel cePanneau;
    // initialisés avec null pour pouvoir traiter le cas du constrcuteur vide
    private CardLayout cLayout = null;
    private Image img = null;

    public PanOptions(Image img, CardLayout cLayout) {
        super();
        Image swap = img.getScaledInstance(DonneesUtiles.largeurEcran, DonneesUtiles.hauteurEcran, Image.SCALE_SMOOTH);
        ImageIcon swap2 = new ImageIcon(swap);
        this.img = swap;
        this.cLayout = cLayout;
        initComponents();
        initListeners();
    }

    public PanOptions() {
        super();
        initComponents();
        initListeners();
        this.setSize(400, 250);
    }

    // Methodes spécifiques

    public void initComponents() {
        this.setBackground(new Color(0, 0, 0, 0));
        this.cePanneau = this;
        // Panneau de 5 par 1 en gridLayout pour offrir une liste d'options
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
        // Lorsqu'on initie le panneau avec un card layout cette fonction s'occupe de changer la carte affichée
        // Lorsqu'on initie le panneau de facon vide, cette fonction dispose du cadre qui contient ce panneau
        bOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (cLayout != null){
                    cLayout.show(getParent(), PanMenuPrincipal.CARTE_MENU_PRINCIPALE);
                }else{
                    disposerDuCadreDuPanneau(cePanneau);
                }
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
