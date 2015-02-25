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

private ArrayList<String> lstString;
private ArrayList<ImageIcon> lstImage;
private String[] lesString = new String[3];

    public Categorie(String[] desString, ArrayList<ImageIcon> listeImage){
        /*lstString = new ArrayList<>();
        for(int i = 0; i < listeString.size(); i++){
            setString(i, listeString.get(i));
        }*/
        
        this.lesString = desString;
        
        lstImage = new ArrayList<>();
        for(int i = 0; i < listeImage.size(); i++){
            setImage(i, listeImage.get(i));
        }
    }
    
    //Accesseurs
    public String getString(int index) {
        return lstString.get(index);
    }
    
    public String getTabString(int index){
        String leRetour = "NULL";
        if(index <= lesString.length){
            leRetour = lesString[index];
        }
        return leRetour;
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
        lstString.add(index, leString);
    }
    
    public void setImage(int index, ImageIcon unImage){
        lstImage.add(index, unImage);
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
