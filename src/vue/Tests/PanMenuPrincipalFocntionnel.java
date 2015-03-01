package vue.Tests;

import controleur.DonneesUtiles;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class PanMenuPrincipalFocntionnel extends JPanel{
    // *************************************************************************
    // Donnees membres
    private JButton btnMulti, btnSingle, btnCredits, btnOptions, btnQuit, btnTutoriel;
    private Image img;
    private ImageIcon swap2;
    private Image swap;
    
    
    // *************************************************************************
    // Constructeur
    public PanMenuPrincipalFocntionnel(Image img){
        super();
        initComponents(img);
        initListeners();
    }
    
    
    // *************************************************************************
    // Methodes specifiques
    public void initComponents(Image img){
        // Initialiser l'image pour la paint en background
        swap = img.getScaledInstance(DonneesUtiles.largeurEcran, DonneesUtiles.hauteurEcran, Image.SCALE_SMOOTH);
        swap2 = new ImageIcon(swap);
        this.img = swap;
        // Construire le gridbagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        changerContrainte(c, 0, 0, 0, 0, 0, 0);
    }
    public void initListeners(){
        
    }
    public void changerContrainte(GridBagConstraints c, int gridx, int gridy, int gridHeight, int gridwidth, int fill, int anchor){
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridheight = gridHeight;
        c.gridwidth = gridwidth;
        c.fill = fill;
        c.anchor = anchor;
    }
    
    
    // *************************************************************************
    // Main
    public static void main(String[] args){
        System.out.println("Hello world!");
    }
}
