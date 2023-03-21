package UI;

import Core.Main;
import Event.MouseHandler;
import java.awt.Color;
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
    
    private JLabel lblTitle;
    public JButton btnPlay;
    public JButton btnManual;
    public JButton btnExit;
    
    public Menu(int width, int height) {
        this.setSize(width, height);
        this.w = this.getWidth();
        this.h = this.getHeight();
    }
    
    public void Settings() {
        this.setOpaque(false);
        this.setLayout(null);
        this.setVisible(true);
    }
    
    public void AddTitle() {
        lblTitle = new JLabel(loader.GameTitle(), JLabel.CENTER);
        lblTitle.setBounds(0, 0, this.w, 400);
        this.add(lblTitle);
    }
    
    public void AddButton() {
        /// Tombol Play
        btnPlay = new JButton("P L A Y");
        btnPlay.setBounds(this.w/2 - 150/2, 380, 150, 50);
        SetButtonStyle(btnPlay);
        this.add(btnPlay);
        /// Tombol Manual
        btnManual = new JButton("M A N U A L");
        btnManual.setBounds(this.w/2 - 200/2, 430, 200, 50);
        SetButtonStyle(btnManual);
        this.add(btnManual);
        /// Tombol Exit
        btnExit = new JButton("E X I T");
        btnExit.setBounds(this.w/2 - 150/2, 480, 150, 50);
        SetButtonStyle(btnExit);
        this.add(btnExit);
    }
    
    public void SetButtonStyle(JButton btn) {
        btn.setFont(new Font("Arial", Font.BOLD, 20));
        btn.setBackground(new Color(0, 0, 0, 0));
        btn.setForeground(Color.decode("#454138"));
        btn.setOpaque(false);
        btn.setBorder(null);
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
    }
    
    public void FillButton(JButton btn, String text, String color) {
        btn.setText(text);
        btn.setForeground(Color.decode(color));
    }
    
    public void Hide() {
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
                } else {
                    lblTitle.setVisible(false);
                }
                if ((a.getAlpha() | b.getAlpha() | c.getAlpha()) != 0) {
                    if (a.getAlpha() != 0) {
                        btnPlay.setForeground(new Color (
                                a.getRed(), 
                                a.getBlue(), 
                                a.getGreen(), 
                                a.getAlpha() - 1)
                        );
                    }
                    if (b.getAlpha() != 0) {
                        btnManual.setForeground(new Color (
                                b.getRed(), 
                                b.getBlue(), 
                                b.getGreen(), 
                                b.getAlpha() - 1)
                        );
                    }
                    if (c.getAlpha() != 0) {
                        btnExit.setForeground(new Color (
                                c.getRed(), 
                                c.getBlue(), 
                                c.getGreen(), 
                                c.getAlpha() - 1)
                        );
                    }
                } else {
                    btnPlay.setVisible(false);
                    btnManual.setVisible(false);
                    btnExit.setVisible(false);
                    Main.screen.remove(Screen.menu);
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
