package System;

import UI.Screen;
import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

public class Bullet extends JLabel {
    
    private final Game game = Screen.game;
    
    private float degree;
    private float radius;
    
    public Bullet(int x, int y) {
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
    
    public boolean Collision(Entity e) {
        return e.getBounds().intersects(this.getBounds());
    }
    
    public void Straight() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (InEdge()) {
                    for (Entity enemy : game.enemy) {
                        if (Collision(enemy)) {
                            Destroy();
                            enemy.Destroy();
//                            game.RemoveEntity(enemy);
                        }
                    }
                    int x = getX();
                    int y = getY();
                    setLocation(x, y - 1);
                } else {
                    Destroy();
                }
            }
        }, 3, 3);
    }
    
    public void Circle(Bullet bullet) {
        radius = 100;
        degree = 0;
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                int x = game.player.getX() + game.player.getWidth()/2 - 10/2;
                int y = game.player.getY() + game.player.getHeight()/2 - 10/2;
                if (bullet.InEdge()) {
                    for (Entity enemy : game.enemy) {
                        game.Collision(enemy, bullet);
                    }
                    float a = (float) Math.cos(degree * Math.PI / 180.0) * radius;
                    float b = (float) Math.sin(degree * Math.PI / 180.0) * radius;
                    bullet.setLocation (
                            x + Math.round(a), 
                            y + Math.round(b)
                    );
                } else {
                    bullet.setLocation(-100, -100);
                    game.player.art.cluster.remove(bullet);
                    this.cancel();
                }
                degree += 0.5f;
            }
        }, 3, 3);
    }
    
}
