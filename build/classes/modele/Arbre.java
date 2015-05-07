package modele;

/**
 *
 * @author Christo
 */
public class Arbre extends ElementDecor {

    // *************************************************************************
    // Constructeur
    public final static int BOIS = 10;

    public Arbre() {
        super(Ressource.BOIS, 10);
    }
}
