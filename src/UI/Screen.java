package UI;

import System.Game;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Screen extends JFrame {
    
    private final String title = "Arcadia - Simple Shooting Game";
    
    private final int w;
    private final int h;
    
    private final AssetsLoader loader = new AssetsLoader();
    
    public JLabel background = new JLabel();
    public JLabel vignette = new JLabel();
    
    public static Menu menu;
    public static Manual manual;
    public static Game game;

    public Screen(int width, int height) throws HeadlessException {
        this.setTitle(title);
        this.setSize(width, height);
        this.setPreferredSize(new Dimension(width, height));
        this.setBounds(0, 0, width, height);
        this.w = this.getWidth();
        this.h = this.getHeight();
        this.menu = new Menu(width, height);
        this.manual = new Manual(width, height);
        this.game = new Game(width, height);
    }
    
    public void Settings() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setLayout(null);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public void Close() {
        this.dispatchEvent ( new WindowEvent (
                this, WindowEvent.WINDOW_CLOSING
        ));
    }
    
    public void Refresh() {
        this.getContentPane().add(background);
    }
    
    public void AddBackground() {
        background.setIcon(loader.Background());
        background.setHorizontalAlignment(JLabel.CENTER);
        background.setBounds(0, 0, this.w, this.h);
        this.getContentPane().add(background);
    }
    
    public void AddVignette() {
        vignette.setIcon(loader.Vignette());
        vignette.setHorizontalAlignment(JLabel.CENTER);
        vignette.setBounds(0, 0, this.w, this.h);
        this.getContentPane().add(vignette);
    }
    
    public void AddMenu() {
        menu.AddTitle();
        menu.AddButton();
        menu.Settings();
        this.getContentPane().add(menu);
        menu.isAdded = true;
        this.Refresh();
    }
    
    public void AddGame() {
        game.Settings();
        game.Play();
        this.getContentPane().add(game);
        this.Refresh();
    }
    
    public void AddManual() {
        manual.AddKeyMap();
        manual.AddButton();
        manual.Settings();
        this.getContentPane().add(manual);
        manual.isAdded = true;
        this.Refresh();
    }
    
}
