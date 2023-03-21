package UI;

import Event.MouseHandler;
import java.awt.Color;
import java.awt.Font;
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
        this.setBackground(new Color(0, 0, 0, 0));
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
        btnPlay.setBounds(0, 380, 500, 50);
        SetButtonStyle(btnPlay);
        this.add(btnPlay);
        /// Tombol Manual
        btnManual = new JButton("M A N U A L");
        btnManual.setBounds(0, 430, 500, 50);
        SetButtonStyle(btnManual);
        this.add(btnManual);
        /// Tombol Exit
        btnExit = new JButton("E X I T");
        btnExit.setBounds(0, 480, 500, 50);
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
    
    public void SetMouseHandler(Screen screen, MouseHandler hdlMouse) {
        btnPlay.addMouseListener(hdlMouse);
        btnManual.addMouseListener(hdlMouse);
        btnExit.addMouseListener(hdlMouse);
        hdlMouse.SetComponent(screen, this);
    }
    
}
