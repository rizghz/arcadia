package System;

import UI.Screen;
import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

public class Bullet extends JLabel {
    
    private final Game game = Screen.game;
    
    public final Entity owner;
    
    private float degree;
    private float radius;
    
    public Bullet(Entity owner, int x, int y) {
        this.owner = owner;
        this.setBackground(Color.decode("#cd664d"));
        this.setOpaque(true);
        this.setBounds(x, y, 10, 10);
    }
    
    public boolean InEdge() {
        int x = getX();
        int y = getY();
        return (-10 <= x && x <= 500 + 10) &&
               (-10 <= y && y <= 800 + 10);
    }
    
    public void Destroy() {
        this.setBackground(new Color(0, 0, 0, 0));
        this.setBounds(-50, -50, 0, 0);
        this.setSize(0, 0);
        this.setVisible(false);
        game.player.art.cluster.remove(this);
    }
    
    public boolean isCollision(Entity e) {
        boolean res = e.getBounds().intersects(this.getBounds()) && 
                      e.type != owner.type;
        if (e.getBackground().getAlpha() != 255) {
            return false;
        } else {
            return res;
        }
    }
    
    public void CheckCollision() {
        for (Entity enemy : game.enemy) {
            if (isCollision(enemy)) {
                Destroy();
                enemy.Destroy(-1);
            }
        }
        if (isCollision(game.player)) {
            Destroy();
            game.player.Destroy(1);
        }
    }
    
    public void Straight(int direction) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (InEdge()) {
                    CheckCollision();
                    int x = getX();
                    int y = getY();
                    setLocation(x, y + direction);
                } else {
                    Destroy();
                    this.cancel();
                }
            }
        }, 3, 3);
    }
    
    public void Straight(int r, int d) {
        radius = r;
        degree = d;
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                int x = owner.getX() + owner.getWidth()/2 - 10/2;
                int y = owner.getY() + owner.getHeight()/2 - 10/2;
                if (InEdge()) {
                    CheckCollision();
                    float a = (float) Math.cos(degree * Math.PI / 180.0) * radius;
                    float b = (float) Math.sin(degree * Math.PI / 180.0) * radius;
                    setLocation (
                            x + Math.round(a), 
                            y + Math.round(b)
                    );
                } else {
                    Destroy();
                    this.cancel();
                }
                radius += 1;
            }
        }, 3, 3);
    }
    
    public void Circle(float r, float d, float e) {
        radius = r;
        degree = d;
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                int x = owner.getX() + owner.getWidth()/2 - 10/2;
                int y = owner.getY() + owner.getHeight()/2 - 10/2;
                CheckCollision();
                float a = (float) Math.cos(degree * Math.PI / 180.0) * radius;
                float b = (float) Math.sin(degree * Math.PI / 180.0) * radius;
                setLocation (
                        x + Math.round(a), 
                        y + Math.round(b)
                );
                degree += 0.5f;
                if (radius <= e) {
                    radius += 1;
                }
            }
        }, 3, 3);
    }
    
    public void Circle(int r, int d) {
        radius = r;
        degree = d;
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                int x = owner.getX() + owner.getWidth()/2 - 10/2;
                int y = owner.getY() + owner.getHeight()/2 - 10/2;
                if (InEdge()) {
                    CheckCollision();
                    float a = (float) Math.cos(degree * Math.PI / 180.0) * radius;
                    float b = (float) Math.sin(degree * Math.PI / 180.0) * radius;
                    setLocation (
                            x + Math.round(a), 
                            y + Math.round(b)
                    );
                } else {
                    Destroy();
                    this.cancel();
                }
                degree += 0.5f;
                radius += 1;
            }
        }, 3, 3);
    }
    
}
