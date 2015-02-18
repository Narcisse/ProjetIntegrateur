package modele;

import javax.swing.ImageIcon;

/**
 *
 * @author Christo
 */
public class MineOr extends ElementDecor {

    // Donnee membres

    public static final int quantiteRetirer = 20;

    // Constructeur

    public MineOr() {
        super(Ressource.OR, 1000);
    }

    // Mutateurs

    public void retirerQuantite() throws Exception {
        if (super.getQuantite() > 0) {
            super.setQuantite(super.getQuantite() - quantiteRetirer);
        } else {
            throw new Exception("Fonds insufisants");
        }
    }
}
