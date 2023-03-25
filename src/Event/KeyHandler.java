package Event;

import Core.Main;
import System.Game;
import UI.Screen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class KeyHandler implements KeyListener, ActionListener {

    private final Timer timer;
    
    private int buffer;
    private int direction;
    
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
        buffer = e.getKeyCode();
        if (buffer == KeyEvent.VK_LEFT || buffer == KeyEvent.VK_A) {
            direction = buffer;
        }
        if (buffer == KeyEvent.VK_RIGHT || buffer == KeyEvent.VK_D) {
            direction = buffer;
        }
        if (buffer == KeyEvent.VK_UP || buffer == KeyEvent.VK_W) {
            direction = buffer;
        }
        if (buffer == KeyEvent.VK_DOWN || buffer == KeyEvent.VK_S) {
            direction = buffer;
        }
        if (buffer == KeyEvent.VK_PERIOD) {
            game.player.art.Basic();
        }
        if (buffer == KeyEvent.VK_1) {
            game.player.art.Shield();
        }
        if (buffer == KeyEvent.VK_2) {
            game.player.Destroy(1);
        }
        if (buffer == KeyEvent.VK_3) {
            game.player.art.Test();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            if (direction == KeyEvent.VK_LEFT || direction == KeyEvent.VK_A) {
                if (game.player.getX() > 0) {
                    game.player.setLocation(
                            game.player.getX() - 1, 
                            game.player.getY());
                }
            }
            if (direction == KeyEvent.VK_RIGHT || direction == KeyEvent.VK_D) {
                if (game.player.getX() < 500 - game.player.getWidth()) {
                    game.player.setLocation(
                            game.player.getX() + 1, 
                            game.player.getY());
                }
            }
            if (direction == KeyEvent.VK_UP || direction == KeyEvent.VK_W) {
                if (game.player.getY() > 0) {
                    game.player.setLocation(
                            game.player.getX(), 
                            game.player.getY() - 1);
                }
            }
            if (direction == KeyEvent.VK_DOWN || direction == KeyEvent.VK_S) {
                if (game.player.getY() < 800 - game.player.getHeight()) {
                    game.player.setLocation(
                            game.player.getX(), 
                            game.player.getY() + 1);
                }
            }
        }
    }
    
}
