package Event;

import Core.Main;
import System.Game;
import UI.Menu;
import UI.Screen;
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
//            Game game = new Game(screen);
//            game.setBounds(0, 0, screen.getWidth(), screen.getHeight());
//            game.Settings();
//            game.add(menu.btnPlay);
//            screen.add(game);
//            game.Play();
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
            menu.FillButton (
                    menu.btnPlay, 
                    "•   P L A Y   •", 
                    "#767165"
            );
        }
        if (e.getSource() == menu.btnManual) {
            menu.FillButton (
                    menu.btnManual, 
                    "•   M A N U A L   •", 
                    "#767165");
        }
        if (e.getSource() == menu.btnExit) {
            menu.FillButton (
                    menu.btnExit, 
                    "•   E X I T   •", 
                    "#767165"
            );
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        menu.FillButton (
                menu.btnPlay, 
                "P L A Y", 
                "#454138"
        );
        menu.FillButton (
                menu.btnManual, 
                "M A N U A L", 
                "#454138");
        menu.FillButton (
                menu.btnExit, 
                "E X I T", 
                "#454138"
        );
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == menu.btnPlay) {
            menu.FillButton (
                    menu.btnPlay, 
                    "P L A Y", 
                    "#767165"
            );
        }
        if (e.getSource() == menu.btnManual) {
            menu.FillButton (
                    menu.btnManual, 
                    "M A N U A L", 
                    "#767165"
            );
        }
        if (e.getSource() == menu.btnExit) {
            menu.FillButton (
                    menu.btnExit, 
                    "E X I T", 
                    "#767165"
            );
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        menu.FillButton (
                menu.btnPlay, 
                "P L A Y", 
                "#454138"
        );
        menu.FillButton (
                menu.btnManual, 
                "M A N U A L", 
                "#454138"
        );
        menu.FillButton (
                menu.btnExit, 
                "E X I T", 
                "#454138"
        );
    }
    
}
