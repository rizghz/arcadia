package Core;

import UI.Screen;
import javax.swing.SwingUtilities;

public class Main {
    
    public static Screen screen = new Screen(500, 800);
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                screen.AddVignette();
                screen.AddMenu();
                screen.AddBackground();
                screen.Settings();
            }
        });
    }
    
}
