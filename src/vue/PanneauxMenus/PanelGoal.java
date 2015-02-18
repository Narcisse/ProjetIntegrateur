package vue.PanneauxMenus;

/**
 * Loic Grant-Steinhardt
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.text.*;
import javax.swing.GroupLayout.*;
import javax.swing.border.*;

public class PanelGoal extends PanelElder {

    private JPanel panHaut, panBas, panGoal, cePanneau;
    private JButton bOK;
    private JLabel labGoal1, labGoal2;

    // Constructeurs
    public PanelGoal() {
        super();
        initComponents();
        initListeners();
    }
    // Methodes Specifiques

    public void initComponents() {
        this.cePanneau = this;
        panGoal = new JPanel(new GridLayout(2, 1, 10, 10));
        panHaut = new JPanel(new GridLayout(2, 1, 10, 10));
        panBas = new JPanel();
        Border noir = BorderFactory.createLineBorder(Color.black);
        Border titre = BorderFactory.createTitledBorder(noir, "Objectifs");
        panGoal.setBorder(titre);
        labGoal1 = new JLabel("Vous devez repousser les vagues d'ennemis le plus longtemps possible.");
        labGoal2 = new JLabel("Bonne chance, vous en aurez besoin...");
        bOK = new JButton("     OK     ");
        panHaut.add(labGoal1);
        panHaut.add(labGoal2);
        panBas.add(bOK);
        panGoal.add(panHaut);
        panGoal.add(panBas);
        add(panGoal);
    }

    public void initListeners() {
        bOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                disposerDuCadreDuPanneau(panHaut);
            }
        });
    }
    @Override
    public void disposerDuCadreDuPanneau(JPanel unPanneau) {
        super.disposerDuCadreDuPanneau(cePanneau);
    }
    
    //MAIN POUR TESTER
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new PanelGoal());
        frame.setSize(450, 250);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

}
