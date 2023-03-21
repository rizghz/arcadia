package Event;

import UI.Menu;
import UI.Screen;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;

public class MouseHandler implements MouseListener {

    private Screen screen;
    private Menu menu;
    
    public void SetComponent(Screen screen, Menu menu) {
        this.screen = screen;
        this.menu = menu;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == menu.btnPlay) {
            System.out.println("play");
        }
        if (e.getSource() == menu.btnManual) {
            System.out.println("manual");
        }
        if (e.getSource() == menu.btnExit) {
            System.out.println("exit");
            screen.dispatchEvent(new WindowEvent(screen, WindowEvent.WINDOW_CLOSING));
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
