package vue.ecouteurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modele.HotelDeVille;

/**
 *
 * @author Christo
 */
public class EcouteurBoutonsHotelVille implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        if(((JButton)e.getSource()).getName().equals(HotelDeVille.BOUTON_HOTELVILLE_PAYSAN)){
            JOptionPane.showMessageDialog(null, "Un paysan est né!");
        }
        if(((JButton)e.getSource()).getName().equals(HotelDeVille.BOUTON_HOTELVILLE_CANCEL)){
            JOptionPane.showMessageDialog(null, "L'action a été annulée");
        }
    }
}
