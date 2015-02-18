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

    private ImageIcon imgDuTutoriel;
    private String infoTutoriel;
    private String titreCategorie;
    public String infoTutoriel2;
    private ImageIcon imgDuTutoriel2;

    private ArrayList<Categorie> listesDeCategoirie;

    public Categorie(ImageIcon imageDuTutoriel, ImageIcon imageDuTutoriel2, String informationTutoriel,
            String titreDeLaCategorie, String informationTutoriel2) {

        setImgDuTutoriel(imageDuTutoriel);
        setInfoDuTutoriel(informationTutoriel);
        setTitreCategorie(titreDeLaCategorie);
        setImgDuTutoriel2(imageDuTutoriel2);
        setInfoDuTutoriel2(informationTutoriel2);
        
        //listesDeCategoirie = new ArrayList<>();
        //listesDeCategoirie.add(this);
    }
    
    //Accesseurs
    public ImageIcon getImgDuTutoriel() {
        return this.imgDuTutoriel;
    }
    
    public ImageIcon getImgDuTutoriel2() {
        return this.imgDuTutoriel2;
    }

    public String getInfoTutoriel() {
        return this.infoTutoriel;
    }
    
    public String getInfoTutoriel2() {
        return this.infoTutoriel2;
    }

    public String getTitreCategorie() {
        return this.titreCategorie;
    }
    
    public Object getCategorieListe(){
        return this.listesDeCategoirie.indexOf(0);
    }

    //Muttateurs
    public void setImgDuTutoriel(ImageIcon image) {
        this.imgDuTutoriel = image;
    }

    public void setImgDuTutoriel2(ImageIcon image) {
        this.imgDuTutoriel2 = image;
    }
    
    public void setInfoDuTutoriel(String leString) {
        this.infoTutoriel = leString;
    }
    
    public void setInfoDuTutoriel2(String leString) {
        this.infoTutoriel2 = leString;
    }

    public void setTitreCategorie(String leString) {
        this.titreCategorie = leString;
    }

    //Methode specifique
    public void clearListeCategorie(){
        listesDeCategoirie.clear();
    }
    
}
