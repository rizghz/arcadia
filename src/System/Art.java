package System;

import UI.Screen;
import java.util.LinkedList;

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
        cluster.add ( new Bullet (
            game.player.getX() + game.player.getWidth()/2 - 10/2, 
            game.player.getY()
        ));
        game.add(cluster.getLast());
        cluster.getLast().Circle(cluster.getLast());
    }
    
}
