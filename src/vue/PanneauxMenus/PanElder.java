package vue.PanneauxMenus;

import java.awt.Window;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Hubris
 */
public class PanElder extends JPanel {
    public PanElder() {
        super();
    }
    /*
    Cette fonction permet de disposer d'un window donc d'un JFrame, un Jdialog etc. dans n'importe quelle
    situation et dans n'importe quelle partie du code
    */
    public void disposerDuCadreDuPanneau(JPanel unPanneau){
        Window frame = (Window) SwingUtilities.getWindowAncestor(unPanneau);
        frame.dispose();
    }
}
