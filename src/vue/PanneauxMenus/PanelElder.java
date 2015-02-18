package vue.PanneauxMenus;

import java.awt.Window;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Hubris
 */
public class PanelElder extends JPanel {
    public PanelElder() {
        super();
    }
    public void disposerDuCadreDuPanneau(JPanel unPanneau){
        Window frame = (Window) SwingUtilities.getWindowAncestor(unPanneau);
        frame.dispose();
    }
}
