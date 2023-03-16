package Research;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Frame extends JFrame {
    
    private JLabel container = new JLabel();
    private JLabel pesawat;
    
    private URL path;
    private Image image;
    private ImageIcon icon;

    public Frame() throws HeadlessException {
        this.setUndecorated(true);
        this.setSize(400, 500);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(this);
        this.setTitle("Research - Java Game");
        this.getContentPane().setBackground(Color.BLACK);
        load();
        this.setVisible(true);
    }
    
    public void load() {
        path = getClass().getResource("../Assets/Pesawat.gif");
        image = new ImageIcon(path).getImage()
                .getScaledInstance(50, 50, Image.SCALE_FAST);
        icon = new ImageIcon(image);
        pesawat = new JLabel(icon, JLabel.CENTER);
        pesawat.setBounds(this.getWidth()/2 - 50/2, this.getHeight()/2 - 50/2, icon.getIconWidth(), icon.getIconHeight());
        this.add(pesawat);
    }
    
}

public class Main {
    
    public static void main(String[] args) {
        Frame f = new Frame();
    }
    
}
