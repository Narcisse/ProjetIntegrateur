package vue.ElementsVisuels;

import modele.Ressource;
/**
 *
 * @author Christo
 */
public class MineOrVue extends ElementDecorVue {

    // Donnee membres

    public static final int quantiteRetirer = 20;

    // Constructeur

    public MineOrVue() {
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
