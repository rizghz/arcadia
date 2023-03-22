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
    
}
