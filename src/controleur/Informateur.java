package controleur;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.time.*;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
/*
*	Christo
*	Une classe qui peut être utilisée pour accéder à diverses informations
*	comme la date et l'heure, la dimension de l'écran etc. 
*/

public class Informateur {
    //**************************************************************************
    // Donnees d'informations generales sur le programme
    public static final Color voileSombre = new Color(0f, 0f, 0f, 0.8f);
    public static Image fondDecran = new ImageIcon("images\\fond.jpg").getImage();
    public static int largeurEcran = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int hauteurEcran = Toolkit.getDefaultToolkit().getScreenSize().height;
    
    // Donnees utiles aux traitements
    private LocalTime leTemps;
    private LocalDate laDate;
    
    
    //**************************************************************************
    // Methodes specifiques a l'informateur
    public String donneHeure(){
        leTemps = LocalTime.now();
        String heure = leTemps.getHour() + ":" + leTemps.getMinute();
        return heure;
    }
    public String donneDate(){
        laDate = LocalDate.now();
        String date = laDate.format(DateTimeFormatter.ofPattern("d MMM uuuu"));
        return date;
    }
    
    
}
