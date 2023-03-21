package Research;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import javax.swing.Timer;

public class Event implements KeyListener, ActionListener, MouseListener {

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
            Skill s = new Skill(frame.player, frame);
            s.Basic(frame);
        }
        if (key == 49) {
            Skill s = new Skill(frame.player, frame);
            s.Special(frame);
        }
        if (key == 50) {
            
        }
        if (key == 51) {
            
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

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == frame.playButton) {
            System.out.println("play");
        }
        if (e.getSource() == frame.manualButton) {
            System.out.println("manual");
        }
        if (e.getSource() == frame.exitButton) {
            System.out.println("exit");
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
