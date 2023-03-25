package UI;

import Event.MouseHandler;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Manual extends JPanel {
    
    private int w;
    private int h;
    
    public JButton btnBack = new JButton();
    
    public int state;
    
    public Manual(int width, int height) {
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
