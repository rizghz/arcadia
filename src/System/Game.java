package System;

import Event.KeyHandler;
import java.awt.Dimension;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

public class Game extends JPanel {
    
    private final Dimension area;
    
    public Entity player;
    public LinkedList<Entity> enemy = new LinkedList<>();

    public Game(int width, int height) {
        this.setOpaque(false);
        this.area = new Dimension(width, height);
        this.setSize(area);
        this.setPreferredSize(this.area);
        this.setBounds(0, 0, width, height);
    }
    
    public void Settings() {
        this.setLayout(null);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setVisible(true);
        this.addKeyListener(new KeyHandler());
    }
    
    public void AddPlayer() {
        int x = (area.width / 2) - (30 / 2);
        int y = 830;
        player = new Entity(x, y);
        player.type = 1;
        this.add(player);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (player.getY() >= 600) {
                    player.setLocation (
                        player.getX(), 
                        player.getY() - 1
                    );
                } else {
                    this.cancel();
                }
            }
        }, 5, 5);
    }
    
    public static int RNG(int a, int b) {
        double f = Math.random() / Math.nextDown(1.0);
        double x = a * (1.0 - f) + b * f;
        return (int) Math.round(x);
    }
    
    public void AddEnemy() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                enemy.add ( new Entity (
                    RNG(50, 450), 20
                ));
                enemy.getLast().type = 2;
                enemy.getLast().Move(1);
                enemy.getLast().Attack();
                add(enemy.getLast());
            }
        }, 1, 1500);
    }
    
    public void Play() {
        this.AddPlayer();
        this.AddEnemy();
    }

}
