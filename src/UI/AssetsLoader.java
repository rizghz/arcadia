package UI;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class AssetsLoader {
    
    private final String BASE_URL = "../Assets/";
    private final int scale = Image.SCALE_FAST;
    
    private URL path;
    private Image image;
    
    public ImageIcon Background() {
        path = getClass().getResource(BASE_URL + "Domain.gif");
        image = new ImageIcon(path)
                    .getImage()
                    .getScaledInstance(500, 800, scale);
        return new ImageIcon(image);
    }
    
    public ImageIcon Vignette() {
        path = getClass().getResource(BASE_URL + "Vignette.png");
        image = new ImageIcon(path)
                    .getImage()
                    .getScaledInstance(500, 800, scale);
        return new ImageIcon(image);
    }
    
    public ImageIcon GameTitle() {
        path = getClass().getResource(BASE_URL + "Title.png");
        image = new ImageIcon(path)
                    .getImage()
                    .getScaledInstance(500, 300, scale);
        return new ImageIcon(image);
    }
    
    public ImageIcon KeyW() {
        path = getClass().getResource(BASE_URL + "key-w.png");
        image = new ImageIcon(path)
                    .getImage()
                    .getScaledInstance(25, 25, scale);
        return new ImageIcon(image);
    }
    
    public ImageIcon KeyA() {
        path = getClass().getResource(BASE_URL + "key-a.png");
        image = new ImageIcon(path)
                    .getImage()
                    .getScaledInstance(25, 25, scale);
        return new ImageIcon(image);
    }
    
    public ImageIcon KeyS() {
        path = getClass().getResource(BASE_URL + "key-s.png");
        image = new ImageIcon(path)
                    .getImage()
                    .getScaledInstance(25, 25, scale);
        return new ImageIcon(image);
    }
    
    public ImageIcon KeyD() {
        path = getClass().getResource(BASE_URL + "key-d.png");
        image = new ImageIcon(path)
                    .getImage()
                    .getScaledInstance(25, 25, scale);
        return new ImageIcon(image);
    }
    
    public ImageIcon KeyPeriod() {
        path = getClass().getResource(BASE_URL + "key-dot.png");
        image = new ImageIcon(path)
                    .getImage()
                    .getScaledInstance(25, 25, scale);
        return new ImageIcon(image);
    }
    
    public ImageIcon KeySlash() {
        path = getClass().getResource(BASE_URL + "key-slash.png");
        image = new ImageIcon(path)
                    .getImage()
                    .getScaledInstance(25, 25, scale);
        return new ImageIcon(image);
    }
    
    public ImageIcon NumKey1() {
        path = getClass().getResource(BASE_URL + "key-1.png");
        image = new ImageIcon(path)
                    .getImage()
                    .getScaledInstance(25, 25, scale);
        return new ImageIcon(image);
    }
    public ImageIcon NumKey2() {
        path = getClass().getResource(BASE_URL + "key-2.png");
        image = new ImageIcon(path)
                    .getImage()
                    .getScaledInstance(25, 25, scale);
        return new ImageIcon(image);
    }
    public ImageIcon NumKey3() {
        path = getClass().getResource(BASE_URL + "key-3.png");
        image = new ImageIcon(path)
                    .getImage()
                    .getScaledInstance(25, 25, scale);
        return new ImageIcon(image);
    }
    
}
