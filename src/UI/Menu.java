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

public class Menu extends JPanel {
    
    private final int w;
    private final int h;

    private final AssetsLoader loader = new AssetsLoader();
    
    private final JLabel lblTitle = new JLabel();
    public JButton btnPlay = new JButton();
    public JButton btnManual = new JButton();
    public JButton btnExit = new JButton();
    
    public int state;
    
    public Menu(int width, int height) {
        this.state = 1;
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
    
    public void AddTitle() {
        lblTitle.setIcon(loader.GameTitle());
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setBounds(0, 0, this.w, 400);
        this.add(lblTitle);
    }
    
    public void AddButton() {
        int position = (this.w / 2) - (200 / 2);
        /// Tombol Play
        btnPlay.setText("P L A Y");
        btnPlay.setHorizontalAlignment(JButton.CENTER);
        btnPlay.setBounds(position, 380, 200, 50);
        SetButtonStyle(btnPlay);
        this.add(btnPlay);
        /// Tombol Manual
        btnManual.setText("M A N U A L");
        btnManual.setHorizontalAlignment(JButton.CENTER);
        btnManual.setBounds(position, 430, 200, 50);
        SetButtonStyle(btnManual);
        this.add(btnManual);
        /// Tombol Exit
        btnExit.setText("E X I T");
        btnExit.setHorizontalAlignment(JButton.CENTER);
        btnExit.setBounds(position, 480, 200, 50);
        SetButtonStyle(btnExit);
        this.add(btnExit);
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
        lblTitle.setVisible(true);
        btnPlay.setForeground(new Color(r, g, b, 0));
        btnPlay.setVisible(true);
        btnManual.setForeground(new Color(r, g, b, 0));
        btnManual.setVisible(true);
        btnExit.setForeground(new Color(r, g, b, 0));
        btnExit.setVisible(true);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                int x = btnPlay.getForeground().getAlpha();
                int y = btnManual.getForeground().getAlpha();
                int z = btnExit.getForeground().getAlpha();
                if (lblTitle.getY() < 400) {
                    lblTitle.setLocation (
                        lblTitle.getX(), 
                        lblTitle.getY() + 1
                    );
                }
                if ((x | y | z) != 255) {
                    btnPlay.setForeground ( new Color (
                        r, g, b, 
                        x + 1
                    ));
                    btnManual.setForeground ( new Color (
                        r, g, b, 
                        y + 1
                    ));
                    btnExit.setForeground ( new Color (
                        r, g, b, 
                        z + 1
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
                Color a = btnPlay.getForeground();
                Color b = btnManual.getForeground();
                Color c = btnExit.getForeground();
                if (lblTitle.getY() > -400) {
                    lblTitle.setLocation (
                        lblTitle.getX(), 
                        lblTitle.getY() - 1
                    );
                }
                if ((a.getAlpha() | b.getAlpha() | c.getAlpha()) != 0) {
                    btnPlay.setForeground ( new Color (
                        a.getRed(), 
                        a.getBlue(), 
                        a.getGreen(), 
                        a.getAlpha() - 1
                    ));
                    btnManual.setForeground ( new Color (
                        b.getRed(), 
                        b.getBlue(), 
                        b.getGreen(), 
                        b.getAlpha() - 1
                    ));
                    btnExit.setForeground ( new Color (
                        c.getRed(), 
                        c.getBlue(), 
                        c.getGreen(), 
                        c.getAlpha() - 1
                    ));
                } else {
                    lblTitle.setVisible(false);
                    btnPlay.setVisible(false);
                    btnManual.setVisible(false);
                    btnExit.setVisible(false);
                    setVisible(false);
                    this.cancel();
                }
            }
        }, 2, 2);
    }
    
    public void SetMouseHandler(MouseHandler hdlMouse) {
        btnPlay.addMouseListener(hdlMouse);
        btnManual.addMouseListener(hdlMouse);
        btnExit.addMouseListener(hdlMouse);
    }
    
}
