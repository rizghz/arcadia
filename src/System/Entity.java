package System;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

public class Entity extends JLabel {
    
    private float degree;
    public final Art art = new Art(this);
    
    public int type;

    public Entity(int x, int y) {
        this.setBounds(x, y, 30, 30);
        this.setOpaque(true);
        Color color = Color.decode("#454138");
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        this.setBackground(new Color(0, 0, 0, 0));
        new Timer().schedule(new TimerTask() {
            int alpha = 0;
            @Override
            public void run() {
                if (getBackground().getAlpha() < 255) {
                    setBackground(new Color(r, g, b, alpha));
                    alpha += 1;
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
    
    public void Dash(int d) {
        degree = 0;
        int x = getX();
        int y = getY();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (degree <= 90) {
                    float a = (float) Math.sin(degree * Math.PI / 180.0) * 50;
                    if (d == KeyEvent.VK_LEFT || d == KeyEvent.VK_A) {
                        if (x - Math.round(a) > 0) {
                            setLocation(x - Math.round(a), y);
                        }
                    }
                    if (d == KeyEvent.VK_RIGHT || d == KeyEvent.VK_D) {
                        if (x + Math.round(a) < 500 - getWidth()) {
                            setLocation(x + Math.round(a), y);
                        }
                    }
                    if (d == KeyEvent.VK_UP || d == KeyEvent.VK_W) {
                        if (y - Math.round(a) > 0) {
                            setLocation(x, y - Math.round(a));
                        }
                    }
                    if (d == KeyEvent.VK_DOWN || d == KeyEvent.VK_S) {
                        if (y + Math.round(a) < 800 - getHeight()) {
                            setLocation(x, y + Math.round(a));
                        }
                    }
                    degree += 1;
                } else {
                    this.cancel();
                }
            }
        }, 1, 1);
    }
    
}
