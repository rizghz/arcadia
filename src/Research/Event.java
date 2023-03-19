package Research;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class Event implements KeyListener, ActionListener {

    private Timer timer;
    private Frame frame;
    
    private int key;

    public Event() {
        timer = new Timer(1, this);
        timer.start();
    }
    
    public void SetFrame(Frame frame) {
        this.frame = frame;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        key = e.getKeyCode();
        if (key == 32) {
            Bullet bullet = new Bullet();
            bullet.setLocation (
                (frame.player.getX()) + (frame.player.getWidth()  / 2) - (bullet.getWidth() / 2), 
                (frame.player.getY()) + (frame.player.getHeight() / 2) - (bullet.getHeight())
            );
            frame.add(bullet);
            frame.bullet.add(new Thread(bullet));
            frame.bullet.getLast().start();
            frame.add(frame.background);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            if (!frame.bullet.isEmpty()) {
                if (frame.bullet.getLast().isAlive()) {
                    timer.setDelay(10);
                } else {
                    timer.setDelay(1);
                }
            }
            if (key == 37 || key == 65) {
                if (frame.player.getX() > 0) {
                    frame.player.setLocation(
                            frame.player.getX() - 1, 
                            frame.player.getY());
                }
            }
            if (key == 39 || key == 68) {
                if (frame.player.getX() < frame.getWidth() - frame.player.getWidth()) {
                    frame.player.setLocation(
                            frame.player.getX() + 1, 
                            frame.player.getY());
                }
            }
            if (key == 38 || key == 87) {
                if (frame.player.getY() > 0) {
                    frame.player.setLocation(
                            frame.player.getX(), 
                            frame.player.getY() - 1);
                }
            }
            if (key == 40 || key == 83) {
                if (frame.player.getY() < frame.getHeight() - frame.player.getHeight()) {
                    frame.player.setLocation(
                            frame.player.getX(), 
                            frame.player.getY() + 1);
                }
            }
        }
    }
    
}
