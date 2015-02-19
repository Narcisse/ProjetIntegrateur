package vue.PanneauxMenus;

/**
 * Loic Grant-Steinhardt
 * Un panneau pour afficher une aide contextuel pour les
 * touches du jeu
 * ReCommenté par Christo Mondor
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.text.*;
import javax.swing.GroupLayout.*;
import javax.swing.border.*;

public class PanelHelp extends PanelElder {

    private JScrollPane scrollHelp;
    private JTextArea textHelp;
    private JPanel panHaut, panBas, panHelp, cePanneau;
    private JButton bOK;

    public PanelHelp() {
        super();
        initComponents();
        initListeners();
    }

    // Methodes spécifiques

    public void initComponents() {
        /*
         La disposition est simple, un panneau de fond (this) qui contient
         deux autres panneau dans un gridlayout de 2 par 1
        
         Le panHaut contient un textArea qui affiche un texte pré-définis pour
         rappeler les commandes à l'utilisateur. Le texte peut être lu dans un
         fichier, dans une version du programme à venir
         */
        this.cePanneau = this;
        panHelp = new JPanel(new GridLayout(2, 1, 10, 10));
        panHaut = new JPanel(new GridLayout(1, 1, 10, 10));
        panBas = new JPanel();
        Border noir = BorderFactory.createLineBorder(Color.black);
        Border titre = BorderFactory.createTitledBorder(noir, "Aide");
        panHelp.setBorder(titre);
        textHelp = new JTextArea();
        textHelp.setColumns(30);
        textHelp.setLineWrap(true);
        textHelp.setRows(5);
        textHelp.setWrapStyleWord(true);
        textHelp.setEditable(false);
        textHelp.setText("Raccourci:\nF1 - ...\nF2 - ...\nF3 - ...\nF4 - ...\nF5 - ...\nF6 - ...\nF7 - ...\nF8 - ...\nF9 - ...\nF10 - ...\nF11 - ...\nF12 - ...");
        scrollHelp = new JScrollPane(textHelp);
        panHaut.add(scrollHelp);
        bOK = new JButton("     OK     ");
        panBas.add(bOK);
        panHelp.add(panHaut);
        panHelp.add(panBas);
        add(panHelp);
    }

    public void initListeners() {
        bOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                disposerDuCadreDuPanneau(cePanneau);
            }
        });
    }
    /*
    Cette fonction permet de disposer d'un window donc d'un JFrame, un Jdialog etc. dans n'importe quelle
    situation et dans n'importe quelle partie du code
    */
    @Override
    public void disposerDuCadreDuPanneau(JPanel unPanneau) {
        super.disposerDuCadreDuPanneau(unPanneau);
    }
    //MAIN POUR TESTER

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new PanelHelp());
        frame.setSize(400, 250);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

}
