/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.ecouteurs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import vue.PanneauxInterface.PanMiniMap;

/**
 *
 * @author Guillaume
 */
public class MiniMapListener implements KeyListener  {
    
    private ImageIcon imgLogo;
    private JTextArea lesMessage;
    private PanMiniMap laMiniMapImage, laMiniMapText;
    
    public MiniMapListener(ImageIcon img, JTextArea message){
        this.imgLogo=img;
        this.lesMessage = message;
        //laMiniMapImage = new PanMiniMap(imgLogo.getImage());
        laMiniMapText = new PanMiniMap(lesMessage);
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyChar() == 'd') {
            /*laMiniMapText.removeAll();
            laMiniMapText.revalidate();
            laMiniMapImage = new PanMiniMap(imgLogo.getImage());
            laMiniMapImage.repaint();
            laMiniMapImage.revalidate();*/
            JOptionPane.showMessageDialog(null, "L'image");
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyChar() == 'a') {
            /*laMiniMapImage.removeAll();
            laMiniMapImage.revalidate();
            laMiniMapText = new PanMiniMap(lesMessage);
            laMiniMapText.repaint();
            laMiniMapText.revalidate();*/
            JOptionPane.showMessageDialog(null, "Le texte");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }   
}
