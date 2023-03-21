package System;

import Event.KeyHandler;
import UI.Screen;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

public class Game extends JPanel {
    
    private Dimension area;
    
    private Entity player;
    private Entity enemy;

    public Game(Screen screen) {
        this.setSize(screen.getSize());
        this.area = screen.getSize();
    }
    
    public void Settings() {
//        this.setBackground(new Color(0, 0, 0, 0));
        this.setBackground(Color.RED);
        this.setOpaque(false);
        this.setLayout(null);
        this.setVisible(true);
    }
    
    public void AddPlayer() {
        player = new Entity();
        player.setBounds(area.width/2 - player.getWidth()/2, -30, 30, 30);
        this.add(player);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (player.getY() > 400) {
                    player.setLocation (
                            player.getX(), 
                            player.getY() - 1
                    );
                }
            }
        }, 2, 2);
    }
    
    public void Play() {
        this.AddPlayer();
    }
    
    public void SetKeyHandler(KeyHandler hdlKey) {
        this.addKeyListener(hdlKey);
    }
    
}
