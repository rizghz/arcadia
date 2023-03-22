package Event;

import System.Game;
import UI.Screen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class KeyHandler implements KeyListener, ActionListener {

    private Timer timer;
    private int key;
    
    private final Game game = Screen.game;

    public KeyHandler() {
        this.timer = new Timer(10, this);
        this.timer.start();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        key = e.getKeyCode();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
                if (game.player.getX() > 0) {
                    game.player.setLocation(
                            game.player.getX() - 1, 
                            game.player.getY());
                }
            }
            if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
                if (game.player.getX() < 500 - game.player.getWidth()) {
                    game.player.setLocation(
                            game.player.getX() + 1, 
                            game.player.getY());
                }
            }
            if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
                if (game.player.getY() > 0) {
                    game.player.setLocation(
                            game.player.getX(), 
                            game.player.getY() - 1);
                }
            }
            if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
                if (game.player.getY() < 800 - game.player.getHeight()) {
                    game.player.setLocation(
                            game.player.getX(), 
                            game.player.getY() + 1);
                }
            }
        }
    }
    
}
