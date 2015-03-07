/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.ecouteurs;

import java.awt.Container;
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
    private PanMiniMap laMiniMap;
    
    public MiniMapListener(ImageIcon img, JTextArea message){
        this.imgLogo=img;
        this.lesMessage = message;
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
            laMiniMap.removeAll();
            laMiniMap = new PanMiniMap(lesMessage);
            laMiniMap.revalidate();
            //laMiniMap.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }   
}
