package Research;

public class Background extends Entity {
    
    public Background(String file, int w, int h) {
        super(file, w, h);
    }
    
    public Background Vignette() {
        Background vignette = new Background("Vignette.png", 500, 800);
        return vignette;
    }
    
}
