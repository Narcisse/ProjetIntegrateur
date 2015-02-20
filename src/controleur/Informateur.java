package controleur;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
/*
*	Christo
*	Une classe qui peut être utilisée pour accéder à diverses informations
*	comme la date et l'heure, la dimension de l'écran etc.
*/

public class Informateur {
    // Donnees utiles aux traitements
    private LocalTime leTemps;
    private LocalDate laDate;
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
