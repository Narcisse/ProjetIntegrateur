/*
 * Classe modèle mineOr extends ElementDecor
 * Methode specifique : retirerQuantite().
 * Représente le model pour tout les mine d'or qui serviront dans le jeu
 */
package modele;

/**
 *
 * @author Christo
 */
public class MineOr extends ElementDecor {

    // Donnee membres
    public final static int OR = 20;

    // Constructeur
    public MineOr() {
        super(Ressource.OR, 1000);
    }
}
