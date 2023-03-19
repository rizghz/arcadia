package Research;

import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Entity extends JLabel {
    
    private final String BASE_URL = "../Assets/";
    
    private URL path;
    private Image image;
    private ImageIcon icon;

    public Entity(String warna) {
        this.setBackground(Color.decode(warna));
        this.setOpaque(true);
        this.setBounds(0, 0, 40, 40);
    }

    public Entity(String file, int w, int h) {
        path = this.getClass().getResource(BASE_URL + file);
        image = new ImageIcon(path).getImage().getScaledInstance(w, h, Image.SCALE_FAST);
        icon = new ImageIcon(image);
        this.setIcon(icon);
        this.setBounds(0, 0, w, h);
    }
    
}
