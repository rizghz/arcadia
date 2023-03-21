package UI;

import Event.MouseHandler;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Screen extends JFrame {
    
    private final String title = "Arcadia - Simple Shooting Game";
    
    private final int w;
    private final int h;
    
    private final AssetsLoader loader = new AssetsLoader();
    
    public JLabel background;
    public JLabel vignette;
    
    public static Menu menu;

    public Screen(int width, int height) throws HeadlessException {
        this.setTitle(title);
        this.setSize(width, height);
        this.w = this.getWidth();
        this.h = this.getHeight();
    }
    
    public void Settings() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(this);
        this.setVisible(true);
    }
    
    public void AddBackground() {
        background = new JLabel(loader.Background(), JLabel.CENTER);
        background.setBounds(0, 0, this.w, this.h);
        this.add(background);
    }
    
    public void AddVignette() {
        vignette = new JLabel(loader.Vignette(), JLabel.CENTER);
        vignette.setBounds(0, 0, this.w, this.h);
        this.add(vignette);
    }
    
    public void AddMenu() {
        menu = new Menu(this.w, this.h);
        menu.setBounds(0, 0, this.w, this.h);
        menu.Settings();
        menu.AddTitle();
        menu.AddButton();
        menu.SetMouseHandler(new MouseHandler());
        this.add(menu);
    }
    
}
