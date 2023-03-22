package System;

import Event.KeyHandler;
import UI.Screen;
import java.awt.Dimension;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

public class Game extends JPanel {
    
    private final Dimension area;
    
    public Entity player;
    public Entity enemy;

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
    
    public void Play() {
        this.AddPlayer();
    }

}
