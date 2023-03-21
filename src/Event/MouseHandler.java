package Event;

import Core.Main;
import UI.Menu;
import UI.Screen;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;

public class MouseHandler implements MouseListener {

    private final Screen screen = Main.screen;
    private final Menu menu = Screen.menu;
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == menu.btnPlay) {
            menu.Hide();
        }
        if (e.getSource() == menu.btnManual) {
            
        }
        if (e.getSource() == menu.btnExit) {
            screen.dispatchEvent(new WindowEvent (
                    screen, WindowEvent.WINDOW_CLOSING)
            );
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == menu.btnPlay) {
            menu.btnPlay.setText("•   P L A Y   •");
            menu.btnPlay.setForeground(Color.decode("#767165"));
        }
        if (e.getSource() == menu.btnManual) {
            menu.btnManual.setText("•   M A N U A L   •");
            menu.btnManual.setForeground(Color.decode("#767165"));
        }
        if (e.getSource() == menu.btnExit) {
            menu.btnExit.setText("•   E X I T   •");
            menu.btnExit.setForeground(Color.decode("#767165"));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        menu.btnPlay.setText("P L A Y");
        menu.btnPlay.setForeground(Color.decode("#454138"));
        menu.btnManual.setText("M A N U A L");
        menu.btnManual.setForeground(Color.decode("#454138"));
        menu.btnExit.setText("E X I T");
        menu.btnExit.setForeground(Color.decode("#454138"));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
