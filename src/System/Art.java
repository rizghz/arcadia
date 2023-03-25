package System;

import UI.Screen;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class Art {
    
    private final Game game = Screen.game;
    
    public final LinkedList<Bullet> cluster;

    public Art() {
        cluster = new LinkedList<>();
    }
    
    public void Basic() {
        cluster.add ( new Bullet (
            game.player.getX() + game.player.getWidth()/2 - 10/2, 
            game.player.getY()
        ));
        game.add(cluster.getLast());
        cluster.getLast().Straight();
    }
    
    public void Shield() {
        new Timer().schedule(new TimerTask() {
            int i = 1;
            @Override
            public void run() {
                if (i <= 9) {
                    cluster.add ( new Bullet (
                        game.player.getX() + game.player.getWidth()/2 - 10/2, 
                        game.player.getY()
                    ));
                    game.add(cluster.getLast());
                    cluster.getLast().Circle();
                    i++;
                } else {
                    this.cancel();
                }
            }
        }, 1, 289);
    }
    
    public void Test() {
        for (int i = 1; i <= 8; i++) {
            cluster.add ( new Bullet (
                game.player.getX() + game.player.getWidth()/2 - 10/2, 
                game.player.getY()
            ));
            game.add(cluster.getLast());
            cluster.getLast().Test(0, 45 * i);
        }
    }
    
}
