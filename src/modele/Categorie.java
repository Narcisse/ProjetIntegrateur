/*
 */
package modele;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Guillaume
 *
 * Classe qui recoit en paramètre une image et un String, afin de créer un
 * tutoriel Utilisé avec la classe vue PanelTutoriel
 *
 */
public class Categorie implements Serializable {

private ArrayList<String> lstString = new ArrayList<String>();
private ArrayList<ImageIcon> lstImage = new ArrayList<ImageIcon>();

    public Categorie(ArrayList<String> listeString, ArrayList<ImageIcon> listeImage){
        this.lstString = listeString;
        this.lstImage = listeImage;
    }
    
    //Accesseurs
    public String getString(int index) {
        return lstString.get(index);
    }
    
    public ImageIcon getImage(int index){
        return lstImage.get(index);
    }
    
    public int getlstImageSize(){
        return lstImage.size();
    }
    
    public int getLstStringSize(){
        return lstString.size();
    }
    
    //Muttateurs    
    public void setString(int index, String leString) {
        lstString.set(index, leString);
    }
    
    public void setImage(int index, ImageIcon unImage){
        lstImage.set(index, unImage);
    }
    
    //Methode specifique
    //Verifie si les listes sont vides
    public boolean lstStringVide(){
        boolean laListeEstVide = false;
        if(lstString.isEmpty()){laListeEstVide = true;}
        return laListeEstVide;
    }
    
    public boolean lstImageVide(){
        boolean laListeEstVide = false;
        if(lstImage.isEmpty()){laListeEstVide = true;}
        return laListeEstVide;
    }
}
