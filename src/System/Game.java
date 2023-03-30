package System;

import Event.KeyHandler;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game extends JPanel {
    
    private final Dimension area;
    
    public Entity player;
    public LinkedList<Entity> enemy = new LinkedList<>();
    
    public long score = 0;
    public JLabel lblScore = new JLabel();

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
        player.SetTitle("player");
        this.add(player);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (player.getY() >= 600) {
                    player.Move(0, -1);
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
                enemy.getLast().SetTitle(Entity.GenerateName());
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
    
    public void AddScore() {
        lblScore.setText(String.valueOf(score));
        lblScore.setHorizontalAlignment(JLabel.CENTER);
        lblScore.setForeground(Color.decode("#454138"));
        lblScore.setFont(new Font("consolas", Font.BOLD, 40));
        lblScore.setBounds(500 / 2 - 500 / 2, 50, 500, 40);
        this.add(lblScore);
    }
    
    public static boolean isCollision(Entity a, Entity b) {
        boolean res = a.getBounds().intersects(b.getBounds()) && 
                      a.type != b.type;
        if (a.getBackground().getAlpha() != 255 || b.getBackground().getAlpha() != 255) {
            return false;
        } else {
            return res;
        }
    }
    
    public void CheckCollision() {
        for (Entity e : enemy) {
            if (Game.isCollision(player, e)) {
                player.Destroy(1);
                e.Destroy(-1);
            }
        }
    }

}
