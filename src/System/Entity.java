package System;

import UI.Screen;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

public class Entity extends JLabel {
    
    private final Game game = Screen.game;
    
    private JLabel title = new JLabel();
    
    private float degree;
    public final Art art = new Art(this);
    
    public int type;
    private boolean isDestroyed;

    public Entity(int x, int y) {
        isDestroyed = false;
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
    
    public static String GenerateName() {
        String[] alphabet = new String[]{
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", 
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", 
            "U", "V", "W", "X", "Y", "Z"
        };
        String[] numeric = new String[]{
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
        };
        int a = Game.RNG(0, 25);
        int b = Game.RNG(0, 8);
        return alphabet[a] + numeric[b];
    }
    
    public void SetTitle(String title) {
        this.title.setText("[" + title + "]");
        this.title.setHorizontalAlignment(JLabel.CENTER);
        this.title.setFont(new Font("consolas", Font.BOLD, 10));
        this.title.setBounds(getX() - 70, getY() - 25, 100, 20);
        game.add(this.title);
    }
    
    public void Move(int direction) {
        new Timer().schedule ( new TimerTask() {
            @Override
            public void run() {
                setLocation(getX(), getY() + direction);
                title.setLocation(getX() - 70, getY() - 25 + direction);
            }
        }, 10, 10);
    }
    
    public void Move(int x, int y) {
        this.setLocation(this.getX() + x, this.getY() + y);
        title.setLocation(title.getX() + x, title.getY() + y);
    }
    
    public void Attack() {
        new Timer().schedule ( new TimerTask() {
            @Override
            public void run() {
                if (!isDestroyed) {
                    switch (Game.RNG(1, 3)) {
                        case 1: art.Basic(1); break;
                        case 2: art.Spread(); break;
                        case 3: art.Spiral(1); break;
                    }
                } else {
                    this.cancel();
                }
            }
        }, 1, 4000);
    }
    
    public void Destroy(int direction) {
        isDestroyed = true;
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
                    title.setLocation(-100, -100);
                    if (type == 2) {
                        game.score += 30;
                        game.lblScore.setText(String.valueOf(game.score));
                    }
                    this.cancel();
                }
            }
        }, 5, 5);
    }
    
    public void Dash(int d) {
        degree = 0;
        int x = getX();
        int y = getY();
        int v = title.getX();
        int w = title.getY();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (degree <= 90) {
                    float a = (float) Math.sin(degree * Math.PI / 180.0) * 50;
                    if (d == KeyEvent.VK_LEFT || d == KeyEvent.VK_A) {
                        if (x - Math.round(a) > 0) {
                            setLocation(x - Math.round(a), y);
                            title.setLocation(v - Math.round(a), w);
                        }
                    }
                    if (d == KeyEvent.VK_RIGHT || d == KeyEvent.VK_D) {
                        if (x + Math.round(a) < 500 - getWidth()) {
                            setLocation(x + Math.round(a), y);
                            title.setLocation(v + Math.round(a), w);
                        }
                    }
                    if (d == KeyEvent.VK_UP || d == KeyEvent.VK_W) {
                        if (y - Math.round(a) > 0) {
                            setLocation(x, y - Math.round(a));
                            title.setLocation(v, w - Math.round(a));
                        }
                    }
                    if (d == KeyEvent.VK_DOWN || d == KeyEvent.VK_S) {
                        if (y + Math.round(a) < 800 - getHeight()) {
                            setLocation(x, y + Math.round(a));
                            title.setLocation(v, w + Math.round(a));
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
