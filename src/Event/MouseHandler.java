package Event;

import Core.Main;
import System.Game;
import UI.Manual;
import UI.Menu;
import UI.Screen;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {

    private final Screen screen = Main.screen;
    private final Menu menu = screen.menu;
    private final Game game = screen.game;
    private final Manual manual = screen.manual;
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (menu.state == 1) {
            if (e.getSource() == menu.btnPlay) {
                menu.Hide();
                screen.AddGame();
            }
            if (e.getSource() == menu.btnManual) {
                menu.Hide();
                screen.AddManual();
            }
            if (e.getSource() == menu.btnExit) {
                screen.Close();
            }
        }
        if (manual.state == 1) {
            if (e.getSource() == manual.btnBack) {
                manual.Hide();
                menu.Show();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (menu.state == 1) {
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
        if (manual.state == 1) {
            if (e.getSource() == manual.btnBack) {
                manual.FillButton (
                    manual.btnBack, 
                    "•   B A C K   •", 
                    "#767165"
                );
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (menu.state == 1) {
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
        if (manual.state == 1) {
            manual.FillButton (
                manual.btnBack, 
                "B A C K", 
                "#454138"
            );
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (menu.state == 1) {
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
        if (manual.state == 1) {
            if (e.getSource() == manual.btnBack) {
                manual.FillButton (
                    manual.btnBack, 
                    "B A C K", 
                    "#767165"
                );
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (menu.state == 1) {
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
        if (manual.state == 1) {
            manual.FillButton (
                manual.btnBack, 
                "B A C K", 
                "#454138"
            );
        }
    }
    
}
