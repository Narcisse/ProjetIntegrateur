
package modele;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Guillaume
 *
 * Classe qui recoit en paramètre une liste String et une liste d'ImageIcon,
 * afin de créer un tutoriel utilisé avec la classe vue PanelTutoriel
 *
 */

// Implements Serializable puisque il y aura une lecture de fichier
public class Categorie implements Serializable {

    //Données membres
    private ArrayList<String> lstString;
    private ArrayList<ImageIcon> lstImage;

    //Constructeur
    public Categorie(ArrayList<String> listeString, ArrayList<ImageIcon> listeImage) {
        //Ajout des éléments a l'interieure des listes
        lstString = new ArrayList<>();
        for (int i = 0; i < listeString.size(); i++) {
            setString(i, listeString.get(i));
        }

        lstImage = new ArrayList<>();
        for (int i = 0; i < listeImage.size(); i++) {
            setImage(i, listeImage.get(i));
        }
    }

    //Accesseurs
    public String getString(int index) {
        return lstString.get(index);
    }

    public ImageIcon getImage(int index) {
        return lstImage.get(index);
    }

    //Pour avoir la taille des listes
    public int getlstImageSize() {
        return lstImage.size();
    }

    public int getLstStringSize() {
        return lstString.size();
    }

    //Muttateurs    
    public void setString(int index, String leString) {
        lstString.add(index, leString);
    }

    public void setImage(int index, ImageIcon unImage) {
        lstImage.add(index, unImage);
    }
}
