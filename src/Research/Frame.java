package Research;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame extends JFrame {
    
    private final String title = "Arcadia - Simple Shooting Game";
    
    protected Background background;
    protected Entity player;
    protected Entity enemy;
    protected LinkedList<Thread> bullet = new LinkedList<>();
    
    protected JButton playButton;
    protected JButton manualButton;
    protected JButton exitButton;
    
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
        Entity title = new Entity("Title.png", w, 300);
        background = new Background("Domain.gif", w, h);
        player = new Entity("#454138");
        enemy = new Entity("#454138");
        
        this.add(background.Vignette());
        
        title.setLocation(title.getX(), title.getY() + 100);
        this.add(title);
        
        playButton = new JButton("P L A Y");
        playButton.setBounds(0, 370, 500, 50);
        playButton.setFont(new Font("Arial", Font.BOLD, 20));
        playButton.setBackground(new Color(0, 0, 0, 0));
        playButton.setForeground(Color.decode("#454138"));
        playButton.setOpaque(false);
        playButton.setBorder(null);
        playButton.setFocusPainted(false);
        playButton.setContentAreaFilled(false);
        this.add(playButton);
        
        manualButton = new JButton("M A N U A L");
        manualButton.setBounds(0, 420, 500, 50);
        manualButton.setFont(new Font("Arial", Font.BOLD, 20));
        manualButton.setBackground(new Color(0, 0, 0, 0));
        manualButton.setForeground(Color.decode("#454138"));
        manualButton.setOpaque(false);
        manualButton.setBorder(null);
        manualButton.setFocusPainted(false);
        manualButton.setContentAreaFilled(false);
        this.add(manualButton);
        
        exitButton = new JButton("E X I T");
        exitButton.setBounds(0, 470, 500, 50);
        exitButton.setFont(new Font("Arial", Font.BOLD, 20));
        exitButton.setBackground(new Color(0, 0, 0, 0));
        exitButton.setForeground(Color.decode("#454138"));
        exitButton.setOpaque(false);
        exitButton.setBorder(null);
        exitButton.setFocusPainted(false);
        exitButton.setContentAreaFilled(false);
        this.add(exitButton);
        
        player.setLocation (
                (w / 2) - (player.getWidth()  / 2), 
                (h / 2) - (player.getHeight() / 2)
        );
//        this.add(player);
        
        enemy.setLocation (
                (w / 2) - (enemy.getWidth() / 2), 
                (30)
        );
//        this.add(enemy);
        
    }
    
    public void SetEventHandler(Event e) {
        this.addKeyListener(e);
        playButton.addMouseListener(e);
        manualButton.addMouseListener(e);
        exitButton.addMouseListener(e);
        e.SetFrame(this);
    }
    
}
