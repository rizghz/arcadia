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
    
}
