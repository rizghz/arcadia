package System;

import UI.Screen;
import java.util.LinkedList;

public class Art {
    
    private final Game game = Screen.game;
    
    private LinkedList<Bullet> cluster;

    public Art() {
        cluster = new LinkedList<>();
    }
    
    public void Basic() {
        cluster.add(new Bullet());
        cluster.getLast().SetCoordinate (
                game.player.getX() + game.player.getWidth()/2 - 10/2, 
                game.player.getY()
        );
        game.add(cluster.getLast());
        cluster.getLast().Move(cluster.getLast());
    }
    
    public void Special() {
        
    }
    
}
