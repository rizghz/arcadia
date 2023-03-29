package UI;

import Event.MouseHandler;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Manual extends JPanel {
    
    private int w;
    private int h;
    
    private final AssetsLoader loader = new AssetsLoader();
    
    public JButton btnBack = new JButton();
    public JLabel[] keymap = new JLabel[9];
    public JLabel[] label = new JLabel[3];
    
    public int state;
    public boolean isAdded;
    
    public Manual(int width, int height) {
        this.state = 1;
        this.isAdded = false;
        this.setOpaque(false);
        this.setSize(width, height);
        this.setPreferredSize(new Dimension(width, height));
        this.setBounds(0, 0, width, height);
        this.w = this.getWidth();
        this.h = this.getHeight();
    }
    
    public void Settings() {
        this.setLayout(null);
        this.setVisible(true);
        this.SetMouseHandler(new MouseHandler());
    }
    
    public void AddKeyMap() {
        keymap[0] = new JLabel();
        keymap[0].setIcon(loader.KeyW());
        keymap[0].setHorizontalAlignment(JLabel.CENTER);
        keymap[0].setBounds(135, 220, 30, 30);
        this.add(keymap[0]);
        
        keymap[1] = new JLabel();
        keymap[1].setIcon(loader.KeyA());
        keymap[1].setHorizontalAlignment(JLabel.CENTER);
        keymap[1].setBounds(105, 250, 30, 30);
        this.add(keymap[1]);
        
        keymap[2] = new JLabel();
        keymap[2].setIcon(loader.KeyS());
        keymap[2].setHorizontalAlignment(JLabel.CENTER);
        keymap[2].setBounds(135, 250, 30, 30);
        this.add(keymap[2]);
        
        keymap[3] = new JLabel();
        keymap[3].setIcon(loader.KeyD());
        keymap[3].setHorizontalAlignment(JLabel.CENTER);
        keymap[3].setBounds(165, 250, 30, 30);
        this.add(keymap[3]);
        
        label[0] = new JLabel("M O V E", JLabel.LEFT);
        label[0].setFont(new Font("Arial", Font.BOLD, 17));
        label[0].setForeground(Color.decode("#454138"));
        label[0].setBounds(240, 240, 100, 20);
        this.add(label[0]);
        
        keymap[4] = new JLabel();
        keymap[4].setIcon(loader.KeyPeriod());
        keymap[4].setHorizontalAlignment(JLabel.CENTER);
        keymap[4].setBounds(135, 350, 30, 30);
        this.add(keymap[4]);
        
        keymap[5] = new JLabel();
        keymap[5].setIcon(loader.KeySlash());
        keymap[5].setHorizontalAlignment(JLabel.CENTER);
        keymap[5].setBounds(165, 350, 30, 30);
        this.add(keymap[5]);
        
        label[1] = new JLabel("B A S I C  S K I L L", JLabel.LEFT);
        label[1].setFont(new Font("Arial", Font.BOLD, 17));
        label[1].setForeground(Color.decode("#454138"));
        label[1].setBounds(240, 355, 200, 20);
        this.add(label[1]);
        
        keymap[6] = new JLabel();
        keymap[6].setIcon(loader.NumKey1());
        keymap[6].setHorizontalAlignment(JLabel.CENTER);
        keymap[6].setBounds(105, 450, 30, 30);
        this.add(keymap[6]);
        
        keymap[7] = new JLabel();
        keymap[7].setIcon(loader.NumKey2());
        keymap[7].setHorizontalAlignment(JLabel.CENTER);
        keymap[7].setBounds(135, 450, 30, 30);
        this.add(keymap[7]);
        
        keymap[8] = new JLabel();
        keymap[8].setIcon(loader.NumKey3());
        keymap[8].setHorizontalAlignment(JLabel.CENTER);
        keymap[8].setBounds(165, 450, 30, 30);
        this.add(keymap[8]);
        
        label[2] = new JLabel("A D V  S K I L L", JLabel.LEFT);
        label[2].setFont(new Font("Arial", Font.BOLD, 17));
        label[2].setForeground(Color.decode("#454138"));
        label[2].setBounds(240, 455, 200, 20);
        this.add(label[2]);
    }
    
    public void AddButton() {
        int position = (this.w / 2) - (200 / 2);
        /// Tombol Kembali
        btnBack.setText("B A C K");
        btnBack.setHorizontalAlignment(JButton.CENTER);
        btnBack.setBounds(position, 600, 200, 50);
        SetButtonStyle(btnBack);
        this.add(btnBack);
    }
    
    public void SetButtonStyle(JButton btn) {
        btn.setContentAreaFilled(false);
        btn.setFocusPainted(false);
        btn.setBorder(null);
        btn.setFont(new Font("Arial", Font.BOLD, 20));
        btn.setForeground(Color.decode("#454138"));
    }
    
    public void FillButton(JButton btn, String text, String color) {
        btn.setText(text);
        btn.setForeground(Color.decode(color));
    }
    
    public void Show() {
        setVisible(true);
        int r = 0x45;
        int g = 0x41;
        int b = 0x38;
        btnBack.setForeground(new Color(r, g, b, 0));
        btnBack.setVisible(true);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                int x = btnBack.getForeground().getAlpha();
                if (x != 255) {
                    btnBack.setForeground ( new Color (
                        r, g, b, 
                        x + 1
                    ));
                } else {
                    state = 1;
                    this.cancel();
                }
            }
        }, 2, 2);
    }
    
    public void Hide() {
        this.state = 0;
        this.requestFocus(false);
        this.setFocusable(false);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Color a = btnBack.getForeground();
                if (a.getAlpha() != 0) {
                    btnBack.setForeground ( new Color (
                        a.getRed(), 
                        a.getBlue(), 
                        a.getGreen(), 
                        a.getAlpha() - 1
                    ));
                } else {
                    btnBack.setVisible(false);
                    setVisible(false);
                    this.cancel();
                }
            }
        }, 2, 2);
    }
    
    public void SetMouseHandler(MouseHandler hdlMouse) {
        btnBack.addMouseListener(hdlMouse);
    }
    
}
