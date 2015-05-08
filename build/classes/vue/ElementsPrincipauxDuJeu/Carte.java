package vue.ElementsPrincipauxDuJeu;

import org.lwjgl.util.Dimension;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author Christopher Desrosiers Mondor
 */
public class Carte {

    // *************************************************************************
    // Donnees membres
    private TiledMap carte;

    // *************************************************************************
    // Initialisation
    public void init() throws SlickException {
        this.carte = new TiledMap("data/map/cartePrincipale.tmx");
    }

    // *************************************************************************
    // Affichage
    public void renderArrierePlan() {
        this.carte.render(0, 0, 0);
        this.carte.render(0, 0, 1);
        this.carte.render(0, 0, 2);
        this.carte.render(0, 0, 5);
    }

    public void renderAvantPlan() {
        this.carte.render(0, 0, 3);
        this.carte.render(0, 0, 4);
    }

    public Dimension getMapDimension() {
        int mapWidth = carte.getWidth();
        int mapHeight = carte.getHeight();
        
        int tileWidth = carte.getTileWidth();
        int tileHeight = carte.getTileHeight();
        
        int mapPixelWidth = mapWidth * tileWidth;
        int mapPixelHeight = mapHeight * tileHeight;
        
        return new Dimension(mapPixelWidth, mapPixelHeight);
    }

    // *************************************************************************
    // Colisions

    public boolean isCollision(float x, float y) {
        int tileW = this.carte.getTileWidth();
        int tileH = this.carte.getTileHeight();
        int logicLayer = this.carte.getLayerIndex("logic");
        Image tile = this.carte.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
        boolean collision = tile != null;
        if (collision) {
            Color color = tile.getColor((int) x % tileW, (int) y % tileH);
            collision = (color.getAlpha() > 0);
        }
        return collision;
    }
    
    public boolean isArbre(float x, float y){
        int tileW = this.carte.getTileWidth();
        int tileH = this.carte.getTileHeight();
        int logicLayer = this.carte.getLayerIndex("DevantPersoArbreBas");
        Image tile = this.carte.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
        boolean collision = tile != null;
        return collision;
    }
    /*public boolean isOr(float x, float y){
        int tileW = this.carte.getTileWidth();
        int tileH = this.carte.getTileHeight();
        //LayerRessource
        int logicLayer = this.carte.getLayerIndex("DevantPersoArbreBas");
        Image tile = this.carte.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
        boolean collision = tile != null;
        return collision;
    }
    
      public boolean isFood(float x, float y){
        int tileW = this.carte.getTileWidth();
        int tileH = this.carte.getTileHeight();
        //LayerRessource
        int logicLayer = this.carte.getLayerIndex("DevantPersoArbreBas");
        Image tile = this.carte.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
        boolean collision = tile != null;
        return collision;
    }*/

    // *************************************************************************
    // Ecouteurs
    public int getObjectCount() {
        return this.carte.getObjectCount(0);
    }

    public String getObjectType(int objectID) {
        return this.carte.getObjectType(0, objectID);
    }

    public float getObjectX(int objectID) {
        return this.carte.getObjectX(0, objectID);
    }

    public float getObjectY(int objectID) {
        return this.carte.getObjectY(0, objectID);
    }

    public float getObjectWidth(int objectID) {
        return this.carte.getObjectWidth(0, objectID);
    }

    public float getObjectHeight(int objectID) {
        return this.carte.getObjectHeight(0, objectID);
    }

    public String getObjectProperty(int objectID, String propertyName, String def) {
        return this.carte.getObjectProperty(0, objectID, propertyName, def);
    }

    // *************************************************************************
    // Methode de changement de map (utiliser pour la teleportation)
    public void changeMap(String file) throws SlickException {
        this.carte = new TiledMap(file);
    }
}
