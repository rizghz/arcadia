package Research;

import java.awt.HeadlessException;
import java.util.LinkedList;
import javax.swing.JFrame;

public class Frame extends JFrame {
    
    private final String title = "Arcadia - Simple Shooting Game";
    
    protected Background background;
    protected Entity player;
    protected Entity enemy;
    protected LinkedList<Thread> bullet = new LinkedList<>();
    
    private final int w;
    private final int h;

    public Frame(int w, int h) throws HeadlessException {
        this.setTitle(title);
        this.setSize(w, h);
        this.w = getWidth();
        this.h = getHeight();
    }
    
    public void Settings() {
        this.setUndecorated(true);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(background);
    }
    
    public void Close() {
        
    }
    
    public void LoadAssets() {
        
        background = new Background("Domain.png", w, h);
        player = new Entity("#454138");
        enemy = new Entity("#454138");
        
        this.add(background.Vignette());
        
        player.setLocation (
                (w / 2) - (player.getWidth()  / 2), 
                (h / 2) - (player.getHeight() / 2)
        );
        this.add(player);
        
        enemy.setLocation (
                (w / 2) - (enemy.getWidth() / 2), 
                (30)
        );
//        this.add(enemy);
        
    }
    
    public void SetEventHandler(Event e) {
        this.addKeyListener(e);
        e.SetFrame(this);
    }
    
}
