package menu.buttons;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;

public class FontButton extends MouseOverArea implements MouseListener{

    private final UnicodeFont font;
    private final String text;
    private boolean isEnabled = true;
    
    private int posX;
    private int posY;

    public FontButton(GUIContext guic, String text, int posX, int posY) throws SlickException, IOException, FontFormatException {
        super(guic, new Image(0, 0), posX, posY);
        this.posX = posX;
        this.posY = posY;
        Font uneFont = new Font("Serif", Font.BOLD, 16);
        this.font = new UnicodeFont(uneFont, uneFont.getSize(), uneFont.isBold(), uneFont.isItalic());
        font.addAsciiGlyphs();
        font.getEffects().add(new ColorEffect(Color.WHITE));
        font.loadGlyphs();        
        this.text = text;
    }

    public void setIsEnabled(boolean b) {
        isEnabled = b;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public void render(GUIContext guic, Graphics g) {
        g.setFont(font);
        font.drawString(posX, posY, text);
    }
    
    @Override
    public void mouseMoved(int oldx, int oldy, int newx, int newy) {
        super.mouseMoved(oldx, oldy, newx, newy);
    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
        System.out.println(this.text);
    }
    

    @Override
    public void setLocation(int i, int i1) {
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

}
