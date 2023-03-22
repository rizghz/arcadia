package Event;

import System.Game;
import UI.Screen;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    private int key;
    
    private final Game game = Screen.game;
    
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("debug");
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        key = e.getKeyCode();
//        System.out.println("debug");
//        if (game.player.InEdge()) {
//            if (key == 37 || key == 65) {
//                if (game.player.getX() > 0) {
//                    game.player.setLocation (
//                            game.player.getX() - 1, 
//                            game.player.getY());
//                }
//            }
//        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
