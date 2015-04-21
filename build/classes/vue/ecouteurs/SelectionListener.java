package vue.ecouteurs;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import vue.ElementsVisuels.UniteVue;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class SelectionListener extends MouseAdapter{
    // *************************************************************************
    // Donnees membres
    private UniteVue patientZero;

    
    // *************************************************************************
    // Constructeurs
    public SelectionListener(UniteVue uneUnite) {
        this.patientZero = uneUnite;
    }
    
    
    // *************************************************************************
    // Ecouteurs
    @Override
    public void mouseClicked(MouseEvent e) {
        if(patientZero.getSelectionner() != true){
            patientZero.setSelectionner(true);
        }else{
            patientZero.setSelectionner(false);
        }
        System.out.println("Touches moi pas!");
    }
}
