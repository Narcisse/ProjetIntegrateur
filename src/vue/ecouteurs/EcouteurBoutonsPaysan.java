package vue.ecouteurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import vue.ElementsVisuels.Paysan;

/**
 *
 * @author Christo
 */
public class EcouteurBoutonsPaysan implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        if(((JButton)e.getSource()).getName().equals(Paysan.BOUTON_PAYSAN_ATTAQUER)){
            JOptionPane.showMessageDialog(null, "Les paysans attaquent!");
        }
        if(((JButton)e.getSource()).getName().equals(Paysan.BOUTON_PAYSAN_ARRETER)){
            JOptionPane.showMessageDialog(null, "Les paysans arretent de bouger!");
        }
        if(((JButton)e.getSource()).getName().equals(Paysan.BOUTON_PAYSAN_RECOLTER)){
            JOptionPane.showMessageDialog(null, "Les paysans recoltent la ressource!");
        }
    }
}
