package vue.PanneauxMenus;

/**
 * Loic Grant-Steinhardt
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import vue.PanneauxInterface.PanMenuPrincipal;
import vue.composants.BoitesDialogue;

public class PanelMenu extends PanelElder {

    private JButton bSave, bLoad, bOptions, bHelp, bTips, bEnd, bBack;
    private JPanel panMenu, panHaut, panMid, panBas;
    private JLabel labSpace;
    private JPanel cePanneau;
    
    public PanelMenu() {
        super();
        this.cePanneau = this;
        initComponents();
        initListeners();
    }

    // Methodes spécifiques

    public void initComponents() {
        
        panMenu = new JPanel(new GridLayout(3, 1, 10, 10));
        panMenu.setBackground(new Color(0,0,0,0));
        Border noir = BorderFactory.createLineBorder(Color.black);
        Border titre = BorderFactory.createTitledBorder(noir, "Menu de Jeu");
        panMenu.setBorder(titre);

        panHaut = new JPanel(new GridLayout(3, 1, 0, 10));
        bSave = new JButton("Sauvegarder Partie");
        bLoad = new JButton("Charger Partie");
        bOptions = new JButton("Options");

        panHaut.add(bSave);
        panHaut.add(bLoad);
        panHaut.add(bOptions);
        panMenu.add(panHaut);

        panMid = new JPanel(new FlowLayout(0, 0, 0));
        bHelp = new JButton("    Aide   ");
        bTips = new JButton(" Astuces ");

        panMid.add(bHelp);
        panMid.add(bTips);
        panMenu.add(panMid);

        panBas = new JPanel(new GridLayout(3, 1, 0, 10));
        bEnd = new JButton("Terminer Partie");
        labSpace = new JLabel("   ");
        bBack = new JButton("Retour a la Partie");

        panBas.add(bEnd);
        panBas.add(labSpace);
        panBas.add(bBack);
        panMenu.add(panBas);
        panHaut.setBackground(new Color(0,0,0,0));
        panMid.setBackground(new Color(0,0,0,0));
        panBas.setBackground(new Color(0,0,0,0));
        add(panMenu);
    }

    public void initListeners() {
        bSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFileChooser savePartie = new JFileChooser();
                savePartie.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                savePartie.showDialog(null, "Sauvegarder");
                JOptionPane.showMessageDialog(null, "Partie Sauvegard�e");
            }
        });

        bLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFileChooser savePartie = new JFileChooser();
                savePartie.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                savePartie.showDialog(null, "Charger");
                JOptionPane.showMessageDialog(null, "Chargement en Cours...");
            }
        });
        bOptions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFrame frame = new JFrame();
                frame.add(new PanelOptions());
                frame.setSize(300, 400);
                frame.setVisible(true);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
            }
        });

        bHelp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                new BoitesDialogue(new PanelHelp(), "Aide", 400, 250);
            }
        });

        bTips.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFrame frame = new JFrame();
                frame.add(new PanelTips());
                frame.setSize(400, 250);
                frame.setVisible(true);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
            }
        });

        bEnd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                int option = JOptionPane.showConfirmDialog(null, "Voulez-vous sauvegarder avant de quitter?", "Sauvegarder?",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (option == JOptionPane.YES_OPTION) {
                    JFileChooser savePartie = new JFileChooser();
                    savePartie.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    savePartie.showDialog(null, "Sauvegarder");
                    JOptionPane.showMessageDialog(null, "Partie Sauvegardée");
                    JOptionPane.showMessageDialog(null, "Partie Terminée");
                    disposerDuCadreDuPanneau(cePanneau);
                    PanMenuPrincipal frame = new PanMenuPrincipal();
                    frame.setVisible(true);
                } else {
                    disposerDuCadreDuPanneau(cePanneau);
                    PanMenuPrincipal frame = new PanMenuPrincipal();
                    frame.setVisible(true);
                }

            }
        });

        bBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                disposerDuCadreDuPanneau(cePanneau);
            }
        });
    }
    
    @Override
    public void disposerDuCadreDuPanneau(JPanel unPanneau) {
        super.disposerDuCadreDuPanneau(unPanneau);
    }

    //MAIN POUR TESTER

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new PanelMenu());
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }
}
