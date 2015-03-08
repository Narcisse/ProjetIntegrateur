package vue.ElementsVisuels;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Christo
 */
public abstract class ElementDecorVue extends JLabel {

    // Donnee membres
    private String ressource;
    private int quantiteDansLelement;
    private Image avantClick;
    private Image apresClick;
    private Image imgPeinturer;

    // Constructeur
    public ElementDecorVue(String uneRessource, int uneQuantiteDeRessource) {
        super();
        this.ressource = uneRessource;
        this.quantiteDansLelement = uneQuantiteDeRessource;
    }

    // Accesseurs
    public String getRessource() {
        return this.ressource;
    }

    public int getQuantite() {
        return this.quantiteDansLelement;
    }

    public Image getImage() {
        return this.imgPeinturer;
    }
    
    public Image getImageApresClick() {
        return this.apresClick;
    }
    
    public Image getImageAvantClick() {
        return this.avantClick;
    }

    // Mutateurs
    public void setQuantite(int uneQuantite) {
        this.quantiteDansLelement = uneQuantite;
    }
    public void setImageAvantClick(Image uneImage){
         avantClick = uneImage;
    }
    public void setImageApresClick(Image uneImage){
         apresClick = uneImage;
    }
    public void setImagePeinturer(Image uneImage){
         imgPeinturer = uneImage;
    }
    public void changerImage(){
        this.imgPeinturer = apresClick;
    }
    
    public void retirerQuantite() throws Exception {
        if (getQuantite() > 0) {
            this.quantiteDansLelement -= this.quantiteDansLelement;
        } else {
            throw new Exception();
        }
    }
}
