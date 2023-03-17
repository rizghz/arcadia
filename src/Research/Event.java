package Research;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Event implements KeyListener {

    Frame frame;
    
    public void SetFrame(Frame frame) {
        this.frame = frame;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'a') {
            frame.pesawat.setLocation(
                    frame.pesawat.getX() - 5, 
                    frame.pesawat.getY());
        }
        if (e.getKeyChar() == 'd') {
            frame.pesawat.setLocation(
                    frame.pesawat.getX() + 5, 
                    frame.pesawat.getY());
        }
        if (e.getKeyChar() == 'w') {
            frame.pesawat.setLocation(
                    frame.pesawat.getX(), 
                    frame.pesawat.getY() - 5);
        }
        if (e.getKeyChar() == 's') {
            frame.pesawat.setLocation(
                    frame.pesawat.getX(), 
                    frame.pesawat.getY() + 5);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 37) {
            frame.pesawat.setLocation(
                    frame.pesawat.getX() - 5, 
                    frame.pesawat.getY());
        }
        if (e.getKeyCode() == 39) {
            frame.pesawat.setLocation(
                    frame.pesawat.getX() + 5, 
                    frame.pesawat.getY());
        }
        if (e.getKeyCode() == 38) {
            frame.pesawat.setLocation(
                    frame.pesawat.getX(), 
                    frame.pesawat.getY() - 5);
        }
        if (e.getKeyCode() == 40) {
            frame.pesawat.setLocation(
                    frame.pesawat.getX(), 
                    frame.pesawat.getY() + 5);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
