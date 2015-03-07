package vue.PanneauxInterface;

import java.awt.GridLayout;
import java.awt.Image;
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
        panel = this;
        initComposant();
        initListeners();
    }

    public void initComposant() {       
        setFocusable(true);
        requestFocusInWindow();
        imgLogo = new ImageIcon(new ImageIcon("images\\chat.jpg").getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH));
        lesMessages = new PanLog();
        //Constructeur avec l'image
        laMiniMapImage = new PanMiniMap(imgLogo.getImage());
        //Constructeur avec le JTextArea
        laMiniMapText = new PanMiniMap(lesMessages.getJTextAreaLog());
        this.add(laMiniMapImage);
    }

    public void initListeners() {
        MiniMapListener ecoMiniMap = new MiniMapListener(imgLogo, lesMessages.getJTextAreaLog());
        panel.addKeyListener(ecoMiniMap);
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
