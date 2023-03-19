package Research;

import javax.swing.SwingUtilities;

public class Main {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Frame frame = new Frame(500, 800);
                frame.LoadAssets();
                frame.SetEventHandler(new Event());
                frame.Settings();
            }
        });
    }
    
}
