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
    private JLabel labelImage;
    
    public MiniMap() {
        super();
        panel = this;
        initComposant();
        initListeners();
    }

    public void initComposant() {
        setFocusable(true);
        requestFocusInWindow();
        this.setLayout(new GridLayout(1,1));
        //imgLogo = new ImageIcon(new ImageIcon("images\\mini.jpg").getImage().getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_SMOOTH));
        imgLogo = new ImageIcon("images\\mini.jpg");
        labelImage = new JLabel();
        labelImage.setIcon(imgLogo);
        lesMessages = new PanLog();
        //Constructeur avec l'image
        laMiniMapImage = new PanMiniMap(imgLogo.getImage());
        labelImage.add(laMiniMapImage);
        this.add(labelImage);
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
