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
    
    public void Spread() {
        new Timer().schedule(new TimerTask() {
            int a = 1;
            @Override
            public void run() {
                if (a <= 1) {
                    for (int i = 1; i <= 8; i++) {
                        cluster.add ( new Bullet (
                            owner, 
                            owner.getX() + (owner.getWidth() / 2) - (10 / 2), 
                            owner.getY()
                        ));
                        game.add(cluster.getLast());
                        cluster.getLast().Straight(0, 45 * i);
                    }
                    a++;
                } else {
                    this.cancel();
                }
            }
        }, 1, 289);
    }
    
    public void Shield() {
        new Timer().schedule(new TimerTask() {
            int n = 1;
            @Override
            public void run() {
                if (n <= 1) {
                    for (int i = 1; i <= 8; i++) {
                        cluster.add ( new Bullet (
                            owner, 
                            owner.getX() + (owner.getWidth() / 2) - (10 / 2), 
                            owner.getY()
                        ));
                        game.add(cluster.getLast());
                        cluster.getLast().Circle(0, 45 * i, 100);
                    }
                    n++;
                } else {
                    this.cancel();
                }
            }
        }, 1, 289);
    }
    
    public void Spiral(int n) {
        new Timer().schedule(new TimerTask() {
            int a = 1;
            @Override
            public void run() {
                if (a <= n) {
                    for (int i = 1; i <= 8; i++) {
                        cluster.add ( new Bullet (
                            owner, 
                            owner.getX() + (owner.getWidth() / 2) - (10 / 2), 
                            owner.getY()
                        ));
                        game.add(cluster.getLast());
                        cluster.getLast().Circle(0, 45 * i);
                    }
                    a++;
                } else {
                    this.cancel();
                }
            }
        }, 1, 289);
    }
    
}
