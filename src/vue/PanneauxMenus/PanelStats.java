package vue.PanneauxMenus;

/**
 * Loic Grant-Steinhardt
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class PanelStats extends PanelElder {

    private JPanel panHaut, panBas, panStats;
    private JButton bOK;
    private JLabel labStats1, labStats2;
    private JPanel cePanneau;
    
    public PanelStats() {
        super();
        initComponents();
        initListeners();
    }

    // Methodes spécifiques

    public void initComponents() {
        this.cePanneau = this;
        panStats = new JPanel(new GridLayout(2, 1, 10, 10));
        panHaut = new JPanel(new GridLayout(2, 1, 10, 10));
        panBas = new JPanel();
        Border noir = BorderFactory.createLineBorder(Color.black);
        Border titre = BorderFactory.createTitledBorder(noir, "Statistiques");
        panStats.setBorder(titre);
        labStats1 = new JLabel("1er dans le classement, plus de gold recolte.");
        labStats2 = new JLabel("Waw tu torches!");
        bOK = new JButton("     OK     ");
        panHaut.add(labStats1);
        panHaut.add(labStats2);
        panBas.add(bOK);
        panStats.add(panHaut);
        panStats.add(panBas);
        add(panStats);
    }

    public void initListeners() {
        bOK.addActionListener(new ActionListener() {
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
        frame.add(new PanelStats());
        frame.setSize(450, 250);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

}
