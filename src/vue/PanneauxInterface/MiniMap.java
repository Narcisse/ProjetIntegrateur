package vue.PanneauxInterface;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import vue.PanneauxMenus.PanLog;

/**
 *
 * @author Guillaume
 */
public class MiniMap extends JPanel implements KeyListener {

    private ImageIcon imgLogo;
    private PanLog lesMessages;
    private PanMiniMap laMiniMap;
    private JPanel panel;
    private JLabel labelImage;

    private int tabCompteur = 0;

    public MiniMap() {
        super();
        panel = this;
        initComposant();
        this.addKeyListener(this);
    }

    public void initComposant() {
        setFocusable(true);
        requestFocusInWindow();
        this.setLayout(new GridLayout(1, 1));
        //imgLogo = new ImageIcon(new ImageIcon("images\\mini.jpg").getImage().getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_SMOOTH));
        initImage();
    }

    public void initImage() {
        imgLogo = new ImageIcon("images\\mini.jpg");
        labelImage = new JLabel();
        labelImage.setIcon(imgLogo);
        lesMessages = new PanLog();
        //Constructeur avec l'image
        laMiniMap = new PanMiniMap(imgLogo.getImage());
        labelImage.add(laMiniMap);
        this.add(labelImage);
    }

    public void initTexte() {
        PanLog messages = new PanLog();
        laMiniMap = new PanMiniMap(messages.getJTextAreaLog());
        this.add(laMiniMap);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SLASH) {
            if (tabCompteur == 0) {
                panel.removeAll();
                initImage();
                revalidate();
                tabCompteur++;
            } else if (tabCompteur == 1) {
                panel.removeAll();
                initTexte();
                revalidate();
                tabCompteur++;
            } else if (tabCompteur == 2) {
                panel.removeAll();
                JLabel tempo = new JLabel("à venir");
                panel.add(tempo);
                revalidate();
                tabCompteur = 0;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
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
