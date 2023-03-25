package System;

import UI.Screen;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class Art {
    
    private final Game game = Screen.game;
    
    public final LinkedList<Bullet> cluster;
    private final Entity owner;

    public Art(Entity owner) {
        cluster = new LinkedList<>();
        this.owner = owner;
    }
    
    public void Basic(int direction) {
        cluster.add ( new Bullet (
            owner, 
            owner.getX() + (owner.getWidth() / 2) - (10 / 2), 
            owner.getY()
        ));
        game.add(cluster.getLast());
        cluster.getLast().Straight(direction);
    }
    
    public void Shield() {
        new Timer().schedule(new TimerTask() {
            int n = 1;
            @Override
            public void run() {
                if (n <= 9) {
                    cluster.add ( new Bullet (
                        owner, 
                        owner.getX() + (owner.getWidth() / 2) - (10 / 2), 
                        owner.getY()
                    ));
                    game.add(cluster.getLast());
                    cluster.getLast().Circle();
                    n++;
                } else {
                    this.cancel();
                }
            }
        }, 1, 289);
    }
    
    public void Spiral() {
        new Timer().schedule(new TimerTask() {
            int n = 1;
            @Override
            public void run() {
                if (n <= 3) {
                    for (int i = 1; i <= 8; i++) {
                        cluster.add ( new Bullet (
                            owner, 
                            owner.getX() + (owner.getWidth() / 2) - (10 / 2), 
                            owner.getY()
                        ));
                        game.add(cluster.getLast());
                        cluster.getLast().Test(0, 45 * i);
                    }
                    n++;
                } else {
                    this.cancel();
                }
            }
        }, 1, 289);
    }
    
}
