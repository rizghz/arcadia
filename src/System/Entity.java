package System;

import java.awt.Color;
import javax.swing.JLabel;

public class Entity extends JLabel {
    
    private int x;
    private int y;

    public Entity() {
        this.setBackground(Color.decode("#454138"));
        this.setOpaque(true);
        this.setSize(30, 30);
    }
    
    public boolean InEdge() {
        this.x = getX();
        this.y = getY();
        return (0 <= x && x <= 500 - getWidth()) && 
               (0 <= y && y <= 800 - getHeight());
    }
    
}
