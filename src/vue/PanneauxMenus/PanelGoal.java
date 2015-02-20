package vue.PanneauxMenus;

/**
 * Loic Grant-Steinhardt
 * ReCommenté par Christo Mondor
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
        /*
         La disposition est simple, un panneau de fond (this) qui contient
         deux autres panneau dans un gridlayout de 2 par 1
        
         Le panHaut contient deux label qui affiche un texte pré-définis dans le
         code ou dans un fichier texte, selon le stade de développement
         */
        this.cePanneau = this;
        panGoal = new JPanel(new GridLayout(2, 1, 10, 10));
        panHaut = new JPanel(new GridLayout(2, 1, 10, 10));
        panBas = new JPanel();
        // Création d'une bordure pour le panneau qui englobe le tout (panGoal)
        Border noir = BorderFactory.createLineBorder(Color.black);
        Border titre = BorderFactory.createTitledBorder(noir, "Objectifs");
        panGoal.setBorder(titre);
        // Création des labels qui contiennent les objectifs et le texte général
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
