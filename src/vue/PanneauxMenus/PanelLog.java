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

public class PanelLog extends PanelElder {

    private JScrollPane scrollLog;
    private JTextArea textLog;
    private JPanel panHaut, panBas, panLog;
    private JButton bOK;

    public PanelLog(JFrame laFrameQuiLeContient) {
        super();
        initComponents();
        initListeners();
        setFrameContainer(laFrameQuiLeContient);
    }

    public PanelLog() {
        super();
        initComponents();
        initListeners();
    }

    // Methodes spécifiques
    public void initComponents() {
        panLog = new JPanel(new GridLayout(2, 1, 10, 10));
        panHaut = new JPanel(new GridLayout(1, 1, 10, 10));
        panBas = new JPanel();
        Border noir = BorderFactory.createLineBorder(Color.black);
        Border titre = BorderFactory.createTitledBorder(noir, "Messages");
        panLog.setBorder(titre);
        textLog = new JTextArea();
        textLog.setColumns(30);
        textLog.setLineWrap(true);
        textLog.setRows(5);
        textLog.setWrapStyleWord(true);
        textLog.setEditable(false);
        textLog.setText("Tous les messages in-game apparaissent ici. Si vous n'avez pas eu le temps de lire ou tout simplement manquez un peu de mmoire ;)");
        scrollLog = new JScrollPane(textLog);
        panHaut.add(scrollLog);
        bOK = new JButton("     OK     ");
        panBas.add(bOK);
        panLog.add(panHaut);
        panLog.add(panBas);
        add(panLog);
    }

    public void initListeners() {
        bOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                laFrameQuiLeContient.dispose();
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
        frame.add(new PanelLog(frame));
        frame.setSize(400, 250);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

}
