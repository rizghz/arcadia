package System;

import Event.KeyHandler;
import UI.Screen;
import java.awt.Color;
import java.awt.Dimension;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

public class Game extends JPanel {
    
    private final Dimension area;
    
    public Entity player;
    public LinkedList<Entity> enemy = new LinkedList<>();

    public Game(Screen screen) {
        this.setSize(screen.getSize());
        this.setBounds(0, 0, screen.getWidth(), screen.getHeight());
        this.area = screen.getSize();
    }
    
    public void Settings() {
        this.setOpaque(false);
        this.setLayout(null);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setVisible(true);
        this.addKeyListener(new KeyHandler());
    }
    
    public void AddPlayer() {
        player = new Entity();
        player.setBounds(area.width/2 - player.getWidth()/2, 830, 30, 30);
        this.add(player);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (player.getY() >= 600) {
                    player.setLocation (
                            player.getX(), 
                            player.getY() - 1
                    );
                }
                if (player.getY() == 600) {
                    this.cancel();
                }
            }
        }, 6, 6);
    }
    
    public void AddEnemy() {
        enemy.add(new Entity());
        enemy.getLast().setBounds (
                area.width/2 - player.getWidth()/2, 
                50, 
                30, 30
        );
        this.add(enemy.getLast());
        enemy.add(new Entity());
        enemy.getLast().setBounds (
                area.width/2 - player.getWidth()/2 - 100, 
                70, 
                30, 30
        );
        this.add(enemy.getLast());
        enemy.add(new Entity());
        enemy.getLast().setBounds (
                area.width/2 - player.getWidth()/2 - 200, 
                100, 
                30, 30
        );
        this.add(enemy.getLast());
        enemy.add(new Entity());
        enemy.getLast().setBounds (
                area.width/2 - player.getWidth()/2 + 100, 
                70, 
                30, 30
        );
        this.add(enemy.getLast());
        enemy.add(new Entity());
        enemy.getLast().setBounds (
                area.width/2 - player.getWidth()/2 + 200, 
                100, 
                30, 30
        );
        this.add(enemy.getLast());
    }
    
    public void RemoveEntity(Entity e) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Color color = e.getBackground();
                if (color.getAlpha() != 0) {
                    e.setBackground(new Color (
                            color.getRed(), 
                            color.getBlue(), 
                            color.getGreen(), 
                            color.getAlpha() - 1)
                    );
                } else {
                    e.setLocation(-30, -30);
                    remove(e);
                    this.cancel();
                }
            }
        }, 3, 3);
    }
    
    public void Play() {
        this.AddPlayer();
        this.AddEnemy();
    }
    
    public void Collision(Entity e, Bullet b) {
        if (e.getBounds().intersects(b.getBounds())) {
            this.RemoveEntity(e);
            b.setVisible(false);
        }
    }

}
