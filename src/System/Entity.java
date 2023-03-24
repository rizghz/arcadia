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
    
    private float degree;
    private float radius;
    
    public Art art;

    public Entity(int x, int y) {
        this.setBackground(Color.decode("#454138"));
        this.setBounds(x, y, 30, 30);
        this.setOpaque(true);
        this.art = new Art();
    }
    
    
    public void Test() {
        degree = 0;
        radius = 10;
        x = getX();
        y = getY();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Color color = getBackground();
                if (color.getAlpha() > 0) {
                    setBackground ( new Color (
                            color.getRed(), 
                            color.getGreen(), 
                            color.getBlue(), 
                            color.getAlpha() - 1
                    ));
                }
                float a = (float) Math.cos(degree * Math.PI / 180.0) * radius;
                float b = (float) Math.sin(degree * Math.PI / 180.0) * radius;
                setLocation (
                        x + Math.round(a), 
                        y + Math.round(b)
                );
                degree += 0.5f;
            }
        }, 2, 2);
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
                        color.getAlpha() - 1
                    ));
                    setLocation (
                        getX(), 
                        getY() + 1
                    );
                } else {
                    this.cancel();
                }
            }
        }, 10, 10);
    }
    
}
