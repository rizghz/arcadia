package System;

import UI.Screen;
import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

public class Bullet extends JLabel {
    
    private final Game game = Screen.game;
    
    public Bullet() {
        this.setBackground(Color.decode("#cd664d"));
        this.setOpaque(true);
        this.setSize(10, 10);
    }
    
    public void SetCoordinate(int x, int y) {
        this.setBounds(x, y, 10, 10);
        this.setLocation(x, y);
    }
    
    public void Move(Bullet bullet) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (bullet.getY() > -10) {
                    for (Entity enemy : game.enemy) {
                        game.Collision(enemy, bullet);
                    }
                    bullet.SetCoordinate (
                            bullet.getX(), 
                            bullet.getY() - 1
                    );
                } else {
                    this.cancel();
                }
            }
        }, 3, 3);
    }
    
}
