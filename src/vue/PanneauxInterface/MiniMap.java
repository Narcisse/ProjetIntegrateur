package vue.PanneauxInterface;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import vue.PanneauxMenus.PanLog;
import vue.ecouteurs.MiniMapListener;

/**
 *
 * @author Guillaume
 */
public class MiniMap extends JPanel {

    private ImageIcon imgLogo;
    private PanLog lesMessages;
    private PanMiniMap laMiniMapImage, laMiniMapText;
    private JPanel panel;

    public MiniMap() {
        super();
        initComposant();
        initListeners();
    }

    public void initComposant() {
        panel = this;
        panel.setFocusable(true);
        panel.requestFocusInWindow();
        imgLogo = new ImageIcon("images\\mini.jpg");
        lesMessages = new PanLog();
        //Constructeur avec l'image
        laMiniMapImage = new PanMiniMap(imgLogo.getImage());
        //Constructeur avec le JTextArea
        laMiniMapText = new PanMiniMap(lesMessages.getJTextAreaLog());
        this.add(laMiniMapText);
    }

    public void initListeners() {
        // Déclaration d'un écouteur pour les touches directionnelles
        MiniMapListener ecoMiniMap = new MiniMapListener(imgLogo, lesMessages.getJTextAreaLog());

        // Ajout de l'écouteur au panneau de test
        //panel.addKeyListener(ecoMiniMap);
        this.addKeyListener(ecoMiniMap);

    }

    public static void main(String[] args) {
        //creer un Pan_MiniMap avec une image
        JPanel unpan = new JPanel();
        unpan.add(new MiniMap());
        //creer une Pan_MiniMap avec un JTextArea
        //JPanel unpan = new PanMiniMap(new JTextArea("test"));

        JFrame uneFrame = new JFrame();
        uneFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        uneFrame.setSize(500, 500);

        uneFrame.add(unpan);
        uneFrame.setVisible(true);
    }
}
