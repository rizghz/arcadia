package Event;

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
        /// pergerakan player
        switch (buffer) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_A:
            case KeyEvent.VK_D:
            case KeyEvent.VK_W:
            case KeyEvent.VK_S:
                direction = buffer;
                break;
        }
        /// kemampuan dasar player
        switch (buffer) {
            case KeyEvent.VK_PERIOD:
                game.player.art.Basic(-1);
                break;
            case KeyEvent.VK_SLASH:
                game.player.Dash(direction);
                break;
        }
        /// kemampuan tingkat lanjut player
        switch (buffer) {
            case KeyEvent.VK_1:
                game.player.art.Shield();
                break;
            case KeyEvent.VK_2:
                game.player.art.Spread();
                break;
            case KeyEvent.VK_3:
                game.player.art.Spiral(3);
                break;
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
                    game.player.Move(-1, 0);
                    game.CheckCollision();
                }
            }
            if (direction == KeyEvent.VK_RIGHT || direction == KeyEvent.VK_D) {
                if (game.player.getX() < 500 - game.player.getWidth()) {
                    game.player.Move(1, 0);
                    game.CheckCollision();
                }
            }
            if (direction == KeyEvent.VK_UP || direction == KeyEvent.VK_W) {
                if (game.player.getY() > 0) {
                    game.player.Move(0, -1);
                    game.CheckCollision();
                }
            }
            if (direction == KeyEvent.VK_DOWN || direction == KeyEvent.VK_S) {
                if (game.player.getY() < 800 - game.player.getHeight()) {
                    game.player.Move(0, 1);
                    game.CheckCollision();
                }
            }
        }
    }
    
}
