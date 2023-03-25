package System;

import Core.Main;
import UI.Screen;
import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

public class Entity extends JLabel {
    
    private final Screen screen = Main.screen;
    private final Game game = Screen.game;
    
    private int x;
    private int y;
    
    public Art art;

    public Entity(int x, int y) {
        this.setBounds(x, y, 30, 30);
        this.setOpaque(true);
        this.art = new Art();
        Color color = Color.decode("#454138");
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        this.setBackground(new Color(0, 0, 0, 0));
        new Timer().schedule(new TimerTask() {
            int a = 0;
            @Override
            public void run() {
                if (getBackground().getAlpha() < 255) {
                    setBackground(new Color(r, g, b, a));
                    a++;
                } else {
                    this.cancel();
                }
            }
        }, 1, 1);
    }
    
    public void Destroy(int direction) {
        new Timer().schedule ( new TimerTask() {
            @Override
            public void run() {
                Color color = getBackground();
                if (color.getAlpha() > 0) {
                    setBackground ( new Color (
                        color.getRed(), 
                        color.getGreen(), 
                        color.getBlue(), 
                        color.getAlpha() - 15
                    ));
                    setLocation (
                        getX(), 
                        getY() + direction
                    );
                } else {
                    setLocation(-100, -100);
                    this.cancel();
                }
            }
        }, 5, 5);
    }
    
}
