package Core;

import UI.Screen;
import javax.swing.SwingUtilities;

public class Main {
    
    public static Screen screen;
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                screen = new Screen(500, 800);
                screen.Settings();
                screen.AddVignette();
                screen.AddMenu();
                screen.AddBackground();
            }
        });
    }
    
}
